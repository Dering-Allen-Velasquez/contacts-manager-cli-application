import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Contacts {
    private static final Path path = Paths.get("./src/contacts.txt");
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void loadContacts() {
        if (Files.exists(path)) {
            try {
                ArrayList<String> allContacts = (ArrayList<String>) Files.readAllLines(path);
                System.out.println(allContacts);
                addContacts(allContacts);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

    public static ArrayList<Contact> searchContacts(String searchInput) {
        ArrayList<Contact> bucket = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchInput) || contact.getNumber().contains(searchInput)) {
                bucket.add(contact);
            }
        }

        return bucket;
    }

    public static void addContact(String[] contactInfo) {
        contacts.add(new Contact(contactInfo));
    }

    public static void deleteContact(int number) {
        contacts.remove(number);
    }

    public static void addContacts(ArrayList<String> strings) {
        for (String string : strings) {
            String[] contactInfo = new String[2], name = new String[2];
            contactInfo = string.split(":::");

            addContact(contactInfo);
        }
    }

    public static void saveContacts() {
        ArrayList<String> contactStrings = new ArrayList<>();
        for (Contact contact : contacts) {
            String string = contact.getName() + ":::" + contact.getNumber();
            contactStrings.add(string);
        }
//            contactStrings.add("Tracy:::2105555555");
        try {
            Files.write(path, contactStrings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        loadContacts();
        saveContacts();
    }
}

