import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsApplication {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Contacts.loadContacts();
        boolean run = true;
        int input;

        do {
            Display.menu();
            input = scanner.nextInt();
            run = inputSwitch(input);
        } while(run);
        Contacts.saveContacts();
    }

    public static boolean inputSwitch(int input) {
        switch (input) {
            case 1:
                Display.showContacts(Contacts.getContacts());
                break;
            case 2:
                String input2 = scanner.next();
                Display.showContacts(Contacts.searchContacts(input2.toLowerCase()));
                break;
            case 3:
                //
                break;
            case 4:
                int input3 = scanner.nextInt();
                Contacts.deleteContact(input3);
                break;
            case 5:
                //
                break;
            case 6:
                System.out.println("Goodbye.");
                return false;
            default:
                System.out.println("Sorry " + input + "is not a valid option. Try again.");
        }

        return true;
    }
}


