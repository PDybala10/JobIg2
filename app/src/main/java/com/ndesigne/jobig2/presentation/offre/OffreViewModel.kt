package com.ndesigne.jobig2.presentation.offre

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ndesigne.jobig2.data.model.Offre
import com.ndesigne.jobig2.presentation.acceuil.AcceuilActivity.staticVariable.listOfrre
import com.ndesigne.jobig2.presentation.acceuil.AcceuilActivity.staticVariable.positionG

class OffreViewModel : ViewModel() {

    var LiveOffre: MutableLiveData<Offre> = MutableLiveData()

    init {
        LiveOffre.value = listOfrre.get(positionG)

    }


}
