package viktor.braus.kplanner.Timer

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class PusherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}