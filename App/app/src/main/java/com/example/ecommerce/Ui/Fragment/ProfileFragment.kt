package com.example.ecommerce.Ui.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.ecommerce.R
import com.example.ecommerce.Ui.Activity.SettingActivity


class ProfileFragment : Fragment() {
    private lateinit var imgBtnSetting:ImageButton
    private lateinit var imgBtnCart:ImageButton
    private lateinit var imgBtnMessage:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_profile, container, false)
        init(view)
        return view
    }

    private fun init(view:View) {
        imgBtnMessage = view.findViewById(R.id.img_btn_message)
        imgBtnCart = view.findViewById(R.id.img_btn_cart)
        imgBtnSetting = view.findViewById(R.id.img_btn_setting)
        imgBtnSetting.setOnClickListener(View.OnClickListener {
            startActivity(Intent(requireContext(), SettingActivity::class.java))
        })
    }

}