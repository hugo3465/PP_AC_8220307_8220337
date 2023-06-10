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

public class BasePartner implements Partner {

    /**
     *
     * The BasePartners class represents a basic implementation of the Partner
     * interface.
     *
     * It contains fields for vat, website, name, email, contact, institution.
     *
     * This class provides methods to access these Partner details, but only
     * has method to modify Contact and Institution details.
     */

    /**
     * The VAT (Value Added Tax) number of the partner.
     */
    private String vat;

    /**
     * The website URL of the partner.
     */
    private String website;

    /**
     * The name of the partner.
     */
    private String name;

    /**
     * The email address of the partner.
     */
    private String email;

    /**
     * The contact details of the partner.
     */
    private Contact contact;

    /**
     * The institution to which the partner belongs.
     */
    private Instituition instituition;

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
    public BasePartner(String vat, String website, String name, String email, Contact contact,
            Instituition instituition) {
        this.vat = vat;
        this.website = website;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.instituition = instituition;
    }

    /**
     * Retrieves the vat number of the Partner.
     *
     * @return vatNumber of thePartner
     */
    @Override
    public String getVat() {
        return this.vat;
    }

    /**
     * Retrieves the website of the Partner.
     *
     * @return the website of the Partner
     */
    @Override
    public String getWebsite() {
        return this.website;
    }

    /**
     * Retrieves the name of the Partner.
     *
     * @return the name of the Partner
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the email of the Partner.
     *
     * @return the email of the Partner
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Retrieves the contact of the Partner.
     *
     * @return the contact of the Partner
     */
    @Override
    public Contact getContact() {
        return this.contact;
    }

    /**
     * Retrieves the institution of the Partner.
     *
     * @return the institution of the Partner
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BasePartner other = (BasePartner) obj;
        if (vat == null) {
            if (other.vat != null)
                return false;
        } else if (!vat.equals(other.vat))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\tVAT: " + vat + "\n"
                + "\tWebsite: " + website + "\n"
                + "\tName: " + name + "\n"
                + "\tEmail: " + email + "\n"
                + "\tContact: " + contact + "\n"
                + "\tInstitution: " + instituition + "\n";
    }
}
