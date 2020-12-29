package com.ndesigne.jobig2.presentation.main


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ndesigne.jobig2.domain.entities.User
import com.ndesigne.jobig2.domain.usecase.CreateUserUseCase
import com.ndesigne.jobig2.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
   private val createUserUserCase : CreateUserUseCase,
   private val getUserUseCase: GetUserUseCase
) : ViewModel(){


    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()



    fun OnclickButton(emailUser : String, passUser : String) {
        viewModelScope.launch(Dispatchers.IO) {

            val user: User? = getUserUseCase.invoke(emailUser)
            val loginStatus:LoginStatus = if(user != null && user.password==passUser){
                LoginSucces(user.email)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }

}