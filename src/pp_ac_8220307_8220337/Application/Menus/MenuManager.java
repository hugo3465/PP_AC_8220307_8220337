/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */

package pp_ac_8220307_8220337.Application.Menus;

import java.time.LocalDate;
import java.util.Scanner;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.participants.Student;
import ma02_resources.project.Task;
import pp_ac_8220307_8220337.Api.BaseContact;
import pp_ac_8220307_8220337.Api.BaseInstitution;
import pp_ac_8220307_8220337.Api.BaseStudent;
import pp_ac_8220307_8220337.Api.BaseTask;
import pp_ac_8220307_8220337.Api.EditionManagement;
import pp_ac_8220307_8220337.Api.interfaces.IEditionManagement;
import pp_ac_8220307_8220337.Application.InitialTestingValues;



/**
 * This class represents a menu manager that handles user input and menu
 * navigation.
 * It provides methods for displaying menus, getting user input, and creating
 * various objects.
 */
public class MenuManager {
    /**
     * Scanner object to read user input
     */
    private Scanner scanner;

    /**
     * Edition management object
     */
    private IEditionManagement editions;

    /**
     * Constructor for the MenuManager class.
     * Initializes the scanner and adds some initial testing values to the editions.
     */
    public MenuManager() {
        scanner = new Scanner(System.in);

        editions = new EditionManagement();

        // Testing values
        InitialTestingValues testingValues = new InitialTestingValues();
        editions.addEdition(testingValues.edition1);
        editions.addEdition(testingValues.edition2);
        editions.addEdition(testingValues.edition3);
    }

    /**
     * Displays the provided menu and gets the user's choice.
     *
     * @param menu the menu to be displayed
     * @return the user's choice
     */
    public int diplayMenu(IMenu menu) {

        int choice;
        menu.display();
        choice = getUserChoice();

        return choice;
    }

    /**
     * Gets a string input from the user with the specified message.
     *
     * @param msg the message to be displayed to the user
     * @return the user's input string
     */
    public String getUserInputString(String msg) {
        System.out.print(msg);

        String input = scanner.nextLine();

        return input;
    }

    /**
     * Gets a LocalDate input from the user with the specified message.
     *
     * @param msg the message to be displayed to the user
     * @return the user's input LocalDate
     */
    public LocalDate getUserInputLocalDate(String msg) {
        System.out.print(msg + " in the format (YYYY-MM-DD): ");

        String input = scanner.nextLine();

        LocalDate date = LocalDate.parse(input);

        return date;
    }

    /**
     * Private method to get the user's choice as an integer.
     *
     * @return the user's choice
     */
    private int getUserChoice() {
        System.out.print("Enter your choice: ");

        int choice = -1;

        try {
            choice = scanner.nextInt();

        } catch (Exception e) {
            System.out.println("Invalid Option");
        } finally {
            // clear the buffer
            scanner.nextLine();
        }

        return choice;
    }

    /**
     * Gets an integer input from the user with the specified message and maximum
     * value.
     *
     * @param msg the message to be displayed to the user
     * @param max the maximum value for the input
     * @return the user's input integer
     */
    public int getUserInputInteger(String msg, int max) {
        int choice = -1;
        while (choice < 0 || choice >= max) {
            System.out.print(msg);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
            if (choice < 0 || choice >= max) {
                System.out.println("Invalid choice.");
            }
        }
        return choice;
    }

    /**
     * Gets the contact input information from the user.
     *
     * @return the Contact object representing the user's input
     */
    public Contact getContactInputInfo() {
        String street = getUserInputString("Enter street: ");
        String city = getUserInputString("Enter city: ");
        String state = getUserInputString("Enter state: ");
        String zipCode = getUserInputString("Enter zipCode: ");
        String country = getUserInputString("Enter contry: ");
        String phone = getUserInputString("Enter phone: ");

        return new BaseContact(street, city, state, zipCode, country, phone);
    }

    /**
     * Gets the institution type information from the user.
     *
     * @return the selected InstituitionType
     */
    public InstituitionType getInstituitionTypeInfo() {
        System.out.println("Institution Types:");
        for (InstituitionType type : InstituitionType.values()) {
            System.out.println(type.ordinal() + ". " + type.name());
        }

        int choice = getUserInputInteger("Enter the institution type: ", InstituitionType.values().length);
        return InstituitionType.values()[choice];
    }

    /**
     * Gets the institution input information from the user.
     *
     * @return the Instituition object representing the user's input
     */
    public Instituition geInstituitionInputInfo() {
        String name = getUserInputString("Enter the name of the intituiton: ");
        String email = getUserInputString("Enter the email of the intituiton: ");
        InstituitionType type = getInstituitionTypeInfo();
        Contact contact = getContactInputInfo();
        String website = getUserInputString("Enter the website of the intituiton: ");
        String description = getUserInputString("Enter the description of the intituiton: ");

        return new BaseInstitution(name, email, type, contact, website, description);
    }

    /**
     * Gets the student input information from the user.
     *
     * @return the Student object representing the user's input
     */
    public Student getStudentInputInfo() {
        int number = getUserInputInteger("Enter student number", Integer.MAX_VALUE);
        String name = getUserInputString("Enter student's first name: ");
        String email = getUserInputString("Enter student's email: ");
        System.out.println("Contact Information:");
        Contact contact = getContactInputInfo();
        System.out.println("Instituiton Information:");
        Instituition instituition = geInstituitionInputInfo();

        return new BaseStudent(number, name, email, contact, instituition);

    }

    /**
     * Gets the task input information from the user.
     *
     * @return the Task object representing the user's input
     */
    public Task getTasktInputInfo() {
        String title = getUserInputString("Enter task title: ");
        String description = getUserInputString("Enter task description: ");
        int start = getUserInputInteger("Enter task start date (in the format YYYYMMDD): ", Integer.MAX_VALUE);
        int duration = getUserInputInteger("Enter task duration (in days): ", Integer.MAX_VALUE);
        int maxSubmissions = getUserInputInteger("Enter maximum number of submissions: ", Integer.MAX_VALUE);

        return new BaseTask(title, description, start, duration, maxSubmissions);
    }

    /**
     * Gets the edition management object.
     *
     * @return the IEditionManagement object
     */
    public IEditionManagement getEditions() {
        return editions;
    }
}
