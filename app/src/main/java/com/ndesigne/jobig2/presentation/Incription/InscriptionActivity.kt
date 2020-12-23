package com.ndesigne.jobig2.presentation.Incription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import com.ndesigne.jobig2.R
import com.ndesigne.jobig2.presentation.main.InscriptionViewModel
import com.ndesigne.jobig2.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_instription.*
import org.koin.android.ext.android.inject
import www.sanju.motiontoast.MotionToast

class InscriptionActivity : AppCompatActivity() {

    val incriptionViewModel : InscriptionViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instription)



        incriptionViewModel.registerLiveData.observe(this, Observer {
            when(it){
                is RegisterSucces -> {
                    MotionToast.createToast(this,"Success",
                        MotionToast.TOAST_SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this,R.font.helvetica_regular))
                }
                   RegisterError ->{
                          MotionToast.createToast(this,"Le Compte existe deja!",
                           MotionToast.TOAST_ERROR,
                           MotionToast.GRAVITY_BOTTOM,
                           MotionToast.SHORT_DURATION,
                           ResourcesCompat.getFont(this,R.font.helvetica_regular))
                   }
            }
        })

        btnRegister.setOnClickListener {
            if (inputPseudo.text.toString() != "" && inputPassword.text.toString() != "") {
                incriptionViewModel.OnclickCreateAccount(
                    inputPseudo.text.toString(),
                    inputPassword.text.toString()
                )

            }
            else{
                MotionToast.createToast(this,"veillez remplir tous les champs!",
                    MotionToast.TOAST_ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
            }

           }

        val intent = Intent(this, MainActivity::class.java)
        btnBack.setOnClickListener{
            startActivity(intent)
        }
    }

}