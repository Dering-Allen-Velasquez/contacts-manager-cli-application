public class Verify {

    public static boolean phone(String phoneNumber) {
        if(phoneNumber.contains("-"))
            phoneNumber = String.join("",phoneNumber.split("-"));
        int phoneNumberLength;
        try {
            phoneNumberLength = Integer.toString(Integer.parseInt(phoneNumber)).length();
        } catch(NumberFormatException e) {
            return false;
        }

        return phoneNumberLength == 10 || phoneNumberLength == 7;
    }

}
