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

import java.time.LocalDate;

import ma02_resources.project.Project;
import ma02_resources.project.Task;

public interface ITasklist {
    public Task[] getTaksByDate(LocalDate date, Project project);
}
