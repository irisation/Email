package email;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(name = "email")
public class Email {
    private int  emailId;
    private String toAddress;
    private String fromAddress;
    private String subject;
    private String body;
    private String sendDate;
    private static int  currentemailId = 0;


    public Email(){};
    public Email(String toAddress, String fromAddress, String subject, String body, String sendDate) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.subject = subject;
        this.body = body;
        this.emailId = ++currentemailId;
        this.sendDate = sendDate;
    }

    public String getToAddress() {
        return toAddress;
    }
    @XmlElement
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }
    @XmlElement
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getSubject() {
        return subject;
    }
    @XmlElement
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }
    @XmlElement
    public void setBody(String body) {
        this.body = body;
    }

    public int getEmailId() {
        return emailId;
    }
    @XmlAttribute
    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }
    @XmlElement
    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return ("From: " + this.fromAddress + "\nto: " + this.toAddress + "\nSubject: " + this.subject + "\n" + this.body + "\n" + this.sendDate + "\nid:" + this.emailId);
    }
}
