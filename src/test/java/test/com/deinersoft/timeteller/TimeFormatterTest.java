package test.com.deinersoft.timeteller;

import com.deinersoft.timeteller.*;
import org.junit.Test;
import test.com.deinersoft.clock.ClockForTesting;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TimeFormatterTest {

    @Test
    public void localTimeNumericNow(){
        assertThat(new TimeFormatterNumeric().formatTime(new Clock()), is(getFormatTimeLocal()));
    }

    @Test
    public void utcTimeNumericNow(){
        assertThat(new TimeFormatterNumeric().formatTime(new Clock("UTC")), is(getFormatTimeUTC()));
    }

    @Test
    public void localTimeNumeric102445(){
        assertThat(new TimeFormatterNumeric().formatTime(new ClockForTesting(10,24,45, "LOCAL")), is("10:24:45"));
    }

    @Test
    public void zuluTimeNumeric102445(){
        assertThat(new TimeFormatterNumeric().formatTime(new ClockForTesting(10,24,45, "UTC")), is("10:24:45Z"));
    }

   @Test
   public void zuluTimeInWords000005(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(0,0,5, "UTC")), is("about twelve at night Zulu"));
   }

   @Test
   public void localTimeInWords000005(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(0,0,5, "LOCAL")), is("about twelve at night"));
   }

    @Test
    public void localTimeInWords090239(){
        assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,2,39, "LOCAL")), is("a little after nine in the morning"));
    }

    @Test
    public void localTimeInWords090949(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,9,49, "LOCAL")), is("about ten after nine in the morning"));
    }

   @Test
   public void localTimeInWords091702(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,17,2, "LOCAL")), is("about a quarter after nine in the morning"));
   }

   @Test
   public void localTimeInWords091902(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,19,2, "LOCAL")), is("about twenty after nine in the morning"));
   }

   @Test
   public void localTimeInWords092312(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,23,12, "LOCAL")), is("almost half past nine in the morning"));
   }

   @Test
   public void localTimeInWords093112(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,31,12, "LOCAL")), is("about half past nine in the morning"));
   }

   @Test
   public void localTimeInWords093623(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,36,23, "LOCAL")), is("almost twenty before ten in the morning"));
   }

   @Test
   public void localTimeInWords093823(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,38,23, "LOCAL")), is("about twenty before ten in the morning"));
   }

   @Test
   public void localTimeInWords094145(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,43,45, "LOCAL")), is("about a quarter of ten in the morning"));
   }

   @Test
   public void localTimeInWords094945(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,49,45, "LOCAL")), is("about ten of ten in the morning"));
   }

   @Test
   public void localTimeInWords095801(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(9,53,1, "LOCAL")), is("almost ten in the morning"));
   }

   @Test
   public void localTimeInWords120105(){
       assertThat(new TimeFormatterApproximateWording().formatTime(new ClockForTesting(12,1,5, "LOCAL")), is("about twelve in the afternoon"));
   }

    private String getFormatTimeLocal() {
        return String.format("%02d:%02d:%02d", LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(), LocalDateTime.now().getSecond());
    }

    private String getFormatTimeUTC() {
        return String.format("%02d:%02d:%02d", LocalDateTime.now(java.time.Clock.systemUTC()).getHour(), LocalDateTime.now(java.time.Clock.systemUTC()).getMinute(), LocalDateTime.now(java.time.Clock.systemUTC()).getSecond())+"Z";
    }

}