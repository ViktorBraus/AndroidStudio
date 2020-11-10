package viktor.braus.kplanner.timer

import android.os.Handler
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber

class TTimer() : LifecycleObserver {

    var secondsCountFocused = 0
    companion object
    {
        var secondsCountTotal = 0
    }
    var runnable: Runnable? = null
    var runnableTotal: Runnable? = null
    var handler: Handler

    constructor(lifecycle: Lifecycle) : this() {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun startTimerTotal() {
        runnableTotal = Runnable {
            secondsCountTotal = secondsCountTotal + 1
            Timber.i("Timer is at: %s", secondsCountTotal)
            handler.postDelayed(runnableTotal!!, 1000)
        }
        handler.postDelayed(runnableTotal!!, 1000)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stopTimerTotal() {
        handler.removeCallbacks(runnableTotal!!)
        val focusPercentage = secondsCountFocused.toFloat() / secondsCountTotal * 100
        Timber.i(
            "%d/%d секунд - час роботи додатку. %.2f%c - додаток був у фокусі.",
            secondsCountFocused, secondsCountTotal, focusPercentage, '%'
        )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startTimerFocused() {
        runnable = Runnable {
            setSecondsCount(secondsCountFocused + 1)
            Timber.i("Timer is at: %s", secondsCountFocused)
            handler.postDelayed(runnable!!, 1000)
        }
        handler.postDelayed(runnable!!, 1000)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopTimerFocused() {
        handler.removeCallbacks(runnable!!)
    }

    fun setSecondsCount(secondsCountFocused: Int) {
        this.secondsCountFocused = secondsCountFocused
    }

    init {
        setSecondsCount(0)
        secondsCountTotal = 0
        handler = Handler()
    }
}