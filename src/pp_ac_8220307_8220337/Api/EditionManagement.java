package pp_ac_8220307_8220337.Api;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Partner;
import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Submission;
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
public class EditionManagement implements IEditionManagement {

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
     * 
     * Retrieves an array of projects based on the specified tag string and edition.
     * 
     * @param tagString The tag string used to filter the projects.
     * 
     * @param edition   The edition object representing the edition of the projects.
     * 
     * @return An array of projects that have the specified tag and belong to the
     *         given edition.
     */
    @Override
    public Project[] getProjectByTags(String tagString, Edition edition) {
        Project[] matchProjects = new Project[edition.getNumberOfProjects()];
        int countMatchProjects = 0;

        for (Project project : edition.getProjects()) {
            String[] projectTags = project.getTags();
            for (String tag : projectTags) {
                if (tag.equalsIgnoreCase(tagString)) {
                    matchProjects[countMatchProjects] = project;
                    countMatchProjects++;
                    break; // Exit the inner loop since a match is found
                }
            }
        }

        Project[] onlyProjects = new Project[countMatchProjects];
        System.arraycopy(matchProjects, 0, onlyProjects, 0, countMatchProjects);

        return onlyProjects;
    }

    /**
     * Retrieves a string containing the names of students with more submissions,
     * sorted in ascending order based on the number of submissions.
     * 
     * @param edition The edition of the project.
     * @param project The project to retrieve the student submissions from.
     * @return A string containing the names of students with more submissions,
     *         separated by commas and sorted in ascending order.
     */
    @Override
    public String getSudentsWithMoreSubmissions(Edition edition, Project project) {
        String[] students = new String[project.getNumberOfStudents()];
        int[] studentSubmissions = new int[students.length];
        int studentsCount = 0;
        int indexOfStudent;

        for (Task task : project.getTasks()) {
            for (Submission submission : task.getSubmissions()) {
                indexOfStudent = confereRepetitioninStudentsSubmissions(students,
                        submission.getStudent().getName(), studentsCount);

                if (indexOfStudent != -1) {
                    // If the student is already in the array, increment their submission count
                    studentSubmissions[indexOfStudent]++;
                } else {
                    // Add the student to the array
                    students[studentsCount] = submission.getStudent().getName();
                    studentSubmissions[studentsCount]++;
                    studentsCount++;
                }
            }
        }

        // Sort students and studentSubmissions arrays based on submission count
        for (int i = 0; i < studentsCount - 1; i++) {
            for (int j = i + 1; j < studentsCount; j++) {
                if (studentSubmissions[i] > studentSubmissions[j]) {
                    // Swap students
                    String tempStudent = students[i];
                    students[i] = students[j];
                    students[j] = tempStudent;

                    // Swap submission counts
                    int tempSubmissions = studentSubmissions[i];
                    studentSubmissions[i] = studentSubmissions[j];
                    studentSubmissions[j] = tempSubmissions;
                }
            }
        }

        // Build the result string in ascending order
        String result = "";
        for (int i = 0; i < studentsCount; i++) {
            result += students[i] + "-->" + studentSubmissions[i] + '\n';
        }

        return result;
    }

