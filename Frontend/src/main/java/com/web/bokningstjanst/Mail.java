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

    public static String sendMail(String to, String extra, String mode) {

        final String username = "bokelibok@gmail.com";
        final String password = "Derp1234";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
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
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
            
            if(mode.equals("validation")){
                message.setSubject("Validation");
                message.setText("Welcome, your username is your email and this is your password: "+extra+".\nHere is your validation code: "+validationString
                    + "\n\n Please enter it on the site you were redirected to.");
                Transport.send(message);
                
            }else if(mode.equals("ticket")){
                message.setSubject("Your ticket");
                message.setText("Here is your ticket\n\n"+extra);//add ticket here
                Transport.send(message);
                
            }else if(mode.equals("contact")){
                message.setSubject("User feedback");
                message.setText("Your message have been recieved and will be answered shortly.");
                Transport.send(message);
            }
            
            

            System.out.println("Done");
            return validationString;

        } catch (MessagingException e) {
            return "error";
            
        }
    }
}