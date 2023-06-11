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

/**
 * <ul>
 * <li>The BaseContact class that represents a basic contact information
 * template.</li>
 * 
 * <li>It contains fields for street, city, state, zip code, country, and phone
 * number.</li>
 * 
 * <li>This class provides methods to access and modify these contact
 * details.</li>
 * </ul>
 */
public class BaseContact implements Contact {

    /**
     * The street address of the contact.
     */
    private String street;

    /**
     * The city of the contact.
     */
    private String city;

    /**
     * The state or province of the contact.
     */
    private String state;

    /**
     * The ZIP code or postal code of the contact.
     */
    private String zipCode;

    /**
     * The country of the contact.
     */
    private String country;

    /**
     * The phone number of the contact.
     */
    private String phone;

    /**
     * Constructs a 'BaseContact' object with the specified contact details.
     * 
     * @param street
     * @param city
     * @param state
     * @param zipCode
     * @param country
     * @param phone
     */
    public BaseContact(String street, String city, String state, String zipCode, String country, String phone) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.phone = phone;
    }

    /**
     * returns the {@code street} of the Contact
     * 
     * @return String return the street
     */
    @Override
    public String getStreet() {
        return street;
    }

    /**
     * returns the {@code city} of the Contact
     * 
     * @return String return the city
     */
    @Override
    public String getCity() {
        return city;
    }

    /**
     * returns the {@code state} of the Contact
     * 
     * @return String return the state
     */
    @Override
    public String getState() {
        return state;
    }

    /**
     * returns the {@code zipCode} of the Contact
     * 
     * @return String return the zipCode
     */
    @Override
    public String getZipCode() {
        return zipCode;
    }

    /**
     * return the {@code country} of the Contact
     * 
     * @return String return the country
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * return the {@code phone} of the Contact
     * 
     * @return String return the phone
     */
    @Override
    public String getPhone() {
        return phone;
    }

}
