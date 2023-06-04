package pp_ac_8220307_8220337.Api;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Partner;
import ma02_resources.participants.Student;
import ma02_resources.project.Project;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;
import ma02_resources.project.exceptions.TaskAlreadyInProject;
import pp_ac_8220307_8220337.Api.Exceptions.ParticipantDoesntExistException;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class BaseProject implements Project {
    /**
     * the maximum number of tasks allowed in the project
     */
    private final int MAXIMUM_NUMBER_OF_TASKS = 30;

    /**
     * the maximum number of participants allowed in the project
     */
    private final int MAXIMUM_NUMBER_OF_PARTICIPANTS = 32;

    /**
     * the maximum number of students allowed in the project
     */
    private final int MAXIMUM_NUMBER_OF_STUDENTS = 7;

    /**
     * the maximum number of partners allowed in the project
     */
    private final int MAXIMUM_NUMBER_OF_PARTNERS = 20;

    /**
     * the maximum number of facilitators allowed in the project
     */
    private final int MAXIMUM_NUMBER_OF_FACILITATORS = 5;

    /**
     * the name of the projects
     */
    private String name;

    /**
     * the description of the project
     */
    private String description;

    /**
     * the current number of participants in the project
     */
    private int numberOfParticipants;

    /**
     * the current number of partners in the project
     */
    private int numberOfPartners;

    /**
     * the current number of facilitators in the project
     */
    private int numberOfFacilitators;

    /**
     * the current number of students in the project
     */
    private int numberOfStudents;

    /**
     * the current number of tasks in the project
     */
    private int numberOfTasks;

    /**
     * the array of participants in the project
     */
    private Participant[] participants;

    /**
     * indicates if the project has tags
     */
    private boolean hasTags;

    /**
     * the array of tags associated with the project
     */
    private String[] tags;

    /**
     * the array of tasks in the project
     */
    private Task[] tasks;

    /**
     * Constructs a BaseProject object with the specified parameters.
     * 
     * @param name                 the name of the project
     * @param description          the description of the project
     * @param numberOfParticipants the current number of participants in
     *                             the project
     * @param numberOfPartners     the current number of partners in the
     *                             project
     * @param numberOfFacilitators the current number of facilitators in
     *                             the project
     * @param numberOfStudents     the current number of students in the
     *                             project
     * @param numberOfTasks        the current number of tasks in the
     *                             project
     * @param hasTags              indicates if the project has tags
     * @param tags                 the array of tags associated with the
     *                             project
     * @param tasks                the array of tasks in the project
     * @throws IllegalNumberOfParticipantType
     */
    public BaseProject(String name, String description,
            int numberOfParticipants, int numberOfPartners, int numberOfFacilitators, int numberOfStudents,
            int numberOfTasks, boolean hasTags, String[] tags, Task[] tasks)
            throws IllegalNumberOfParticipantType {

        this.name = name;
        this.description = description;
        // Check if the number of participants exceeds the maximum limit
        if (numberOfParticipants > MAXIMUM_NUMBER_OF_PARTICIPANTS) {
            throw new IllegalNumberOfParticipantType("Illegal Number Of Participants");
        }
        this.numberOfParticipants = numberOfParticipants;

        // Check if the number of partners exceeds the maximum limit
        if (numberOfPartners > MAXIMUM_NUMBER_OF_PARTNERS) {
            throw new IllegalNumberOfParticipantType("Illegal Number Of Partners");
        }
        this.numberOfPartners = numberOfPartners;

        // Check if the number of facilitators exceeds the maximum limit
        if (numberOfFacilitators > MAXIMUM_NUMBER_OF_FACILITATORS) {
            throw new IllegalNumberOfParticipantType("Illegal Number Of Facilitators");
        }
        this.numberOfFacilitators = numberOfFacilitators;

        // Check if the number of students exceeds the maximum limit
        if (numberOfStudents > MAXIMUM_NUMBER_OF_STUDENTS) {
            throw new IllegalNumberOfParticipantType("Illegal Number Of Students");
        }
        this.numberOfStudents = numberOfStudents;

        // Check if the number of tasks exceeds the maximum limit
        if (numberOfTasks > MAXIMUM_NUMBER_OF_TASKS) {
            throw new IllegalNumberOfParticipantType("Illegal Number Of Tasks");
        }
        this.tasks = tasks;

        this.hasTags = hasTags;

        if (this.hasTags) {
            this.tags = tags;
        }
    }

    /**
     * Constructs a BaseProject object with only with name, description and the tags
     * array.
     * 
     * @param name        the name of the project
     * @param description the description of the project
     * @param tags        the array of tags associated with the
     *                    project
     */
    public BaseProject(String name, String description,
            String[] tags) {

        this.name = name;
        this.description = description;
        this.tags = tags;

        /**
         * If the tags array is null, the hasTas atribute will be false
         */
        this.hasTags = (tags == null) ? false : true;

        this.numberOfParticipants = 0;
        this.numberOfPartners = 0;
        this.numberOfFacilitators = 0;
        this.numberOfParticipants = 0;
        this.numberOfTasks = 0;
    }

    /**
     * This Constructor is mostly used in the {@code addProject()} method in the
     * {@code BaseEdition} class
     * 
     * @param name
     * @param description
     * @param numberOfParticipants
     * @param numberOfPartners
     * @param numberOfFacilitators
     * @param numberOfStudents
     * @param numberOfTasks
     * @param tags
     * @param tasks
     * @throws IllegalNumberOfParticipantType
     */
    public BaseProject(String name, String description, int numberOfParticipants, int numberOfPartners,
            int numberOfFacilitators, int numberOfStudents, int numberOfTasks, String[] tags, Task[] tasks)
            throws IllegalNumberOfParticipantType {
        this.name = name;
        this.description = description;

        // Check if the number of participants exceeds the maximum limit
        if (numberOfParticipants > MAXIMUM_NUMBER_OF_PARTICIPANTS) {
            throw new IllegalNumberOfParticipantType("Illegal Number Of Participants");
        }
        this.numberOfParticipants = numberOfParticipants;

        // Check if the number of partners exceeds the maximum limit
        if (numberOfPartners > MAXIMUM_NUMBER_OF_PARTNERS) {
            throw new IllegalNumberOfParticipantType("Illegal Number Of Partners");
        }
        this.numberOfPartners = numberOfPartners;

        // Check if the number of facilitators exceeds the maximum limit
        if (numberOfFacilitators > MAXIMUM_NUMBER_OF_FACILITATORS) {
            throw new IllegalNumberOfParticipantType("Illegal Number Of Facilitators");
        }
        this.numberOfFacilitators = numberOfFacilitators;

        // Check if the number of students exceeds the maximum limit
        if (numberOfStudents > MAXIMUM_NUMBER_OF_STUDENTS) {
            throw new IllegalNumberOfParticipantType("Illegal Number Of Students");
        }
        this.numberOfStudents = numberOfStudents;

        // Check if the number of tasks exceeds the maximum limit
        if (numberOfTasks > MAXIMUM_NUMBER_OF_TASKS) {
            throw new IllegalNumberOfParticipantType("Illegal Number Of Tasks");
        }
        this.numberOfTasks = numberOfTasks;

        this.tags = tags;

        /**
         * If the tags array is null, the hasTas atribute will be false
         */
        this.hasTags = (tags == null) ? false : true;

        this.tasks = tasks;

        this.participants = new Participant[numberOfParticipants];
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    @Override
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    @Override
    public int getNumberOfPartners() {
        return numberOfPartners;
    }

    @Override
    public int getNumberOfFacilitators() {
        return numberOfFacilitators;
    }

    @Override
    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    @Override
    public int getMaximumNumberOfTasks() {
        return MAXIMUM_NUMBER_OF_TASKS;
    }

    @Override
    public long getMaximumNumberOfParticipants() {
        return MAXIMUM_NUMBER_OF_PARTICIPANTS;
    }

    @Override
    public int getMaximumNumberOfStudents() {
        return MAXIMUM_NUMBER_OF_STUDENTS;
    }

    @Override
    public int getMaximumNumberOfPartners() {
        return MAXIMUM_NUMBER_OF_PARTNERS;
    }

    @Override
    public int getMaximumNumberOfFacilitators() {
        return MAXIMUM_NUMBER_OF_FACILITATORS;
    }

    /**
     * Add a participant to the project
     * 
     * @param p participant that will be added
     */
    @Override
    public void addParticipant(Participant p) throws IllegalNumberOfParticipantType, ParticipantAlreadyInProject {
        try {
            // Check if the participant is already in the project
            if (getParticipant(p.getName()) != null) {
                throw new ParticipantAlreadyInProject("That participant already exists in this project!");
            }

            // Increment the counters based on the participant type (student, partner,
            // facilitator)
            if (p instanceof Facilitator) {
                if (numberOfFacilitators == MAXIMUM_NUMBER_OF_FACILITATORS) {
                    throw new IllegalNumberOfParticipantType("Number of facilitators has reached its maximum!");
                }
                numberOfFacilitators++;
            } else if (p instanceof Student) {
                if (numberOfStudents == MAXIMUM_NUMBER_OF_STUDENTS) {
                    throw new IllegalNumberOfParticipantType("Number of students has reached its maximum!");
                }
                numberOfStudents++;
            } else if (p instanceof Partner) {
                if (numberOfPartners == MAXIMUM_NUMBER_OF_PARTNERS) {
                    throw new IllegalNumberOfParticipantType("Number of partners has reached its maximum!");
                }
                numberOfPartners++;
            }

            // Add the participant to the project
            this.participants[numberOfParticipants] = p;

            numberOfParticipants++;

        } catch (ArrayIndexOutOfBoundsException aiofbe) {
            throw new ArrayIndexOutOfBoundsException(aiofbe + " in addParticipant method");
        } catch (NullPointerException npe) {
            throw new NullPointerException(npe + " in addParticipant method");
        } catch (ParticipantAlreadyInProject paip) {
            paip.printStackTrace();
        } catch (IllegalNumberOfParticipantType inopt) {
            inopt.printStackTrace();
        }
    }

    /**
     * Remove a participant from the project
     * 
     * @param string name of the participant to be removed
     * @return removed participant
     */
    @Override
    public Participant removeParticipant(String string) {
        try {
            if (this.numberOfParticipants < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }

            // Verify the existance of the participant
            int index = searchByName(string);
            if (index < 0) {
                throw new ParticipantDoesntExistException();
            }

            // save the participant that will be removed
            Participant removedParticipant = participants[index];

            // Remove the participant from the project
            for (int i = index; i < this.participants.length - 1; i++) {
                this.participants[i] = this.participants[i + 1];
            }

            /*
             * verify the instace of the {@code p} and decrement the number of that
             * instance.
             */
            if (participants[numberOfParticipants] instanceof Facilitator) {
                numberOfFacilitators--;
            } else if (participants[numberOfParticipants] instanceof Student) {
                numberOfStudents--;
            } else if (participants[numberOfParticipants] instanceof Partner) {
                numberOfPartners--;
            }

            this.numberOfParticipants--;
            this.participants[numberOfParticipants] = null;

            return removedParticipant;

        } catch (ArrayIndexOutOfBoundsException aioobe) {
            throw new ArrayIndexOutOfBoundsException(aioobe + " in addParticipant method");
        } catch (ParticipantDoesntExistException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Searches for a Participant in the participant array by name.
     *
     * @param name the name of the participant to search for
     * @return the index of the participant if found, -1 otherwise
     */
    private int searchByName(String string) {
        for (int i = 0; i < participants.length; i++) {
            if (this.participants[i].getName().equals(string) == true) {
                return i;
            }
        }
        return -1;
    }

    /**
     * searches for a participant in the {@code participants} array based on their
     * name.
     * 
     * @param string he name of the participant to search for
     * @return the participant if found, -1 otherwise
     */
    @Override
    public Participant getParticipant(String string) {
        for (Participant i : participants) {
            // Check if the participant's name matches the given name
            if (i.getName().equals(string)) {
                return i;
            }
        }

        // Return null if the participant is not found
        return null;
    }

    /**
     * Retrieves the participants of the project
     * 
     * @return all participants in the current project
     */
    public Participant[] getParticipants() {
        return this.participants;
    }

    @Override
    public String[] getTags() {
        return hasTags ? tags : null;
    }

    /**
     * Check if the project has the specified tag
     * 
     * @param string name of the tag that is looking for
     * @return true if a match is found, false otherwise
     */
    @Override
    public boolean hasTag(String string) {
        if (hasTags) {
            // Iterate through the tags array and check for a match with the given string
            for (String i : tags) {
                if (i == string) {
                    return true; // if a match is found
                }
            }
        }
        return false;

    }

    /**
     * Adds a task to the project.
     *
     * @param task The task to be added.
     * @throws IllegalNumberOfTasks If the maximum number of tasks has been reached.
     * @throws TaskAlreadyInProject If the task already exists in the project.
     */
    @Override
    public void addTask(Task task) throws IllegalNumberOfTasks, TaskAlreadyInProject {
        try {
            // Check if the maximum number of tasks has been reached
            if (numberOfTasks == MAXIMUM_NUMBER_OF_TASKS) {
                throw new IllegalNumberOfTasks("Maximum number of taks reached!");
            }

            // Check if the task is already in the project
            if (getTask(task.getTitle()) == null) {
                throw new TaskAlreadyInProject("This task already exist!");
            }

            // Add the task to the project
            this.tasks[numberOfTasks] = task;

            // Increment the task counter
            this.numberOfTasks++;
        } catch (IllegalNumberOfTasks inot) {
            inot.printStackTrace();
        } catch (TaskAlreadyInProject taip) {
            taip.printStackTrace();
        }
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
     * A task is marked as completed, if it has 1 or more submissions
     * 
     * @return a string representation of the project progress in percentage
     */
    public String projectProgress() {
        int completedTasks = 0;
        int totalTasks = getTasks().length;

        // Iterate through each task in the project
        for (Task task : getTasks()) {
            // The Task is marked as completed, if it has 1 or more submissions
            if (task.getNumberOfSubmissions() > 0) {
                completedTasks++;
            }
        }

        // Calculate the progress percentage by dividing the completed tasks by the
        // total tasks
        double progressPercentage = (double) completedTasks / totalTasks * 100;

        // Format the progress percentage as a string with two decimal places
        String progress = String.format("%.2f", progressPercentage) + "%";

        return progress;
    }

    /**
     * Retrieves a Task object based on its title.
     * 
     * @param string the title of the task to retrieve
     * @return the Task object with the specified title, or null if no such task
     *         exists
     */
    @Override
    public Task getTask(String string) {
        for (int i = 0; i < numberOfTasks; i++) {
            if (this.tasks[i].getTitle().equals(string)) {
                return this.tasks[i];
            }
        }

        return null;
    }

    /**
     * Retrieves an array of tasks associated with the edition.
     *
     * @return An array of tasks.
     */
    @Override
    public Task[] getTasks() {
        return tasks;
    }

    /**
     * Checks if all the tasks in the edition have at least one submission.
     *
     * @return {@code true} if all tasks have at least one submission, {@code false}
     *         otherwise.
     */
    @Override
    public boolean isCompleted() {
        for (Task task : tasks) {
            if (task.getNumberOfSubmissions() == 0) {
                return false;
            }
        }

        return true;
    }

    
    @Override
    public String toString() {
        String string = "Name: " + name + "\n"
                + "Description: " + description + "\n"
                + "Participants: " + "\n";

        for (Participant i : getParticipants()) {
            if (i != null) {
                string += i.toString() + "\n";
            }

        }

        string += "Tags: " + "\n";

        for (String i : tags) {
            string += "\t" + i + "\n";
        }

        string += "Tasks: " + "\n";

        for (Task i : tasks) {
            if (i != null) {
                string += i.toString() + "\n";
            }

        }

        string += "Is Completed: " + isCompleted();

        return string;
    }

    // TODO: isCompleted nunca está a ser colocada como true, o que fazia mais
    // sentido era sempre que se ia fazer
    // TODO: assumimos que quando existe uma submissão a task está feita mas acho
    // que devia ser pelo end, é melhor mudar. Ao vriar um metodo is completed nas
    // tasks
}
