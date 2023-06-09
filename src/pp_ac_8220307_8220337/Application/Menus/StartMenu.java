package pp_ac_8220307_8220337.Application.Menus;

import ma02_resources.participants.Participant;
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

        String editionName, participantName, projectName; 
        

        do {
            switch (menuManager.diplayMenu(menuStartManagement)) {
                case 1:
                    AdminMenu.display(menuManager);
                    break;
                case 2:
                    // A student can only acces active editions
                    try {
                        participantName = menuManager.getUserInputString("Enter the your name to login: ");
                        editionName = menuManager.getUserInputString("Enter the edition name: ");
                        projectName = menuManager.getUserInputString("Enter the name of your project: ");
                        
                        
                        Edition edition = menuManager.getEditions().getActivEdition();
                        Student participant = menuManager.getEditions().getStudent(participantName);
                        Project project = edition.getProject(projectName);

                        StudentMenu startMenu = new StudentMenu(participant, edition, project);

                        startMenu.display(menuManager);
                    } catch (NullPointerException e) {
                        System.out.println("No active projects at the moment");
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
