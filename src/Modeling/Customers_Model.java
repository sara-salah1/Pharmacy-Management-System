package Modeling;

/**
 *
 * @author lenovo
 */
public class Customers_Model {
    
    private String firstname,lastname,city,street,gender,phoneNumber_1;
    private int customer_id; 
   public Customers_Model()
{






}
    public Customers_Model(int customer_id,String firstname, String lastname, String city, String street, String gender, String phoneNumber_1) 
    {

        this.customer_id = customer_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.street = street;
        this.gender = gender;
        this.phoneNumber_1 = phoneNumber_1;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber_1(String phoneNumber_1) {
        this.phoneNumber_1 = phoneNumber_1;
    }

   

    
public int getCustomer_id() {
        return customer_id;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber_1() {
        return phoneNumber_1;
    }


    
    
    
    
}
