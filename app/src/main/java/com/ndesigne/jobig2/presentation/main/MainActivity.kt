package com.ndesigne.jobig2.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import com.ndesigne.jobig2.R
import com.ndesigne.jobig2.presentation.Incription.InscriptionActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.newScope
import www.sanju.motiontoast.MotionToast

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSucces -> { MotionToast.createToast(this,"Success",
                    MotionToast.TOAST_SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
                }
                   LoginError -> { MotionToast.createToast(this,"Compte inconnu",
                       MotionToast.TOAST_ERROR,
                       MotionToast.GRAVITY_BOTTOM,
                       MotionToast.SHORT_DURATION,
                       ResourcesCompat.getFont(this,R.font.helvetica_regular)) }
            }
        })

        btnLogin.setOnClickListener {
            mainViewModel.OnclickButton(inputPseudo.text.toString().trim(),inputPassword.text.toString())
        }

        val intent = Intent(this, InscriptionActivity::class.java)

        gotoRegister.setOnClickListener{
            startActivity(intent)
        }
    }
}