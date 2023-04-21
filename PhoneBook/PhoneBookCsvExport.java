package PhoneBook;
import java.util.List;

public class PhoneBookCsvExport extends Exporter{
    @Override
    public void exportContacts(List<Contact> contacts, String filePath) {
        Exporter exporter = new Exporter();
        exporter.exportContacts(contacts, filePath + ".csv");
    }
}
