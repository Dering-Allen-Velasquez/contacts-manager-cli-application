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

    public String getString(String message, int length) {
        System.out.print(message);
        String line = scanner.nextLine();
        if(line.length() > length) {
            System.out.println(length + " characters or less");
            line = getString(message,length);
        } else if(line.length() == 0) {
            System.out.println("Please enter anything");
        }
        return line;
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

    public int getInt(int min, int max) {
        int number = getInt();

        if (number < min || number > max) {
            System.out.println("Error: Invalid Input");
            number = getInt(min, max);
        }

        return number;
    }
}
