package pp_ac_8220307_8220337.Api.interfaces;

import ma02_resources.project.Edition;
import ma02_resources.project.Project;

public interface IProjectList {
    public Project[] getUnfinishedProjects(Edition edition);

    public Project getProjectByTags(String TagString, Edition edition);

    // TODO Quando houver mais listagens de edições, criar uma interface só para as edições
    public String projectProgress(Project project);

    public String editionProgress(Edition edition);
}
