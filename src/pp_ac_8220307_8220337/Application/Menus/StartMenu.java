package pp_ac_8220307_8220337.Application.Menus;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class StartMenu implements IMenu {

    @Override
    public void display() {
        System.out.println("\n\tWelcome to CBL ");
        System.out.println("\t1 - Admin");
        System.out.println("\t2 - Student");
        System.out.println("\t0 - Sair\n");
    }

    public static void display(MenuManager menuManager) {
        IMenu menuStartManagement = new StartMenu();
        boolean isRunning = true;

        String editionName; // = menuManager.getUserInputString("Enter the name of the edition you want to
                            // work on: ");
        String participantName; // = menuManager.getUserInputString("Enter the your name to login: ");

        do {
            switch (menuManager.diplayMenu(menuStartManagement)) {
                case 1:
                    AdminMenu.display(menuManager);
                    break;
                case 2:
                    try {
                        participantName = menuManager.getUserInputString("Enter the your name to login: ");

                        StudentMenu startMenu = new StudentMenu(menuManager.getEditions().getStudent(participantName));

                        startMenu.display(menuManager);
                    } catch (NullPointerException e) {
                        System.out.println("Invalid name");
                    }

                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        } while (isRunning);

    }

}
