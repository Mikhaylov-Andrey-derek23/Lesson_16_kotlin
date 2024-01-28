package com.example.lesson_16

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.lesson_16.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

//    private var btnNavigateToSecondFragment: Button? = null
//    private  var etTeatToPass: EditText? = null
    private  var binding: FragmentFirstBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        btnNavigateToSecondFragment = requireActivity().findViewById(R.id.btnNavigateToSecondFragment)
//        etTeatToPass = requireActivity().findViewById(R.id.etTextToPass)


        setOnClickListeners()
    }

    private  fun setOnClickListeners(){
        binding?.btnNavigateToSecondFragment?.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("TEXT_EXTRA", binding?.etTextToPass?.text.toString())
            val fragment = SecondFragment()
            fragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }
}