public class Contacts {

// Declare private variable to store contact names.
// Private fields are where information is stored
private String name;
private String number;

//Constructor (like a start button for adding a contact)
    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }
// Getter for Name. Let's other classes read the name.
public String getName() {
        // Return value stored in name variable
        return name;
}
// Getter for number
public String getNumber() {
        // Return value stored in number variable
        return number;
    }
}


