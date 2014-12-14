package email.xml;

import email.Email;
import email.Emails;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Created by Irko on 09.12.2014.
 */
public class Unmarshaller {
    public static void main(String[] args) {
        try {
            File file = new File("./resources/emails-r.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Emails.class);

            javax.xml.bind.Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Emails emails = (Emails) jaxbUnmarshaller.unmarshal(file);
            for (Email arr : emails.getEmails()) {
                System.out.println(arr);
            }
//            System.out.println(emails.getEmails().get(1));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
