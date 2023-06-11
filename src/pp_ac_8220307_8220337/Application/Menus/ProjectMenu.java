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

import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Task;

/**
 * The ProjectMenu class represents the menu for project management.
 * 
 * It provides options to add, remove, and modify projects, as well as manage
 * project participants and tasks.
 */
public class ProjectMenu implements IMenu {
    /**
     * The edition associated with the menu.
     */
    private Edition edition;

    /**
     * Constructs a ProjectMenu object with the specified edition.
     *
     * @param edition the edition to associate with the menu
     */
    public ProjectMenu(Edition edition) {
        this.edition = edition;
    }

    /**
     * Displays the menu options for project management.
     */
    @Override
    public void display() {
        System.out.println("\n\t--- Admin / Projects ---");
        System.out.println("\t1 - Add Project");
        System.out.println("\t2 - Remove Project");
        System.out.println("\t3 - Add Participant to a Project");
        System.out.println("\t4 - Remove Participant from a Project");
        System.out.println("\t5 - Add Task to a Project");
        System.out.println("\t6 - Get Participant");
        System.out.println("\t7 - List all Projects");
        System.out.println("\t8 - Get progress from a Project");
        System.out.println("\t0 - Back\n");
    }

    /**
     * Displays the project management menu and handles user input.
     *
     * @param menuManager the menu manager
     */
    public void display(MenuManager menuManager) {
        // IMenu menuEdition = new ProjectMenu();
        boolean isRunning = true;

        String projectTitle, projectDescription, participantName;
        String[] projectTags;

        do {
            switch (menuManager.diplayMenu(this)) {
                case 1: // Add Project
                    try {
                        System.out.println(
                                "Most of a project's attributes are passed from a json file, which has to be at the root of the project folder.\n");
                        System.out.println("The json file must be named 'project.json'.\n");

                        projectTitle = menuManager.getUserInputString("Insert the title of the project: ");
                        projectDescription = menuManager.getUserInputString("Insert the description of the project: ");
                        projectTags = menuManager
                                .getUserInputString("Insert the tags of the project (separate by ','): ").split(",");

                        menuManager.getEditions().getEdition(this.edition.getName()).addProject(projectTitle,
                                projectDescription, projectTags);

                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has ocurred!: " + e.getMessage());
                    }
                    break;
                case 2: // Remove Project
                    try {
                        projectTitle = menuManager
                                .getUserInputString("Inser the title of the project you want to remove: ");

                        menuManager.getEditions().getEdition(this.edition.getName()).removeProject(projectTitle);
                    } catch (NullPointerException e) {
                        System.out.println("Edition not found.");
                    } catch (Exception e) {
                        System.out.println("An error has ocurred!: " + e.getMessage());
                    }
                    break;
                case 3: // Add Participant to a Project
                    try {
                        projectTitle = menuManager
                                .getUserInputString("Inser the title of the project you want to add participant to: ");

                        menuManager.getEditions().getEdition(this.edition.getName()).getProject(projectTitle)
                                .addParticipant(menuManager.getStudentInputInfo());
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has ocurred!: " + e.getMessage());
                    }

                    break;
                case 4: // Remove Participant from a Project
                    try {
                        projectTitle = menuManager
                                .getUserInputString(
                                        "Inser the title of the project you want to remove the participant: ");

                        participantName = menuManager.getUserInputString(
                                "Inser the name of the student you want to remove from the prohect: ");

                        menuManager.getEditions().getEdition(this.edition.getName()).getProject(projectTitle)
                                .removeParticipant(participantName);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has ocurred!: " + e.getMessage());
                    }
                    break;
                case 5: // Add Task to a Project
                    try {
                        projectTitle = menuManager
                                .getUserInputString("Inser the title of the project you want to add a task: ");

                        Task task = menuManager.getTasktInputInfo();

                        menuManager.getEditions().getEdition(edition.getName()).getProject(projectTitle).addTask(task);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has ocurred!: " + e.getMessage());
                    }
                    break;
                case 6: // Get Participant
                    try {
                        participantName = menuManager
                                .getUserInputString("Insert the name of the participant you are looking for: ");
                        menuManager.getEditions().getParticipant(participantName);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 7: // List all Projects
                    try {
                        for (Project project : menuManager.getEditions().getEdition(this.edition.getName())
                                .getProjects()) {
                            System.out.println(project.toString() + '\n');
                        }
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }

                    break;
                case 8: // Get progress from a Project
                    try {
                        projectTitle = menuManager
                                .getUserInputString(
                                        "Inser the title of the project you want to remove the participant: ");

                        Project searchedProject = menuManager.getEditions().getEdition(edition.getName())
                                .getProject(projectTitle);

                        System.out.println(menuManager.getEditions().getProjectProgress(searchedProject));
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 0:
                    isRunning = false;
                default:
                    System.out.println("Invalid Option");
            }
        } while (isRunning);
    }
}
