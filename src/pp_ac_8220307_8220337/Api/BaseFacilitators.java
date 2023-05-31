package pp_ac_8220307_8220337.Api;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Instituition;


/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */

public class BaseFacilitators implements Facilitator {

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
    private String areaOfExpertise;
    private String name;
    private String email;
    private Contact contact;
    private Instituition instituition;

    /**
     * Constructs a BaseFacilitators that initializes all the instance variables
     * to null.
     */
    public BaseFacilitators() {
        this.areaOfExpertise = null;
        this.name = null;
        this.email = null;
        this.contact = null;
        this.instituition = null;
    }

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
    public BaseFacilitators(String areaOfExpertise, String name, String email, Contact contact, Instituition instituition) {
        this.areaOfExpertise = areaOfExpertise;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.instituition = instituition;
    }

    /**
     * Returns the "areaOfExpertise"
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
     * Returns the "name"
     *
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the "email"
     *
     * @return
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the "contact"
     *
     * @return
     */
    @Override
    public Contact getContact() {
        return this.contact;
    }

    /**
     * Returns the "instituition"
     *
     * @return
     */
    @Override
    public Instituition getInstituition() {
        return this.instituition;
    }

    /**
     * Sets the instituition to the provided "instn"
     *
     * @param instn
     */
    @Override
    public void setInstituition(Instituition instn) {
        this.instituition = instn;
    }

    /**
     * Sets the contact to the provided "cntct"
     *
     * @param cntct
     */
    @Override
    public void setContact(Contact cntct) {
        this.contact = cntct;
    }
}
