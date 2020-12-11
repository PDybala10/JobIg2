package com.ndesigne.jobig2.presentation.main


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ndesigne.jobig2.domain.entities.User
import com.ndesigne.jobig2.domain.usecase.CreateUserUseCase
import com.ndesigne.jobig2.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
   private val createUserUserCase : CreateUserUseCase,
   private val getUserUseCase: GetUserUseCase
) : ViewModel(){


    val counter : MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun OnclickButton(emailUser : String) {
        viewModelScope.launch(Dispatchers.IO) {
            createUserUserCase.invoke(User(emailUser))
            delay(1000)
            val user: User = getUserUseCase.invoke("igor")
        }
    }
}