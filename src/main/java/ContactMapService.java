import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;


public class ContactMapService {
    // Change declaration from Map to List - save contact objects here
    private List<Contact> contactList = new ArrayList<>();


    // Add a new contact
    public void addContact(String name, String number) {
        // Check if number already exists, instead of name
        for (Contact c : contactList) {
            // Compare number
            if (c.getNumber().equals(number)) {
                System.out.println("Error: A contact with the number " + number + " already exists!");
                // Return if number is found
                return;
            }
        }
        // If number is not found -> Create and add
        Contact newContact = new Contact(name, number);
        contactList.add(newContact);
        System.out.println("Sucess: New contact added!");
    }

    // Method to list all contacts
    public void listContact() {
        if (contactList.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            System.out.println("--- All Contacts ---");
            for (Contact c : contactList) {
                System.out.println(c.getName() + " (" + c.getNumber() + ")");
            }
        }
    }

    // Method to search by name - Shows all matches if there are duplicate names
    public void searchByName(String name) {
        boolean found = false;
        // In arrayLists each person needs to be searched for
        for (Contact c : contactList) {
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
        for (Contact c : contactList) {
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
    public void updateContact(Contact contact, String newName, String newNumber) {
        // If the number changes, check that it doesn't already exist.
        if (!contact.getNumber().equals(newNumber)) {
            for (Contact c : contactList) {
                if (c.getNumber().equals(newNumber)) {
                    System.out.println("Error: The new number already exists!");
                    return;
                }
            }
        }
        // Setters
        contact.setName(newName);
        contact.setNumber(newNumber);
        System.out.println("Sucess: Contact was updated!");
    }

    // Finds a contact by number (used when deleting/updating)
    public Contact findContactByNumber(String number) {
        for (Contact c : contactList) {
            if (c.getNumber().equals(number)) {
                return c;
            }
        }
        return null;
    }

    public void removeContact(Contact contact) {
        contactList.remove(contact);
        System.out.println("Sucess: Contact removed!");
    }

    public void saveToFile() {
        // Create the file contacts.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter("contacts.txt"))) {
            for (Contact c : contactList) {
                // Prints using the format Name|Number
                writer.println(c.getName() + "|" + c.getNumber());
            }
            System.out.println("The contacts were saved successfully!");
        } catch (Exception e) {
            // If anything goes wrong
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        java.io.File file = new java.io.File("contacts.txt");
        if (!file.exists()) return;

        try (java.util.Scanner fileScanner = new java.util.Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Split the line - at the pipe symbol
                String[] parts = line.split("\\|");

                if (parts.length == 2) {
                    // Create contact + add it directly to list
                    contactList.add(new Contact(parts[0], parts[1]));
                }
            }
            System.out.println("Contacts loaded from file");
        } catch (Exception e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }

    // Getter used by unit tests to verify list order/content
    public List<Contact> getContactList() {
        return contactList;
    }

}