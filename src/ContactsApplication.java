import java.util.Scanner;

public class ContactsApplication {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
                Contacts.deleteContact(input.getInt(1,Contacts.getContacts().size())-1);
                break;
            case 5:
                Contacts.editContact(input.getInt(1,Contacts.getContacts().size())-1);
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid Option");
        }

        Contacts.saveContacts();
        mainThread();
    }

//    public static void inputSwitch() {
//        Input input1 = new Input();
//
//        // input variable
//        int input = input1.getInt();
//        switch (input) {
//            case 1:
//                Display.showContacts(Contacts.getContacts());
//                break;
//            case 2:
//                Display.showContacts(Contacts.searchContacts(input1.getString().toLowerCase()));
//                break;
//            case 3:
//                Contacts.newContact();
////                Contacts.addContact(Input.getContact());
//                break;
//            case 4:
//                int input3 = scanner.nextInt() - 1;
//                Contacts.deleteContact(input3);
//                break;
//            case 5:
//                // Edit
//                Contact contactToEdit = Contacts.getContacts().get(input1.getInt() - 1);
//                contactToEdit.setName(input1.getString());
//                contactToEdit.setNumber(input1.getString());
//                break;
//            case 6:
//                System.out.println("Goodbye.");
//                return;
//            default:
//                System.out.println("Sorry " + input + "is not a valid option. Try again.");
//        }
//        Contacts.saveContacts();
//        mainThread();
//    }
}


