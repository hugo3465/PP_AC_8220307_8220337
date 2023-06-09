/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
*/

package pp_ac_8220307_8220337.Api;

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
     * Used to initalize projects form variables or from other files.
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
     * @param participants         the array of participants with the project
     * @param tags                 the array of tags associated with the
     *                             project
     * @param tasks                the array of tasks in the project
     */
    public BaseProject(String name, String description,
            int numberOfParticipants, int numberOfPartners, int numberOfFacilitators, int numberOfStudents,
            int numberOfTasks, Participant[] participants, String[] tags, Task[] tasks) {

        this.name = name;
        this.description = description;

        // Set the number of participants, ensuring it doesn't exceed the maximum limit
        this.numberOfParticipants = Math.min(numberOfParticipants, MAXIMUM_NUMBER_OF_PARTICIPANTS);

        // Set the number of partners, ensuring it doesn't exceed the maximum limit
        this.numberOfPartners = Math.min(numberOfPartners, MAXIMUM_NUMBER_OF_PARTNERS);

        // Set the number of facilitators, ensuring it doesn't exceed the maximum limit
        this.numberOfFacilitators = Math.min(numberOfFacilitators, MAXIMUM_NUMBER_OF_FACILITATORS);

        // Set the number of students, ensuring it doesn't exceed the maximum limit
        this.numberOfStudents = Math.min(numberOfStudents, MAXIMUM_NUMBER_OF_STUDENTS);

        this.tasks = tasks;

        this.tags = tags;

        /**
         * If the tags array is null, the hasTas atribute will be false
         */
        this.hasTags = (tags == null) ? false : true;

        this.participants = participants;
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
     */
    public BaseProject(String name, String description, int numberOfParticipants, int numberOfPartners,
            int numberOfFacilitators, int numberOfStudents, int numberOfTasks, String[] tags, Task[] tasks) {
        this.name = name;
        this.description = description;

        // Check and limit the number of participants
        this.numberOfParticipants = Math.min(numberOfParticipants, MAXIMUM_NUMBER_OF_PARTICIPANTS);

        // Check and limit the number of partners
        this.numberOfPartners = Math.min(numberOfPartners, MAXIMUM_NUMBER_OF_PARTNERS);

        // Check and limit the number of facilitators
        this.numberOfFacilitators = Math.min(numberOfFacilitators, MAXIMUM_NUMBER_OF_FACILITATORS);

        // Check and limit the number of students
        this.numberOfStudents = Math.min(numberOfStudents, MAXIMUM_NUMBER_OF_STUDENTS);

        // Check and limit the number of tasks
        this.numberOfTasks = Math.min(numberOfTasks, MAXIMUM_NUMBER_OF_TASKS);

        this.tags = tags;

        /**
         * If the tags array is null, the hasTas atribute will be false
         */
        this.hasTags = (tags == null) ? false : true;

        this.tasks = tasks;

        this.participants = new Participant[numberOfParticipants];
    }

    /**
     * 
     * Constructor for the BaseProject class.
     * Mostly use in {@code InitialTestingValues} class
     * 
     * @param name                 
     * @param description         
     * @param numberOfPartners     
     * @param numberOfFacilitators 
     * @param numberOfStudents    
     * @param participants         
     * @param tags                 
     * @param tasks                
     */

    public BaseProject(String name, String description, int numberOfPartners, int numberOfFacilitators,
            int numberOfStudents, Participant[] participants, String[] tags, Task[] tasks) {
        this.name = name;
        this.description = description;
        this.numberOfPartners = numberOfPartners;
        this.numberOfFacilitators = numberOfFacilitators;
        this.numberOfStudents = numberOfStudents;
        this.participants = participants;
        this.tags = tags;
        this.tasks = tasks;

        /**
         * If the tags array is null, the hasTas atribute will be false
         */
        this.hasTags = (tags == null) ? false : true;

        this.numberOfTasks = tasks.length;

        this.numberOfParticipants = participants.length;
    }

    /**
     * Retrieves the name of the project.
     *
     * @return The name of the project.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Retrieves the description of the project.
     *
     * @return The description of the project.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the number of participants in the project.
     *
     * @return The number of participants in the project.
     */
    @Override
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    /**
     * Retrieves the number of students in the project.
     *
     * @return The number of students in the project.
     */
    @Override
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * Retrieves the number of partners in the project.
     *
     * @return The number of partners in the project.
     */
    @Override
    public int getNumberOfPartners() {
        return numberOfPartners;
    }

    /**
     * Retrieves the number of facilitators in the project.
     *
     * @return The number of facilitators in the project.
     */
    @Override
    public int getNumberOfFacilitators() {
        return numberOfFacilitators;
    }

    /**
     * Retrieves the number of tasks in the project.
     *
     * @return The number of tasks in the project.
     */
    @Override
    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    /**
     * Retrieves the maximum number of tasks allowed in the project.
     *
     * @return The maximum number of tasks allowed in the project.
     */
    @Override
    public int getMaximumNumberOfTasks() {
        return MAXIMUM_NUMBER_OF_TASKS;
    }

    /**
     * Retrieves the maximum number of participants allowed in the project.
     *
     * @return The maximum number of participants allowed in the project.
     */
    @Override
    public long getMaximumNumberOfParticipants() {
        return MAXIMUM_NUMBER_OF_PARTICIPANTS;
    }

    /**
     * Retrieves the maximum number of students allowed in the project.
     *
     * @return The maximum number of students allowed in the project.
     */
    @Override
    public int getMaximumNumberOfStudents() {
        return MAXIMUM_NUMBER_OF_STUDENTS;
    }

    /**
     * Retrieves the maximum number of partners allowed in the project.
     *
     * @return The maximum number of partners allowed in the project.
     */
    @Override
    public int getMaximumNumberOfPartners() {
        return MAXIMUM_NUMBER_OF_PARTNERS;
    }

    /**
     * Retrieves the maximum number of facilitators allowed in the project.
     *
     * @return The maximum number of facilitators allowed in the project.
     */
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
            // check if the array participants has sufficient space
            if (getNumberOfParticipants() == MAXIMUM_NUMBER_OF_PARTICIPANTS) {
                throw new ArrayIndexOutOfBoundsException("This project has reached its maximum number of participants");
            }

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

        } catch (Exception e) {
            throw new RuntimeException("An error occurred in remove Add Participant method: " + e.getMessage());
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
                return null;
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

        } catch (NullPointerException e) {
            throw new NullPointerException("Participant not found!");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred in removeParticipant method");
        }
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
     * @throws NullPointerException if the participant is not found
     */
    @Override
    public Participant getParticipant(String string) {
        for (Participant i : participants) {
            // Check if the participant's name matches the given name
            if (i.getName().equals(string)) {
                return i;
            }
        }

        // throw newPointerException if the participant is not found
        throw new NullPointerException("Participant not found!");
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
        } catch (Exception e) {
            throw new RuntimeException("An error occurred in addTask method");
        }
    }

    /**
     * Retrieves a Task object based on its title.
     * 
     * @param string the title of the task to retrieve
     * @return the Task object with the specified title, or null if no such task
     *         exists
     * @throws NullPointerException if the task is not found
     */
    @Override
    public Task getTask(String string) {
        for (int i = 0; i < numberOfTasks; i++) {
            if (this.tasks[i].getTitle().equals(string)) {
                return this.tasks[i];
            }
        }

        // throw newPointerException if the Task is not found
        throw new NullPointerException("Task not found!");
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
            if (task.getNumberOfSubmissions() == task.getSubmissions().length) {
                return false;
            }
        }

        return true;
    }

    /**
     * Retrieves the participants of the project, this mehtod is only used in the
     * toString method, only the toString method from this class uses this mehtod
     * 
     * @return all participants in the current project
     */
    private Participant[] getParticipants() {
        return this.participants;
    }

    @Override
    public String toString() {
        String string = "Name: " + name + "\n"
                + "\tDescription: " + description + "\n";

        string += "\tParticipants: " + "\n";
        try {
            for (Participant participant : getParticipants()) {
                if (participant != null) {
                    string += "\t\tName: " + participant.getName() + "\n"
                            + "\t\tEmail: " + participant.getEmail() + "\n";
                }
            }
        } catch (NullPointerException e) {

        }

        string += "\tTags: " + "\n";
        for (String tag : tags) {
            if (tag != null) {
                string += "\t\t" + tag + "\n";
            }
        }

        string += "\tTasks: " + "\n";
        for (Task task : tasks) {
            if (task != null) {
                string += "\t\t" + task.toString() + "\n";
            }
        }

        string += "\tIs Completed: " + isCompleted() + "\n\t --------------\n";

        return string;
    }
}
