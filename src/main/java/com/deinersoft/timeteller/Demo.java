package com.deinersoft.timeteller;

import com.deinersoft.messenger.Email;
import com.deinersoft.messenger.Sms;

import javax.mail.MessagingException;
import java.io.IOException;

public class Demo {
    public static void main(String [] args) throws MessagingException, IOException{

        Email eMail = new Email("configEmail.properties");
        Sms sms = new Sms("config.Sms.properties");

        System.out.println(new TimeFormatterNumeric(new Clock()).formatTime());
        System.out.println(new TimeFormatterNumeric(new Clock("UTC")).formatTime());
        System.out.println(new TimeFormatterNumeric(new Clock("Europe/Kiev")).formatTime());
        System.out.println(new TimeFormatterApproximateWording(new Clock()).formatTime());
        System.out.println(new TimeFormatterApproximateWording(new Clock("UTC")).formatTime());
        System.out.println(new TimeFormatterApproximateWording(new Clock("Europe/Kiev")).formatTime());

        eMail.send(new TimeFormatterNumeric(new Clock()).formatTime());
        eMail.send(new TimeFormatterNumeric(new Clock("UTC")).formatTime());
        eMail.send(new TimeFormatterNumeric(new Clock("Europe/Kiev")).formatTime());
        eMail.send(new TimeFormatterApproximateWording(new Clock()).formatTime());
        eMail.send(new TimeFormatterApproximateWording(new Clock("UTC")).formatTime());
        eMail.send(new TimeFormatterApproximateWording(new Clock("Europe/Kiev")).formatTime());

        sms.send(new TimeFormatterNumeric(new Clock()).formatTime());
        sms.send(new TimeFormatterNumeric(new Clock("UTC")).formatTime());
        sms.send(new TimeFormatterNumeric(new Clock("Europe/Kiev")).formatTime());
        sms.send(new TimeFormatterApproximateWording(new Clock()).formatTime());
        sms.send(new TimeFormatterApproximateWording(new Clock("UTC")).formatTime());
        sms.send(new TimeFormatterApproximateWording(new Clock("Europe/Kiev")).formatTime());

    }

}
