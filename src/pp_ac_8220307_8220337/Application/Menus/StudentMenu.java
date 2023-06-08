package pp_ac_8220307_8220337.Application.Menus;

import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Task;
import pp_ac_8220307_8220337.Api.BaseSubmission;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class StudentMenu implements IMenu {
    private Student student;
    private Edition edition;
    private Project project;

    public StudentMenu(Student student, Edition edition, Project project) {
        this.student = student;
        this.edition = edition;
        this.project = project;
    }

    @Override
    public void display() {
        System.out.println("\n\t--- Hello " + student.getName() + " ---");
        System.out.println("\t1 - Add Submission");
        System.out.println("\t2 - Get Task");
        System.out.println("\t3 - List all Tasks");
        System.out.println("\t4 - Get progress from Project");
        System.out.println("\t0 - Back\n");
    }

    public void display(MenuManager menuManager) {
        // Menu menuEdition = new StudentMenu(student);
        boolean isRunning = true;

        String submissionText, taskTitle; // submission text

        do {
            switch (menuManager.diplayMenu(this)) {
                case 1: // add Submission
                    try {

                        taskTitle = menuManager.getUserInputString("Insert the title of the task you want to make a submission: ");
                        submissionText = menuManager.getUserInputString("Insert a text in your submission: ");

                        menuManager.getEditions().getEdition(edition.getName()).getProject(project.getName()).getTask(taskTitle)
                                .addSubmission(new BaseSubmission(student, submissionText));
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }

                    break;
                case 2: //Get Task
                    try {
                        taskTitle = menuManager.getUserInputString("Insert the title of the task you are looking for: ");

                        System.out.println(menuManager.getEditions().getEdition(edition.getName()).getProject(project.getName()).getTask(taskTitle).toString());
                    } catch (Exception e) {
                       System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 3: // List all Tasks
                    for (Task task : project.getTasks()) {
                        System.out.println(task.toString());
                    }
                    break;
                case 4: // Get progress from Project
                    System.out.println(menuManager.getEditions().getProjectProgress(project));
                    break;
                case 0:
                    isRunning = false;
                default:
                    System.out.println("Invalid Option");
            }
        } while (isRunning);
    }

}
