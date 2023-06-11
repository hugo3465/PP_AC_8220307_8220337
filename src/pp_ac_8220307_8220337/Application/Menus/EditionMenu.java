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

import java.time.LocalDate;

import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import pp_ac_8220307_8220337.Api.BaseEdition;

/**
 * The DistinctListsMenu class represents the menu for accessing distinct lists.
 *
 * It provides options to get students with more submissions and projects by
 * tags.
 */
public class EditionMenu implements IMenu {

    /**
     * Displays the menu options for accessing distinct lists.
     */
    @Override
    public void display() {
        System.out.println("\t================================================");
        System.out.println("\t||------------- Admin / Editions ------------||");
        System.out.println("\t||            1 - Add Edition                ||");
        System.out.println("\t||            2 - Remove Edition             ||");
        System.out.println("\t||            3 - Set Edition as Active      ||");
        System.out.println("\t||            4 - Set Edition as Inactive    ||");
        System.out.println("\t||            5 - Set Edition as Closed      ||");
        System.out.println("\t||            6 - Set Edition as Canceled    ||");
        System.out.println("\t||            7 - List all Editions          ||");
        System.out.println("\t||            8 - Get Edition                ||");
        System.out.println("\t||            9 - Get Progress from edition  ||");
        System.out.println("\t||            10 - Get active edition        ||");
        System.out.println("\t||            11 - Get inactive editions     ||");
        System.out.println("\t||            12 - Get closed editions       ||");
        System.out.println("\t||            13 - Get canceled editions     ||");
        System.out.println("\t||            14 - Get unfinished editions   ||");
        System.out.println("\t||            0 - Back                       ||");
        System.out.println("\t================================================");
    }

    /**
     * Displays the distinct lists menu and handles user input.
     *
     * @param menuManager the menu manager
     */
    public static void display(MenuManager menuManager) {
        IMenu menuEdition = new EditionMenu();
        boolean isRunning = true;
        String name;
        String projectTemplate;
        LocalDate start;
        LocalDate end;
        Edition edition;

        do {
            switch (menuManager.diplayMenu(menuEdition)) {
                case 1: // Add Edition
                    try {
                        name = menuManager.getUserInputString("Insert the name of the edition: ");
                        projectTemplate = menuManager.getUserInputString("Insert project template: ");
                        start = menuManager.getUserInputLocalDate("Insert start date: ");
                        end = menuManager.getUserInputLocalDate("Insert end date: ");

                        menuManager.getEditions().addEdition(new BaseEdition(name, projectTemplate, start, end));
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }

                    break;
                case 2: // Remove Edition
                    try {
                        name = menuManager.getUserInputString("Insert the name of the edition you want to remove: ");

                        menuManager.getEditions().removeEdition(name);
                    } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Edition not found.");
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }

                    break;
                case 3: // Set Edition as Active
                    try {
                        System.out.println(
                                "only one edition can be set to active, if there is an active edition it will be put as inactive!");

                        name = menuManager
                                .getUserInputString("Insert the name of the edition you want to set as active: ");

                        menuManager.getEditions().defineAsActive(name);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 4: // Set Edition as Inactive
                    try {
                        name = menuManager
                                .getUserInputString("Insert the name of the edition you want to set as inactive: ");

                        menuManager.getEditions().defineAsInactive(name);

                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }

                    break;
                case 5: // Set Edition as Closed
                    try {
                        name = menuManager
                                .getUserInputString("Insert the name of the edition you want to set as closed: ");

                        menuManager.getEditions().defineAsClosed(name);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 6: // Set Edition as Canceled
                    try {
                        name = menuManager
                                .getUserInputString("Insert the name of the edition you want to set as Canceled: ");

                        menuManager.getEditions().defineAsCanceled(name);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 7: // List all Editions
                    try {
                        System.out
                                .println("\n\n\n\n" + menuManager.getEditions().getNumberOfCBLEditions() + "\n\n\n\n");
                        System.out.println(menuManager.getEditions().toString());
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }

                    break;
                case 8: // Get Edition
                    try {
                        name = menuManager.getUserInputString("Insert the name of the edition you want display: ");

                        System.out.println(menuManager.getEditions().getEdition(name));

                    } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Edition not found.");
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 9: // Get progress from Edition
                    try {
                        name = menuManager
                                .getUserInputString("Insert the name of the edition you want display the progress: ");
                        edition = menuManager.getEditions().getEdition(name);

                        System.out.println(menuManager.getEditions().getEditionProgress(edition));
                    } catch (NullPointerException e) {
                        System.out.println("Edition not found!");
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }

                    break;
                case 10: // Get pactive Edition
                    try {
                        System.out.println(menuManager.getEditions().getActiveEdition());
                    } catch (NullPointerException e) {
                        System.out.println("Edition not found!");
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }

                    break;
                case 11:
                    try {
                        for (Edition editioni : menuManager.getEditions().getAllInactiveEditions()) {
                            System.out.println(editioni.toString());
                        }
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 12:
                    try {
                        for (Edition editioni : menuManager.getEditions().getAllClosedEditions()) {
                            System.out.println(editioni.toString());
                        }
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 13:
                    try {
                        for (Edition editioni : menuManager.getEditions().getAllCanceledEditions()) {
                            System.out.println(editioni.toString());
                        }
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 14:
                    try {
                        for (Edition editioni : menuManager.getEditions().getUnfinishedEditions()) {
                            System.out.println(editioni.toString());
                        }
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
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
