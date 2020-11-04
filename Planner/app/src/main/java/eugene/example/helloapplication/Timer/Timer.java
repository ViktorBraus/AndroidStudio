package eugene.example.helloapplication.Timer;

import android.os.Handler;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import timber.log.Timber;

public class Timer implements LifecycleObserver
{
    private int secondsCount;
    private int secondsCountTotal;
    private Runnable runnable;
    private Runnable runnableTotal;
    private Handler handler;
   public Timer()
   {
       setSecondsCount(0);
       setSecondsCountTotal(0);
       handler = new Handler();
   }
    public Timer(Lifecycle lifecycle) {
        this();
        lifecycle.addObserver(this);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void startTimerTotal() {
        runnableTotal = new Runnable() {
            @Override
            public void run() {
                setSecondsCountTotal(getSecondsCountTotal() + 1);
                Timber.i("Timer is at: %s", getSecondsCountTotal());
                handler.postDelayed(runnableTotal, 1000);
            }
        };

        handler.postDelayed(runnableTotal, 1000);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void stopTimerTotal() {
        handler.removeCallbacks(runnableTotal);
        float focusPercentage = (float) getSecondsCountFocused() / getSecondsCountTotal() * 100;
        Timber.i("%d/%d секунд - час роботи додатку. %.2f%c - додаток був у фокусі.",
                getSecondsCountFocused(), getSecondsCountTotal(), focusPercentage, '%');
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void startTimerFocused() {
        runnable = new Runnable() {
            @Override
            public void run() {
                setSecondsCount(getSecondsCountFocused() + 1);
                Timber.i("Timer is at: %s", getSecondsCountFocused());
                handler.postDelayed(runnable, 1000);
            }
        };

        handler.postDelayed(runnable, 1000);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void stopTimerFocused() {
        handler.removeCallbacks(runnable);
    }
    public int getSecondsCountFocused() {
        return secondsCount;
    }

    public void setSecondsCount(int secondsCountFocused) {
        this.secondsCount = secondsCountFocused;
    }

    public int getSecondsCountTotal() {
        return secondsCountTotal;
    }

    public void setSecondsCountTotal(int secondsCountTotal) {
        this.secondsCountTotal = secondsCountTotal;
    }


}
