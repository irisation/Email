package email.csv;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import email.Email;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToCSV {
    public static void main(String[] args) throws IOException {

        Email email = new Email("you@tut.by", "me@tut.by", "Hello", "How are you?", "10.12.2014");
        Email email2 = new Email("you1@tut.by", "me1@tut.by", "Hellohh", "How are you?", "10.12.2014");

        ArrayList<Email> emails = new ArrayList<>(2);

        emails.add(email);
        emails.add(email2);

        CsvMapper objectMapper = new CsvMapper();

        CsvSchema schema = objectMapper.schemaFor(Email.class).withHeader();
        BufferedWriter file = null;
        try {
            file = new BufferedWriter(new FileWriter("./resources/emails-w.csv"));
            objectMapper.writer(schema).writeValue(file, emails);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                file.close();
            }

        }


    }
}
