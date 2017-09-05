package test.com.deinersoft.messenger;

import com.deinersoft.messenger.Sms;
import com.deinersoft.timeteller.ClockForTesting;
import com.deinersoft.timeteller.TimeFormatterNumeric;
import com.twilio.rest.api.v2010.account.Message;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;

public class SmsTest {
    @Test
    public void sendAndValidateSms() throws IOException {
        Sms sms = new Sms("config.Sms.properties");

        sms.send(new TimeFormatterNumeric(new ClockForTesting(12,0,0, "LOCAL")).formatTime());

        assertThat(sms.getStatus(), isIn(new Message.Status[]{Message.Status.QUEUED,Message.Status.ACCEPTED, Message.Status.DELIVERED,Message.Status.RECEIVED,Message.Status.RECEIVING,Message.Status.SENDING, Message.Status.SENT}));
    }
}
