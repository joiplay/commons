package cyou.joiplay.commons.utils;

import android.app.Activity;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

public class AutoCloseTimer {

    private class AutoCloseTimerTask extends TimerTask {
        private Activity mActivity;

        AutoCloseTimerTask(Activity activity){
            mActivity = activity;
        }

        @Override
        public void run() {
            Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            mActivity.startActivity(intent);

            System.exit(0);
        }
    }

    private Activity mActivity;
    private long mTimeout = 0L;
    private long lastSchedule = 0L;

    private Timer mTimer;


    public AutoCloseTimer(Activity activity, int timeout){
        mActivity = activity;
        mTimeout = 1000L * 60 * timeout;

        mTimer = new Timer();
        mTimer.schedule(new AutoCloseTimerTask(mActivity), mTimeout);
    }

    public void reschedule(){
        if (System.currentTimeMillis() < lastSchedule + 10 * 1000) return;

        lastSchedule = System.currentTimeMillis();

        mTimer.cancel();
        mTimer = new Timer();
        mTimer.schedule(new AutoCloseTimerTask(mActivity), mTimeout);
    }

    public void cancel(){
        mTimer.cancel();
    }
}
