package PhoneBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Importer implements IImporter{
    public List<Contact> importContacts(String filePath)
{
        List<Contact> importedContacts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    Contact contact = new Contact(fields[0], fields[1], fields[2], fields[3]);
                    importedContacts.add(contact);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return importedContacts;
    }
}