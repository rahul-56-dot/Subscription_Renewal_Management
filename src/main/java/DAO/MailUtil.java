package DAO;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class MailUtil {

    public static void sendExpiryAlert(String toEmail, String username, String planName)
            throws Exception {

        final String from = "varimadlarahul8@gmail.com";   // admin mail
        final String password = "wnja lxhc htld zats"; // Gmail App Password

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
        msg.setRecipients(
            Message.RecipientType.TO,
            InternetAddress.parse(toEmail)
        );

        msg.setSubject("Subscription Expiry Alert");

        msg.setText(
            "Hello " + username + ",\n\n" +
            "Your subscription for plan \"" + planName + "\" is about to expire.\n" +
            "Please renew your plan to continue enjoying our service.\n\n" +
            "Regards,\nAdmin Team"
        );

        Transport.send(msg);
    }
}
