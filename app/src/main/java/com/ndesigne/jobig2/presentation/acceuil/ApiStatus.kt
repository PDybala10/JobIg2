package com.ndesigne.jobig2.presentation.acceuil

import com.ndesigne.jobig2.data.model.Offre

sealed class ApiStatus

data class ApiSucces(val offres: List<Offre>) : ApiStatus()
object ApiError : ApiStatus()
