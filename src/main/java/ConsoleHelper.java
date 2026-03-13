// Import the scanner class to read input
import java.util.Scanner;

// This class handles user Input/Output
public class ConsoleHelper {

    // Create scanner to handle input
    private Scanner scanner = new Scanner(System.in);

    // Method to print menu
    public void displayMenu() {

        // Print header
        System.out.println("\n=== Contact Management Menu ===");
        System.out.println("1. Add contact");
        System.out.println("2. List all contacts");
        System.out.println("3. Search by name");
        System.out.println("4. Search by number");
        System.out.println("5. Delete contact");
        System.out.println("6. Sort contacts alphabetically");
        System.out.println("0. Exit");
        System.out.println("Please choose an option: ");
    }
    // Method to get a line of text from user
    public String getStringInput() {
    // Return input
        return scanner.nextLine();
        }

    // Method to print specific message to user
    public void printMessage(String message) {
    // Print the message passed as an argument
        System.out.println(message);
    }

}
