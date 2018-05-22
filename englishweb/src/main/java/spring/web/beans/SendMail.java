package spring.web.beans;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class SendMail {
    static final String server = "huyl472@gmail.com";
    static final String password = "lethithanhthuy";

    public boolean sendMail(Mail mail) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(server, password);
                    }
                });
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(server));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail.getReciver()));
            message.setSubject(mail.getSubject());
            message.setText(mail.getContent());
            Transport.send(message);
            return true;


        } catch (MessagingException e) {
        }
        return false;

    }

    public String generateRandomString(int lenght) {
        String s = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            int character = (int) (Math.random() * s.length());
            builder.append(s.charAt(character));
        }
        return builder.toString();

    }


}
