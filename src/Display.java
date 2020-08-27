import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Display {
    public static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println(
                "1. View all contacts \n" +
                "2. Search contacts \n" +
                "3. Add a new contact \n" +
                "4. Delete a contact\n" +
                "5. Edit a contact \n" +
                "6. Exit"
        );
    }

    public static void showContacts(ArrayList<Contact> contacts) {
        for(int i=0; i<contacts.size(); i++) {
            // Do this later : create ifs - change column line up
            System.out.printf("%3d. %-17s | %13s\n", i+1, contacts.get(i).getName(), formatPhone(contacts.get(i).getNumber()));
        }
//        for (Contact contact : contacts) {
//            System.out.printf("%-17s | %13s\n", contact.getName(), formatPhone(contact.getNumber()));
////            System.out.println(contact.getName() + " | " + formatPhone(contact.getNumber()));
//        }
    }

    public static String formatPhone(String phoneNumber) {
        ArrayList<String> formatted = new ArrayList<>(Arrays.asList(phoneNumber.split("")));
        if(formatted.size() == 10) {
            formatted.add(0,"(");
            formatted.add(4,")");
            formatted.add(5," ");
            formatted.add(9,"-");
        } else {
            formatted.add(3, "-");
        }

        return String.join("",formatted);
    }
}
