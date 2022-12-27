package com.maverick.navigationcomponent_stevdzasan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Dimension.SP
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.maverick.navigationcomponent_stevdzasan.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.user?.let {
            binding.tvFragmentTwo.apply {
                text = buildString {
                    append("First Name: ")
                    append(it.firstName)
                    append("\nLast Name: ")
                    append(it.lastName)
                }
                textSize = 24F
            }
        }

        binding.tvFragmentTwo.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}