    /**
     * Checks if the given student name already exists in the students array.
     * 
     * @param students      The array of students' names.
     * @param name          The name to check for repetition.
     * @param studentsCount The current count of students in the array.
     * @return The index of the repeated student, or -1 if not found.
     */
    private int confereRepetitioninStudentsSubmissions(String[] students, String name, int studentsCount) {
        for (int i = 0; i < studentsCount; i++) {
            if (students[i].equals(name)) {
                return i;
            }
        }
        return -1;
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
    public Edition getActiveEdition() {
        for (Edition edition : editions) {
            if (edition.getStatus() == Status.ACTIVE) {
                return edition;
            }
        }
        return null;
    }

    // Method to save editions to a binary file
    @Override
    public void saveEditionsToJsonFile(String filePath) throws IOException {
        JSONArray arr = new JSONArray();
        for (Edition f : this.editions) {
            if (f != null) {
                JSONObject obj = new JSONObject();
                obj.put("Name", f.getName());
                obj.put("Project Template", f.getProjectTemplate());
                obj.put("Status", f.getStatus());
                obj.put("number of Projects", f.getNumberOfProjects());
                obj.put("start", f.getStart());
                obj.put("end", f.getEnd());
                obj.put("Project", f.getProjects());

                arr.add(obj);
            }
        }
        FileWriter out = new FileWriter(filePath);
        // String ar = arr.toJSONString();
        out.write(arr.toJSONString());
        out.flush();
        out.close();
    }

    // Method to read editions from a binary file
    @Override
    public void readEditionsFromJsonFile(String filePath) throws IOException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader fileReader = new FileReader(filePath)) {
            JSONArray jsonArray = (JSONArray) parser.parse(fileReader);

            editions = new Edition[jsonArray.size()];
            numEditions = 0;

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                String name = (String) jsonObject.get("Name");
                String projectTemplate = (String) jsonObject.get("Project Template");
                Status status = (Status) jsonObject.get("Status");
                int numberOfProjects = ((Long) jsonObject.get("number of Projects")).intValue();
                LocalDate start = LocalDate.parse((String) jsonObject.get("start"));
                LocalDate end = LocalDate.parse((String) jsonObject.get("end"));

                // Projects
                JSONArray projectsArray = (JSONArray) jsonObject.get("Project");
                Project[] projects = new Project[projectsArray.size()];
                for (int j = 0; j < projectsArray.size(); j++) {
                    JSONObject projectObject = (JSONObject) projectsArray.get(j);
                    String projectName = (String) projectObject.get("Name");
                    String projectDescription = (String) projectObject.get("Description");
                    int numberOfParticipants = ((Long) projectObject.get("Number Of Participants")).intValue();
                    int numberOfPartners = ((Long) projectObject.get("Number Of Partners")).intValue();
                    int numberOfFacilitators = ((Long) projectObject.get("Number Of Facilitators")).intValue();
                    int numberOfStudents = ((Long) projectObject.get("Number Of Students")).intValue();
                    int numberOfTasks = ((Long) projectObject.get("Number Of Tasks")).intValue();

                    // read Participants inside Project
                    JSONArray participantsArray = (JSONArray) jsonObject.get("Participants");
                    Participant[] participants = new Participant[participantsArray.size()];
                    for (int k = 0; k < participantsArray.size(); k++) {
                        JSONObject participantObject = (JSONObject) participantsArray.get(k);
                        String participantName = (String) participantObject.get("Name");
                        String participantEmail = (String) participantObject.get("Email");
                        Contact participantContact = (Contact) participantObject.get("Contact");
                        Instituition participantInstitution = (Instituition) participantObject.get("Institution");

                        if (participantObject instanceof Partner) {
                            String partnerVat = (String) participantObject.get("Vat");
                            String partnerWebsite = (String) participantObject.get("Website");

                            participants[k] = new BasePartner(partnerVat, partnerWebsite, participantName,
                                    participantEmail, participantContact,
                                    participantInstitution);
                        } else if (participantObject instanceof Student) {
                            int studentNumber = ((Long) projectObject.get("Number")).intValue();

                            participants[k] = new BaseStudent(studentNumber, participantName, participantEmail,
                                    participantContact, participantInstitution);
                        } else if (participantObject instanceof Facilitator) {
                            String facilitatorAreaOfExpertise = (String) participantObject.get("Area of Expertise");

                            participants[k] = new BaseFacilitator(facilitatorAreaOfExpertise, participantName,
                                    participantEmail, participantContact, participantInstitution);
                        }

                    }

                    // read tags inside Project
                    JSONArray tagsArray = (JSONArray) jsonObject.get("Tags");
                    String[] tags = new String[tagsArray.size()];
                    for (int l = 0; l < tagsArray.size(); l++) {
                        tags[l] = (String) tagsArray.get(l);
                    }

                    // read Tasks inside Project
                    JSONArray tasksArray = (JSONArray) jsonObject.get("Tasks");
                    Task[] tasks = new Task[tasksArray.size()];
                    for (int m = 0; m < tasksArray.size(); m++) {
                        JSONObject taskObject = (JSONObject) tasksArray.get(m);
                        LocalDate taskStart = LocalDate.parse((String) taskObject.get("Start"));
                        LocalDate taskEnd = LocalDate.parse((String) taskObject.get("End"));
                        int taskDuration = ((Long) taskObject.get("Duration")).intValue();
                        String taskTitle = (String) taskObject.get("Title");
                        String taskDescription = (String) taskObject.get("Description");

                        // read Submissions inside Task
                        JSONArray submissionsArray = (JSONArray) taskObject.get("Submissions");
                        Submission[] submissions = new Submission[submissionsArray.size()];
                        for (int n = 0; n < submissionsArray.size(); n++) {
                            JSONObject submissionObject = (JSONObject) submissionsArray.get(n);
                            int studentNumber = ((Long) submissionObject.get("Number")).intValue();
                            String studentName = (String) submissionObject.get("Name");
                            String studentEmail = (String) submissionObject.get("Email");
                            Contact studentContact = ((Contact) submissionObject.get("Contact"));
                            Instituition studentInstitution = ((Instituition) submissionObject.get("Institution"));

                            Student student = new BaseStudent(studentNumber, studentName, studentEmail, studentContact,
                                    studentInstitution);
                            LocalDateTime submissionDate = LocalDateTime.parse((String) submissionObject.get("Date"));
                            String submissionText = (String) submissionObject.get("Text");

                            Submission submission = new BaseSubmission(student, submissionDate, submissionText);
                            submissions[n] = submission;
                        }

                        Task task = new BaseTask(taskStart, taskEnd, taskDuration, taskTitle, taskDescription,
                                submissions);
                        tasks[m] = task;
                    }

                    Project project = new BaseProject(projectName, projectDescription, numberOfParticipants,
                            numberOfPartners, numberOfFacilitators, numberOfStudents, numberOfTasks, participants, tags,
                            tasks);
                    projects[j] = project;
                }

                Edition edition = new BaseEdition(name, projectTemplate, status, projects, numberOfProjects, start,
                        end);
                editions[numEditions] = edition;
                numEditions++;
            }

        }
    }

}
