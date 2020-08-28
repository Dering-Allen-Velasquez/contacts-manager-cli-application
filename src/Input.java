import java.util.Scanner;

public class Input {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static String[] getContact(){
        String[] contactInfo = new String[2];
        System.out.println("Enter name: ");
        contactInfo[0] = getString();
        System.out.println("Enter phone number: ");
        contactInfo[1] = getString();
        return contactInfo;
        }

}
