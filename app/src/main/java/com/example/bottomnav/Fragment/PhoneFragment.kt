package com.example.bottomnav.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnav.R
import kotlinx.android.synthetic.main.fragment_phone.*

class PhoneFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_phone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_phone.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:8 (944) 534-12-09")))
        }
    }
}
