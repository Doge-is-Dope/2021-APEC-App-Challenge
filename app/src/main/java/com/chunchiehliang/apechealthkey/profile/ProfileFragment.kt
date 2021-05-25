package com.chunchiehliang.apechealthkey.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.chunchiehliang.apechealthkey.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentProfileBinding.inflate(inflater)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner

            viewModel = profileViewModel

            recyclerChecks.adapter = CheckListAdapter(CheckListener {
//                profileViewModel.displayVoterInfo(it)
            })
        }
        return binding.root
    }

}