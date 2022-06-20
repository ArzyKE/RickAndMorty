package com.example.rickandmortyapikotlin.ui.fragments.character

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
import com.example.rickandmortyapikotlin.databinding.FragmentCharacterBinding
import com.example.rickandmortyapikotlin.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val binding by viewBinding(FragmentCharacterBinding::bind)
    private val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharacterAdapter(
        this::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupObserve()
    }

    private fun init() = with(binding.characterRecView) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = characterAdapter
    }

    private fun setupObserve() {
        if (isNetwork()) {
            viewModel.fetchCharacters().observe(viewLifecycleOwner) {
                characterAdapter.submitList(it.results)
            }
        } else {
            characterAdapter.submitList(viewModel.getCharacters())
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
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment2(
                position = id
            )
        )
    }
}


