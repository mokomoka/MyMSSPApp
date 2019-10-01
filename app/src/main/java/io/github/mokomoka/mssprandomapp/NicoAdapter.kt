package io.github.mokomoka.mssprandomapp

import android.text.format.DateFormat
import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

//private val listener: NicoListener
class RecyclerAdapter(private val itemList: MutableList<Nicos>, private val listener : NicoListener)
    : RecyclerView.Adapter<RecyclerViewHolder>(){
//    var itemList = mutableListOf<Nicos>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val rowView: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RecyclerViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemTitle.text = item.title
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        val time = df.parse(item.startTime)
        holder.itemTime.text  = DateFormat.format("yyyy/M/d HH:mm", time)
        val viewCount = item.viewCounter
        if (viewCount != null) {
            when {
                viewCount >= 10000000 -> holder.itemViewCounter.text = String.format("%d", viewCount/10000) + "万"
                viewCount >= 10000 -> holder.itemViewCounter.text = String.format("%3.1f", viewCount/10000.0) + "万"
                else -> holder.itemViewCounter.text = String.format("%d", viewCount)
            }
        }
        val comeCount = item.commentCounter
        if (comeCount != null) {
            when {
                comeCount >= 10000000 -> holder.itemCommentCounter.text = String.format("%d", comeCount/10000) + "万"
                comeCount >= 10000 -> holder.itemCommentCounter.text = String.format("%3.1f", comeCount/10000.0) + "万"
                else -> holder.itemCommentCounter.text = String.format("%d", comeCount)
            }
        }
        Picasso.get().load(item.thumbnailUrl).fit().centerCrop().into(holder.itemThumbnail)
        holder.itemTitle.setOnClickListener {
            listener.onClickRow(it, item)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    interface NicoListener {
        fun onClickRow(tappedView: View,nico: Nicos)
    }
}