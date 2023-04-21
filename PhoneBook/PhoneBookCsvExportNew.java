package PhoneBook;

import java.util.List;

public class PhoneBookCsvExportNew extends Exporter{
    @Override
    public void exportContacts(List<Contact> contacts, String filePath) {
        ExporterNew exporter = new ExporterNew();
        exporter.exportContacts(contacts, filePath + ".csv");
    }
}