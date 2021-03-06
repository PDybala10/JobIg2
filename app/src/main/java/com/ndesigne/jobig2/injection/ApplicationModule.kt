package com.ndesigne.jobig2.injection


import android.content.Context
import androidx.room.Room
import com.ndesigne.jobig2.data.local.AppDatabase
import com.ndesigne.jobig2.data.local.DataBaseDao
import com.ndesigne.jobig2.data.model.Offre
import com.ndesigne.jobig2.data.repository.RetrofitRepository
import com.ndesigne.jobig2.data.repository.UserRepository
import com.ndesigne.jobig2.domain.usecase.CreateUserUseCase
import com.ndesigne.jobig2.domain.usecase.GetUserUseCase
import com.ndesigne.jobig2.presentation.Incription.InscriptionActivity
import com.ndesigne.jobig2.presentation.main.InscriptionViewModel
import com.ndesigne.jobig2.presentation.main.MainViewModel
import com.ndesigne.jobig2.presentation.offre.AcceuilViewModel
import com.ndesigne.jobig2.presentation.offre.OffreViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.get
import org.koin.dsl.module
import retrofit2.Retrofit

val PresentationModule = module {

    factory { MainViewModel(get(), get()) }
    factory { InscriptionViewModel(get(), get()) }
    factory { AcceuilViewModel(get())}
    factory { OffreViewModel() }
}
val DomainModule = module {

    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}
val DataModule = module {

    single {  UserRepository(get()) }

    single {createDataBase(androidContext()) }

    single { RetrofitRepository() }
}

fun createDataBase(context : Context): DataBaseDao  {
    val appDataBase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-JobIg"
    ).build()
    return appDataBase.dataBaseDao()
}
