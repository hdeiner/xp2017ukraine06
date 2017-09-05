package com.deinersoft.messenger;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.io.IOException;

public class Sms extends Messenger {
    Message message;

    public Sms(String configurationFile) throws IOException {
        super(configurationFile);
    }

    public void send(String formattedTime) {
        Twilio.init(localConfiguration.getProperty("account.sid"), localConfiguration.getProperty("auth.token"));

        message = Message.creator(  new PhoneNumber(localConfiguration.getProperty("number.to")),
                                    new PhoneNumber(localConfiguration.getProperty("number.from")),
                                    formattedTime   ).create();

    }

    public Message.Status getStatus() {
        return message.getStatus();
    }

}
