package ua.romanik.vladislav.dogsandcats.presentation.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ua.romanik.vladislav.dogsandcats.di.appModules

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }

}