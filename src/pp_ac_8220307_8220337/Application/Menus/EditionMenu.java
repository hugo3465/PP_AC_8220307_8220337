package pp_ac_8220307_8220337.Application.Menus;

/**
 * Nome: Pedro Marcelo Santos Pinho Número: 8220307 Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães Número: 8220337 Turma: LEIT2
 */
public class EditionMenu implements IMenu {

    @Override
    public void display() {
        System.out.println("\n\t--- Admin / Editions ---");
        System.out.println("\t1 - Add Edition");
        System.out.println("\t2 - Remove Edition");
        System.out.println("\t3 - Set Edition as Active");
        System.out.println("\t4 - Set Edition as Inactive");
        System.out.println("\t5 - Set Edition as Closed");
        System.out.println("\t6 - Set Edition as Canceled");
        System.out.println("\t7 - List all Editions");
        System.out.println("\t0 - Back\n");
    }

    public static void display(MenuManager menuManager) {
        IMenu menuEdition = new EditionMenu();
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
                case 0:
                    isRunning = false;
                default:
                    System.out.println("Invalid Option");
            }
        } while (isRunning == true);
    }

}
