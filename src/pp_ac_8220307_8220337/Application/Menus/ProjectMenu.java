package pp_ac_8220307_8220337.Application.Menus;

import ma02_resources.participants.Participant;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Task;

/**
 * Nome: Pedro Marcelo Santos Pinho Número: 8220307 Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães Número: 8220337 Turma: LEIT2
 */
public class ProjectMenu implements IMenu {
    private Edition edition;

    public ProjectMenu(Edition edition) {
        this.edition = edition;
    }

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
        // System.out.println("\t8 - List all Participants from Project");
        System.out.println("\t8 - List all Projects");
        System.out.println("\t9 - Get progress from a Project");
        System.out.println("\t0 - Back\n");
    }

    public void display(MenuManager menuManager) {
        // IMenu menuEdition = new ProjectMenu();
        boolean isRunning = true;

        String projectTitle, projectDescription, participantName;
        String[] projectTags;

        do {
            switch (menuManager.diplayMenu(this)) {
                case 1:
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

                    } catch (Exception e) {
                        System.out.println("An error has ocurred!: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        projectTitle = menuManager
                                .getUserInputString("Inser the title of the project you want to remove: ");

                        menuManager.getEditions().getEdition(this.edition.getName()).removeProject(projectTitle);
                    } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Edition not found.");
                    }
                    break;
                case 3:
                    try {
                        projectTitle = menuManager
                                .getUserInputString("Inser the title of the project you want to add participant to: ");

                        menuManager.getEditions().getEdition(this.edition.getName()).getProject(projectTitle)
                                .addParticipant(menuManager.getStudentInputInfo());
                    } catch (Exception e) {
                        System.out.println("An error has ocurred!: " + e.getMessage());
                    }

                    break;
                case 4:
                    try {
                        projectTitle = menuManager
                                .getUserInputString(
                                        "Inser the title of the project you want to remove the participant: ");

                        participantName = menuManager.getUserInputString(
                                "Inser the name of the student you want to remove from the prohect: ");

                        menuManager.getEditions().getEdition(this.edition.getName()).getProject(projectTitle)
                                .removeParticipant(participantName);
                    } catch (Exception e) {
                        System.out.println("An error has ocurred!: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        projectTitle = menuManager
                                .getUserInputString("Inser the title of the project you want to add a task: ");

                        Task task = menuManager.getTasktInputInfo();

                        menuManager.getEditions().getEdition(edition.getName()).getProject(projectTitle).addTask(task);
                    } catch (Exception e) {
                        System.out.println("An error has ocurred!: " + e.getMessage());
                    }
                    break;
                case 6:
                //TODO
                    break;
                case 7:
                    for (Participant participant : menuManager.getEditions()
                            .getAllParticipantsFromEdition(edition.getName())) {
                        System.out.println(participant.toString());
                    }
                    break;
                case 8:
                    for (Project project : menuManager.getEditions().getEdition(this.edition.getName()).getProjects()) {
                        System.out.println(project.toString() + '\n');
                    }
                    break;
                case 9:
                // TODO
                    break;
                case 0:
                    isRunning = false;
                default:
                    System.out.println("Invalid Option");
            }
        } while (isRunning);
    }
}
