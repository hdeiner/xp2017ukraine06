package test.com.deinersoft.clock;

import com.deinersoft.timeteller.Clock;
import com.deinersoft.timeteller.ClockForTesting;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClockTest {

    @Test
    public void newYorkIsLosAngelesPlus3(){
        Clock estTime = new Clock("America/New_York");
        Clock pstTime = new Clock("America/Los_Angeles");
        assertThat((pstTime.getHour()+3)%24, is(estTime.getHour()));
    }

    @Test
    public void clockForTestingIsAClock(){
        Clock clock = new ClockForTesting(1, 2, 3, "UTC");
        assertThat(clock.getHour(), is(1));
        assertThat(clock.getMinute(), is(2));
        assertThat(clock.getSecond(), is(3));
        assertThat(clock.getTimeZone(), is("UTC"));
    }

}
