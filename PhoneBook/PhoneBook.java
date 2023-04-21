package PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    // private List<Contact> contacts;
    public List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void exportToCsv(String fileName) {
        Exporter exporter = new Exporter();
        exporter.exportContacts(contacts, fileName);
    }

    public void importContacts(String fileName) {
        Importer importer = new Importer();
        List<Contact> importedContacts = importer.importContacts(fileName);
        contacts.addAll(importedContacts);
    }
}
