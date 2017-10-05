package com.deinersoft.timeteller;

import com.deinersoft.messenger.Email;
import com.deinersoft.messenger.Sms;

import javax.mail.MessagingException;
import java.io.IOException;

class Demo {
    public static void main(String [] args) throws MessagingException, IOException{

        System.out.println(new TimeFormatterNumeric().formatTime(new Clock()));
        System.out.println(new TimeFormatterNumeric().formatTime(new Clock("UTC")));
        System.out.println(new TimeFormatterNumeric().formatTime(new Clock("Europe/Kiev")));
        System.out.println(new TimeFormatterApproximateWording().formatTime(new Clock()));
        System.out.println(new TimeFormatterApproximateWording().formatTime(new Clock("UTC")));
        System.out.println(new TimeFormatterApproximateWording().formatTime(new Clock("Europe/Kiev")));

        Email eMail = new Email("configEmail.properties");
        eMail.send(new TimeFormatterNumeric().formatTime(new Clock()));
        eMail.send(new TimeFormatterNumeric().formatTime(new Clock("UTC")));
        eMail.send(new TimeFormatterNumeric().formatTime(new Clock("Europe/Kiev")));
        eMail.send(new TimeFormatterApproximateWording().formatTime(new Clock()));
        eMail.send(new TimeFormatterApproximateWording().formatTime(new Clock("UTC")));
        eMail.send(new TimeFormatterApproximateWording().formatTime(new Clock("Europe/Kiev")));

        Sms sms = new Sms("config.Sms.properties");
        sms.send(new TimeFormatterNumeric().formatTime(new Clock()));
        sms.send(new TimeFormatterNumeric().formatTime(new Clock("UTC")));
        sms.send(new TimeFormatterNumeric().formatTime(new Clock("Europe/Kiev")));
        sms.send(new TimeFormatterApproximateWording().formatTime(new Clock()));
        sms.send(new TimeFormatterApproximateWording().formatTime(new Clock("UTC")));
        sms.send(new TimeFormatterApproximateWording().formatTime(new Clock("Europe/Kiev")));

    }

}
