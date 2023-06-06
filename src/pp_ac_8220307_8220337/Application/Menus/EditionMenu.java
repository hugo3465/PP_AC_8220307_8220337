package pp_ac_8220307_8220337.Application.Menus;

import java.time.LocalDate;

import pp_ac_8220307_8220337.Api.BaseEdition;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
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
        String name;
        String projectTemplate;
        LocalDate start;
        LocalDate end;

        do {
            switch (menuManager.diplayMenu(menuEdition)) {
                case 1:
                    name = menuManager.getUserInputString("Inser the name of the edition: ");
                    projectTemplate = menuManager.getUserInputString("Insert project template: ");
                    start = menuManager.getUserInputLocalDate("Insert stat date: ");
                    end = menuManager.getUserInputLocalDate("Insert end date: ");

                    menuManager.getEditions().addEdition(new BaseEdition(name, projectTemplate, start, end));
                    break;
                case 2:
                    name = menuManager.getUserInputString("Inser the name of the edition you want to remove: ");

                    menuManager.getEditions().removeEdition(name);
                    break;
                case 3:
                    System.out.println(
                            "only one edition can be set to active, if there is an active edition it will be put as inactive!");

                    name = menuManager.getUserInputString("Inser the name of the edition you want to set as active: ");

                    menuManager.getEditions().defineAsActive(name);
                    break;
                case 4:
                    name = menuManager
                            .getUserInputString("Inser the name of the edition you want to set as inactive: ");

                    menuManager.getEditions().defineAsInactive(name);
                    break;
                case 5:
                    name = menuManager.getUserInputString("Inser the name of the edition you want to set as closed: ");

                    menuManager.getEditions().defineAsClosed(name);
                    break;
                case 6:
                    name = menuManager
                            .getUserInputString("Inser the name of the edition you want to set as Canceled: ");

                    menuManager.getEditions().defineAsCanceled(name);
                    ;
                    break;
                case 7:
                    System.out.println(menuManager.getEditions().toString());
                    break;
                case 0:
                    isRunning = false;
                default:
                    System.out.println("Invalid Option");
            }
        } while (isRunning);
    }

}
