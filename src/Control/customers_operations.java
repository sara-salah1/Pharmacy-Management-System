/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Modeling.DBOperation;
import java.sql.ResultSet;
import Modeling.Customers_Model;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class customers_operations {
    
     public  static void insert_CustomerData( String firstname,String lastname,String city, String street, String gender, String phoneNumber_1 )
   {
       String query="insert into customer (customer_firstname,customer_lastname,city,street,gender,phoneNumber_1) values ('"+firstname+"' , '"+lastname+"' , '"+city+"' , '"+street+"' , '"+gender+"', '"+phoneNumber_1+"')";
       DBOperation.setDataOrDelete(query, "New customer has been Inserted Successfully");
   }
               //get data
      public  static ArrayList<Customers_Model> get_customersData()
    {
          String query="select * from customer";
          ResultSet rs=DBOperation.getData(query);
          ArrayList<Customers_Model> arr= new ArrayList();

        try {
            while(rs.next())
            {
                arr.add(new Customers_Model(rs.getInt("customer_id"),rs.getString("customer_firstname"),rs.getString("customer_lastname"),rs.getString("city"),rs.getString("street"),rs.getString("gender"),rs.getString("phoneNumber_1")));
            }
            return arr;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                rs.close();
            } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
       return null;
        
    }
       public static Customers_Model Search_customer(int customer_id)
    {   
        Customers_Model obj=null;
        String Query="select *from customer where customer_id='"+customer_id+"'";
        ResultSet rs=DBOperation.getData(Query);
        try {
            while(rs.next())
            {
              obj= new Customers_Model(rs.getInt("customer_id"),rs.getString("customer_firstname"),rs.getString("customer_lastname"),rs.getString("city"),rs.getString("street"),rs.getString("gender"),rs.getString("phoneNumber_1"));  
            }       
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
         obj=null;
        }
         return obj;    
    }
     
    public static Customers_Model Return_Customer_ID( String firstname,String lastname, String phoneNumber_1)
    {   
        Customers_Model obj=null;
        String Query="select *from customer where customer_firstname='"+firstname+"' and customer_lastname='"+lastname+"' and phoneNumber_1='"+phoneNumber_1+"' ";
        ResultSet rs=DBOperation.getData(Query);
        try {
            while(rs.next())
            {
              obj= new Customers_Model(rs.getInt("customer_id"),rs.getString("customer_firstname"),rs.getString("customer_lastname"),rs.getString("city"),rs.getString("street"),rs.getString("gender"),rs.getString("phoneNumber_1"));  
            }       
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
         obj=null;
        }
         return obj;    
    }
              
       public static void Delete_customer(int customer_id)
    {
        String Query="delete from customer where customer_id='"+customer_id+"'";
       DBOperation.setDataOrDelete(Query, "");
    }
     
     
     
    
}
