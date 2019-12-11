package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;


public class MailUtil {

//    public static void sendMail(String recipient, final String fromAccount, final String password, String text){
////        System.out.println("Prepare message");
////        Properties properties = new Properties();
////
//////        properties.put("mail.smtp.host", "smtp.gmail.com");
//////        properties.put("mail.smtp.port", "587");
//////        properties.put("mail.smtp.auth", "true");
//////        properties.put("mail.smtp.starttls.enable", "true");
////
////        properties.put("mail.default-encoding", "UTF-8");
////        properties.put("mail.host", "smtp.gmail.com");
////        properties.put("mail.username", fromAccount);
////        properties.put("mail.password", password);
////        properties.put("mail.port", "587");
////        properties.put("mail.protocol", "smtp");
////        properties.put("mail.debug", "true");
////        properties.put("mail.smtp.auth", "true");
////        properties.put("mail.smtp.starttls.enable", "true");
////
////
////        Session session = Session.getInstance(properties, new Authenticator() {
////            @Override
////            protected PasswordAuthentication getPasswordAuthentication() {
////                return new PasswordAuthentication(fromAccount, password);
////            }
////        });
////
////        Message message = prepareMessage(session, fromAccount, recipient, text);
////
////        try {
////            Transport.send(message);
////        } catch (MessagingException e) {
////            e.printStackTrace();
////        }
////        System.out.println("Message sent successfully!");
////
////    }
////
////    private static Message prepareMessage(Session session, String fromAccount, String recepient, String text){
////        Message message = new MimeMessage(session);
////        try {
////            message.setFrom(new InternetAddress(fromAccount));
////            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
////            message.setSubject("Time to make a trade");
////            message.setText(text);
////            return message;
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return null;
////    }


    public static void sendMail(String recipient, String fromAccount, String subject, String message) throws IOException {
        Email from = new Email(fromAccount);
        Email to = new Email(recipient);
        Content content = new Content("text/plain", message);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}
