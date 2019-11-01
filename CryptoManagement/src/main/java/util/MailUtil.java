package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {

    public static void sendMail(String recipient, final String fromAccount, final String password){
        System.out.println("Prepare message");
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromAccount, password);
            }
        });

        Message message = prepareMessage(session, fromAccount, recipient);

        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Message sent successfully!");
    }

    private static Message prepareMessage(Session session, String fromAccount, String recepient){
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(fromAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("My first email");
            message.setText("Hey There!");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
