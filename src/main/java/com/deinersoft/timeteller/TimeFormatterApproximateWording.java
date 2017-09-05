package com.deinersoft.timeteller;

public class TimeFormatterApproximateWording extends TimeFormatter {

    private static final int SECONDS_IN_A_HALF_MINUTE = 30;
    private static final int HOURS_IN_A_QUARTER_OF_A_DAY = 6;
    private static final int MINUTE_TO_START_FUZZING_INTO_NEXT_HOUR = 35;

    public TimeFormatterApproximateWording(Clock clock) {
        super(clock);
    }

    public String formatTime(){
        String formattedTime = "";

        int hour = clock.getHour();
        int minute = clock.getMinute();
        int second = clock.getSecond();

        String[] namesOfTheHours = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};
        String[] fuzzyTimeWords = {"about", "a little after", "about ten after", "about a quarter after", "about twenty after", "almost half past", "about half past", "almost twenty before", "about twenty before", "about a quarter of", "about ten of", "almost", "about"};
        String[] quadrantOfTheDay = {"at night", "in the morning", "in the afternoon", "in the evening"};

        if (second >= SECONDS_IN_A_HALF_MINUTE) minute++;

        formattedTime += fuzzyTimeWords[(minute+2)/5] + " ";

        if (minute < MINUTE_TO_START_FUZZING_INTO_NEXT_HOUR) {
            formattedTime += namesOfTheHours[hour % namesOfTheHours.length];
        }  else {
            formattedTime += namesOfTheHours[(hour+1) % namesOfTheHours.length];
        }

        formattedTime += " " + quadrantOfTheDay[hour/HOURS_IN_A_QUARTER_OF_A_DAY];

        if (clock.getTimeZone().equals("LOCAL")) { return formattedTime; }
        if (clock.getTimeZone().equals("UTC")) { return formattedTime + " Zulu"; }
        return formattedTime + " " + clock.getTimeZone();
    }

}
