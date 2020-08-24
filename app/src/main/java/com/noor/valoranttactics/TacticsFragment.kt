package com.noor.valoranttactics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.noor.valoranttactics.adapters.VideoAdepter
import com.noor.valoranttactics.databinding.FragmentTacticsBinding
import com.noor.valoranttactics.service.VideoLinkAdapter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_tactics.*


class TacticsFragment : Fragment(),AdapterView.OnItemSelectedListener, VideoLinkAdapter{

    private var bind : FragmentTacticsBinding? = null
    private val binding get() = bind!!

    private lateinit var db : FirebaseFirestore
    lateinit var mAdView : AdView

    private var spinAgent : String = "BREACH"
    private var spinMap : String = "Ascent"
    private var spinAttack : String = "Attack"

    private var agentFromFB : ArrayList<String> = ArrayList()
    private var mapFromFB : ArrayList<String> = ArrayList()
    private var attackFromFB : ArrayList<String> = ArrayList()
    private var videoImageFromFB : ArrayList<String> = ArrayList()
    private var descriptionFromFB : ArrayList<String> = ArrayList()
    private var videoUrlFromFB : ArrayList<String> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentTacticsBinding.inflate(inflater,container,false)
        db = FirebaseFirestore.getInstance()

        MobileAds.initialize(requireContext()) {}
        mAdView = binding.adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val spinnerAgents: Spinner = binding.spinnerAgents
        ArrayAdapter.createFromResource(requireContext(),R.array.agents,R.layout.support_simple_spinner_dropdown_item).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
            spinnerAgents.adapter = adapter
        }

        val spinnerMap : Spinner = binding.spinnerMaps
        ArrayAdapter.createFromResource(requireContext(),R.array.maps,R.layout.support_simple_spinner_dropdown_item).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
            spinnerMap.adapter = adapter
        }

        val spinnerAttack : Spinner = binding.spinnerAttack
        ArrayAdapter.createFromResource(requireContext(),R.array.attack,R.layout.support_simple_spinner_dropdown_item).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
            spinnerAttack.adapter = adapter
        }
        spinnerAgents.onItemSelectedListener = this
        spinnerAttack.onItemSelectedListener = this
        spinnerMap.onItemSelectedListener = this
        /*
        val intent = YouTubeStandalonePlayer.createVideoIntent(activity,"AIzaSyBnLpv2JDcWVtIXiuxEiAs-x4_liFnuCqA,Evfe8GEn33w","Evfe8GEn33w",0,true,true)
        startActivity(intent)*/

        getDataFromFireStore(spinAgent,spinMap,spinAttack)


        binding.videoRecyclerView.adapter = VideoAdepter(agentFromFB, mapFromFB,attackFromFB,descriptionFromFB,videoImageFromFB,videoUrlFromFB,this)
        binding.videoRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.videoRecyclerView.setHasFixedSize(true)

        return  binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        bind = null
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        spinAgent = "BREACH"
        spinMap = "Ascent"
        spinAttack = "Attack"
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent == spinner_agents){
            spinAgent = parent?.getItemAtPosition(position).toString()

            getDataFromFireStore(spinAgent,spinMap,spinAttack)
            binding.videoRecyclerView.adapter!!.notifyDataSetChanged()
        }
        if (parent == spinner_maps){
            spinMap = parent?.getItemAtPosition(position).toString()

            getDataFromFireStore(spinAgent,spinMap,spinAttack)
            binding.videoRecyclerView.adapter!!.notifyDataSetChanged()
        }
        if (parent == spinner_attack){
            spinAttack = parent?.getItemAtPosition(position).toString()

            getDataFromFireStore(spinAgent,spinMap,spinAttack)
            binding.videoRecyclerView.adapter!!.notifyDataSetChanged()

        }

    }

    private fun getDataFromFireStore(sagent : String,smap : String,sattack : String){
        db.collection("videos").whereEqualTo("agent",sagent).whereEqualTo("map",smap).whereEqualTo("attack",sattack).addSnapshotListener{ snapshot, exception ->
            if(exception!= null){
                Toast.makeText(context,exception.localizedMessage,Toast.LENGTH_LONG).show()
            }
            if(snapshot!= null) {
                if (!snapshot.isEmpty) {

                    agentFromFB.clear()
                    mapFromFB.clear()
                    attackFromFB.clear()
                    descriptionFromFB.clear()
                    videoImageFromFB.clear()
                    videoUrlFromFB.clear()

                    val documents = snapshot.documents
                    for (document in documents) {
                        val agent = document.get("agent") as String
                        val map = document.get("map") as String
                        val attack = document.get("attack") as String
                        val videoImage = document.get("videoImage") as String
                        val videoDesc = document.get("description") as String
                        val videoUrl = document.get("videoUrl") as String

                            agentFromFB.add(agent)
                            mapFromFB.add(map)
                            attackFromFB.add(attack)
                            descriptionFromFB.add(videoDesc)
                            videoImageFromFB.add(videoImage)
                            videoUrlFromFB.add(videoUrl)


                        binding.videoRecyclerView.adapter!!.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    override fun videoClick(videolink: String) {
        val intent = YouTubeStandalonePlayer.createVideoIntent(activity,"AIzaSyBnLpv2JDcWVtIXiuxEiAs-x4_liFnuCqA,Evfe8GEn33w",videolink,0,true,true)
        startActivity(intent)
    }


}