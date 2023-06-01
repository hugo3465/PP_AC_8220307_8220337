package pp_ac_8220307_8220337.Api;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;

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
     * @param string  --> nome
     * @param string1 --> Descrição
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

        } catch (Exception e) {
        }

    }

    /**
     * 
     * @param string
     */
    @Override
    public void removeProject(String string) {
        if (this.numberOfProjects < 0) {
            return;
        }

        int index = searchByName(string);
        if (index < 0) {
            return;
        }

        for (int i = index; i < this.projects.length - 1; i++) {
            this.projects[i] = this.projects[i + 1];
        }

        this.numberOfProjects--;
        this.projects[this.numberOfProjects] = null;
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
     * 
     * @param string
     * @return
     */
    @Override
    public Project[] getProjectsByTag(String string) {

        Project[] returnArray = new Project[this.numberOfProjects];
        int i = 0;
        for (Project i1 : this.projects) {
            if (i1.getTags().contains(string)) {
                returnArray[i] = i1;
                i++;
            }
        }
        return returnArray;

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
     * 
     * @return
     */
    @Override
    public int getNumberOfProjects() {
        return this.numberOfProjects;
    }

    /**
     * 
     * @return
     */
    @Override
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     * 
     */
    private void resizeProjects() {
        Project[] newProjects = new Project[this.projects.length * 2];
        for (int i = 0; i < this.projects.length; i++) {
            newProjects[i] = this.projects[i];
        }
        this.projects = newProjects;
    }

    /**
     * 
     * @param string
     * @return
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
