package pp_ac_8220307_8220337.Api.interfaces;

import ma02_resources.project.Edition;

public interface IEditionList {
    public Edition[] getEditions();

    public Edition getEdition(String editionName);

    public Edition getActiveEdition();
}
