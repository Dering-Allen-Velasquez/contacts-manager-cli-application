import java.util.Scanner;

public class ContactsApplication {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What would you like to do?");
        Contacts.loadContacts();
        mainThread();
    }

    public static void mainThread() {
        Display.menu();
        inputSwitch();
    }

    public static void inputSwitch() {
        Input input = new Input();
        int userChoice = input.getInt();

        // All Ints should be between
        switch(userChoice) {
            case 1:
                Display.showContacts(Contacts.getContacts());
                break;
            case 2:
                Display.showContacts(Contacts.searchContacts(input.getString("Please enter a name or number to search by: ").toLowerCase()));
                break;
            case 3:
                Contacts.newContact();
                break;
            case 4:
                Contacts.deleteContact(input.getInt(1,Contacts.getContacts().size(), "Enter a number for the contact you would like to delete: ")-1);
                break;
            case 5:
                Contacts.editContact(input.getInt(1,Contacts.getContacts().size(),"Enter a number for the contact you would like to edit: ")-1);
                break;
            case 6:
                System.out.print("Goodbye!");
                return;
            default:
                System.out.println("Invalid Option");
        }
        Contacts.saveContacts();
        mainThread();
    }
}


