<%-- 
    Document   : validate
    Created on : Oct 20, 2013, 7:08:59 PM
    Author     : Philip
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
--%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
    final String username = "username@gmail.com";
    final String password = "password";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from-email@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("to-email@gmail.com"));
        message.setSubject("Testing Subject");
        message.setText("Dear Mail Crawler,"
                + "\n\n No spam to my email, please!");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
%>
<html>
    <head>
        <title>Validate account</title>
    </head>
    <body>
        <p align="center">
            <%
                out.println("Result: " + result + "\n");
            %>
        <form method="post" action="util">
            <input type="hidden" name="action" value="validate" />
            <label>Enter the validation string you received in your email here</label>
            <input type="text" name="enterValidation"/>
            <input type="submit" value="validate"/>
        </form>
    </p>
</body>
</html>