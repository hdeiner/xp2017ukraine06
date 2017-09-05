package com.deinersoft.timeteller;

public class ClockForTesting extends Clock {
    private int hour;
    private int minute;
    private int second;

    public ClockForTesting(int hour, int minute, int second, String timeZone) {
        this.timeZone = timeZone;
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
