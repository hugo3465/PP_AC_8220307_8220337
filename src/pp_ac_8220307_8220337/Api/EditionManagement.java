package pp_ac_8220307_8220337.Api;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Partner;
import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Task;
import pp_ac_8220307_8220337.Api.interfaces.IEditionManagement;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class EditionManagement implements IEditionManagement, Serializable {

    private final int DEFALUT_NUMBER_EDITION;
    private Edition[] editions;
    private int numEditions;

    /**
     * Default constructor for EditionManagement class.
     * Initializes the editions array with a default size.
     */
    public EditionManagement() {
        this.DEFALUT_NUMBER_EDITION = 5;
        this.numEditions = 0;
        this.editions = new Edition[DEFALUT_NUMBER_EDITION];
    }

    /**
     * Resizes the editions array by creating a new array with double the size
     * and copying the elements from the original array.
     */
    private void resizeEdition() {
        Edition[] newEditions = new Edition[this.editions.length * 2];
        for (int i = 0; i < this.editions.length; i++) {
            newEditions[i] = this.editions[i];
        }
        this.editions = newEditions;
    }

    /**
     * Returns the index of the edition with the specified name in the editions
     * array.
     *
     * @param name the name of the edition
     * @return the index of the edition, or -1 if not found
     */
    private int getEditionIndex(String name) {
        int i = 0;
        while (i < this.numEditions && this.editions[i].getName().compareTo(name) != 0) {
            i++;
        }

        if (i >= this.numEditions) {
            return -1;
        }

        return i;
    }

    /**
     * Adds a new edition to the editions array.
     *
     * @param edition the edition to be added
     */
    @Override
    public void addEdition(Edition edition) {

        try {
            if (this.numEditions >= this.editions.length) {
                resizeEdition();
            }

            this.editions[this.numEditions] = edition;

            this.numEditions++;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    /**
     * Removes an edition from the editions array.
     *
     * @param editionName the name of the edition to be removed
     */
    @Override
    public void removeEdition(String editionName) {
        try {
            int index = getEditionIndex(editionName);

            for (int i = index; i < this.numEditions - 1; i++) {
                this.editions[i] = this.editions[i + 1];
            }

            this.numEditions--;
            this.editions[this.numEditions] = null;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns an array of all editions.
     *
     * @return the array of editions
     */
    @Override
    public Edition[] getEditions() {
        return this.editions;
    }

    /**
     * Returns the edition with the specified name.
     *
     * @param editionName the name of the edition
     * @return the edition object, or null if not found
     */
    @Override
    public Edition getEdition(String editionName) {
        for (int i = 0; i < this.numEditions; i++) {
            if (editions[i].getName().equals(editionName)) {
                return editions[i];
            }
        }

        return null;
    }

    /**
     * Defines the edition with the specified name as active.
     * Sets the status of other active editions as Inactive, because only one
     * edition can be set as Active.
     *
     * @param editionName the name of the edition to be set as active
     */
    @Override
    public void defineAsActive(String editionName) {
        for (int i = 0; i < this.numEditions; i++) {
            // Sets the status of other active editions as Inactive
            if (editions[i].getStatus().equals(Status.ACTIVE)) {
                editions[i].setStatus(Status.INACTIVE);
            }

            // Defines the edition with the specifided name as active.
            if (editions[i].getName().equals(editionName)) {
                editions[i].setStatus(Status.ACTIVE);
            }
        }
    }

    /**
     * Retrieves the number of CBL Editions
     * 
     * @return number of CBL Editions
     */
    @Override
    public int getNumberOfCBLEditions() {
        return this.numEditions;
    }

    /**
     * Defines the edition with the specified name as inactive.
     *
     * @param editionName the name of the edition to be set as inactive
     */
    @Override
    public void defineAsInactive(String editionName) {
        try {
            int index = getEditionIndex(editionName);

            editions[index].setStatus(Status.INACTIVE);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    /**
     * Defines the edition with the specified name as canceled.
     *
     * @param editionName the name of the edition to be set as canceled
     */
    @Override
    public void defineAsCanceled(String editionName) {
        try {
            int index = getEditionIndex(editionName);

            editions[index].setStatus(Status.CANCELED);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    /**
     * Defines the edition with the specified name as closed.
     *
     * @param editionName the name of the edition to be set as closed
     */
    @Override
    public void defineAsClosed(String editionName) {
        try {
            int index = getEditionIndex(editionName);

            editions[index].setStatus(Status.CLOSED);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves an array of editions with the unfinished projects in all editions.
     * 
     * @return array of projects with the unfinished projects in all editions
     */
    public Edition[] getunfinishedEditions() {
        Edition[] unfinishedEditions = new BaseEdition[numEditions];
        int countUnfinishedEditions = 0;

        for (int i = 0; i < numEditions; i++) {
            for (Project project : this.editions[i].getProjects()) {
                if (project.isCompleted()) {
                    unfinishedEditions[countUnfinishedEditions] = editions[i];
                    countUnfinishedEditions++;
                }

            }
        }

        // Create a new array to hold only the unfinished Projects in all editions
        Edition[] onlyunfinishedEditions = new BaseEdition[countUnfinishedEditions];
        System.arraycopy(unfinishedEditions, 0, onlyunfinishedEditions, 0, countUnfinishedEditions);

        return onlyunfinishedEditions;
    }

    @Override
    public String toString() {
        String string = "";

        for (int i = 0; i < numEditions; i++) {
            string += "\n" + editions[i].toString();
        }

        return string;
    }

    /**
     * @return
     */
    @Override
    public Participant[] getAllStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllStudents'");
    }

    @Override
    public Participant[] getAllFacilitators() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFacilitators'");
    }

    @Override
    public Participant[] getAllPartners() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPartners'");
    }

    @Override
    public Student getStudent(String name) {
        for (int i = 0; i < numEditions; i++) {
            for (int j = 0; j < editions[i].getNumberOfProjects(); i++) {
                if (editions[i].getProjects()[j].getParticipant(name) instanceof Student) {
                    return (Student) editions[i].getProjects()[j].getParticipant(name);
                }
            }
        }

        return null;
    }

    @Override
    public Facilitator getFacilitator(String name) {
        for (int i = 0; i < numEditions; i++) {
            for (int j = 0; j < editions[i].getNumberOfProjects(); i++) {
                if (editions[i].getProjects()[j].getParticipant(name) instanceof Facilitator) {
                    return (Facilitator) editions[i].getProjects()[j].getParticipant(name);
                }
            }
        }

        return null;
    }

    @Override
    public Partner getPartner(String name) {
        for (int i = 0; i < numEditions; i++) {
            for (int j = 0; j < editions[i].getNumberOfProjects(); i++) {
                if (editions[i].getProjects()[j].getParticipant(name) instanceof Partner) {
                    return (Partner) editions[i].getProjects()[j].getParticipant(name);
                }
            }
        }

        return null;
    }

    @Override
    public Participant[] getAllParticipantsFromEdition(String EditionName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllParticipants'");
    }

    /**
     * Retrieves an array of projects with the unfinished projects of an edition.
     *
     * The method iterates through each project in the specified edition and checks
     * if any of the tasks within the project
     * have at least one submission. If a task has one or more submissions, the
     * project is considered unfinished and is added
     * to the array of unfinished projects.
     *
     * @param edition the edition from which to retrieve the unfinished projects
     * @return an array of projects containing the unfinished projects of the
     *         edition
     */
    @Override
    public Project[] getUnfinishedProjects(Edition edition) {
        Project[] unfinishedProjects = new BaseProject[edition.getNumberOfProjects()];
        int countUnfinishedProjects = 0;

        // Iterate through each project in the edition
        for (int i = 0; i < edition.getNumberOfProjects(); i++) {

            Project curretnProject = edition.getProjects()[i];
            // Check each task within the project for the presence of submissions
            for (Task task : curretnProject.getTasks()) {
                // If a task has at least one submission, add the project to the
                // unfinishedProjects array
                if (task.getNumberOfSubmissions() > 0) {
                    unfinishedProjects[countUnfinishedProjects] = curretnProject;
                    countUnfinishedProjects++;
                }

            }
        }

        // Create a new array to hold only the unfinished Projects
        Project[] onlyUnfinishedProjects = new BaseProject[countUnfinishedProjects];
        System.arraycopy(unfinishedProjects, 0, onlyUnfinishedProjects, 0, countUnfinishedProjects);

        return onlyUnfinishedProjects;
    }

    /**
     * Retrieves a project based on its tags from a given edition.
     *
     * The method iterates through each project in the specified edition and checks
     * if the tags of the project match the
     * provided TagString. If a project with matching tags is found, it is returned.
     * If no matching project is found, null
     * is returned.
     *
     * @param TagString the string representing the tags to search for
     * @param edition   the edition from which to retrieve the project
     * @return the project with matching tags, or null if no match is found
     */
    @Override
    public Project getProjectByTags(String TagString, Edition edition) {

        for (Project project : edition.getProjects()) {
            if (project.getTags().equals(TagString)) {
                return project;
            }
        }

        return null;
    }

    /**
     *
     * Retrieves the progress of the edition as a percentage.
     *
     * The progress is calculated based on the completion status of the projects
     *
     * in the edition. The completed projects are counted, and the progress is
     *
     * expressed as a percentage of the total number of projects.
     *
     * @param edition the edition for which the progress is calculated
     * @return a string representation of the edition progress in percentage
     */
    @Override
    public String getEditionProgress(Edition edition) {
        int completedProjects = 0;
        int totalProjects = edition.getNumberOfProjects();

        for (Project project : edition.getProjects()) {
            if (project.isCompleted()) {
                completedProjects++;
            }
        }

        double progressPercentage = (double) completedProjects / totalProjects * 100;
        String progress = String.format("%.2f", progressPercentage) + "%";

        return progress;
    }

    /**
     * 
     * Retrieves the progress of the project as a percentage.
     * 
     * The method calculates the progress of the project by counting the number of
     * completed tasks
     * 
     * and expressing it as a percentage of the total number of tasks in the
     * project. The progress
     * 
     * A task is marked as completed, if it the number of submissions in equal to
     * the the lenght of the submisisons array inside the taks
     * 
     * @param project the project for which the progress is calculated
     * @return a string representation of the project progress in percentage
     */
    @Override
    public String getProjectProgress(Project project) {
        int completedTasks = 0;
        int totalTasks = project.getTasks().length;

        // Iterate through each task in the project
        for (Task task : project.getTasks()) {
            // A task is considered completed if the number of submissions is equal to the
            // length of the submissions array inside the task
            if (task.getNumberOfSubmissions() == task.getSubmissions().length) {
                completedTasks++;
            }
        }

        // Calculate the progress percentage by dividing the completed tasks by the
        // total tasks
        double progressPercentage = (double) completedTasks / totalTasks * 100;

        // Format the progress percentage as a string with two decimal places
        String progress = String.format("%.2f", progressPercentage) + "%";

        return "O projeto está com " + progress + " de progresso, com " + completedTasks + " tarefas concluídas.";
        // TODO: Incluir o número total de tarefas para fornecer uma visão completa do
        // progresso do projeto
    }

    /**
     * Retrieves the active edition from the list of editions.
     *
     * The method iterates through each edition in the list of editions and checks
     * if the status of the edition is set to
     * "ACTIVE". If an active edition is found, it is returned. If no active edition
     * is found, null is returned.
     *
     * @return the active edition, or null if no active edition is found
     */
    @Override
    public Edition getActivEdition() {
        for (Edition edition : editions) {
            if (edition.getStatus() == Status.ACTIVE) {
                return edition;
            }
        }
        return null;
    }

    // Method to save editions to a binary file
    @Override
    public void saveEditionsToFile(String filename) {
        /*try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            // Create an ObjectOutputStream called 'oos' and initialize it with a new
            // FileOutputStream that writes to the specified 'filename' file

            // está a dar erro no primeiro, vou ter de serializar isto
            oos.writeObject(editions); // Write the 'editions' array to the file
            oos.writeInt(numEditions); // Write the 'numOfEditions' value to the file

            System.out.println("Editions have been saved to " + filename); // Print a success message
        } catch (IOException e) {
            System.out.println("Error occurred while saving editions to file: " + e.getMessage()); // Print an error
                                                                                                   // message if an
                                                                                                   // IOException occurs
        }*/

        try {
            FileOutputStream fileOut = new FileOutputStream("teste.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            fileOut.close();
            System.out.println("Objects have been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read editions from a binary file
    @Override
    public void readEditionsFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            // Create an ObjectInputStream called 'ois' and initialize it with a new
            // FileInputStream that reads from the specified 'filename' file

            editions = (Edition[]) ois.readObject(); // Read the serialized 'editions' array from the file and assign it
                                                     // to the 'editions' variable
            numEditions = ois.readInt(); // Read the 'numOfEditions' value from the file and assign it to the
                                           // 'numOfEditions' variable

            System.out.println("Editions have been loaded from " + filename); // Print a success message
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred while reading editions from file: " + e.getMessage()); // Print an error
                                                                                                      // message if an
                                                                                                      // IOException or
                                                                                                      // ClassNotFoundException
                                                                                                      // occurs
        }
    }

}
