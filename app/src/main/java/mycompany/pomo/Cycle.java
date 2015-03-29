package mycompany.pomo;

/**
 * Created by dexter on 28/03/15.
 */

public class Cycle {

    // count the number of cycles
    int count;
    int maxCycles;
    int cycleLength;

    // timer counts in minutes
    int workLength;
    int shortBreakLength;
    int longBreakLength;

    // time left
    int secondsLeft;

    // timer instance
    CycleTimer timer;


    /**
     * Constructor
     * @param maxCycles         The maximum of cycles to run.
     * @param cycleLength       The total number of cycles before a long break is initiated.
     * @param workLength        The duration of the work shift in minutes.
     * @param shortBreakLength  The duration of the short break in minutes.
     * @param longBreakLength   The duration of the long break in minutes.
     */
    public Cycle (int maxCycles, int cycleLength, int workLength, int shortBreakLength, int longBreakLength) {
        this.count = 0;
        this.maxCycles = maxCycles;
        this.workLength = workLength;
        this.shortBreakLength = shortBreakLength;
        this.longBreakLength = longBreakLength;
        this.cycleLength = cycleLength;
    }

    public void execute() {
        int interval = 1000;
        long workDuration = workLength * 60 * interval;
        long shortBreakDuration = shortBreakLength *60 * interval;
        long longBreakDuration = longBreakLength * 60 * interval;
        while (count < maxCycles) {
            count ++;
            timer = new CycleTimer(workDuration,interval,this);
            timer.start();

            if ((count % cycleLength) == 0) {
                timer = new CycleTimer(longBreakDuration,interval,this);
                timer.start();
            } else {
                timer = new CycleTimer(shortBreakDuration,interval,this);
                timer.start();
            }
        }
    }

    public void stop() {
        timer.cancel();
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void setSecondsLeft(int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMaxCycles() {
        return maxCycles;
    }

    public void setMaxCycles(int maxCycles) {
        this.maxCycles = maxCycles;
    }

    public int getCycleLength() {
        return cycleLength;
    }

    public void setCycleLength(int cycleLength) {
        this.cycleLength = cycleLength;
    }

    public int getWorkLength() {
        return workLength;
    }

    public void setWorkLength(int workLength) {
        this.workLength = workLength;
    }

    public int getShortBreakLength() {
        return shortBreakLength;
    }

    public void setShortBreakLength(int shortBreakLength) {
        this.shortBreakLength = shortBreakLength;
    }

    public int getLongBreakLength() {
        return longBreakLength;
    }

    public void setLongBreakLength(int longBreakLength) {
        this.longBreakLength = longBreakLength;
    }

    public String getTimeLeft() {
        String seconds = String.valueOf(secondsLeft % 60);
        if (seconds.length() < 2) {
            seconds = "0" + seconds;
        }

        String minutes = String.valueOf(secondsLeft / 60);
        if (minutes.length() < 2) {
            minutes = "0" + minutes;
        }

        String hours = String.valueOf(secondsLeft / 360);
        if (minutes.length() < 2) {
            hours = "0" + hours;
        }

        return hours+":"+minutes+":"+seconds;
    }
}
