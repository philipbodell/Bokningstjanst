package com.web.bokningstjanst;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mail {

    public static String sendMail(String to, String uPassword) {

        final String username = "bodellbokning@gmail.com";
        final String password = "bodellbokning123";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {
            
            String possibleLetters="QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
            Random random=new Random();
            String validationString="";
            for (int a=0;a<8;a++){
                validationString+=possibleLetters.charAt(random.nextInt(possibleLetters.length()));
            }
            
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bodellbokning@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
            message.setSubject("Validation");
            message.setText("Welcome, your username is your email and this is your password: "+uPassword+".\nHere is your validation code: "+validationString
                + "\n\n Please enter it on the site you were redirected to.");

            Transport.send(message);

            System.out.println("Done");
            return validationString;

        } catch (MessagingException e) {
            return "error";
            
        }
    }
}