package com.noor.valoranttactics.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.noor.valoranttactics.AgentsFragmentDirections
import com.noor.valoranttactics.R
import com.noor.valoranttactics.model.Agent
import kotlinx.android.synthetic.main.agents_item.view.*

class AgentAdapter(private val agentList: List<Agent>) : RecyclerView.Adapter<AgentAdapter.AgentViewHolder>() {

    class AgentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val agentImage : ImageView = itemView.agentImage
        val agentName : TextView = itemView.agentName
        val agentRole : TextView = itemView.agentRole
        val roleImage : ImageView = itemView.roleImage

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.agents_item,parent,false)
        return AgentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val currentAgent = agentList[position]

        holder.agentImage.setImageResource(currentAgent.imageResource)
        holder.agentName.text = currentAgent.agentName
        holder.agentRole.text = currentAgent.agentRole
        holder.roleImage.setImageResource(currentAgent.roleImage)

        holder.itemView.setOnClickListener {
            val agentName = it.agentName.text.toString()
            val action = AgentsFragmentDirections.actionAgentsFragmentToAgentDetailFragment(agentName)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount() = agentList.size


}