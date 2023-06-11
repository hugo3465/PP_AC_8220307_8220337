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
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Student;

/**
 *
 * The BaseStudent class represents a basic implementation of the Student
 * interface.
 *
 * It contains fields for vatNumber, name, email, contact, institution.
 *
 * This class provides methods to access these Student details, but only has
 * methods to modify Institution and Contact details.
 */

public class BaseStudent implements Student {

    /**
     * The student number.
     */
    private int number;

    /**
     * The name of the student.
     */
    private String name;

    /**
     * The email of the student.
     */
    private String email;

    /**
     * The contact information of the student.
     */
    private Contact contact;

    /**
     * The institution of the student.
     */
    private Instituition instituition;

    /**
     * Constructs a BaseStudent object with the specified Student details.
     *
     * @param vatNumber
     * @param name
     * @param email
     * @param contact
     * @param instituition
     */
    public BaseStudent(int number, String name, String email, Contact contact, Instituition instituition) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.instituition = instituition;
    }

    /**
     * Access method to the number of the student
     * 
     * @return {@code number}
     */
    @Override
    public int getNumber() {
        return this.number;
    }

    /**
     * Access method to the name of the student
     * 
     * @return {@code name}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Access method to the email of the student
     * 
     * @return {@coode email}
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Access method to the contact of the student
     * 
     * @return {@code contact}
     */
    @Override
    public Contact getContact() {
        return this.contact;
    }

    /**
     * Access method to the institution of the student
     * 
     * @return {@code instituition}
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
        BaseStudent other = (BaseStudent) obj;
        if (number != other.number)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\tnumber:" + number + "\n"
                + "\tname:" + name + "\n"
                + "\temail:" + email + "\n"
                + "\tcontact:" + contact + "\n"
                + "\tinstituition=" + instituition + "\n";
    }

}
