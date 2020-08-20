package com.example.valoranttactics.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.valoranttactics.MainActivity
import com.example.valoranttactics.R
import com.example.valoranttactics.model.Video
import com.example.valoranttactics.service.VideoLinkAdapter
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_item.view.*
import kotlinx.coroutines.flow.callbackFlow

class VideoAdepter(private val videoAgentArray: ArrayList<String>,
                    private val videoMapArray: ArrayList<String>,
                    private val videoAttackArray: ArrayList<String>,
                    private val videoDescriptionArray : ArrayList<String>,
                    private val videoImageArray : ArrayList<String>,
                    private val videoUrlArray :ArrayList<String>,
                    private val videoLinkAdapter: VideoLinkAdapter) : RecyclerView.Adapter<VideoAdepter.videoViewHolder>(),VideoLinkAdapter {

    class videoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val videoAgent : TextView = itemView.videoAgent
        val videoMap : TextView = itemView.videoMap
        val videoAttack : TextView = itemView.videoAttack
        val videoDescription : TextView = itemView.videoDescription
        val videoImage : ImageView = itemView.videoImageView
        val videoUrl : TextView = itemView.videoUrl

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): videoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.video_item,parent,false)
        return videoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: videoViewHolder, position: Int) {

        val videoLink : String

        holder.videoAgent.text = videoAgentArray[position]
        holder.videoAttack.text = videoAttackArray[position]
        holder.videoMap.text = videoMapArray[position]
        holder.videoDescription.text = videoDescriptionArray[position]
        holder.videoUrl.text = videoUrlArray[position]
        Picasso.get().load(videoImageArray[position]).into(holder.videoImage)

        holder.itemView.setOnClickListener {
            videoLinkAdapter.videoClick(videoUrlArray[position])
        }

    }

    override fun getItemCount() = videoAgentArray.size
    override fun videoClick(videolink: String) {

    }

}