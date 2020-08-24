package com.noor.valoranttactics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noor.valoranttactics.databinding.FragmentWeaponsBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class WeaponsFragment : Fragment() {

    private var bind : FragmentWeaponsBinding? = null
    private val binding get() = bind!!
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentWeaponsBinding.inflate(inflater,container,false)
        MobileAds.initialize(requireContext()) {}
        mAdView = binding.adView3
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        return  binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        bind = null
    }


}