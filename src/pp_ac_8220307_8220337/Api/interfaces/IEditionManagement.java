
package pp_ac_8220307_8220337.Api.interfaces;

import java.io.IOException;

import ma02_resources.project.Edition;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public interface IEditionManagement extends IParticipantList, IProjectList {
    public void addEdition(Edition edition);
    public void removeEdition(String editionName);

    public Edition[] getEditions();
    public Edition getEdition(String editionName);
    public int getNumberOfCBLEditions();

    public void defineAsActive(String editionName);
    public void defineAsInactive(String editionName);
    public void defineAsCanceled(String editionName);
    public void defineAsClosed(String editionName);


    public void saveEditionsToJsonFile(String filename) throws IOException;
    public void readEditionsFromJsonFile(String filename) throws IOException, org.json.simple.parser.ParseException;

}
