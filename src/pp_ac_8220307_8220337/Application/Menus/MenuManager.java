package pp_ac_8220307_8220337.Application.Menus;

import java.util.Scanner;

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

    public MenuManager(int maxMenus) {
        menus = new IMenu[maxMenus];
        menuCount = 0;
        scanner = new Scanner(System.in);
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

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public IMenu getCurrentMenu() {
        return this.menus[menuCount];
    }
}
