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
public class MenuAdminManagement implements MenuDisplay {

    @Override
    public void display() {
        System.out.println("\nWelcom to the Admin menu");
        System.out.println("\t1 - Edition Management");
        System.out.println("\t0 - Sair");
        System.out.print("Choose an option: ");
    }

    public static void adminMenu(MenuManagerUseless menuManager) {
        MenuDisplay menuAdminManagement = new MenuAdminManagement();
        boolean isAdminMenuRunning = true;

        while (isAdminMenuRunning) {
            menuManager.displayMenu(menuAdminManagement);
            int option = menuManager.getInput();

            switch (option) {
                case 1:
                    MenuEditionAdmin.editionMenu(menuManager);
                    break;
                case 2:
                    break;
                case 0:
                    isAdminMenuRunning = false;
                    return;
                default:
                    System.out.println("Invalid option. Please Try again");
                    break;
            }
        }
    }

}
