package util;


import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;


public class EmailSender {

    public static void create() {
        try {
            Email email = EmailBuilder.startingBlank()
                    .from("emailsendchathushapehemina@gmail.com")
                    .to("kython9999@gmail.com")
                    .withSubject("Hello")
                    .withPlainText("Hello, this is a test email.")
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
