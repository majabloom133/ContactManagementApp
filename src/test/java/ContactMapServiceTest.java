// Import annotations, like @Test and @BeforeEach
import org.junit.jupiter.api.*;
// Import assertion tools, like assertEquals
import static org.junit.jupiter.api.Assertions.*;

// Class name ending with Test - to distinguish from rest of the code
public class ContactMapServiceTest {

    // Declare object that should be tested
    private ContactMapService service;

    // This method needs to run before each test
    // Ensures "isolation" - each test starts with empty service
    @BeforeEach
    void setUp() {
        service = new ContactMapService();
    }

    @Test
    @DisplayName("Happy Path: Adding new contact and finding it")
    void testAddAndFindContact() {
        // --- Arrange ---
        // Prepare inputs
        String name = "Anna";
        String number = "123";

        // --- Act ---
        // Perform actual operation we want to test
        service.addContact(name, number);
        Contact found = service.findContactByNumber(number);

        // --- Assert ---
        // Verify the outputs matches expectations
        assertNotNull(found, "The contact should be found in the list");
        assertEquals(name, found.getName(), "The name in the list should be Anna");
    }

    @Test
    @DisplayName("Negative Case: Preventing duplicate phone numbers")
    void testAddDuplicateNumber() {

        // --- Arrange ---
        // Add the first contact
        service.addContact("Anna", "123");

        // --- Act ---
        // Try to add a second person with the same number (invalid input)
        service.addContact("Erik", "123");
        Contact found = service.findContactByNumber("123");

        // --- Assert ---
        // Based on logic, Erik should be rejected
        // Verify that "Anna" is still there
        assertEquals("Anna", found.getName(), "System should keep the original contact, and reject duplicate number");
    }

    @Test
    @DisplayName("Edge Case: Searching for a number in an empty list")
    void testFindInEmptyList() {

        // --- Act ---
        // Try to find something that's not here (Boundary scenario)
        Contact found = service.findContactByNumber("999");

        // --- Assert ---
        // Expect the method to return null
        assertNull(found, "Searching an empty list should return null");
    }

    @Test
    @DisplayName("Action Case: Removing a contact")
    void testRemoveContact() {

        // --- Arrange ---
        service.addContact("Anna", "123");
        Contact roRemove = service.findContactByNumber("123");

        // --- Act ---
        // First remove unit from the list
        service.removeContact(roRemove);
        Contact found = service.findContactByNumber("123");

        // --- Assert ---
        // Verify contact no longer exists
        assertNull(found, "Contact should be successfully removed from the list");
    }

    @Test
    @DisplayName("Action Case: Updating existing contact's info.")
    void testUpdateContact() {
        // --- Arrange ---
        service.addContact("Anna", "111");
        Contact contact = service.findContactByNumber("111");

        // --- Act ---
        // Update existing contact with last name and change the number
        service.updateContact(contact, "Anna Andersson", "222");
        Contact updated = service.findContactByNumber("222");

        // --- Assert ---
        assertNotNull(updated, "The contact should be found at new number.");
        assertEquals("Anna Andersson", updated.getName(), "The name should be updated correctly!");
    }

    @Test
    @DisplayName("Complex Scenario: Sorting alpabetically")
    void testSortContacts() {

        // --- Arrange ---
        // Add contacts in random order
        service.addContact("Maja", "111");
        service.addContact("Bella", "222");
        service.addContact("Malin", "333");

        // --- Act ---
        service.sortContacts();

        Contact first = service.findContactByNumber("111");
        assertEquals("Maja", first.getName(), "Maja should still exist after sorting");
    }
}
