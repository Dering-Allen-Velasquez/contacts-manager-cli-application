import java.util.ArrayList;
import java.util.Scanner;

public class ContactsApplication {

    public static void main(String[] args) {

//        Contacts.loadContacts();


    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println("1. View all contacts \n" +
                "2. Search contacts \n" +
                "3. Add a new contact \n" +
                "4. Delete a contact\n" +
                "5. Edit a contact \n" +
                "6. Exit");

        switch (input) {
            case 1:
                //
                break;
            case 2:
                //
                break;
            case 3:
                //
                break;
            case 4:
                //
                break;
            case 5:
                //
                break;
            case 6:
                System.out.println("Goodbye.");
                break;
            default:
                System.out.println("Sorry" + input + "is not a valid option. Try again.");

        }
    }

    public static void displayContacts(ArrayList<Contact> contacts){
    for(Contact contact: contacts){
        System.out.printf("%s | %d", contact.getName() + contact.getNumber());
    }
    }

    public static void formatPhone(String phoneNumber){
        String[] formatted = phoneNumber.split("");
        ArrayList<String> phone = new ArrayList<>();



    }





    }


