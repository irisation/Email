package email.property;


import email.Email;

import java.io.*;
import java.util.Properties;

public class ReadProp {
        private static final Properties emails;

        static {
            emails = new Properties();
            try (InputStream is = new FileInputStream("./resources/emails.properties")) {
                emails.load(is);
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }

        public static Email get(int id) {
            Email email = new Email(emails.getProperty("email.toAddress." + id), emails.getProperty("email.fromAddress." + id),
                    emails.getProperty("email.subject." + id), emails.getProperty("email.body." + id), emails.getProperty("email.sendDate." + id) );
            email.setEmailId(id);
            return email;
        }

    public static void main(String[] args) throws IOException {
        Email email = ReadProp.get(1);
        System.out.println(email);

    }
}

