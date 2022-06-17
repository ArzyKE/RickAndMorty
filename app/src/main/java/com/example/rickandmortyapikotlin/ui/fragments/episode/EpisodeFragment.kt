package com.example.rickandmortyapikotlin.ui.fragments.episode

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapikotlin.R
import com.example.rickandmortyapikotlin.databinding.FragmentEpisodeBinding
import com.example.rickandmortyapikotlin.ui.adapters.EpisodeAdapter
import kotlinx.coroutines.launch

class EpisodeFragment : Fragment(R.layout.fragment_episode) {

    private val binding by viewBinding(FragmentEpisodeBinding::bind)
    private val viewModel: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodeAdapter(
        this::onItemClick
    )

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
        viewModel.fetchEpisode().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                episodeAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(
                position = id
            )
        )
    }
}








