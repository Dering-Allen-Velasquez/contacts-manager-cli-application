import java.util.ArrayList;
import java.util.Arrays;

public class Display {

    public static void menu() {
        System.out.println(
                "1. View all contacts \n" +
                "2. Search contacts \n" +
                "3. Add a new contact \n" +
                "4. Delete a contact\n" +
                "5. Edit a contact \n" +
                "6. Exit\n"
        );
    }

    public static void showContacts(ArrayList<Contact> contacts) {
        System.out.printf("%-22s | %-13s\n", "  Name", "Phone Number");
        System.out.println("---------------------------------------");
        for(int i=0; i<contacts.size(); i++) {
            System.out.printf("%3d. %-17s | %13s\n", i+1, contacts.get(i).getName(), formatPhone(contacts.get(i).getNumber()));
        }
        System.out.println("");
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
