package email.xml;

import email.Email;
import email.Emails;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Date;

/**
 * Created by Irko on 09.12.2014.
 */
public class Marshaller {
    public static void main(String[] args) {
        Email email = new Email("you@tut.by", "me@tut.by", "Hello", "How are you?", "10.12.2014");
        Email email2 = new Email("you1@tut.by", "me1@tut.by", "Hellohh", "How are you?", "10.12.2014");
        Emails emails = new Emails();
        emails.add(email);
        emails.add(email2);

        try {
            File file = new File("./resources/emails-w.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Emails.class);
            javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(emails, file);
            jaxbMarshaller.marshal(emails, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
