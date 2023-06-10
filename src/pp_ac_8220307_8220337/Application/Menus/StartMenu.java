package pp_ac_8220307_8220337.Application.Menus;

import java.io.IOException;

import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */

/**
 * The StartMenu class represents the initial menu of the application.
 * 
 * It provides options for administrators and students to login and access their
 * respective menus.
 */
public class StartMenu implements IMenu {

    /**
     * Displays the options of the start menu.
     */
    @Override
    public void display() {
        System.out.println("\n\tWelcome to CBL ");
        System.out.println("\t1 - Admin");
        System.out.println("\t2 - Student");
        System.out.println("\t0 - Sair\n");
    }

    /**
     * Displays the start menu and handles user input.
     *
     * @param menuManager the menu manager
     * @throws IOException if an I/O error occurs
     */
    public static void display(MenuManager menuManager) throws IOException {
        IMenu menuStartManagement = new StartMenu();
        boolean isRunning = true;

        String editionName, participantName, projectName;

        do {
            switch (menuManager.diplayMenu(menuStartManagement)) {
                case 1:
                    AdminMenu.display(menuManager);
                    break;
                case 2:
                    try {
                        participantName = menuManager.getUserInputString("Enter the your name to login: ");
                        Student student = menuManager.getEditions().getStudent(participantName);

                        editionName = menuManager.getUserInputString("Enter the edition name: ");
                        Edition edition = menuManager.getEditions().getEdition(editionName);

                        projectName = menuManager.getUserInputString("Enter the name of your project: ");
                        Project project = edition.getProject(projectName);

                        StudentMenu startMenu = new StudentMenu(student, edition, project);

                        startMenu.display(menuManager);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
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
