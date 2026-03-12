import java.util.HashMap;
import java.util.Map;
// List contact, update delete etc

public class ContactMapService {
    // Storage. HashMap where the Key is a String
    private Map<String, Contacts> contactMap = new HashMap<>();
// Handles logic for adding a new contact.

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
}