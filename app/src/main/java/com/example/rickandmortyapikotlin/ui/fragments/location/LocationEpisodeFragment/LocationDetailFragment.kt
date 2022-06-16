package com.example.rickandmortyapikotlin.ui.fragments.location.LocationEpisodeFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapikotlin.R
import com.example.rickandmortyapikotlin.databinding.FragmentLocationDetailBinding
import com.example.rickandmortyapikotlin.ui.fragments.location.LocationViewModel

class LocationDetailFragment : Fragment(R.layout.fragment_location_detail) {

    private val viewBinding by viewBinding(FragmentLocationDetailBinding::bind)
    private val viewModel: LocationViewModel by viewModels()
    private val args by navArgs<LocationDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        viewModel.fetchLocationId(args.position).observe(viewLifecycleOwner) { locationDetail ->
            viewBinding.locationDetailName.text = locationDetail.name
        }
    }
}