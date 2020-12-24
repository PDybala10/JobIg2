package com.ndesigne.jobig2.presentation.offre


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ndesigne.jobig2.R
import org.koin.android.ext.android.inject


class OffreActivity : AppCompatActivity() {

    val offreViewModel : OffreViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offre)

      /*  offreViewModel.liveData.observe(this, Observer {

        })*/

    }

}