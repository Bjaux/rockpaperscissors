package de.kaehler.rockpaperscissors

import android.app.Application
import de.kaehler.rockpaperscissors.di.koinMainModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin(
            this, listOf(
                koinMainModule
            )
        )
    }
}