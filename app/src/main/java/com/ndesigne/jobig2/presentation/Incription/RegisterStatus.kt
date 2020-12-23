package com.ndesigne.jobig2.presentation.Incription

sealed class RegisterStatus

data class RegisterSucces(val email: String) : RegisterStatus()
object RegisterError : RegisterStatus()
