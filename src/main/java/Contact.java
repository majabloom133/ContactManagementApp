public class Contact {

    // Declare private variable to store contact names.
// Private fields are where information is stored
    private String name;
    private String number;

    //Constructor (like a start button for adding a contact)
    public Contact(String name, String number) {
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

    // Setter for Name. To update the name of a contact
    public void setName(String name) {
        this.name = name;
    }

    // Setter for Number. To update the number of existing contact.
    public void setNumber(String number) {
        this.number = number;
    }
}

