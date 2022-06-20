package com.example.rickandmortyapikotlin.ui.fragments.location

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
import com.example.rickandmortyapikotlin.databinding.FragmentLocationBinding
import com.example.rickandmortyapikotlin.ui.adapters.LocationAdapter

class LocationFragment : Fragment(R.layout.fragment_location) {

    private val binding by viewBinding(FragmentLocationBinding::bind)
    private val viewModel: LocationViewModel by viewModels()
    private val locationAdapter = LocationAdapter(
        this::onItemClick
    )

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
        if (isNetwork()) {
            viewModel.fetchLocation().observe(viewLifecycleOwner) {
                locationAdapter.submitList(it.results)
            }
        } else {
            locationAdapter.submitList(viewModel.getLocation())
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
            LocationFragmentDirections.actionLocationFragmentToLocationDetailFragment(
                position = id
            )
        )
    }
}
