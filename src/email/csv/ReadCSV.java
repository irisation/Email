package email.csv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import email.Email;

import java.io.*;
import java.util.ArrayList;

public class ReadCSV {
    public static void main(String[] args) throws IOException {

        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader("./resources/emails-r.csv"));
            //схему можно задать явным образом
            CsvMapper objectMapper = new CsvMapper();

//        CsvSchema schema = CsvSchema.builder()
//                .addColumn("emailId", CsvSchema.ColumnType.NUMBER)
//                .addColumn("toAddress")
//                .addColumn("fromAddress")
//                .addColumn("subject")
//                .addColumn("body")
//                .addColumn("sendDate")
//                .build().withoutHeader();


            //используем заголовки
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            MappingIterator<Email> result = objectMapper.reader(Email.class).with(schema).readValues(file);
            ArrayList<Email> emails = new ArrayList<Email>();
            while (result.hasNext()) {
                emails.add(result.next());

            }
            for (Email arr : emails) {
                System.out.println(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                file.close();
            }

        }

    }
}
