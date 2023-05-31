package pp_ac_8220307_8220337.Api;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Student;



/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class BaseStudent implements Student {

    /**
     *
     * The BaseStudent class represents a basic implementation of the Student
     * interface.
     *
     * It contains fields for vatNumber, name, email, contact, institution.
     *
     * This class provides methods to access and modify these Student details.
     */
    private int vatNumber;
    private String name;
    private String email;
    private Contact contact;
    private Instituition instituition;

    /**
     * Constructs a BaseStudent that initializes all the instance variables to
     * null or 0.
     */
    public BaseStudent() {
        this.vatNumber = 0;
        this.name = null;
        this.email = null;
        this.contact = null;
        this.instituition = null;
    }

    /**
     * Constructs a BaseStudent object with the specified Student details.
     *
     * @param vatNumber
     * @param name
     * @param email
     * @param contact
     * @param instituition
     */
    public BaseStudent(int vatNumber, String name, String email, Contact contact, Instituition instituition) {
        this.vatNumber = vatNumber;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.instituition = instituition;
    }

    /**
     * Returns the "vatNumber"
     * @return
     */
    @Override
    public int getNumber() {
        return this.vatNumber;
    }

    /**
     * Returns the "name"
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the "email"
     * @return
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the "contact"
     * @return
     */
    @Override
    public Contact getContact() {
        return this.contact;
    }

    /**
     * Returns the "instituition"
     * @return
     */
    @Override
    public Instituition getInstituition() {
        return this.instituition;
    }

    /**
     * Sets the instituition to the provided "instn"
     * @param instn
     */
    @Override
    public void setInstituition(Instituition instn) {
        this.instituition = instn;
    }

    /**
     * Sets the contact to the provided "cntct"
     * @param cntct
     */
    @Override
    public void setContact(Contact cntct) {
        this.contact = cntct;
    }

}
