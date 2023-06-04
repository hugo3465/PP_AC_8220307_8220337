package pp_ac_8220307_8220337.Application;

import java.util.Scanner;

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

    private static final int MAX_SIZE = 300; //Array Size

    private int currentOption; //Option

    private MenuDisplay[] menuDisplays;

    private int lastOption;

    public MenuManager() {
        this.currentOption = 0;
        this.lastOption = currentOption--;
        menuDisplays = new MenuDisplay[MAX_SIZE];
    }

    public MenuDisplay getCurrentMenu() {
        return this.menuDisplays[this.currentOption];
    }

    public int getInput() {
        int option;
        Scanner scn = new Scanner(System.in);

        option = scn.nextInt();
        this.currentOption++;

        // clear buffer
        scn.nextLine();
        
        scn.close();

        return option;
    }

    public void displayMenu(MenuDisplay menu) {
        if (this.lastOption < this.MAX_SIZE - 1) {
            this.menuDisplays[++this.currentOption] = menu;
            menu.display();
        } else {
            System.out.println("Menu is full. Can´t push new Menu");
        }
    }

    public void goBack() {
        if (this.lastOption >= 0) {
            MenuDisplay previousMenu = this.menuDisplays[this.lastOption];
            previousMenu.display();
        } else {
            System.out.println("Cannot go back!!. Exiting programm");
            System.exit(0);
        }
    }
}
