public class Verify {
    public static boolean name() {
        return false;
    }

    public static boolean phone(String phoneNumber) {
        if(phoneNumber.contains("-"))
            phoneNumber = String.join("",phoneNumber.split("-"));
        int phoneNumberLength = Integer.toString(Integer.parseInt(phoneNumber)).length();

        return phoneNumberLength == 10 || phoneNumberLength == 7;
    }

    public static boolean length(String input, int length) {
        return input.length() > 0 && input.length() <= length;
    }
}
