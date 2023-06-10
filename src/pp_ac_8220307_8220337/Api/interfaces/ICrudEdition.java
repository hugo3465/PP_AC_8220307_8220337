package pp_ac_8220307_8220337.Api.interfaces;

import ma02_resources.project.Edition;

public interface ICrudEdition {
    public void addEdition(Edition edition);

    public void removeEdition(String editionName);

    public void defineAsActive(String editionName);

    public void defineAsInactive(String editionName);

    public void defineAsCanceled(String editionName);

    public void defineAsClosed(String editionName);
}
