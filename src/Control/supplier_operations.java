/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modeling.DBOperation;
import Modeling.Products_Model;
import Modeling.Suppliers_Model;
import Modeling.supp_prod_rel_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LEGION
 */
public class supplier_operations {
    public  static void insert_SupplierData(int Company_id, String Company_name, String city, String region, String postal_code, String phone )
   {
       String query="insert into supplier (supplier_id, Company_name,city,region,postal_code,phone) values ('"+Company_id+"','"+Company_name+"' , '"+city+"' , '"+region+"' , '"+postal_code+"', '"+phone+"')";
       DBOperation.setDataOrDelete(query, "New Supplier has been Inserted Successfully");  
       
   }
    //get data
    public  static ArrayList<Suppliers_Model> get_suppliersData()
    {
          String query="select * from supplier";
          
          ResultSet rs=DBOperation.getData(query);
          
          ArrayList<Suppliers_Model> arr= new ArrayList();
          
        try {
            while(rs.next())
            {
                arr.add(new Suppliers_Model(rs.getInt("supplier_id"),
                        rs.getString("Company_name"),
                        rs.getString("city"),
                        rs.getString("region"),
                        rs.getString("postal_code"),
                        rs.getString("phone")));
            }
            return arr;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                rs.close();
                  throw new SQLException("check not right");
            } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
       return null;  
    }
       public static ArrayList<Object> Search_supplier(String Company_name)
    {   
//        Object obj=null;
        String Query="select supplier.supplier_id, supplier.Company_name, products.med_name, supplier_prod_rel.date from supplier, products,supplier_prod_rel where Company_name='"+Company_name+"' and supplier_prod_rel.supp_id = supplier.supplier_id and supplier_prod_rel.prod_name = products.med_name ";
        ResultSet rs=DBOperation.getData(Query);
        ArrayList<Object> arr= new ArrayList();
        try {
            while(rs.next())
            {
              arr.add(new Suppliers_Model(rs.getInt("supplier_id"),rs.getString("Company_name")));
              arr.add(new Products_Model(rs.getString("med_name")));
              arr.add(new supp_prod_rel_Model((rs.getString("date"))));
              
            }       
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
         arr=null;
        }
         return arr;    
    }

      public  static ArrayList<Object> get_PRodSuppData()
    {
          String query="select supplier.supplier_id, supplier.Company_name, products.med_name, supplier_prod_rel.date from supplier, products, supplier_prod_rel where supplier_prod_rel.supp_id=supplier.supplier_id and supplier_prod_rel.prod_name=products.med_name";
          ResultSet rs=DBOperation.getData(query);
          ArrayList<Object> arr= new ArrayList();

        try {
            while(rs.next())
            {
                arr.add(new Suppliers_Model(rs.getInt("supplier_id"),rs.getString("Company_name")));
                arr.add(new Products_Model(rs.getString("med_name")));
                arr.add(new supp_prod_rel_Model((rs.getString("date"))));
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
      public static void insertSupplier_prod_rel(String prod_name,int supp_id, int ph_id,String date)
      {
          String Query="insert into supplier_prod_rel (prod_name,supp_id, ph_id,date) values ('"+prod_name+"','"+supp_id+"','"+ph_id+"','"+date+"') ";
//          String Query="insert into supplier_prod_rel values select prod_name,supp_id, phar_id from "
          DBOperation.setDataOrDelete(Query, "added Successfully");
          
      }
      /* to check company name exist or not */
      public static ArrayList<Object> SearchToCheck(int Company_ID)
    {   
        String Query="select supplier.*, supplier_prod_rel.date from supplier,supplier_prod_rel,products where supplier.supplier_id='"+Company_ID+"'";
        ResultSet rs=DBOperation.getData(Query);
        ArrayList<Object> arr= new ArrayList();
        try {
            if(!rs.isBeforeFirst())
            {
                return null;
            }
            while(rs.next())
            {
                
                arr.add(new Suppliers_Model(rs.getString("Company_name"),
                      rs.getString("city"),
                      rs.getString("region"),
                      rs.getString("postal_code"),
                      rs.getString("phone")));
                arr.add(new supp_prod_rel_Model(rs.getString("date")));
                
                
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
      
     public static void edit_Supplier(int id,String Company_name, String Telephone, String address)
     {
         StringTokenizer addr= new StringTokenizer(address,",");
         String[] myArray = new String[3];
         for(int  i=0;i<myArray.length;i++)
         {
               if( addr.hasMoreTokens())
                {
                    myArray[i]=addr.nextToken();
                }  
         }
         String city=myArray[0];
         String region=myArray[1];
         String postal_code=myArray[2];
         // myArray[0]--> city ,myArray[1]---> region  ,myArray[2]-->postal_code
        String query="UPDATE supplier set city='"+city+"',region='"+region+"', postal_code='"+postal_code+"', Company_name='"+Company_name+"', phone='"+Telephone+"' where supplier_id='"+id+"'";
         DBOperation.setDataOrDelete(query, "supplier and product has been updated Successfully");
       
     }
     /*                function search for edit               */
     public static ArrayList<Object> SearchEdit(int Company_id)
    {   
        String Query="select supplier.* from supplier where supplier.supplier_id = '"+Company_id+"'  ";
        ResultSet rs=DBOperation.getData(Query);
        ArrayList<Object> arr= new ArrayList();
        try {
            if(!rs.isBeforeFirst())
            {
                return null;
            }
            while(rs.next())
            {
                arr.add(new Suppliers_Model(rs.getString("Company_name"),
                      rs.getString("city"),
                        rs.getString("region"),
                        rs.getString("postal_code"),
                      rs.getString("phone")));
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
      
     public static ArrayList<Suppliers_Model> view_Supplier(int company_id)
     {
         String Query="SELECT Company_name, phone , city, region, postal_code FROM supplier, products where supplier.supplier_id='"+company_id+"'";
         ResultSet rs=DBOperation.getData(Query); 
         ArrayList<Suppliers_Model> arr= new ArrayList();

        try {
            while(rs.next())
            {
                arr.add(new Suppliers_Model(
                        rs.getString("Company_name"),
                        rs.getString("city"),
                        rs.getString("region"),
                        rs.getString("postal_code"),
                        rs.getString("phone")));
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

     
}
