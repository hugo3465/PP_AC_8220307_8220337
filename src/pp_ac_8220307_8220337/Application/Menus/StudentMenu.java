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

import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Task;
import pp_ac_8220307_8220337.Api.BaseSubmission;

/**
 * The StudentMenu class represents the menu for a student user.
 * 
 * It provides options for a student to interact with their project and tasks.
 */
public class StudentMenu implements IMenu {
    /**
     * The student associated with the menu.
     */
    private Student student;

    /**
     * The edition associated with the menu.
     */
    private Edition edition;

    /**
     * The project associated with the menu.
     */
    private Project project;

    /**
     * Creates a new instance of the StudentMenu class.
     *
     * @param student the student
     * @param edition the edition
     * @param project the project
     */
    public StudentMenu(Student student, Edition edition, Project project) {
        this.student = student;
        this.edition = edition;
        this.project = project;
    }

    /**
     * Displays the options of the student menu.
     */
    @Override
    public void display() {
        System.out.println("\t=============================================================");
        System.out.println("\t||-------------- Hello " + student.getName() + " ------------||");
        System.out.println("\t||               1 - Add Submission                        ||");
        System.out.println("\t||               2 - Get Task                              ||");
        System.out.println("\t||               3 - List all Tasks                        ||");
        System.out.println("\t||               4 - Get progress from Project             ||");
        System.out.println("\t||               0 - Back                                  ||");
        System.out.println("\t=============================================================");
    }

    /**
     * Displays the student menu and handles user input.
     *
     * @param menuManager the menu manager
     */
    public void display(MenuManager menuManager) {
        // Menu menuEdition = new StudentMenu(student);
        boolean isRunning = true;

        String submissionText, taskTitle; // submission text

        do {
            switch (menuManager.diplayMenu(this)) {

                case 1: // add Submission
                    // A student can acces all editions, but can only add submissions to the active
                    // one
                    if (edition.getStatus() != Status.ACTIVE) {
                        System.out.println("This edition is not active, you can't add any submissions");
                        break;
                    }

                    try {

                        taskTitle = menuManager
                                .getUserInputString("Insert the title of the task you want to make a submission: ");
                        submissionText = menuManager.getUserInputString("Insert a text in your submission: ");

                        menuManager.getEditions().getEdition(edition.getName()).getProject(project.getName())
                                .getTask(taskTitle)
                                .addSubmission(new BaseSubmission(student, submissionText));
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }

                    break;
                case 2: // Get Task
                    try {
                        taskTitle = menuManager
                                .getUserInputString("Insert the title of the task you are looking for: ");

                        System.out.println(menuManager.getEditions().getEdition(edition.getName())
                                .getProject(project.getName()).getTask(taskTitle).toString());
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }
                    break;
                case 3: // List all Tasks
                    try {
                        for (Task task : project.getTasks()) {
                            System.out.println(task.toString());
                        }
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error has occured: " + e.getMessage());
                    }

                    break;
                case 4: // Get progress from Project
                    try {
                        System.out.println(menuManager.getEditions().getProjectProgress(project));
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
