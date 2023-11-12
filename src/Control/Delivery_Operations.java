package Control;

import Modeling.DBOperation;
import Modeling.Delivery_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Seifeldin Ahmed
 */
public class Delivery_Operations {
  
   public  static void insert_OrderData(int delivery_ID,String phone_number , String name)
   {    
       String query="insert into delivery (delivery_ID,delivery_phoneNumber,name) values ('"+delivery_ID+"' , '"+phone_number+"' , '"+name+"')";
       DBOperation.setDataOrDelete(query, "");       
   }
       public static Delivery_Model Search(int id)
    {   
        Delivery_Model obj=null;
        String Query="select *from delivery where delivery_ID='"+id+"'";
        ResultSet rs=DBOperation.getData(Query);
        try {
            while(rs.next())
            {
                obj= new Delivery_Model(rs.getString("name"),rs.getString("delivery_phoneNumber"),rs.getInt("delivery_ID"));  
            }       
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
         obj=null;
        }
         return obj;    
    }
}
