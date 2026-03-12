// Import HashMap class for storage
// Import Map interface to define storage type
import java.util.HashMap;
import java.util.Map;

// Define class that handles contact logic
public class ContactMapService {
    // Storage. HashMap where the Key is a String
    private Map<String, Contacts> contactMap = new HashMap<>();

    // Adding a new contact.
    public void addContact(String name, String number) {
        // Check if the name (Key) already exists in our Map.
        if (contactMap.containsKey(name)) {
            System.out.println("Error: A contact with the same name '" + name + "' already exists.");
        } else {
            // Create new object (instance) of the Contacts class.
            Contacts newContact = new Contacts(name, number);
            // Storage. Key = name, Value = number.
            contactMap.put(name, newContact);
            System.out.println("Sucess: Contact added!");
        }
    }

    // List contacts
    public void listContact() {
    // Check if empty before trying to print it.
        if (contactMap.isEmpty()) {
            // Let's user know there is nothing to list.
            System.out.println("The contact list is empty.");
            // If map contains data, list it.
        } else {
            // Print contact list header
            System.out.println("--- All Contacts ---");
            // Loop through all Contact objects (c) stored in map values + print name and number using getter methods
            for (Contacts c : contactMap.values()) {
                System.out.println(c.getName() + " (" + c.getNumber() + ")");
            }
        }

    }


}