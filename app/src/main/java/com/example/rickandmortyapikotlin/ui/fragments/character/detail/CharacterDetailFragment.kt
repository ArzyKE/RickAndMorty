package com.example.rickandmortyapikotlin.ui.fragments.character.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.rickandmortyapikotlin.R
import com.example.rickandmortyapikotlin.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail) {

    private val viewBinding by viewBinding(FragmentCharacterDetailBinding::bind)
    private val viewModel: CharacterDetailViewModel by viewModels()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        viewModel.fetchCharactersId(args.position).observe(viewLifecycleOwner) { characterDetail ->
            viewBinding.characterDetailName.text = characterDetail.name
            Glide.with(viewBinding.characterImAva)
                .load(characterDetail.image)
                .into(viewBinding.characterImAva)
        }
    }
}