package com.example.rickandmortyapikotlin.ui.fragments.location

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapikotlin.R
import com.example.rickandmortyapikotlin.databinding.FragmentLocationBinding
import com.example.rickandmortyapikotlin.ui.adapters.LocationAdapter

class LocationFragment : Fragment(R.layout.fragment_location) {

    private val binding by viewBinding(FragmentLocationBinding::bind)
    private val viewModel: LocationViewModel by activityViewModels()
    private val locationAdapter = LocationAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupObserve()
    }

    private fun init() = with(binding.locationRecView) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = locationAdapter
    }

    private fun setupObserve() {
        viewModel.fetchLocation().observe(viewLifecycleOwner) { location ->
            locationAdapter.submitList(location.results)
        }
    }
}