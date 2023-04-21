package PhoneBook;

import java.util.List;

public interface IExporter {
    void exportContacts(List<Contact> contacts, String filePath);
}
