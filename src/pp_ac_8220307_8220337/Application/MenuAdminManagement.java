/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_ac_8220307_8220337.Application;

/**
 *
 * @author pedro
 */
public class MenuAdminManagement implements MenuDisplay {

    @Override
    public void display() {
        System.out.println("Bem-Vindo ao Menu do Administrador ");
        System.out.println("Escolha a opção que deseja");
        System.out.println("1 - Editar");
        System.out.println("10 - Sair");
    }

    public static void hadleAdminmenu(MenuManager menuManager) {
        // MenuAdminManagement menuAdminManagement = new MenuAdminManagement();
        Boolean isAdminMenuRunning = true;

        while (isAdminMenuRunning) {
            int option = menuManager.getInput();

            switch (option) {
                case 1:
                    break;
                case 10:
                    isAdminMenuRunning = false;
                    return;
                default:
                    System.out.println("Invalid option. Please Try again");
                    break;
            }
        }
    }

}
