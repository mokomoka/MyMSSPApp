package io.github.mokomoka.mssprandomapp

import android.content.Context
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random


class YoutubeFragment : Fragment() {
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
        val root: View = inflater.inflate(R.layout.fragment_youtube, container, false)
//        recyclerView = root.findViewById<View>(R.id.tubeList) as RecyclerView
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(activity)
//        recyclerView.adapter = RecyclerAdapter(getData, object : RecyclerAdapter.NicoListener {
////            override fun onClickRow(tappedView: View, nico: Nicos) {
////                this@YoutubeFragment.onClickRow(tappedView, nico)
////            }
//        })
//        Log.d("onViewCreated", "adapter set")
//
//        getTubeData()
//        Log.d("onCreateView", "return")
        return root
    }

//        private fun getTubeData(){
//        val baseApiUrl = "https://www.googleapis.com/youtube/"
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(baseApiUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val tubeService = retrofit.create<Interface.TubeApiService>(Interface.TubeApiService::class.java)
//        val tubeCall = tubeService.getTubeData(
//            part = "id,snippet",
//            channelId = "UCzciBmqDXPE47nOPRrjmo9A",
//            order = "viewCount",
//            query = "",
//            type = "video",
//            key = ""
//        )
//        tubeCall.enqueue(object : Callback<TubeResponse> {
//            override fun onResponse(NicoCall : Call<TubeResponse>, response : Response<TubeResponse>) {
//                if(response.isSuccessful) {
//                    val tubeResponse = response!!.body()!!
//                        Log.d("Tube retrofit", tubeResponse.items[0].toString())
////                        getData.addAll(tubeResponse.data.shuffled().slice(0..9))
//                        recyclerView.adapter?.notifyDataSetChanged()
//                }
//            }
//
//            override fun onFailure(call: Call<TubeResponse>, t: Throwable) {
//                Log.d("Nico retrofit", t.message)
//            }
//        })
//    }

//    fun onClickRow(tappedView: View, nico: Nicos) {
//        val url = "https://nico.ms/${nico.contentId}"
//        val intent = Intent(Intent.ACTION_VIEW)
//        intent.data = Uri.parse(url)
//        if(intent.resolveActivity(activity!!.packageManager) != null) {
//            startActivity(intent)
//        }
//    }
}
