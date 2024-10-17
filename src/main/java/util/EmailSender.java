package util;


import jakarta.activation.DataSource;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;




public class EmailSender {

    public static void create(String to, String subject, String text, DataSource file) {
        try {
            Email email = EmailBuilder.startingBlank()
                    .from("emailsendchathushapehemina@gmail.com")
                    .to(to)
                    .withSubject(subject)
                    .withPlainText(text)
                    .withAttachment("Bill",file)
                    .buildEmail();

            Mailer mailer = MailerBuilder
                    .withSMTPServer("smtp.gmail.com", 465, "emailsendchathushapehemina@gmail.com", "jswv gzqk cqtv armn")
                    .withTransportStrategy(TransportStrategy.SMTPS)
                    .buildMailer();

            mailer.sendMail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void create(String to, String subject, String text) {
        try {
            Email email = EmailBuilder.startingBlank()
                    .from("emailsendchathushapehemina@gmail.com")
                    .to(to)
                    .withSubject(subject)
                    .withPlainText(text)
                    .buildEmail();

            Mailer mailer = MailerBuilder
                    .withSMTPServer("smtp.gmail.com", 465, "emailsendchathushapehemina@gmail.com", "jswv gzqk cqtv armn")
                    .withTransportStrategy(TransportStrategy.SMTPS)
                    .buildMailer();

            mailer.sendMail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
