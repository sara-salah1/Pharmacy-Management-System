
package Modeling;

import java.sql.*;
import javax.swing.*;


public class Connector {
    private final String user="root";
    private final String pass="";
    private final String url="jdbc:mysql://localhost/pharmacy";
    public  Connection connect() 
    {
          try {
               return DriverManager.getConnection(url, user, pass);
              }
          catch (SQLException e) {
   
                JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
                return  null;
             }
      
    }
}
