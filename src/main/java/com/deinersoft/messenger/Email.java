package com.deinersoft.messenger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class Email extends  Messenger {

    public Email(String configurationFile) throws IOException {
        super(configurationFile);
    }

    public void send(String formattedTime) throws MessagingException {
        Session eMailSession = getEmailSession();
        Message message = new MimeMessage(eMailSession);
        message.setFrom(new InternetAddress(localConfiguration.getProperty("email.sender")));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(localConfiguration.getProperty("email.recipient")));
        message.setSubject(localConfiguration.getProperty("email.subject"));
        message.setText(localConfiguration.getProperty("email.message") + " " + formattedTime);

        Transport.send(message);
    }

    private Session getEmailSession() {
        Properties systemConfiguration = getSystemConfiguration(localConfiguration);
        return Session.getInstance(systemConfiguration,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(localConfiguration.getProperty("smtp.username.to.use"), localConfiguration.getProperty("smtp.password.to.use"));
                    }
                });
    }

    private Properties getSystemConfiguration(Properties localConfiguration) {
        Properties systemProperties = System.getProperties();

        systemProperties.put("mail.smtp.auth", localConfiguration.getProperty("smtp.authentication.enabled"));
        systemProperties.put("mail.smtp.starttls.enable", localConfiguration.getProperty("smtp.starttls.enabled"));
        systemProperties.put("mail.smtp.host", localConfiguration.getProperty("smtp.host.to.use"));
        systemProperties.put("mail.smtp.port", localConfiguration.getProperty("smtp.port.to.use"));

        return systemProperties;
    }

}