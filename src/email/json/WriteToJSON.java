package email.json;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import email.Email;


import javax.json.stream.JsonGenerationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


//маршалинг для json
public class WriteToJSON {
    public static void main(String[] args) throws IOException {

        Email email = new Email("you@tut.by", "me@tut.by", "Hello", "How are you?", "10.12.2014");
        Email email2 = new Email("you1@tut.by", "me1@tut.by", "Hellohh", "How are you?", "10.12.2014");

        ArrayList<Email> emails = new ArrayList<Email>(2);
        emails.add(email);
        emails.add(email2);

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            objectMapper.writeValue(new File("./resources/emails-w.json"), emails);

            // display to console
            for(Email eml:emails) {
                Object json = objectMapper.readValue(
                        objectMapper.writeValueAsString(eml), Object.class);

                System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(json));
            }
        } catch (JsonGenerationException | IOException e) {
            e.printStackTrace();
        }
    }


}





