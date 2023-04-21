package PhoneBook;

import java.io.IOException;
import java.util.List;

public interface IImporter {
    List<Contact> importContacts(String fileName) throws IOException;
}
