package com.example.koindi

import android.app.Application
import com.example.koindi.data.dataModule
import com.example.koindi.domain.domainModule
import com.example.koindi.view.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(
                dataModule,
                domainModule,
                uiModule
            )
        }
    }
}