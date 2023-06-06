package pp_ac_8220307_8220337.Application.Menus;

import java.time.LocalDate;
import java.util.Scanner;

import pp_ac_8220307_8220337.Api.EditionManagement;
import pp_ac_8220307_8220337.Api.interfaces.IEditionManagement;

/**
 * Nome: Pedro Marcelo Santos Pinho Número: 8220307 Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães Número: 8220337 Turma: LEIT2
 */
public class MenuManager {

    /**
     * MenuManager class, representing the variable that wants to update. The
     * MenuManager class provides getSharedVariable() and setSharedVariable()
     * methods to access and modify the variable.
     */
    private IMenu[] menus;
    private int menuCount;
    private Scanner scanner;

    private IEditionManagement Editions;

    public MenuManager(int maxMenus) {
        menus = new IMenu[maxMenus];
        menuCount = 0;
        scanner = new Scanner(System.in);

        Editions = new EditionManagement();
    }

    public void addMenu(IMenu menu) {
        if (menuCount < menus.length) {
            menus[menuCount] = menu;
            menuCount++;
        } else {
            System.out.println("Maximum menu count reached.");
        }
    }

    public int diplayMenu(IMenu menu) {
        if (menuCount == menus.length) {
            System.out.println("Menu not found.");
            return -1;
        }

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
        System.out.print(msg + " in the format (YYYY-MM-DD) :");

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

    public IMenu getCurrentMenu() {
        return this.menus[menuCount];
    }

    public IEditionManagement getEditions() {
        return Editions;
    }
}
