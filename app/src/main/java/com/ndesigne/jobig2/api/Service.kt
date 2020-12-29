package com.ndesigne.jobig2.api;

import com.ndesigne.jobig2.data.model.Offre
import retrofit2.Response
import retrofit2.http.GET

 interface Service {
    //TODO: Definir le model des offres

    @GET("/positions.json?location=Europe")
    suspend fun getAllOffre(): Response<ArrayList<Offre>>

}

