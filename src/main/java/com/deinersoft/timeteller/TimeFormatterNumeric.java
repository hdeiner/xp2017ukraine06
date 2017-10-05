package com.deinersoft.timeteller;

public class TimeFormatterNumeric implements TimeFormatter {

    public String formatTime(Clock clock) {
        String formattedTime = String.format("%02d:%02d:%02d", clock.getHour(), clock.getMinute(), clock.getSecond());
        if (clock.getTimeZone().equals("LOCAL")) { return formattedTime; }
        if (clock.getTimeZone().equals("UTC")) { return formattedTime + "Z"; }
        return formattedTime + " " + clock.getTimeZone();
    }
}
