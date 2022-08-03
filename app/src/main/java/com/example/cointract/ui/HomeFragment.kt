package com.example.cointract.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cointract.adapter.HomePagerAdapter
import com.example.cointract.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private val categoryArray = listOf(
        "Cryptoassets",
        "Exchanges"
    )
    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var pagerAdapter: HomePagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pagerAdapter = HomePagerAdapter(requireActivity())
        binding.apply {
            viewPager.adapter = pagerAdapter
            viewPager.isUserInputEnabled = false
            //tabs.setSelectedTabIndicator(null)
        }

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = categoryArray[position]
        }.attach()
    }
}