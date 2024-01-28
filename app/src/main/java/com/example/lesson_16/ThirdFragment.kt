package com.example.lesson_16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson_16.databinding.FragmentFirstBinding
import com.example.lesson_16.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    private  var binding: FragmentThirdBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding?.tvText?.text = arguments?.getString("TEXT_EXTRA")

        setOnClickListeners()
    }
    private  fun setOnClickListeners(){

        binding?.btnNavigateToFirstFragment?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FirstFragment())
                .commit()
        }
        binding?.btnNavigateToSecondFragment?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, SecondFragment())
                .commit()
        }
    }
}