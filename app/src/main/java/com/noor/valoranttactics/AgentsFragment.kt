package com.noor.valoranttactics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.noor.valoranttactics.adapters.AgentAdapter
import com.noor.valoranttactics.databinding.FragmentAgentsBinding
import com.noor.valoranttactics.model.Agent
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.firestore.FirebaseFirestore

class AgentsFragment : Fragment() {

    //ca-app-pub-6820833737096197~8417590699 Admob Id
    //ca-app-pub-6820833737096197/2540052831 bannerAdId
    //ca-app-pub-3940256099942544/6300978111 BannerTest Id
    //ca-app-pub-3940256099942544/1033173712 Inter Test Id

    private var bind : FragmentAgentsBinding? = null
    private val binding get() = bind!!

    private lateinit var db : FirebaseFirestore
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentAgentsBinding.inflate(inflater,container,false)

        MobileAds.initialize(requireContext()) {}
        mAdView = binding.adView2
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val exampleList = dumpList(12)


        binding.agentsRecycler.adapter = AgentAdapter(exampleList)
        binding.agentsRecycler.layoutManager = LinearLayoutManager(activity)
        binding.agentsRecycler.setHasFixedSize(true)

        return  binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        bind = null
    }

    private fun dumpList(size : Int): List<Agent>{

        val list = ArrayList<Agent>()

        for(i in 0 until size){
            val item : Agent = when (i % 12) {
                0 -> {
                    Agent(R.drawable.breachavatar , "Breach" , "Initiator",R.drawable.initiator)
                }
                1 -> {
                    Agent(R.drawable.brimstoneavatar , "Brimstone" , "Controller",R.drawable.controller)
                }
                2 -> {
                    Agent(R.drawable.cypheravatar , "Cyper" , "Duelist",R.drawable.duelist)
                }
                3 -> {
                    Agent(R.drawable.jettavatar , "Jett" , "Duelist",R.drawable.duelist)
                }
                4 -> {
                    Agent(R.drawable.omenavatar , "Omen" , "Controller",R.drawable.controller)
                }
                5 -> {
                    Agent(R.drawable.phoenixavatar , "Phoenix" , "Duelist",R.drawable.duelist)
                }
                6 -> {
                    Agent(R.drawable.razeavatar , "Raze" , "Duelist",R.drawable.duelist)
                }
                7 -> {
                    Agent(R.drawable.reynaavatar , "Reyna" , "Duelist",R.drawable.duelist)
                }
                8 -> {
                    Agent(R.drawable.sageavatar , "Sage" , "Sentinel",R.drawable.sentinel)
                }
                9 -> {
                    Agent(R.drawable.sovaavatar , "Sova" , "Initiator",R.drawable.initiator)
                }
                10 -> {
                    Agent(R.drawable.viperavatar , "Viper" , "Controller",R.drawable.controller)
                }
                11 -> {
                    Agent(R.drawable.killjoyavatar , "Killjoy" , "Sentinel",R.drawable.sentinel)
                }
                else -> {
                    Agent(R.drawable.viperavatar , "Viper" , "Controller",R.drawable.controller)
                }
            }
            list += item
        }
        return list
    }

}