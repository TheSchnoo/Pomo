package mycompany.pomo;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {


    TextView timerView;


    //new Cycle(1, 1, 10, 10, 10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button) findViewById(R.id.stopButton);
        timerView = (TextView) findViewById(R.id.timerView);

        final MyTimer cycle = new MyTimer(20000, 1000);


        startButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycle.start();
            }

        });

        stopButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MyTimer extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String seconds = String.valueOf(millisUntilFinished/1000 % 60);
            if (seconds.length() < 2) {
                seconds = "0" + seconds;
            }

            String minutes = String.valueOf(millisUntilFinished/1000 / 60);
            if (minutes.length() < 2) {
                minutes = "0" + minutes;
            }

            String hours = String.valueOf(millisUntilFinished/1000 / 360);
            if (minutes.length() < 2) {
                hours = "0" + hours;
            }
            timerView.setText(hours+":"+minutes+":"+seconds);

        }

        @Override
        public void onFinish() {
            timerView.setText("butt");

        }
    }
}
