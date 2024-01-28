package com.example.lesson_16


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class SecondFragment : Fragment() {
    private var btnNavigateToFirstFragment: Button? = null
    private var btnNavigateToThirdFragment: Button? = null
    private  var tvFragmentText: TextView? = null
    private  var valueText:String? = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnNavigateToFirstFragment = requireActivity().findViewById(R.id.btnNavigateToFirstFragment)
        btnNavigateToThirdFragment = requireActivity().findViewById(R.id.btnNavigateToThirdFragment)
        tvFragmentText = requireActivity().findViewById(R.id.tvText)
        valueText = arguments?.getString("TEXT_EXTRA", "")
        tvFragmentText?.text = valueText
        setOnClickListeners()

    }
    private  fun setOnClickListeners(){
        btnNavigateToFirstFragment?.setOnClickListener {


            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FirstFragment())
                .commit()
        }
        btnNavigateToThirdFragment?.setOnClickListener {
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