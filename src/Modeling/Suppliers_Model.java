/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modeling;
import Modeling.supp_prod_rel_Model;
import Modeling.Products_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author LEGION
 */
public class Suppliers_Model {
//    private String Company_name,city,region,postal_code,phone;
    private String Company_name;
    private String city;
    private String region;
    private String postal_code;
    private String phone;
    private String date;
    private int supplier_id;

    public Suppliers_Model( int supplier_id, String Company_name, String city, String region, String postal_code, String phone) {
        this.supplier_id = supplier_id;
        this.Company_name = Company_name;
        this.city = city;
        this.region = region;
        this.postal_code = postal_code;
        this.phone = phone;
        
    }
    public Suppliers_Model(String Company_name, String city, String region, String postal_code, String phone)
    {
        this.Company_name = Company_name;
        this.city = city;
        this.region = region;
        this.postal_code = postal_code;
        this.phone = phone;
    }
    public Suppliers_Model(String Company_name, String med_name)
    {
        Products_Model p=new Products_Model(med_name);
        this.Company_name = Company_name;
        p.med_name=med_name;
        
    }
    public Suppliers_Model(int Company_id,String Company_name)
    {
        this.supplier_id=Company_id;
        this.Company_name = Company_name;
    }
    public Suppliers_Model()
    {
        
    }

    public String getCompany_name() {
        return Company_name;
    }
    public String getMed_name()
    {
        Products_Model p=new Products_Model();
        return p.med_name;
    }


    public void setCompany_name(String Company_name) {
        this.Company_name = Company_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }
    public static supp_prod_rel_Model getDate()
      {
          supp_prod_rel_Model obj=null;
          String Query="select date from supplier_prod_rel where supplier_prod_rel.supp_id=supplier.supplier_id";
          ResultSet rs=DBOperation.getData(Query);
        try {
            while(rs.next())
            {
              obj=new supp_prod_rel_Model(rs.getString("date"));
            }       
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
         obj=null;
        }
         return obj;
         
      }
    
    
}
