package pp_ac_8220307_8220337.Application;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class MenuStartManagement implements MenuDisplay {

    @Override
    public void display() {
        System.out.println("\nWelcome to CBL ");
        System.out.println("\t1 - Admin");
        System.out.println("\t2 - Student");
        System.out.println("\t0 - Sair");
        System.out.print("Choose an option: ");
    }

    public static void handleStartMenu(MenuManagerUseless menuManager) {
        MenuDisplay menuStartManagement = new MenuStartManagement();
        boolean isRunning = true;

        while (isRunning) {
            menuManager.displayMenu(menuStartManagement);
            int option = menuManager.getInput();

            switch (option) {
                case 1:
                    MenuAdminManagement.adminMenu(menuManager);
                    break;
                case 0:
                    isRunning = false;
                    return;
                default:
                    System.out.println("Invalid option");

            }
        }
    }

}
