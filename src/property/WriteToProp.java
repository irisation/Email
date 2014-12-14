package property;

import email.Email;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;


public class WriteToProp {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        Email email1 = new Email("you@tut.by", "me@tut.by", "Hello", "How are you?", "10.12.2014");
        Email email2 = new Email("you1@tut.by", "me1@tut.by", "Hellohh", "How are you?", "10.12.2014");
        ArrayList<Email> emails = new ArrayList<>(2);
        emails.add(email1);
        emails.add(email2);
        for (Email email: emails) {
            int id = email.getEmailId();
            prop.setProperty("email.toAddress." + id, email.getToAddress());
            prop.setProperty("email.fromAddress." + id, email.getFromAddress());
            prop.setProperty("email.subject." + id, email.getSubject());
            prop.setProperty("email.body." + id, email.getBody());
            prop.setProperty("email.sendDate." + id, email.getSendDate());
            prop.setProperty("email.id." + id, String.valueOf(id));
        }
        OutputStream is = new FileOutputStream("./resources/emails-w.properties");
        prop.store(is, "");
        is.close();
    }
}
