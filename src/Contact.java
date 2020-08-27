public class Contact {
//for each individual contact
    private String name;
    private int number;

    public Contact(String[] contactInfo) {
        this.name = contactInfo[0];
        this.number = Integer.parseInt(contactInfo[1]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
