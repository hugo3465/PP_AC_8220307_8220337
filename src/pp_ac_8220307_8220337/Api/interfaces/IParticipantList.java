package pp_ac_8220307_8220337.Api.interfaces;

import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Partner;
import ma02_resources.participants.Student;

public interface IParticipantList {
    public Participant[] getAllStudents();
    public Participant[] getAllFacilitators();
    public Participant[] getAllPartners();

    public Participant getStudent(String name);
    public Participant getFacilitator(String name);
    public Participant getPartner(String name);
}
