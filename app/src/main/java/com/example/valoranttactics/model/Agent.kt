package com.example.valoranttactics.model

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Agent(

    val imageResource: Int,

    val agentName : String,

    val agentRole : String,

    val roleImage: Int){

}