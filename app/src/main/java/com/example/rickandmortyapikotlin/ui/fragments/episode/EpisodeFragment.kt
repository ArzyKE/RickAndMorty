package com.example.rickandmortyapikotlin.ui.fragments.episode

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapikotlin.R
import com.example.rickandmortyapikotlin.databinding.FragmentEpisodeBinding
import com.example.rickandmortyapikotlin.ui.adapters.EpisodeAdapter

class EpisodeFragment : Fragment(R.layout.fragment_episode) {

    private val binding by viewBinding(FragmentEpisodeBinding::bind)
    private val viewModel: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodeAdapter(
        this::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupObserve()
    }

    private fun init() = with(binding.episodeRecView) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = episodeAdapter
    }

    private fun setupObserve() {
        if (isNetwork()) {
            viewModel.fetchEpisode().observe(viewLifecycleOwner) {
                episodeAdapter.submitList(it.results)
            }
        } else {
            episodeAdapter.submitList(viewModel.getEpisode())
        }
    }

    private fun isNetwork(): Boolean {
        val connectivityManager: ConnectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(
                position = id
            )
        )
    }
}








