/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */

package pp_ac_8220307_8220337.Api;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Instituition;

/**
 *
 * The BaseFacilitators class represents a basic implementation of the
 * Facilitator interface.
 *
 * It contains fields for areaOfExpertise, name, email, contact,
 * institution.
 *
 * This class provides methods to access and modify these Facilitator
 * details.
 */
public class BaseFacilitator implements Facilitator {

    /**
     * The name of the facilitator.
     */
    private String name;

    /**
     * The email of the facilitator.
     */
    private String email;

    /**
     * The contact information of the facilitator.
     */
    private Contact contact;

    /**
     * The instituition of the facilitator.
     */
    private Instituition instituition;

    /**
     * The area of expertise of the facilitator.
     */
    private String areaOfExpertise;

    /**
     * Constructs a BaseFacilitators object with the specified Facilitator
     * details.
     *
     * @param areaOfExpertise
     * @param name
     * @param email
     * @param contact
     * @param instituition
     */
    public BaseFacilitator(String areaOfExpertise, String name, String email, Contact contact,
            Instituition instituition) {
        this.areaOfExpertise = areaOfExpertise;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.instituition = instituition;
    }

    /**
     * Returns the {@code areaOfExpertise}
     *
     * @return the "areaOfExpertise"
     */
    @Override
    public String getAreaOfExpertise() {
        return this.areaOfExpertise;
    }

    /**
     * Sets the areaOfExpertise to the provided "string"
     *
     * @param string
     */
    @Override
    public void setAreaOfExpertise(String string) {
        this.areaOfExpertise = string;
    }

    /**
     * Returns the {@code name}
     *
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the {@code email}
     *
     * @return
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the {@code contact}
     *
     * @return
     */
    @Override
    public Contact getContact() {
        return this.contact;
    }

    /**
     * Returns the {@code institution}
     *
     * @return
     */
    @Override
    public Instituition getInstituition() {
        return this.instituition;
    }

    /**
     * Sets the instituition to the provided {@code instn}
     *
     * @param instn
     */
    @Override
    public void setInstituition(Instituition instn) {
        this.instituition = instn;
    }

    /**
     * Sets the contact to the provided {@code cntct}
     *
     * @param cntct
     */
    @Override
    public void setContact(Contact cntct) {
        this.contact = cntct;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseFacilitator other = (BaseFacilitator) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\tName: " + name + "\n"
                + "\tEmail: " + email + "\n"
                + "\tContact: " + contact + "\n"
                + "\tInstitution: " + instituition + "\n"
                + "\tArea of Expertise: " + areaOfExpertise + "\n";
    }

}
