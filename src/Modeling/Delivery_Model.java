package Modeling;

/**
 *
 * @author Seifeldin Ahmed
 */
public class Delivery_Model {
   private String name , phonenumber; 
   private int id;

    public Delivery_Model(String name, String phonenumber, int id) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
