package com.ndesigne.jobig2.presentation.main


import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ndesigne.jobig2.R
import com.ndesigne.jobig2.domain.entities.User
import com.ndesigne.jobig2.domain.usecase.CreateUserUseCase
import com.ndesigne.jobig2.domain.usecase.GetUserUseCase
import com.ndesigne.jobig2.presentation.Incription.RegisterError
import com.ndesigne.jobig2.presentation.Incription.RegisterStatus
import com.ndesigne.jobig2.presentation.Incription.RegisterSucces
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import www.sanju.motiontoast.MotionToast

class InscriptionViewModel(
    private val createUserUserCase : CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){


    val registerLiveData : MutableLiveData<RegisterStatus> = MutableLiveData()



    fun OnclickCreateAccount(emailUser : String, passUser : String){
        viewModelScope.launch(Dispatchers.IO) {
            val user: User? = getUserUseCase.invoke(emailUser)

            val registerStatus:RegisterStatus = if (user == null){
                createUserUserCase.invoke(User(emailUser, passUser))
                RegisterSucces(emailUser)

            }else{
                RegisterError
            }
            withContext(Dispatchers.Main) {
                registerLiveData.value = registerStatus
            }

        }

    }
}