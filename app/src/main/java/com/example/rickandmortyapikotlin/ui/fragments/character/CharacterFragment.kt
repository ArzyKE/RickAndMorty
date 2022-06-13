package com.example.rickandmortyapikotlin.ui.fragments.character

import android.icu.text.Transliterator
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapikotlin.R
import com.example.rickandmortyapikotlin.databinding.FragmentCharacterBinding
import com.example.rickandmortyapikotlin.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val binding by viewBinding(FragmentCharacterBinding::bind)
    private val viewModel: CharacterViewModel by activityViewModels()
    private val characterAdapter = CharacterAdapter(
        this::onItemClick
    )

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
        viewModel.fetchCharacters().observe(viewLifecycleOwner) { character ->
            characterAdapter.submitList(character.results)
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment2(
                position = id
            )
        )
    }
}


