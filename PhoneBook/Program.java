package PhoneBook;
// OCP - принцип: класс Exporter имеет базовую реализацию, а PhoneBookCsvExport и PhoneBookTXTExport расширяют его также и с импортом
// LSP - принцип: для экспорта в файл мы можем использовать как класс Exporter так и PhoneBookCsvExport, результат будет одинаковый, как и у импорта
// SRP - принцип: каждый класс в этом проекте имеет одну ответственность, даже класс PhoneBook у которого есть 4 метода, так как он отвечает только за управление списком контактов, и не занимается никакими другими задачами
public class Program {
    public static void main(String[] args) {
        // контакты
        Contact oleg = new Contact("Oleg", "Barvin", "1", "1@mail.ru");
        Contact Vitya = new Contact("Vitya", "Lagov", "2", "2@mail.ru");
        Contact Tom = new Contact("Tom", "Cruize", "3", "3@mail.ru");
        
        // телефонные книги
        PhoneBook firstBook = new PhoneBook();
        PhoneBook twoBook = new PhoneBook();
        PhoneBook threeBook = new PhoneBook();
        PhoneBook fourBook = new PhoneBook();

        // добавление контактов в книгу
        firstBook.addContact(oleg);
        firstBook.addContact(Vitya);
        firstBook.addContact(Tom);
        
        // экспорт
        Exporter firstExporterExport = new Exporter(); // родительский
        ExporterNew firstExporterExportNew = new ExporterNew(); // дочерний
       
        // импорт
        Importer Imp = new Importer(); // родительский
        PhoneBookCsvImport firstImport = new PhoneBookCsvImport(); // дочерний
        PhoneBookTXTImport firstTXTImport = new PhoneBookTXTImport(); // дочерний

        PhoneBookCsvExport firstCSVExport = new PhoneBookCsvExport();
        PhoneBookTXTExport firstTXTExport = new PhoneBookTXTExport();
        PhoneBookCsvExportNew firstCSVExportNew = new PhoneBookCsvExportNew();

    
        System.out.println("Контакты 1 книги" + firstBook.getContacts() + "\n");

        // LSP
        firstExporterExport.exportContacts(firstBook.getContacts(), "PhoneBook1.csv");
        firstCSVExport.exportContacts(firstBook.getContacts(), "PhoneBook");
        firstTXTExport.exportContacts(firstBook.getContacts(), "phonebook");

        // LSP
        firstExporterExportNew.exportContacts(firstBook.getContacts(), "PhoneBook22.csv"); 
        firstCSVExportNew.exportContacts(firstBook.getContacts(), "PhoneBook2");

        twoBook.importContacts("PhoneBook.csv");

        // родительский и дочерний класс взаимозаменяемы
        System.out.println("Родительский Импортирующий класс csv" + Imp.importContacts("PhoneBook.csv") + "\n");
        System.out.println("Родительский Импортирующий класс txt" + Imp.importContacts("phonebook.txt") + "\n");
        System.out.println("дочерний CSV класс" + firstImport.importContacts("PhoneBook") + "\n");
        System.out.println("дочерний TXT класс" + firstTXTImport.importContacts("phonebook") + "\n");

        System.out.println("Импортированные контакты  2 книги" + twoBook.getContacts());
    }

}
