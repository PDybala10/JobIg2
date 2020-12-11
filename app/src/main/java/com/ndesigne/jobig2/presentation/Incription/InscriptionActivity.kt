package com.ndesigne.jobig2.presentation.Incription

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.ndesigne.jobig2.R
import com.ndesigne.jobig2.presentation.main.InscriptionViewModel
import org.koin.android.ext.android.inject

class InscriptionActivity : AppCompatActivity() {

    val incriptionViewModel : InscriptionViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        incriptionViewModel.counter.observe(this, Observer {
            //main_text.text = it.toString()
        })

        /*   main_button.setOnClickListener {
               mainViewModel.OnclickButton("igor")
           }*/


    }
}