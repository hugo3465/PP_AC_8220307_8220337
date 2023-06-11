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

import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Partner;
import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;

public interface IParticipantList {
    public Participant getParticipant(String name);

    public Student getStudent(String name);

    public Facilitator getFacilitator(String name);

    public Partner getPartner(String name);

    public String getSudentsWithMoreSubmissions(Edition edition, Project project);

}
