package com.deinersoft.timeteller;

public class TimeFormatterNumeric extends TimeFormatter {

    public TimeFormatterNumeric(Clock clock) {
        super(clock);
    }

    public String formatTime() {
        String formattedTime = String.format("%02d:%02d:%02d", clock.getHour(), clock.getMinute(), clock.getSecond());
        if (clock.getTimeZone() == "LOCAL") { return formattedTime; }
        if (clock.getTimeZone() == "UTC") { return formattedTime + "Z"; };
        return formattedTime + " " + clock.getTimeZone();
    }
}