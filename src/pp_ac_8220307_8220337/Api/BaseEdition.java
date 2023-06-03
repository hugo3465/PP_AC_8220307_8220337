package pp_ac_8220307_8220337.Api;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ma02_resources.participants.Participant;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import pp_ac_8220307_8220337.Api.Exceptions.ProjectDoesntExistException;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class BaseEdition implements Edition {

    private final int DEFAULT_NUMBER_PROJECTS = 5;
    private String name;
    private String projectTemplate;
    private Status status;
    private Project[] projects;
    private int numberOfProjects;
    private LocalDate start;
    private LocalDate end;

    /**
     *
     * @param name
     * @param projectTemplate
     * @param status
     * @param projects
     * @param numberOfProjects
     * @param start
     * @param end
     */
    public BaseEdition(String name, String projectTemplate, Status status, Project[] projects, int numberOfProjects,
            LocalDate start, LocalDate end) {
        this.name = name;
        this.projectTemplate = projectTemplate;
        this.status = status;
        this.projects = new Project[numberOfProjects];
        this.numberOfProjects = numberOfProjects;
        this.start = start;
        this.end = end;
    }

    
    /**
     * 
     * @param name
     * @param projectTemplate
     * @param status
     * @param start
     * @param end
     */
    public BaseEdition(String name, String projectTemplate, Status status, LocalDate start, LocalDate end) {
        this.name = name;
        this.projectTemplate = projectTemplate;
        this.status = status;
        this.start = start;
        this.end = end;

        this.projects = new Project[DEFAULT_NUMBER_PROJECTS];
        this.numberOfProjects = 0;
    }



    /**
     * Retrieves the name of the Edition.
     * 
     * @return the name of the Edition
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the start date of the Edition.
     * 
     * @return the start date of the Edition
     */
    @Override
    public LocalDate getStart() {
        return this.start;
    }

    /**
     * Retrieves the project template of the Edition.
     * 
     * @return the project template of the Edition
     */
    @Override
    public String getProjectTemplate() {
        return this.projectTemplate;
    }

    /**
     * Retrieves the status of the Edition.
     * 
     * @return the status of the Edition
     */
    @Override
    public Status getStatus() {
        return this.status;
    }

    /**
     * Sets the status of the Edition.
     * 
     * @param status the status to set for the Edition
     */
    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Adds a project based on the information provided in a JSON file.
     * 
     * The JSON file should contain details such as the number of facilitators,
     * students, partners, and tasks for the project.
     * 
     * @param string  the name of the project
     * 
     * @param string1 the description of the project
     * 
     * @param strings an array of strings representing tags associated with the
     *                project
     * 
     * @throws IOException    if an I/O error occurs while reading the JSON file
     * 
     * @throws ParseException if there is an error while parsing the JSON file
     */
    @Override
    public void addProject(String string, String string1, String[] strings) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("./project_template.json")) {
            // Parse the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // Extract the number_of_facilitators, number_of_students, and
            // number_of_partners from the JSON object
            int numberOfFacilitators = ((Long) jsonObject.get("number_of_facilitors")).intValue();
            int numberOfStudents = ((Long) jsonObject.get("number_of_students")).intValue();
            int numberOfPartners = ((Long) jsonObject.get("number_of_partners")).intValue();
            int numberOfParticipants = numberOfFacilitators + numberOfStudents + numberOfPartners;

            // Extract the tasks array from the JSON object
            JSONArray tasksArray = (JSONArray) jsonObject.get("tasks");

            // Create an array to store the tasks
            Task[] tasks = new Task[tasksArray.size()];

            // Iterate over each task and create a Task object
            for (int i = 0; i < tasksArray.size(); i++) {
                JSONObject taskObject = (JSONObject) tasksArray.get(i);

                // Extract the attributes from the task object
                String title = (String) taskObject.get("title");
                String description = (String) taskObject.get("description");
                int startAt = ((Long) taskObject.get("start_at")).intValue();
                int duration = ((Long) taskObject.get("duration")).intValue();

                // Create a new Task object with the extracted attributes
                Task taskTemplate = new BaseTask(title, description, startAt, duration);

                // Add the task to the tasks array
                tasks[i] = taskTemplate;
            }

            // Set the number of tasks
            int numberOfTasks = tasksArray.size();

            this.projects[numberOfProjects] = new BaseProject(string, string1, numberOfParticipants, numberOfPartners,
                    numberOfFacilitators, numberOfStudents, numberOfTasks, strings, tasks);

            this.numberOfProjects++;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException | ArrayIndexOutOfBoundsException eAgain) {
            eAgain.printStackTrace();
        } catch (IllegalNumberOfParticipantType e) {
            e.printStackTrace();
        }

    }

    /**
     * Removes a project with the specified name from the projects array.
     * 
     * @param name the name of the project to be removed
     */
    @Override
    public void removeProject(String string) {
        try {
            if (this.numberOfProjects < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }

            // Search for the project index by name
            int index = searchByName(string);
            // Check if the project exists
            if (index < 0) {
                throw new ProjectDoesntExistException();
            }

            // Shift the remaining projects in the array
            for (int i = index; i < this.projects.length - 1; i++) {
                this.projects[i] = this.projects[i + 1];
            }

            // Update the number of projects and set the last element to null
            this.numberOfProjects--;
            this.projects[numberOfProjects] = null;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            aioobe.printStackTrace();
        } catch (ProjectDoesntExistException pdee) {
            pdee.printStackTrace();
        }
    }

    /**
     * Retrieves a project with the specified name from the projects array.
     * 
     * @param name the name of the project to retrieve
     * @return the Project object matching the specified name, or null if not found
     */
    @Override
    public Project getProject(String string) {
        for(int i = 0; i < numberOfProjects; i++) {
            if(getProjects()[i].getName().equals(string)) {
                return getProjects()[i];
            }
        }
        return null;
    }

    /**
     * Retrieves all projects stored in the Edition.
     * 
     * @return an array of Project objects representing all the projects in the
     *         Edition
     */
    @Override
    public Project[] getProjects() {
        return this.projects;
    }

    /**
     * Retrieves an array of projects associated with a specific tag.
     *
     * @param tag the tag to filter projects
     * @return an array of projects associated with the specified tag
     */
    @Override
    public Project[] getProjectsByTag(String string) {

        Project[] matchingProjects = new Project[this.numberOfProjects];
        int matchingCount = 0;

        for (Project project : this.projects) {
            if (verifyTag(string, project.getTags())) {
                matchingProjects[matchingCount] = project;
                matchingCount++;
            }
        }

        // Create a new array to hold only the matching projects
        Project[] onlyMatchingProjects = new Project[matchingCount];
        System.arraycopy(matchingProjects, 0, onlyMatchingProjects, 0, matchingCount);

        return onlyMatchingProjects;

    }

    /**
     * Verifies if a given tag is present in an array of tags.
     *
     * @param tag  the tag to search for
     * @param tags the array of tags to check
     * @return true if the tag is found, false otherwise
     */
    private boolean verifyTag(String tag, String[] tags) {
        for (String i : tags) {
            if (i == tag) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves an array of projects associated with a specific participant name.
     * 
     * @param string the name of the participant to filter projects
     * @return an array of projects associated with the specified participant name
     */
    @Override
    public Project[] getProjectsOf(String string) {
        // provavlemente é os projetos que um determinado participante está
        Project[] matchingProjects = new Project[numberOfProjects];
        int matchingCount = 0;

        for (Project project : this.projects) {
            if (project.getParticipant(string) != null) {
                matchingProjects[matchingCount] = project;
                matchingCount++;
            }
        }

        // Create a new array to hold only the matching projects
        Project[] onlyMatchingProjects = new Project[matchingCount];
        System.arraycopy(matchingProjects, 0, onlyMatchingProjects, 0, matchingCount);

        return onlyMatchingProjects;
    }

    /**
     * Retrieves the number of projects in the edition.
     *
     * @return the number of projects
     */
    @Override
    public int getNumberOfProjects() {
        return this.numberOfProjects;
    }

    /**
     * Retrieves the end date of the edition.
     *
     * @return the end date of the edition
     */
    @Override
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     * Resizes the projects array to accommodate more projects.
     * This method doubles the size of the projects array when it reaches its
     * maximum capacity.
     */
    private void resizeProjects() {
        Project[] newProjects = new Project[this.projects.length * 2];
        for (int i = 0; i < this.projects.length; i++) {
            newProjects[i] = this.projects[i];
        }
        this.projects = newProjects;
    }

    /**
     * Searches for a project in the projects array by name.
     *
     * @param name the name of the project to search for
     * @return the index of the project if found, -1 otherwise
     */
    private int searchByName(String string) {
        int i = 0;

        while (i < this.numberOfProjects && this.projects[i].getName().compareTo(string) != 0) {
            i++;
        }
        if (i > this.numberOfProjects) {
            return -1;
        }

        return i;

    }

}
