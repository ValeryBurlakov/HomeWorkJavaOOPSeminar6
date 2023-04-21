package PhoneBook;

import java.util.List;

public class BookSaver {
    public void saveContacts(List<Contact> contacts, PhoneBook book) {
        book.getContacts().addAll(contacts);
    }
 }
