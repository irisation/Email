package email;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement(name = "emails")
public class Emails {
    ArrayList<Email> emails;
    public Emails(){
        emails = new ArrayList<Email>();
    }
    public void add(Email email){
        emails.add(email);
    }
    @XmlElement(name = "email")
    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }
}
