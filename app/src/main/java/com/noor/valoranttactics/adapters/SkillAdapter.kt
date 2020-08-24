package com.noor.valoranttactics.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.noor.valoranttactics.R
import com.noor.valoranttactics.model.Skill
import kotlinx.android.synthetic.main.agentskill_item.view.*

class SkillAdapter(private val skillList: List<Skill>) : RecyclerView.Adapter<SkillAdapter.skillViewHolder>(){

    class skillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val skillImage : ImageView = itemView.skillImage
        val skillName : TextView = itemView.skillName
        val skillCost : TextView = itemView.skillCost
        val skillDescription : TextView = itemView.skillDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): skillViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.agentskill_item,parent,false)
        return skillViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: skillViewHolder, position: Int) {
        val currentSkill = skillList[position]

        holder.skillImage.setImageResource(currentSkill.skillImage)
        holder.skillName.text = currentSkill.skillName
        holder.skillCost.text = currentSkill.skillCost
        holder.skillDescription.text = currentSkill.skillDescription
    }

    override fun getItemCount() = skillList.size

}