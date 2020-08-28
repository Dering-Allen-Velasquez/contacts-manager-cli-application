public class Verify {
    public static boolean name() {
        return false;
    }

    public static boolean phone() {
        return false;
    }

    public static boolean length(String input, int length) {
        return input.length() > 0 && input.length() <= length;
    }
}
