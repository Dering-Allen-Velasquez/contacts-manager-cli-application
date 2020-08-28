public class Contact {
    private String name;
    private String number;

    public Contact(String[] contactInfo) {
        this.name = contactInfo[0];
        this.number = contactInfo[1];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
