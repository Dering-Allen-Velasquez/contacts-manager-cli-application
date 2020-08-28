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
                Contacts.newContact();
//                Contacts.addContact(Input.getContact());
                break;
            case 4:
                int input3 = scanner.nextInt();
                Contacts.deleteContact(input3);
                break;
            case 5:
                // Edit
                Contact contactToEdit = Contacts.getContacts().get(Input.getInt("Which contact # to edit: ") - 1);
                contactToEdit.setName(Input.getString("Enter a new name: "));
                contactToEdit.setNumber(Input.getString("Enter a new number: "));
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


