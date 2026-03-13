import java.util.ArrayList;
import java.util.List;

public class ContactMapService {
    // Change declaration from Map to List - save contact objects here
    private List<Contacts> contactList = new ArrayList<>();


    // Add a new contact
    public void addContact(String name, String number) {
        // Check if number already exists, instead of name
        for (Contacts c : contactList) {
            // Compare number
            if (c.getNumber().equals(number)) {
                System.out.println("Error: A contact with the number " + number + " already exists!");
                // Return if number is found
                return;
            }
        }
        // If number is not found -> Create and add
        Contacts newContact = new Contacts(name, number);
        contactList.add(newContact);
        System.out.println("Sucess: New contact added!");
    }

    // Method to list all contacts
    public void listContact() {
        if (contactList.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            System.out.println("--- All Contacts ---");
            for (Contacts c : contactList) {
                System.out.println(c.getName() + " (" + c.getNumber() + ")");
            }
        }
    }

    // Method to search by name - Shows all matches if there are duplicate names
    public void searchByName(String name) {
        boolean found = false;
        // In arrayLists each person needs to be searched for
        for (Contacts c : contactList) {
            // If the name matches
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + c.getName() + " - " + c.getNumber());
                found = true;
                // Exit loop
            }
        }
        if (!found) {
            System.out.println("No contact found with the name: " + name);
        }
    }

    // Method to search by number
    public void searchByNumber(String number) {
        boolean found = false;
        for (Contacts c : contactList) {
            // Check if number matches
            if (c.getNumber().equals(number)) {
                System.out.println("Found: " + c.getName() + " (" + c.getNumber() + ")");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No contact found with the number: " + number);
        }
    }

    // Sort contacts alphabetically, based on name
    public void sortContacts() {
        // If no names are added, error message shows up saying the list is empty
        if (contactList.isEmpty()) {
            System.out.println("Nothing to sort, list is empty!");
            return;
        }
        // Sort the list by comparing names
        // contactList.sort is a built-in function in Java
        // compareToIgnoreCase is a standard method for Strings in Java.
        contactList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        // Print message saying the contacts are sorted.
        System.out.println("Contacts are now sorted alphabetically!");
    }

    // Method to update contacts
    public void updateContact(Contacts contacts, String newName, String newNumber) {
        // If the number changes, check that it doesn't already exist.
        if (!contacts.getNumber().equals(newNumber)) {
            for (Contacts c : contactList) {
                if (c.getNumber().equals(newNumber)) {
                    System.out.println("Error: The new number already exists!");
                    return;
                }
            }
        }
        // Setters
        contacts.setName(newName);
        contacts.setNumber(newNumber);
        System.out.println("Sucess: Contact was updated!");
    }

    // New method for deletion - find by number
    public Contacts findContactByNumber(String number) {
        for (Contacts c : contactList) {
            if (c.getNumber().equals(number)) {
                return c;
            }
        }
        return null;
    }

    public void removeContact(Contacts contacts) {
        contactList.remove(contacts);
        System.out.println("Sucess: Contact removed!");
    }
}

    /*
    // Delete contact
    // Method to find a contact by name (for deletion)
    public Contacts findContactByName(String name) {
        for (Contacts c : contactList) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
    // Tells Main "No contact was found"
        return null;
    }
    // Method to actually remove contact
    public void removeContact(Contacts contact) {
        contactList.remove(contact);
        System.out.println("Sucess: Contact removed!");
    }

     */



// Old HashMap Code
/* // Import HashMap class for storage
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
            for (Contacts c : contactList) {
                System.out.println(c.getName() + " (" + c.getNumber() + ")");
            }
          }

    public void searchByName(String name) {
        if (contactMap.containsKey(name)) {
            Contacts found = contactMap.get(name);
            System.out.println("Found: " + found.getName() + " - " + found.getNumber());
        } else {
            System.out.println("No contact found with the name: " + name);
        }
    }
     }
     */