package email.yaml;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import email.Email;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class WriteToYAML {
    public static void main(String[] args) throws IOException {
        Email email = new Email("you@tut.by", "me@tut.by", "Hello", "How are you?", "10.12.2014");
        Email email2 = new Email("you1@tut.by", "me1@tut.by", "Hellohh", "How are you?", "10.12.2014");

        ArrayList<Email> emails = new ArrayList<Email>(2);
        emails.add(email);
        emails.add(email2);
        YAMLFactory fact = new YAMLFactory();
        ObjectMapper objectMapper = new ObjectMapper(fact);

        BufferedWriter file = new BufferedWriter(new FileWriter("./resources/emails-w.yaml"));
        file.write(objectMapper.writeValueAsString(emails));
        file.close();


    }

}

