import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Contacts {
    private static Path path = Paths.get("./src/contacts.txt");
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void loadContacts() {
        if (Files.exists(path)) {
            try {
                ArrayList<String> allContacts = (ArrayList<String>) Files.readAllLines(path);
                System.out.println(allContacts);
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

    public static void addContacts(ArrayList<String> strings) {
        for (String string:strings) {
        String[] contactInfo = new String[2], name = new String[2];
         contactInfo = string.split("\\[|]");

        Contact contact = new Contact(contactInfo);
        contacts.add(contact);
        }
    }

    public static void saveContacts(){
        ArrayList<String> contactString = new ArrayList<>();
        for (Contact contact: contacts) {
            String string = contact.getName() + "[|]" + contact.getNumber();
            }
    }

    public static void main(String[] args) {
        loadContacts();
    }
}

