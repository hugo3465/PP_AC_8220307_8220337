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
    private final int MAXIMUM_NUMBER_OF_TASKS;

    /**
     * the maximum number of participants allowed in the project
     */
    private final int MAXIMUM_NUMBER_OF_PARTICIPANTS;

    /**
     * the maximum number of students allowed in the project
     */
    private final int MAXIMUM_NUMBER_OF_STUDENTS;

    /**
     * the maximum number of partners allowed in the project
     */
    private final int MAXIMUM_NUMBER_OF_PARTNERS;

    /**
     * the maximum number of facilitators allowed in the project
     */
    private final int MAXIMUM_NUMBER_OF_FACILITATORS;

    /**
     * the name of the projects
     */
    private String name;

    /**
     * the description of the project
     */
    private String desciption;

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
     * indicates if the project is completed
     */
    private boolean isCompleted;

    /**
     * Constructs a BaseProject object with the specified parameters.
     *
     * @param MAXIMUM_NUMBER_OF_TASKS        the maximum number of tasks allowed in
     *                                       the project
     * @param MAXIMUM_NUMBER_OF_PARTICIPANTS the maximum number of participants
     *                                       allowed in the project
     * @param MAXIMUM_NUMBER_OF_STUDENTS     the maximum number of students allowed
     *                                       in the project
     * @param MAXIMUM_NUMBER_OF_PARTNERS     the maximum number of partners allowed
     *                                       in the project
     * @param MAXIMUM_NUMBER_OF_FACILITATORS the maximum number of facilitators
     *                                       allowed in the project
     * @param name                           the name of the project
     * @param description                    the description of the project
     * @param numberOfParticipants           the current number of participants in
     *                                       the project
     * @param numberOfPartners               the current number of partners in the
     *                                       project
     * @param numberOfFacilitators           the current number of facilitators in
     *                                       the project
     * @param numberOfStudents               the current number of students in the
     *                                       project
     * @param numberOfTasks                  the current number of tasks in the
     *                                       project
     * @param hasTags                        indicates if the project has tags
     * @param tags                           the array of tags associated with the
     *                                       project
     * @param tasks                          the array of tasks in the project
     * @param isCompleted                    indicates if the project is completed
     */
    public BaseProject(int mAXIMUM_NUMBER_OF_TASKS, int mAXIMUM_NUMBER_OF_PARTICIPANTS, int mAXIMUM_NUMBER_OF_STUDENTS,
            int mAXIMUM_NUMBER_OF_PARTNERS, int mAXIMUM_NUMBER_OF_FACILITATORS, String name, String desciption,
            int numberOfParticipants, int numberOfPartners, int numberOfFacilitators, int numberOfStudents,
            int numberOfTasks, boolean hasTags, String[] tags, Task[] tasks, boolean isCompleted) {
        MAXIMUM_NUMBER_OF_TASKS = mAXIMUM_NUMBER_OF_TASKS;
        MAXIMUM_NUMBER_OF_PARTICIPANTS = mAXIMUM_NUMBER_OF_PARTICIPANTS;
        MAXIMUM_NUMBER_OF_STUDENTS = mAXIMUM_NUMBER_OF_STUDENTS;
        MAXIMUM_NUMBER_OF_PARTNERS = mAXIMUM_NUMBER_OF_PARTNERS;
        MAXIMUM_NUMBER_OF_FACILITATORS = mAXIMUM_NUMBER_OF_FACILITATORS;

        this.name = name;
        this.desciption = desciption;
        this.numberOfParticipants = numberOfParticipants;
        this.numberOfPartners = numberOfPartners;
        this.numberOfFacilitators = numberOfFacilitators;
        this.numberOfStudents = numberOfStudents;
        this.numberOfTasks = numberOfTasks;
        this.tasks = tasks;
        this.isCompleted = isCompleted;

        this.hasTags = hasTags;
        //
        if (this.hasTags) {
            this.tags = tags;
        }
    }

    /**
     * Constructs a BaseProject only with name and description.
     * All MAXIMUM_NUMBERS are constants, so all of them are required.
     * 
     * @param MAXIMUM_NUMBER_OF_TASKS        the maximum number of tasks allowed in
     *                                       the project
     * @param MAXIMUM_NUMBER_OF_PARTICIPANTS the maximum number of participants
     *                                       allowed in the project
     * @param MAXIMUM_NUMBER_OF_STUDENTS     the maximum number of students allowed
     *                                       in the project
     * @param MAXIMUM_NUMBER_OF_PARTNERS     the maximum number of partners allowed
     *                                       in the project
     * @param MAXIMUM_NUMBER_OF_FACILITATORS the maximum number of facilitators
     *                                       allowed in the project
     * @param name                           the name of the project
     * @param description                    the description of the project
     */
    public BaseProject(int mAXIMUM_NUMBER_OF_TASKS, int mAXIMUM_NUMBER_OF_PARTICIPANTS, int mAXIMUM_NUMBER_OF_STUDENTS,
            int mAXIMUM_NUMBER_OF_PARTNERS, int mAXIMUM_NUMBER_OF_FACILITATORS, String name, String desciption) {
        MAXIMUM_NUMBER_OF_TASKS = mAXIMUM_NUMBER_OF_TASKS;
        MAXIMUM_NUMBER_OF_PARTICIPANTS = mAXIMUM_NUMBER_OF_PARTICIPANTS;
        MAXIMUM_NUMBER_OF_STUDENTS = mAXIMUM_NUMBER_OF_STUDENTS;
        MAXIMUM_NUMBER_OF_PARTNERS = mAXIMUM_NUMBER_OF_PARTNERS;
        MAXIMUM_NUMBER_OF_FACILITATORS = mAXIMUM_NUMBER_OF_FACILITATORS;

        this.numberOfParticipants = 0;
        this.numberOfPartners = 0;
        this.numberOfFacilitators = 0;
        this.numberOfParticipants = 0;
        this.numberOfStudents = 0;
        this.numberOfTasks = 0;
        this.name = name;
        this.desciption = desciption;
    }

    // vai ser usado para o baseEdition
    /**
     * Constructs a BaseProject object with only with name, description and the tags
     * array.
     * This Constructor is mostly used in the {@code addProject()} method int the
     * {@code BaseEdition} class
     * All MAXIMUM_NUMBERS are constants, so all of them are required.
     * 
     * @param MAXIMUM_NUMBER_OF_TASKS        the maximum number of tasks allowed in
     *                                       the project
     * @param MAXIMUM_NUMBER_OF_PARTICIPANTS the maximum number of participants
     *                                       allowed in the project
     * @param MAXIMUM_NUMBER_OF_STUDENTS     the maximum number of students allowed
     *                                       in the project
     * @param MAXIMUM_NUMBER_OF_PARTNERS     the maximum number of partners allowed
     *                                       in the project
     * @param MAXIMUM_NUMBER_OF_FACILITATORS the maximum number of facilitators
     *                                       allowed in the project
     * @param name                           the name of the project
     * @param description                    the description of the project
     * @param tags                           the array of tags associated with the
     *                                       project
     */
    public BaseProject(int mAXIMUM_NUMBER_OF_TASKS, int mAXIMUM_NUMBER_OF_PARTICIPANTS, int mAXIMUM_NUMBER_OF_STUDENTS,
            int mAXIMUM_NUMBER_OF_PARTNERS, int mAXIMUM_NUMBER_OF_FACILITATORS, String name, String desciption,
            String[] tags) {
        MAXIMUM_NUMBER_OF_TASKS = mAXIMUM_NUMBER_OF_TASKS;
        MAXIMUM_NUMBER_OF_PARTICIPANTS = mAXIMUM_NUMBER_OF_PARTICIPANTS;
        MAXIMUM_NUMBER_OF_STUDENTS = mAXIMUM_NUMBER_OF_STUDENTS;
        MAXIMUM_NUMBER_OF_PARTNERS = mAXIMUM_NUMBER_OF_PARTNERS;
        MAXIMUM_NUMBER_OF_FACILITATORS = mAXIMUM_NUMBER_OF_FACILITATORS;

        this.name = name;
        this.desciption = desciption;
        this.tags = tags;

        /**
         * If the tags array is null, the hasTas atribute will be false
         */
        hasTags = (tags == null) ? false : true;

        this.numberOfParticipants = 0;
        this.numberOfPartners = 0;
        this.numberOfFacilitators = 0;
        this.numberOfParticipants = 0;
        this.numberOfTasks = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return desciption;
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
        // Logic to add a participant to the project
        // Check if the maximum number of participants has been reached

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

            // Verifi the existance of the participant
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

    @Override
    public Participant getParticipant(String string) {
        for (Participant i : participants) {
            if (i.getName().equals(string)) {
                return i;
            }
        }

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

    @Override
    public void addTask(Task task) throws IllegalNumberOfTasks, TaskAlreadyInProject {
        // Logic to add a task to the project
        // Check if the maximum number of tasks has been reached
        // Check if the task is already in the project
        // Increment the task counter
        // Add the task to the project

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Task getTask(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Task[] getTasks() {
        return tasks;
    }

    @Override
    public boolean isCompleted() {
        return isCompleted;
    }

}
