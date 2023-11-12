package Control;

import Modeling.Customers_Model;
import Modeling.DBOperation;
import Modeling.Delivery_Model;
import Modeling.Orders_Model;
import Modeling.Pharmacist_Model;
import Modeling.Products_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Orders_Operations {
        
      public    ArrayList<Pharmacist_Model>  Pharmacist_arr= new ArrayList();
      public    ArrayList<Customers_Model>   Customers_arr= new ArrayList();
      public    ArrayList<Products_Model>    Products_arr= new ArrayList();
      public    ArrayList<Orders_Model>      order_arr= new ArrayList();
      public    ArrayList<Delivery_Model>    Delivery_arr= new ArrayList();
      

   public  static void insert_OrderData(int price, String date,String Payment_Type,int delivery_ID)
   {    
       String query="insert into orders (order_price,date,Payment_Type,delivery_ID) values ('"+price+"' , '"+date+"' , '"+Payment_Type+"', '"+delivery_ID+"')";
       DBOperation.setDataOrDelete(query, "");       
   }
      
   public  static void insert_Order_Relation(int Pharmacist_ID , int Customer_ID,String ProductName, int Order_Number)
   {    
      String Query="insert into order_relation (Ph_ID,C_ID,ProductName,order_ID) values ('"+Pharmacist_ID+"' , '"+Customer_ID+"' , '"+ProductName+"', '"+Order_Number+"')";
      DBOperation.setDataOrDelete(Query, "New order has been Inserted Successfully");      
   }
   
      
    public  boolean get_OrderData()
    {
String query = "SELECT * " +
               "FROM pharmacist, customer, products, orders, order_relation, delivery " +
               "WHERE (order_relation.Ph_ID = pharmacist.id) " +
               "AND (order_relation.ProductName = products.med_name) " +
               "AND (order_relation.order_ID = orders.order_number) " +
               "AND (order_relation.C_ID = customer.customer_id) " +
               "AND (orders.delivery_ID=delivery.delivery_ID )" +
               "GROUP BY order_relation.order_ID";
ResultSet Pr=DBOperation.getData(query);

        try {
            while(Pr.next())
            {
                Pharmacist_arr.add(new Pharmacist_Model(Pr.getInt("id"),Pr.getString("hired_date"),Pr.getString("firstname"),Pr.getString("lastname"),Pr.getString("pharmacist_gender"),Pr.getString("phonenumber"),Pr.getString("email"),Pr.getString("password"),Pr.getInt("salary"),Pr.getInt("age")));
                Customers_arr.add(new Customers_Model(Pr.getInt("customer_id"),Pr.getString("customer_firstname"),Pr.getString("customer_lastname"),Pr.getString("city"),Pr.getString("street"),Pr.getString("gender"),Pr.getString("phoneNumber_1")));
                Products_arr.add(new Products_Model(Pr.getString("med_name"),Pr.getInt("price"),Pr.getString("expired_date"),Pr.getInt("quantity"),Pr.getString("category"),Pr.getString("description")));
                order_arr.add(new Orders_Model(Pr.getInt("order_number"),Pr.getInt("order_price"),Pr.getString("date"),Pr.getString("Payment_Type")));                                
                Delivery_arr.add(new Delivery_Model(Pr.getString("name"), Pr.getString("delivery_phoneNumber") , Pr.getInt("delivery_ID")));
            }
            
            return true;
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
       return false;
        
    }

    public static int Return_Order_Number(int price , String date, String Payment_Type)
    {
        int Order_ID=0;
        String Query="select * from orders where order_price='"+price+"'and date='"+date+"' and Payment_Type='"+Payment_Type+"' ";
        ResultSet Pr=DBOperation.getData(Query);
        try {
            while(Pr.next())
            {
             Order_ID= Pr.getInt("order_number");
            }       
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
         Order_ID=0;
        }
        return Order_ID;
    }
    
    public static  ArrayList<Object> Search_Order(int order_number)
    {   
        ArrayList<Object> obj=new ArrayList() ;
        String Query = "SELECT * FROM pharmacist, customer, products, orders, order_relation WHERE order_relation.order_ID = '"+order_number+"' " +
                " AND (order_relation.ProductName = products.med_name) " +
                "AND (order_relation.ProductName = products.med_name) " +
                "AND (order_relation.order_ID = orders.order_number) " +
                "AND (order_relation.C_ID = customer.customer_id) " ;
        ResultSet Pr=DBOperation.getData(Query);
        try {
            while(Pr.next())
            {
                obj.add(new Pharmacist_Model(Pr.getInt("id"),Pr.getString("hired_date"),Pr.getString("firstname"),Pr.getString("lastname"),Pr.getString("pharmacist_gender"),Pr.getString("phonenumber"),Pr.getString("email"),Pr.getString("password"),Pr.getInt("salary"),Pr.getInt("age")));
                obj.add(new Customers_Model(Pr.getInt("customer_id"),Pr.getString("customer_firstname"),Pr.getString("customer_lastname"),Pr.getString("city"),Pr.getString("street"),Pr.getString("gender"),Pr.getString("phoneNumber_1")));
                obj.add(new Products_Model(Pr.getString("med_name"),Pr.getInt("price"),Pr.getString("expired_date"),Pr.getInt("quantity"),Pr.getString("category"),Pr.getString("description")));
                obj.add(new Orders_Model(Pr.getInt("order_number"),Pr.getInt("order_price"),Pr.getString("date"),Pr.getString("Payment_Type")));                                
            }       
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
         obj=null;
        }
         return obj;    
    }
    
    
}
