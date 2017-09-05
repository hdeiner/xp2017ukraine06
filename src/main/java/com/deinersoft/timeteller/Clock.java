package com.deinersoft.timeteller;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Clock {
    String timeZone;
    ZonedDateTime zonedDateTime;

    public Clock() {
        this.timeZone = "LOCAL";
        zonedDateTime = ZonedDateTime.now();
    }

    public Clock(String timeZone) {
        this.timeZone = timeZone;
        zonedDateTime = ZonedDateTime.now(ZoneId.of(timeZone));
    }

    public int getHour() { return zonedDateTime.getHour(); }

    public int getMinute() { return zonedDateTime.getMinute(); }

    public int getSecond() { return zonedDateTime.getSecond(); }

    public String getTimeZone() {
        return timeZone;
    }
}
