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

/**
 * The DistinctListsMenu class represents the menu for accessing distinct lists.
 *
 * It provides options to get students with more submissions and projects by
 * tags.
 */
public class DistinctListsMenu implements IMenu {

    /**
     * Displays the menu options for the administrator.
     */
    @Override
    public void display() {
        System.out.println("\t================================================");
        System.out.println("\t||-------------- Distinct Lists --------------||");
        System.out.println("\t||      1 - Get Sudents With More Submissions ||");
        System.out.println("\t||      2 - Get Projects by Tags              ||");
        System.out.println("\t||      3 - Get Tasks By Date                 ||");
        System.out.println("\t||      0 - Back                              ||");
        System.out.println("\t================================================");
    }

    /**
     * Displays the admin menu and handles user input.
     *
     * @param menuManager the menu manager
     */
    public static void display(MenuManager menuManager) {
        IMenu menuDistinctList = new DistinctListsMenu();
        boolean isRunning = true;

        String editionName, projectName, tagString;
        Edition edition;
        Project project;
        LocalDate date;

        do {
            switch (menuManager.diplayMenu(menuDistinctList)) {
                case 1:
                    try {
                        editionName = menuManager
                                .getUserInputString("Inser the name of the edition you want to search for students: ");
                        edition = menuManager.getEditions().getEdition(editionName);

                        projectName = menuManager
                                .getUserInputString("Inser the name of the project you want to search for students: ");
                        project = edition.getProject(projectName);

                        menuManager.getEditions().getSudentsWithMoreSubmissions(edition, project);
                    } catch (NullPointerException e) {
                        System.out.println("Name not found: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        editionName = menuManager
                                .getUserInputString("Inser the name of the edition you want to search for projects: ");
                        edition = menuManager.getEditions().getEdition(editionName);

                        tagString = menuManager
                                .getUserInputString("Insert the tag for the projects that you are loking for: ");
                        menuManager.getEditions().getProjectByTags(tagString, edition);
                    } catch (NullPointerException e) {
                        System.out.println("Edition not found: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        projectName = menuManager.getUserInputString("Enter the name of the project where the task you are looking for is located: ");
                        project = menuManager.getEditions().getProject(projectName);

                        date = menuManager.getUserInputLocalDate("Insert the date for the tasks you are looking at: ");

                        menuManager.getEditions().getTaksByDate(date, project);
                    }catch(NullPointerException e) {
                        System.out.println(e.getMessage());
                    }catch(Exception e) {
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
