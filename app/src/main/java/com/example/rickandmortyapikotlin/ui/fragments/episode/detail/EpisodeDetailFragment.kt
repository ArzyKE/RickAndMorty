package com.example.rickandmortyapikotlin.ui.fragments.episode.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapikotlin.R
import com.example.rickandmortyapikotlin.databinding.FragmentEpisodeDetailBinding

class EpisodeDetailFragment : Fragment(R.layout.fragment_episode_detail) {

    private val viewBinding by viewBinding(FragmentEpisodeDetailBinding::bind)
    private val viewModel: EpisodeDetailViewModel by viewModels()
    private val args by navArgs<EpisodeDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        viewModel.fetchEpisodeId(args.position).observe(viewLifecycleOwner) { episodeDetail ->
            viewBinding.episodeDetailName.text = episodeDetail.name
        }
    }
}
