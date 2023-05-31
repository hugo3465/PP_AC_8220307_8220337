package pp_ac_8220307_8220337.Api;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Partner;


/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */

public class BasePartners implements Partner {

    /**
     *
     * The BasePartners class represents a basic implementation of the Partner
     * interface.
     *
     * It contains fields for vat, website, name, email, contact, institution.
     *
     * This class provides methods to access and modify these Partner details.
     */
    private String vat;
    private String website;
    private String name;
    private String email;
    private Contact contact;
    private Instituition instituition;

    /**
     * Constructs a BasePartners that initializes all the instance variables to
     * null.
     */
    public BasePartners() {
        this.vat = null;
        this.website = null;
        this.name = null;
        this.email = null;
        this.contact = null;
        this.instituition = null;
    }

    /**
     * Constructs a BaseFacilitators object with the specified Partner details.
     *
     * @param vat
     * @param website
     * @param name
     * @param email
     * @param contact
     * @param instituition
     */
    public BasePartners(String vat, String website, String name, String email, Contact contact, Instituition instituition) {
        this.vat = vat;
        this.website = website;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.instituition = instituition;
    }

    /**
     * Returns the "vat"
     *
     * @return
     */
    @Override
    public String getVat() {
        return this.vat;
    }

    /**
     * Returns the "website"
     *
     * @return
     */
    @Override
    public String getWebsite() {
        return this.website;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Sets the contact to the provided "cntct"
     *
     * @param cntct
     */
    @Override
    public void setContact(Contact cntct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
