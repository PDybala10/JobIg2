package com.ndesigne.jobig2.data.repository

import com.ndesigne.jobig2.api.RetrofitInstance
import com.ndesigne.jobig2.data.model.Offre
import retrofit2.Response

class RetrofitRepository {

    suspend fun getOffres(): Response<ArrayList<Offre>> {
        return RetrofitInstance.api.getAllOffre()
    }
}
