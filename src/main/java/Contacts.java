public class Contacts {
//Create variables
    // Private fields are where we store information
private String name;
private String number;

//Constructor (like a start button for creating a contact)
    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }
    // Getter for Name. window lets other classes see the name
public String getName() {
        return name;
}
// Getter for number
public String getNumber() {
        return number;
    }
}


