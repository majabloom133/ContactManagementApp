import  java.util.Scanner;

public class Main {

     public static void main(String[] args) {

          // Connect to Service class
          ContactMapService service = new ContactMapService();
          // Create scanner to read input
          Scanner scanner = new Scanner(System.in);
          // Variable to start/end program
          boolean running = true;

          while (running) {
               System.out.println("\n=== Contact Management ===");
               System.out.println("1. Add contact");
               System.out.println("2. Display all contacts");
               System.out.println("0. Exit");
               System.out.println("Choose an option: ");

               // Read input
               String choice = scanner.nextLine();

               // Add contact
               if (choice.equals("1")) {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter mobile: ");
                    String mobile = scanner.nextLine();

                    // Call for service class (logic)
                    service.addContact(name, mobile);

               // List contacts
               } else if (choice.equals("2")) {
                    service.listContact();

               // Exit
               } else if (choice.equals("0")) {
                    running = false;
                    System.out.println("Exiting program...");
               } else {
                    System.out.println("Invalid choice, try again.");
               }

          }

     }

}
