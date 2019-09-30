package com.example.mymsspapp


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_niconico.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random



/**
 * A simple [Fragment] subclass.
 *
 */
class NiconicoFragment : Fragment() {

    lateinit var recyclerView : RecyclerView
    var getData = mutableListOf<Nicos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this
        val root: View = inflater.inflate(R.layout.fragment_niconico, container, false)
        recyclerView = root.findViewById<View>(R.id.nicoList) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = RecyclerAdapter(getData, object : RecyclerAdapter.NicoListener {
            override fun onClickRow(tappedView: View, nico: Nicos) {
                this@NiconicoFragment.onClickRow(tappedView, nico)
            }
        })
        Log.d("onViewCreated", "adapter set")

        getNicoData()
        Log.d("onCreateView", "return")
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun getNicoData(){
        val baseApiUrl = "https://api.search.nicovideo.jp/"
//        val sortPattern : List<String> = listOf("+viewCounter", "-viewCounter",
//            "+mylistCounter", "-mylistCounter",
//            "+lengthSeconds", "-lengthSeconds",
//            "+commentCounter", "-commentCounter",
//            "+lastCommentTime", "-lastCommentTime")
        val sortPattern : List<String> = listOf( "-viewCounter",
            "-mylistCounter",
            "+lengthSeconds", "-lengthSeconds",
            "-commentCounter",
            "+lastCommentTime", "-lastCommentTime")

        val retrofit = Retrofit.Builder()
            .baseUrl(baseApiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val nicoService = retrofit.create<Interface.NicoApiService>(Interface.NicoApiService::class.java)
        val nicoCall = nicoService.getNicoData(
            query = "M.S.SProject",
            targets = "tagsExact",
            fields = "contentId,title,viewCounter,lengthSeconds,thumbnailUrl,startTime,commentCounter",
            sort = sortPattern[Random.nextInt(sortPattern.size)],
            offset = Random.nextInt(1600),
            limit = 100,
            context = "testAndroidApp")

        nicoCall.enqueue(object : Callback<NicoResponse> {
            override fun onResponse(NicoCall : Call<NicoResponse>, response : Response<NicoResponse>) {
                if(response.isSuccessful) {
                    val nicoResponse = response!!.body()!!

                    if(nicoResponse.meta!!.status != 200 || nicoResponse.meta!!.totalCount!! <= 100) {
                        Log.d("Nico retrofit", nicoResponse.meta!!.status.toString())
                    } else {
                        Log.d("Nico retrofit", nicoResponse.data[0].title.toString())
//                        callback(nicoResponse.data.shuffled().slice(0..9))
                        getData.addAll(nicoResponse.data.shuffled().slice(0..9))
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<NicoResponse>, t: Throwable) {
                Log.d("Nico retrofit", t.message)
            }
        })
    }

    fun onClickRow(tappedView: View, nico: Nicos) {
        val url = "https://nico.ms/${nico.contentId}"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        if(intent.resolveActivity(activity!!.packageManager) != null) {
            startActivity(intent)
        }
    }
}
