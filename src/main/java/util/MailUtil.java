package util;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;



public class MailUtil {

    public static void sendMail(String recipient, final String fromAccount, final String password, String text){
        System.out.println("Prepare message");
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

//        properties.put("mail.default-encoding", "UTF-8");
//        properties.put("mail.host", "smtp.gmail.com");
//        properties.put("mail.username", fromAccount);
//        properties.put("mail.password", password);
//        properties.put("mail.port", "587");
//        properties.put("mail.protocol", "smtp");
//        properties.put("mail.debug", "true");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromAccount, password);
            }
        });

        Message message = prepareMessage(session, fromAccount, recipient, text);

        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Message sent successfully!");

    }

    private static Message prepareMessage(Session session, String fromAccount, String recepient, String text){
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(fromAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Time to make a trade");
            message.setText(text);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//
//    public static void sendMail(String recipient, String fromAccount, String subject, String message) throws IOException {
//        Email from = new Email(fromAccount);
//        Email to = new Email(recipient);
//        Content content = new Content("text/plain", message);
//        Mail mail = new Mail(from, subject, to, content);
//
//        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
//        Request request = new Request();
//        try {
//            request.setMethod(Method.POST);
//            request.setEndpoint("mail/send");
//            request.setBody(mail.build());
//            Response response = sg.api(request);
//            System.out.println("status code: " + response.getStatusCode());
//            System.out.println("response body: " + response.getBody());
//            System.out.println(response.getHeaders());
//        } catch (IOException ex) {
//            throw ex;
//        }
//    }


//    private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";
//    private static final String SMTP_AUTH_USER = System.getenv("SENDGRID_USERNAME");
//    private static final String SMTP_AUTH_PWD  = System.getenv("SENDGRID_PASSWORD");

//    private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";
//    private static final String SMTP_AUTH_USER = System.getenv("app155169274@heroku.com");
//    private static final String SMTP_AUTH_PWD  = System.getenv("5yctqlaj9858");
//
//    public static void sendMail(String fromEmail, String toEmail, String subject, String htmlContent) throws Exception{
//        Properties props = new Properties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.host", SMTP_HOST_NAME);
//        props.put("mail.smtp.port", 587);
//        props.put("mail.smtp.auth", "true");
//
//        Authenticator auth = new SMTPAuthenticator();
//        Session mailSession = Session.getDefaultInstance(props, auth);
//        // uncomment for debugging infos to stdout
//        // mailSession.setDebug(true);
//        Transport transport = mailSession.getTransport();
//        MimeMessage message = new MimeMessage(mailSession);
//        Multipart multipart = new MimeMultipart("alternative");
//
//        BodyPart bodyPart = new BodyPart() {
//            @Override
//            public int getSize() throws MessagingException {
//                return 0;
//            }
//
//            @Override
//            public int getLineCount() throws MessagingException {
//                return 0;
//            }
//
//            @Override
//            public String getContentType() throws MessagingException {
//                return null;
//            }
//
//            @Override
//            public boolean isMimeType(String s) throws MessagingException {
//                return false;
//            }
//
//            @Override
//            public String getDisposition() throws MessagingException {
//                return null;
//            }
//
//            @Override
//            public void setDisposition(String s) throws MessagingException {
//
//            }
//
//            @Override
//            public String getDescription() throws MessagingException {
//                return null;
//            }
//
//            @Override
//            public void setDescription(String s) throws MessagingException {
//
//            }
//
//            @Override
//            public String getFileName() throws MessagingException {
//                return null;
//            }
//
//            @Override
//            public void setFileName(String s) throws MessagingException {
//
//            }
//
//            @Override
//            public InputStream getInputStream() throws IOException, MessagingException {
//                return null;
//            }
//
//            @Override
//            public DataHandler getDataHandler() throws MessagingException {
//                return null;
//            }
//
//            @Override
//            public Object getContent() throws IOException, MessagingException {
//                return null;
//            }
//
//            @Override
//            public void setDataHandler(DataHandler dataHandler) throws MessagingException {
//
//            }
//
//            @Override
//            public void setContent(Object o, String s) throws MessagingException {
//
//            }
//
//            @Override
//            public void setText(String s) throws MessagingException {
//
//            }
//
//            @Override
//            public void setContent(Multipart multipart) throws MessagingException {
//
//            }
//
//            @Override
//            public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
//
//            }
//
//            @Override
//            public String[] getHeader(String s) throws MessagingException {
//                return new String[0];
//            }
//
//            @Override
//            public void setHeader(String s, String s1) throws MessagingException {
//
//            }
//
//            @Override
//            public void addHeader(String s, String s1) throws MessagingException {
//
//            }
//
//            @Override
//            public void removeHeader(String s) throws MessagingException {
//
//            }
//
//            @Override
//            public Enumeration<Header> getAllHeaders() throws MessagingException {
//                return null;
//            }
//
//            @Override
//            public Enumeration<Header> getMatchingHeaders(String[] strings) throws MessagingException {
//                return null;
//            }
//
//            @Override
//            public Enumeration<Header> getNonMatchingHeaders(String[] strings) throws MessagingException {
//                return null;
//            }
//        };
//        bodyPart.setContent(htmlContent, "text/html");
//        multipart.addBodyPart(bodyPart);
//
//
//        message.setContent(multipart);
//        message.setFrom(new InternetAddress(fromEmail));
//        message.setSubject(subject);
//        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//
//        transport.connect();
//        transport.sendMessage(message,
//                message.getRecipients(Message.RecipientType.TO));
//        transport.close();
//    }
//
//    private static class SMTPAuthenticator extends javax.mail.Authenticator {
//        public PasswordAuthentication getPasswordAuthentication() {
//            String username = SMTP_AUTH_USER;
//            String password = SMTP_AUTH_PWD;
//            return new PasswordAuthentication(username, password);
//        }
//    }

}
