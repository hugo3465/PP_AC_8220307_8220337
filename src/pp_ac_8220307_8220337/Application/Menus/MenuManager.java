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
import pp_ac_8220307_8220337.Api.interfaces.IEditionManagement;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class MenuManager {

    /**
     * MenuManager class, representing the variable that wants to update. The
     * MenuManager class provides getSharedVariable() and setSharedVariable()
     * methods to access and modify the variable.
     */
    // private IMenu[] menus;
    // private int menuCount;
    private Scanner scanner;

    private IEditionManagement editions;

    public MenuManager(int maxMenus) {
        //menus = new IMenu[maxMenus];
        //menuCount = 0;
        scanner = new Scanner(System.in);
        
        
    }

    /*
     * public void addMenu(IMenu menu) {
     * if (menuCount < menus.length) {
     * menus[menuCount] = menu;
     * menuCount++;
     * } else {
     * System.out.println("Maximum menu count reached.");
     * }
     * }
     */

    public int diplayMenu(IMenu menu) {
        /*
         * if (menuCount == menus.length) {
         * System.out.println("Menu not found.");
         * return -1;
         * }
         */

        int choice;
        menu.display();
        choice = getUserChoice();

        return choice;
    }

    public String getUserInputString(String msg) {
        System.out.print(msg);

        String input = scanner.nextLine();

        return input;
    }

    public LocalDate getUserInputLocalDate(String msg) {
        System.out.print(msg + " in the format (YYYY-MM-DD): ");

        String input = scanner.nextLine();

        LocalDate date = LocalDate.parse(input);

        return date;
    }

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

    public Contact getContactInputInfo() {
        String street = getUserInputString("Enter street: ");
        String city = getUserInputString("Enter city: ");
        String state = getUserInputString("Enter state: ");
        String zipCode = getUserInputString("Enter zipCode: ");
        String country = getUserInputString("Enter contry: ");
        String phone = getUserInputString("Enter phone: ");

        return new BaseContact(street, city, state, zipCode, country, phone);
    }

    public InstituitionType getInstituitionTypeInfo() {
        System.out.println("Institution Types:");
        for (InstituitionType type : InstituitionType.values()) {
            System.out.println(type.ordinal() + ". " + type.name());
        }

        int choice = getUserInputInteger("Enter the institution type: ", InstituitionType.values().length);
        return InstituitionType.values()[choice];
    }

    public Instituition geInstituitionInputInfo() {
        String name = getUserInputString("Enter the name of the intituiton: ");
        String email = getUserInputString("Enter the email of the intituiton: ");
        InstituitionType type = getInstituitionTypeInfo();
        Contact contact = getContactInputInfo();
        String website = getUserInputString("Enter the website of the intituiton: ");
        String description = getUserInputString("Enter the description of the intituiton: ");

        return new BaseInstitution(name, email, type, contact, website, description);
    }

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

    public Task getTasktInputInfo() {
        String title = getUserInputString("Enter task title: ");
        String description = getUserInputString("Enter task description: ");
        int start = getUserInputInteger("Enter task start date (in the format YYYYMMDD): ", Integer.MAX_VALUE);
        int duration = getUserInputInteger("Enter task duration (in days): ", Integer.MAX_VALUE);
        int maxSubmissions = getUserInputInteger("Enter maximum number of submissions: ", Integer.MAX_VALUE);

        return new BaseTask(title, description, start, duration, maxSubmissions);
    }

    /*
     * public IMenu getCurrentMenu() {
     * return this.menus[menuCount];
     * }
     */

    public IEditionManagement getEditions() {
        return editions;
    }
}
