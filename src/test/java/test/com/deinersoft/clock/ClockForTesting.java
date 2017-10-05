package test.com.deinersoft.clock;

import com.deinersoft.timeteller.Clock;

public class ClockForTesting extends Clock {
    private final int hour;
    private final int minute;
    private final int second;

    public ClockForTesting(int hour, int minute, int second, String timeZone) {
        super(timeZone);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

}
