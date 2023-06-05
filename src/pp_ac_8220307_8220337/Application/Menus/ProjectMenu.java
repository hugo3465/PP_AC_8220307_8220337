package pp_ac_8220307_8220337.Application.Menus;

/**
 * Nome: Pedro Marcelo Santos Pinho Número: 8220307 Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães Número: 8220337 Turma: LEIT2
 */
public class ProjectMenu implements IMenu {

    @Override
    public void display() {
        System.out.println("\n\t--- Admin / Projects ---");
        System.out.println("\t1 - Add Project");
        System.out.println("\t2 - Remove Project");
        System.out.println("\t3 - Add Participant to a Project");
        System.out.println("\t4 - Remove Participant from a Project");
        System.out.println("\t5 - Add Task to a Project");
        System.out.println("\t6 - Get Participant");
        System.out.println("\t7 - List all Participants");
        System.out.println("\t8 - List all Participants from Project");
        System.out.println("\t9 - List all Projects");
        System.out.println("\t10 - Get progress from a Project");
        System.out.println("\t0 - Back\n");
    }

    public static void display(MenuManager menuManager) {
        IMenu menuEdition = new ProjectMenu();
        boolean isRunning = true;

        do {
            switch (menuManager.diplayMenu(menuEdition)) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    isRunning = false;
                default:
                    System.out.println("Invalid Option");
            }
        } while (isRunning);
    }
}
