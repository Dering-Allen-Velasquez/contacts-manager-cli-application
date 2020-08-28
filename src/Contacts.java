import java.io.IOException;
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

        if(bucket.isEmpty()) {
            System.out.println("No Results found");
            return contacts;
        }

        return bucket;
    }

    public static void addContact(String[] contactInfo) {
        contacts.add(new Contact(contactInfo));
    }

    public static void deleteContact(int number) {
        System.out.println("You have deleted " + contacts.get(number).getName());
        contacts.remove(number);

    }

    public static void addContacts(ArrayList<String> strings) {
        for (String string : strings) {
            String[] contactInfo = new String[2], name = new String[2];
            contactInfo = string.split(":::");

            addContact(contactInfo);
        }
    }

    public static void newContact() {
        Input input = new Input();
        String[] contactInfo = new String[2];
        contactInfo[0] = input.getString("Enter name: ");
        contactInfo[1] = input.getString("Enter number: ");

        addContact(contactInfo);
    }

    public static void editContact(int contact) {
        Input input = new Input();
        Contact contactToEdit = contacts.get(contact);
        String previousName = contactToEdit.getName();
        String previousNumber = contactToEdit.getNumber();
        contactToEdit.setName(input.getString("Enter new name for "+ contactToEdit.getName() +": "));
        if (contactToEdit.getName().isEmpty()){
            contactToEdit.setName(previousName);
        }
        contactToEdit.setNumber(input.getString("Enter new number instead of "+ contactToEdit.getNumber() +": "));
        if (contactToEdit.getNumber().isEmpty()){
        contactToEdit.setNumber(previousNumber);
        }
        if(!Verify.phone(contactToEdit.getNumber())) {
            editContact(contact);
        }
        System.out.println("");
    }

    public static void saveContacts() {
        ArrayList<String> contactStrings = new ArrayList<>();
        for (Contact contact : contacts) {
            String string = contact.getName() + ":::" + contact.getNumber();
            contactStrings.add(string);
        }
        try {
            Files.write(path, contactStrings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

