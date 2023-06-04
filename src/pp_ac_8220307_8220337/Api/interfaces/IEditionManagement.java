
package pp_ac_8220307_8220337.Api.interfaces;

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
public interface IEditionManagement {
    public void addEdition(Edition edition);
    public void removeEdition(String editionName);
    public Edition[] getEditions();
}
