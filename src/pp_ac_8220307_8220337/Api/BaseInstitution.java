package pp_ac_8220307_8220337.Api;

import cbl.participants.Contact;
import cbl.participants.Instituition;
import cbl.participants.InstituitionType;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class BaseInstitution implements Instituition {
    /**
     * 
     * The BaseInstitution class represents a basic implementation of the
     * Instituition interface.
     * 
     * It contains fields for name, email, institution type, contact information,
     * website, and description.
     * 
     * This class provides methods to access and modify these institution details.
     */
    private String name;
    private String email;
    private InstituitionType type;
    private Contact contact;
    private String website;
    private String description;

    /**
     * Constructs a BaseInstitution object with the specified institution details.
     * 
     * @param name
     * @param email
     * @param type
     * @param contact
     * @param website
     * @param description
     */
    public BaseInstitution(String name, String email, InstituitionType type, Contact contact, String website,
            String description) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.contact = contact;
        this.website = website;
        this.description = description;
    }

    /**
     * 
     * Returns the name of the institution.
     * 
     * @return the name of the institution
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 
     * Sets the name of the institution.
     * 
     * @param name the name of the institution to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * Returns the email address of the institution.
     * 
     * @return the email address of the institution
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * 
     * Sets the email address of the institution.
     * 
     * @param email the email address of the institution to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * Returns the type of the institution.
     * 
     * @return the type of the institution
     */
    @Override
    public InstituitionType getType() {
        return type;
    }

    /**
     * 
     * Sets the type of the institution.
     * 
     * @param type the type of the institution to set
     */
    public void setType(InstituitionType type) {
        this.type = type;
    }

    /**
     * 
     * Returns the contact information of the institution.
     * 
     * @return the contact information of the institution
     */
    @Override
    public Contact getContact() {
        return contact;
    }

    /**
     * 
     * Sets the contact information of the institution.
     * 
     * @param contact the contact information of the institution to set
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * 
     * Returns the website URL of the institution.
     * 
     * @return the website URL of the institution
     */
    @Override
    public String getWebsite() {
        return website;
    }

    /**
     * 
     * Sets the website URL of the institution.
     * 
     * @param website the website URL of the institution to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Returns the description of the institution.
     *
     * @return the description of the institution
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the institution.
     *
     * @param description the description of the institution to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
