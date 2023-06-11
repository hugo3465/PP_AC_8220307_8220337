/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */

package pp_ac_8220307_8220337.Application.Menus;

/**
 * The AdminMenu class represents the menu for the administrator.
 *
 * It provides options for edition management, project management, and distinct
 * lists.
 */
public class AdminMenu implements IMenu {

    /**
     * Displays the menu options for the administrator.
     */
    @Override
    public void display() {
        System.out.println("\t===============================");
        System.out.println("\t||----------- Admin ---------||");
        System.out.println("\t||    1 - Edition Management ||");
        System.out.println("\t||    2 - Project Management ||");
        System.out.println("\t||    3 - Distinct Lists     ||");
        System.out.println("\t||    0 - Back               ||");
        System.out.println("\t===============================");
    }

    /**
     * Displays the admin menu and handles user input.
     *
     * @param menuManager the menu manager
     */
    public static void display(MenuManager menuManager) {
        IMenu menuAdmin = new AdminMenu();
        boolean isRunning = true;

        String editionName;

        do {
            switch (menuManager.diplayMenu(menuAdmin)) {
                case 1:
                    EditionMenu.display(menuManager);
                    break;
                case 2:
                    try {
                        editionName = menuManager
                                .getUserInputString("Enter the name of the edition you want to enter: ");

                        ProjectMenu projectMenu = new ProjectMenu(menuManager.getEditions().getEdition(editionName));

                        projectMenu.display(menuManager);
                    } catch (NullPointerException e) {
                        System.out.println("Invalid edition name!");
                    }
                    break;
                case 3:
                    DistinctListsMenu.display(menuManager);
                    break;
                case 0:
                    isRunning = false;
                default:
                    System.out.println("Invalid Option");
            }
        } while (isRunning);
    }

}
