package pp_ac_8220307_8220337.Application.Menus;

/**
 * Nome: Pedro Marcelo Santos Pinho Número: 8220307 Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães Número: 8220337 Turma: LEIT2
 */
public class AdminMenu implements IMenu {

    @Override
    public void display() {
        System.out.println("\n\t--- Admin ---");
        System.out.println("\t1 - Edition Management");
        System.out.println("\t2 - Project Management");
        System.out.println("\t3 - Lists of Projects");
        System.out.println("\t4 - Lists of Tasks");
        System.out.println("\t5 - Lists of Submissions");
        System.out.println("\t6 - Distinct Lists");
        System.out.println("\t0 - Back\n");
    }

    public static void display(MenuManager menuManager) {
        IMenu menuAdmin = new AdminMenu();
        boolean isRunning = true;

        do {
            switch (menuManager.diplayMenu(menuAdmin)) {
                case 1:
                    EditionMenu.display(menuManager);
                    break;
                case 2:
                    ProjectMenu.display(menuManager);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    isRunning = false;
                default:
                    System.out.println("Invalid Option");
            }
        } while (isRunning);
    }

}
