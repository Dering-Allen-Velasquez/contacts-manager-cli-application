import java.util.Scanner;

public class Input {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public static String getString() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static String[] getContact() {
        String[] contactInfo = new String[2];
        contactInfo[0] = getString("Enter name: ");
        scanner.next();
        contactInfo[1] = getString("Enter number: ");
        scanner.next();

        System.out.println(contactInfo[0]);

        return contactInfo;
    }

//    public static String[] getContact(){
//        return contactInfo;
//        }

}
