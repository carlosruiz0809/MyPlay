package com.example.myplay.PlayAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myplay.PlayDTO
import com.example.myplay.R
import kotlinx.android.synthetic.main.item_list.view.*

class PlayAdapter(context: Context, val clickListener: (PlayDTO) -> Unit)
:RecyclerView.Adapter<PlayAdapter.PlayViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var play = emptyList<PlayDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayViewHolder {
        val itemView = inflater.inflate(R.layout.item_list,parent,false)
        return PlayViewHolder(itemView)
    }

    override fun getItemCount() = play.size

    override fun onBindViewHolder(holder: PlayViewHolder, position: Int) {
        val current = play[position]

        holder.bind(current,clickListener)
    }

    fun setPlay(play: List<PlayDTO>){
        this.play = play
    }

    inner class PlayViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(item: PlayDTO,clickListener: (PlayDTO) -> Unit) = with(itemView){
            item_view_play.text = item.equipoA + " vs " + item.equipoB
            this.setOnClickListener { clickListener(item) }
        }
    }

}