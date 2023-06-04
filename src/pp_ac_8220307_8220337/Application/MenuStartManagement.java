/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_ac_8220307_8220337.Application;

/**
 *
 * @author pedro
 */
public class MenuStartManagement implements MenuDisplay {

    @Override
    public void display() {
        System.out.println("Welcome to CBL ");
        System.out.println("Chosse the option correct");
        System.out.println("1 - Admin");
        System.out.println("2 - Sair");
    }

    public static void handleStartMenu(MenuManager menuManager) {
        MenuStartManagement menuStartManagement = new MenuStartManagement();
        boolean isRunning = true;

        while (isRunning) {
            menuManager.displayMenu(menuStartManagement);
            int option = menuManager.getInput();

            switch (option) {
                case 1:
                    MenuAdminManagement.hadleAdminmenu(menuManager);
                    break;
                case 2:
                    isRunning = false;
                    return;
                default:
                    System.out.println("Invalid option");

            }
        }
    }

}
