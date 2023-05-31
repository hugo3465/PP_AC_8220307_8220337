package pp_ac_8220307_8220337.Api;


import ma02_resources.participants.Contact;

/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */
public class BaseContact implements Contact{
    /**
     * <ul>
     *      <li>The BaseContact class represents a basic contact information template.</li>
     * 
     *      <li>It contains fields for street, city, state, zip code, country, and phone number.</li>
     * 
     *      <li>This class provides methods to access and modify these contact details.</li>
     * </ul>
     */

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
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
     * Set the {@code street} of the Contact
     * 
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
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
     * set the {@code city} of the Contact
     * 
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
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
     * set the {@code state} of the Contact
     * 
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
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
     * set the {@code zipCode} of the Contact
     * 
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
     * set the {@code country} of the Contact
     * 
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
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

    /**
     * set the {@code phone} of the Contact
     * 
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
