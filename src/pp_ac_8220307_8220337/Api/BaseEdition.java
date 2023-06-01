package pp_ac_8220307_8220337.Api;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
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

    private final int MAX_PROJECTS = 5;
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
        this.projects = new Project[MAX_PROJECTS];
        this.numberOfProjects = numberOfProjects;
        this.start = start;
        this.end = end;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return
     */
    @Override
    public LocalDate getStart() {
        return this.start;
    }

    /**
     * 
     * @return
     */
    @Override
    public String getProjectTemplate() {
        return this.projectTemplate;
    }

    /**
     * 
     * @return
     */
    @Override
    public Status getStatus() {
        return this.status;
    }

    /**
     * 
     * @param status
     */
    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * 
     * @param string  --> name
     * @param string1 --> description
     * @param strings --> tasks
     * @throws IOException
     * @throws ParseException
     */
    @Override
    public void addProject(String string, String string1, String[] strings) throws IOException, ParseException {
        try {
            if (this.numberOfProjects >= this.projects.length) {
                resizeProjects();
            }
            this.projects[this.numberOfProjects] = null;
            this.numberOfProjects++;

        } catch (NullPointerException npe) {
            throw new NullPointerException(npe + " in addProject");
        }

    }

    /**
     * 
     * @param string
     */
    @Override
    public void removeProject(String string) {
        try {
            if (this.numberOfProjects < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
    
            int index = searchByName(string);
            if (index < 0) {
                throw new ProjectDoesntExistException();
            }
    
            for (int i = index; i < this.projects.length - 1; i++) {
                this.projects[i] = this.projects[i + 1];
            }
    
            this.numberOfProjects--;
            this.projects[numberOfProjects] = null;
        } catch(ArrayIndexOutOfBoundsException aioobe) {
            aioobe.printStackTrace();
        } catch (ProjectDoesntExistException pdee) {
            pdee.printStackTrace();
        } 
    }

    /**
     * 
     * @param string
     * @return
     */
    @Override
    public Project getProject(String string) {
        for (Project i : projects) {
            if (i.getName().equals(string)) {
                return i;
            }
        }
        return null;
    }

    /**
     * 
     * @return
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
     * 
     * @param string
     * @return
     */
    @Override
    public Project[] getProjectsOf(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
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
     * Searches for a project in the projects array by its name.
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
