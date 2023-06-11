/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */

package pp_ac_8220307_8220337.Api.interfaces;

import java.io.IOException;

public interface IEditionManagement extends ICrudEdition, IEditionList, IParticipantList, IProjectList, ITasklist {

    public int getNumberOfCBLEditions();

    public void saveEditionsToJsonFile(String filename) throws IOException;

    public void readEditionsFromJsonFile(String filename) throws IOException, org.json.simple.parser.ParseException;

}
