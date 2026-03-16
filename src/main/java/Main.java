// Import scanner class to read input from keyboard
import  java.util.Scanner;

public class Main {
     public static void main(String[] args) {

          // Create the "brain" - connect to Service class
          ContactMapService service = new ContactMapService();
          // Create "assistant" - Helper class
          ConsoleHelper helper = new ConsoleHelper();

          // Variable to keep loop running
          boolean running = true;

          while (running) {
               // Use Helper to find menu
               helper.displayMenu();
               // Use Helper to get the choice
               String choice = helper.getStringInput();

               switch (choice) {

                    case "1":
                         helper.printMessage("Enter name: ");
                         String name = helper.getStringInput();
                         helper.printMessage("Enter number: ");
                         String number = helper.getStringInput();
                         service.addContact(name, number);
                         break;

                    case "2":
                         service.listContact();
                         break;

                    case "3":
                         helper.printMessage("Enter the name you want to search for: ");
                         String searchName = helper.getStringInput();
                         service.searchByName(searchName);
                         break;


                    case "4":
                         helper.printMessage("Enter the number you want to search for: ");
                         String searchNumber = helper.getStringInput();
                         service.searchByNumber(searchNumber);
                         break;


                    case "5":
                         helper.printMessage("Enter number to delete: ");
                         String numberToDelete = helper.getStringInput();
                         // Find the contact
                         Contact foundContact = service.findContactByNumber(numberToDelete);

                         if (foundContact != null) {
                              // Display matching contact
                              helper.printMessage("Found Contact: " + foundContact.getName() + " (" + foundContact.getNumber() + " )");
                              // Ask for confirmation
                              helper.printMessage("Are you sure you want to delete contact? (Y/N)");
                              String confirm = helper.getStringInput();

                              if (confirm.equalsIgnoreCase("Y")) {
                                   service.removeContact(foundContact);
                              } else {
                                   helper.printMessage("Deletion was cancelled.");
                              }
                         }else {
                              helper.printMessage("Error: No contact with that number was found. ");
                         }
                         break;

                    case "6":
                         service.sortContacts();
                         break;

                    case "7":
                         helper.printMessage("Enter the number of the contact you want to update: ");
                         String numToUpdate = helper.getStringInput();
                         Contact contactToEdit = service.findContactByNumber(numToUpdate);

                         if (contactToEdit != null) {
                              helper.printMessage("Current: " + contactToEdit.getName() + " (" + contactToEdit.getNumber() + ")");

                              helper.printMessage("Enter new name: ");
                              String updatedName = helper.getStringInput();
                              helper.printMessage("Enter new number: ");
                              String updatedNumber = helper.getStringInput();

                              service.updateContact(contactToEdit, updatedName, updatedNumber);
                         } else {
                              helper.printMessage("Error: Contact was not found!");
                         }
                         break;


                    case "0":
                         running = false;
                         helper.printMessage("Exiting program...");
                         break;

                    default:
                         helper.printMessage("Invalid choice, please try again!");
                         break;

               }
          }
     }
}

               /*

               // Add Contact
               if (choice.equals("1")) {

               // Enter name
                    helper.printMessage("Enter name: ");
                    String name = helper.getStringInput();

               // Enter number
                    helper.printMessage("Enter number: ");
                    String number = helper.getStringInput();

               // Call the Service to add contact
                    service.addContact(name, number);

               // List all contacts
               } else if (choice.equals("2")) {
                    service.listContact();

               // Search by name
               } else if (choice.equals("3")) {
                    helper.printMessage("Enter name to search for: ");
                    String searchName = helper.getStringInput();
                    service.searchByName(searchName);
               // Ends loop, exits program

               // Search by number
               } else if (choice.equals("4")) {
                    helper.printMessage("Enter number to search for: ");
                    String searchNumber = helper.getStringInput();
                    service.searchByNumber(searchNumber);


               (If we want to be able to delete a contact
               // Delete a contact
               } else if (choice.equals("5")) {
               helper.printMessage("Enter the name you want to delete: ");
               String nameToDelete = helper.getStringInput();
               // Call the service to remove the contact
               service.deleteContact(nameToDelete);    )

               // Exit program
               } else if (choice.equals("0")) {
                    running = false;
                    helper.printMessage("Exiting Program...");

               // Handle invalid input
               } else {
                    helper.printMessage("Invalid choice, please try again!");

*/