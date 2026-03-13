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
                    // Search for contacts
               } else if (choice.equals("3")) {
                    helper.printMessage("Enter name to search for: ");
                    String searchName = helper.getStringInput();
                    service.searchByName(searchName);
                    // Ends loop, exits program
               } else if (choice.equals("0")) {
                    running = false;
                    helper.printMessage("Exiting Program...");
                    // Handle invalid input
               } else {
                    helper.printMessage("Invalid choice, please try again!");
               }

          }
     }
}