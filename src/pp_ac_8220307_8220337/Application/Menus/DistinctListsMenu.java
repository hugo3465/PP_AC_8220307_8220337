package pp_ac_8220307_8220337.Application.Menus;

import ma02_resources.project.Edition;
import ma02_resources.project.Project;

public class DistinctListsMenu implements IMenu {

    @Override
    public void display() {
        System.out.println("--- Distinct Lists ");
        System.out.println("\t1 - Get Sudents With More Submissions");
        System.out.println("\t2 - Get Projects by Tags");
        System.out.println("\t3 - ");
        System.out.println("\t0 - Back\n");
    }

    public static void display(MenuManager menuManager) {
        IMenu menuDistinctList = new DistinctListsMenu();
        boolean isRunning = true;

        String editionName, projectName, tagString;
        Edition edition;
        Project project;

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
