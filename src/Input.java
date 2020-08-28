import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return scanner.nextLine();
    }

    public String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public int getInt() {
        int number;
        try {
            number = Integer.parseInt(getString());
        } catch(NumberFormatException e) {
            throw new NumberFormatException("Number entered was not a number");
        }
        return number;
    }

    public int getInt(int min, int max, String message) {
        System.out.print(message);
        int number = getInt();

        if (number < min || number > max) {
            System.out.println("Error: Invalid Input");
            number = getInt(min, max, message);
        }

        return number;
    }
}
