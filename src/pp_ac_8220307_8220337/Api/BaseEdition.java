package pp_ac_8220307_8220337.Api;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;

/**
 * Nome: Pedro Marcelo Santos Pinho Número: 8220307 Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães Número: 8220337 Turma: LEIT2
 */
public class BaseEdition implements Edition {

    private static int MAX_PROJECTS = 5;
    private String name;
    private String projectTemplate;
    private Status status;
    private Project[] projects;
    private int numberofProjects;
    private LocalDate start;
    private LocalDate end;

    /**
     *
     * @param name
     * @param projectTemplate
     * @param status
     * @param projects
     * @param numberofProjects
     * @param start
     * @param end
     */
    public BaseEdition(String name, String projectTemplate, Status status, Project[] projects, int numberofProjects, LocalDate start, LocalDate end) {
        this.name = name;
        this.projectTemplate = projectTemplate;
        this.status = status;
        this.projects = new Project[MAX_PROJECTS];
        this.numberofProjects = numberofProjects;
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
     * @param string
     * @param string1
     * @param strings
     * @throws IOException
     * @throws ParseException 
     */
    @Override
    public void addProject(String string, String string1, String[] strings) throws IOException, ParseException {
        try {
            
        } catch (Exception e) {
        }
        if (this.numberofProjects >= this.projects.length) {
            resizeProjects();
        }

        this.projects[this.numberofProjects] = null;
        this.numberofProjects++;

    }

    /**
     * 
     * @param string 
     */
    @Override
    public void removeProject(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param string
     * @return 
     */
    @Override
    public Project getProject(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public Project[] getProjects() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param string
     * @return 
     */
    @Override
    public Project[] getProjectsByTag(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param string
     * @return 
     */
    @Override
    public Project[] getProjectsOf(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public int getNumberOfProjects() {
        return this.numberofProjects;
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

}
