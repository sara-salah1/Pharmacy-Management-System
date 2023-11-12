package Control;

import Modeling.DBOperation;
import Modeling.Products_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 * @author lenovo
 */
public class Products_Operations {
    
   

    
    public  static void insert_ProductData(String med_name,int price,String expired_date,int quantity,String category,String description )
   {    
       String query="insert into products (med_name,price,expired_date,quantity,category,description) values ('"+med_name+"' , '"+price+"' , '"+expired_date +"' , '"+quantity+"' , '"+category+"', '"+description+"')";
       DBOperation.setDataOrDelete(query, "New Product has been Inserted Successfully");
   }
   
    public  static ArrayList<Products_Model> get_ProductsData()
    {
          String query="select * from products";
          ResultSet Pr=DBOperation.getData(query);
          ArrayList<Products_Model> arr= new ArrayList();

        try {
            while(Pr.next())
            {
                arr.add(new Products_Model(Pr.getString("med_name"),Pr.getInt("price"),Pr.getString("expired_date"),Pr.getInt("quantity"),Pr.getString("category"),Pr.getString("description")));
            }
            return arr;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                Pr.close();
            } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
       return null;
        
    }

    public static Products_Model Search_Product(String med_name)
    {   
        Products_Model obj=null;
        String Query="select * from products where med_name='"+med_name+"' ";
        ResultSet Pr=DBOperation.getData(Query);
        try {
            while(Pr.next())
            {
             obj= new Products_Model(Pr.getString("med_name"),Pr.getInt("price"),Pr.getString("expired_date"),Pr.getInt("quantity"),Pr.getString("category"),Pr.getString("description"));     
            }       
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
         obj=null;
        }
         return obj;    
    }
    
    public static void Delete_Product(String med_name)
    {
        String Query="delete from products where med_name='"+med_name+"'";
        DBOperation.setDataOrDelete(Query, " Product has been Deleted Successfully ");
    }
    
    public static void Edit_Product(String med_name,int new_price,String new_expired_date,int quantity)
    {        
        String query="UPDATE products set price='"+new_price+"',quantity='"+quantity+"', expired_date='"+new_expired_date+"' where med_name='"+med_name+"'";
        DBOperation.setDataOrDelete(query, "");
    }
}
   
