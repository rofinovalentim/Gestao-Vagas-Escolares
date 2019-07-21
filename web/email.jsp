<%-- 
    Document   : email
    Created on : Oct 14, 2018, 8:19:44 PM
    Author     : Rofino Chunga Jr
--%>
<%@page import="javax.activation.FileDataSource"%>
<%@page import="javax.activation.DataSource"%>
<%@page import="javax.mail.*"%>
<%@page import="javax.naming.*"%>
<%@page import="java.io.*"%>
<%@page import="javax.mail.internet.*"%>
<%@page import="javax.activation.*"%>
<%@page import="com.sun.mail.smtp.*"%>
<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            String user, host, pass;

            host = "smtp.gmail.com";
            pass = "rofinounilurio";
            user = "rvalentim@unilurio.ac.mz";
            String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            String to = "rvalentim@unilurio.ac.mz";
            String from = "rvalentim@unilurio.ac.mz";
            String subject = "Enviando Arquivo do Email";
            String messageText = "melhores cumprimentos";

            boolean WasEmailSent;
            boolean sessionDebug = true;

            Properties props = System.getProperties();
            props.put("mail.host", host);
            props.put("mail.transport.protocol.", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.startls.enable", "true");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.socketFactory.class", SSL_FACTORY);

            Session mailSession = Session.getInstance(props, null);
            mailSession.setDebug(sessionDebug);

            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);

            msg.setSubject(subject);
  //msg.setContent(msg);

            Transport transport = mailSession.getTransport("smtp");

            try {
                out.print("Enviado Com sucesso");
                transport.connect(host, user, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
                WasEmailSent = true;

            } catch (Exception ex) {
                WasEmailSent = false;
            }
            transport.close();

        %>
    </body>
</html>
