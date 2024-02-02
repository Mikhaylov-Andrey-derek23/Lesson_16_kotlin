package com.example.lesson_16


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lesson_16.databinding.FragmentSecondBinding



class SecondFragment : Fragment() {
    private  var binding: FragmentSecondBinding? = null
    private  var valueText:String? = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        valueText = arguments?.getString("TEXT_EXTRA", "")
        binding?.tvText?.text = valueText
        setOnClickListeners()

    }
    private  fun setOnClickListeners(){

        binding?.btnNavigateToThirdFragment?.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("TEXT_EXTRA", valueText)
            val fragment = ThirdFragment()
            fragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()

        }
    }
}