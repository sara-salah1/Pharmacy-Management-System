/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modeling.DBOperation;
import Modeling.Products_Model;
import Modeling.Reservation_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed Sherif
 */
public class Reservation_Operations {

    public static void insert_reservation(int PH_ID, int CU_ID, String Product_Name, int Quantity) {
        LocalDate currentDate = LocalDate.now();
        String query = "insert into reservation(pharmacist_ID ,Customer_ID ,Product_Name ,Quantity,Reservation_date) values('" + PH_ID + "','" + CU_ID + "','" + Product_Name + "','" + Quantity + "','" + currentDate.toString() + "')";
        DBOperation.setDataOrDelete(query, "New reservation has been Added Successfully");

    }
    public  static ArrayList<Reservation_Model> get_ReservationData()
    {
          String query="select * from reservation";
          ResultSet Res=DBOperation.getData(query);
          ArrayList<Reservation_Model> arr= new ArrayList();

        try {
            while(Res.next())
            {
                arr.add(new Reservation_Model(Res.getInt("pharmacist_ID"),Res.getInt("Customer_ID"),Res.getInt("Quantity"),Res.getString("Product_Name"),Res.getString("Reservation_date")));
            }
            return arr;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                Res.close();
            } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
       return null;
        
    }
       public static ArrayList<Reservation_Model> Search_Reservation(int PH_ID)
    {   
       ArrayList<Reservation_Model> arr= new ArrayList();
        String Query="select * from reservation where pharmacist_ID ='"+PH_ID+"' ";
        ResultSet Res=DBOperation.getData(Query);
        try {
            while(Res.next())
            {
            arr.add(new Reservation_Model(Res.getInt("pharmacist_ID"),Res.getInt("Customer_ID "),Res.getInt("Quantity"),Res.getString("Product_Name"),Res.getString("Reservation_date")));}       
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.ERROR_MESSAGE);
         arr=null;
        }
         return arr;    
    }
        public static void Delete_Reservation(int PH_ID,int CU_ID,String productName)
    {
        String Query="delete from reservation where pharmacist_ID ='"+PH_ID+"' And Customer_ID ='"+CU_ID+"' AND Product_Name ='"+productName+"'";
        DBOperation.setDataOrDelete(Query, " Reservation has been Deleted Successfully ");
    }
        public static void Edit_Reservation(int PH_ID,int CU_ID,String productName,int quantity)
    {        
        String query="UPDATE reservation set quantity='"+quantity+"' where pharmacist_ID ='"+PH_ID+"' AND Customer_ID='"+CU_ID+"' AND Product_Name ='"+productName+"'";
        DBOperation.setDataOrDelete(query, "Edited Seccussfully");
    }
}
