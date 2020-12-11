package com.ndesigne.jobig2.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JobIgApplication : Application(){

    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@JobIgApplication)
            // modules
            modules(PresentationModule,DomainModule,DataModule)
        }
    }
}