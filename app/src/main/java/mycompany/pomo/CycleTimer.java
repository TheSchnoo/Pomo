package mycompany.pomo;

import android.os.CountDownTimer;

/**
 * Created by dexter on 28/03/15.
 */
public class CycleTimer extends CountDownTimer {

    Cycle cycle;


    public CycleTimer(long millisInFuture, long countDownInterval, Cycle cycle) {
        super(millisInFuture, countDownInterval);
        this.cycle = cycle;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        //activity;
        cycle.setSecondsLeft((int)millisUntilFinished * 1000);

    }

    @Override
    public void onFinish() {

    }
}
