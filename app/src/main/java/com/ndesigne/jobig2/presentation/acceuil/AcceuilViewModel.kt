package com.ndesigne.jobig2.presentation.offre


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ndesigne.jobig2.data.model.Offre
import com.ndesigne.jobig2.data.repository.RetrofitRepository
import com.ndesigne.jobig2.presentation.acceuil.AcceuilActivity
import com.ndesigne.jobig2.presentation.acceuil.ApiStatus
import kotlinx.coroutines.launch
import retrofit2.Response


class AcceuilViewModel(private val repository: RetrofitRepository) : ViewModel() {


    var myResponse: MutableLiveData<Response<ArrayList<Offre>>> = MutableLiveData()

    fun getOffres(){
        viewModelScope.launch {
            val response = repository.getOffres()
            myResponse.value = response
        }

    }

}
