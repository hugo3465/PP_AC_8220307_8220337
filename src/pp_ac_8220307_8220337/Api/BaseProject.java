package pp_ac_8220307_8220337.Api;

import ma02_resources.participants.Participant;
import ma02_resources.project.Project;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;
import ma02_resources.project.exceptions.TaskAlreadyInProject;

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
    private final int MAXIMUM_NUMBER_OF_TASKS;
    private final int MAXIMUM_NUMBER_OF_PARTICIPANTS;
    private final int MAXIMUM_NUMBER_OF_STUDENTS;
    private final int MAXIMUM_NUMBER_OF_PARTNERS;
    private final int MAXIMUM_NUMBER_OF_FACILITATORS;

    private String name;
    private String desciption;
    private int numberOfParticipants;
    private int numberOfPartners;
    private int numberOfFacilitators;
    private int numberOfTasks;
    private Participant[] participants;
    private boolean hasTags;
    private String[] tags;
    private Task[] tasks;
    private boolean isCompleted;

    // com array
    public BaseProject(int mAXIMUM_NUMBER_OF_TASKS, int mAXIMUM_NUMBER_OF_PARTICIPANTS, int mAXIMUM_NUMBER_OF_STUDENTS,
            int mAXIMUM_NUMBER_OF_PARTNERS, int mAXIMUM_NUMBER_OF_FACILITATORS, String name, String desciption,
            int numberOfParticipants, int numberOfPartners, int numberOfFacilitators, int numberOfTasks,
            boolean hasTags, String[] tags, Task[] tasks, boolean isCompleted) {
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
        this.numberOfTasks = numberOfTasks;
        this.tasks = tasks;
        this.isCompleted = isCompleted;

        this.hasTags = hasTags;
        if (this.hasTags) {
            this.tags = tags;
        }
    }

    // sem array
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
        this.numberOfTasks = 0;
        this.name = name;
        this.desciption = desciption;
    }

    
    // vai ser usado para o baseEdition
    public BaseProject(String name, String desciption, String[] tags) {
        this.name = name;
        this.desciption = desciption;
        this.tags = tags;

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
        return numberOfParticipants - numberOfPartners - numberOfFacilitators;
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

    @Override
    public void addParticipant(Participant p) throws IllegalNumberOfParticipantType, ParticipantAlreadyInProject {
        // Logic to add a participant to the project
        // Check if the maximum number of participants has been reached
        // Check if the participant is already in the project
        // Increment the counters based on the participant type (student, partner,
        // facilitator)
        // Add the participant to the project

        try {
            if(numberOfParticipants == MAXIMUM_NUMBER_OF_PARTICIPANTS) {
                throw new IllegalNumberOfParticipantType("This Project has reached the maximum number of participants!");
            }

            if(getParticipant(p.getName()) != null) {
                throw new ParticipantAlreadyInProject("That participant already exists in this project!");
            }

            this.participants[numberOfParticipants] = p;

            /*switch(p.getClass().toString()) {
                
            }*/
            numberOfParticipants++;

        } catch(ArrayIndexOutOfBoundsException aiofbe) {
            throw new ArrayIndexOutOfBoundsException(aiofbe + " in addParticipant method");
        } catch(NullPointerException npe) {
            throw new NullPointerException(npe + " in addParticipant method");
        }
    }

    @Override
    public Participant removeParticipant(String string) {
        // Logic to remove a participant from the project
        // Find the participant by their identifier (string)
        // Decrement the counters based on the participant type
        // Remove the participant from the project
        // Return the removed participant
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Participant getParticipant(String string) {
        for(Participant i: participants) {
            if(i.getName().equals(string)) {
                return i;
            }
        }

        return null;
    }

    @Override
    public String[] getTags() {
        return hasTags ? tags : null;
    }

    @Override
    public boolean hasTag(String string) {
        if (hasTags) {
            // Logic to check if the project has the specified tag
            // Iterate through the tags array and check for a match with the given string
            // Return true if a match is found
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
