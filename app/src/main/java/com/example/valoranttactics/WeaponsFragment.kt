package com.example.valoranttactics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valoranttactics.databinding.FragmentWeaponsBinding

class WeaponsFragment : Fragment() {

    private var bind : FragmentWeaponsBinding? = null
    private val binding get() = bind!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentWeaponsBinding.inflate(inflater,container,false)


        return  binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        bind = null
    }


}