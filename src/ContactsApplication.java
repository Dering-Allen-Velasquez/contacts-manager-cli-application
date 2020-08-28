import java.util.Scanner;

public class ContactsApplication {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int intInput;
        Contacts.loadContacts();

        do {
            Display.menu();
            intInput = Input.getInt("Input Choice Number: ");
            inputSwitch(intInput);
        } while (true);
    }

    public static boolean inputSwitch(int input) {
        switch (input) {
            case 1:
                Display.showContacts(Contacts.getContacts());
                break;
            case 2:
                Display.showContacts(Contacts.searchContacts(Input.getString("Please enter a name: ").toLowerCase()));
                break;
            case 3:
                Contacts.addContact(Input.getContact());
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
        Contacts.saveContacts();
        return true;
    }
}


