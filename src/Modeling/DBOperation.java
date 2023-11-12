package Modeling;
import java.sql.*;
import javax.swing.*;

/*
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
   LocalDateTime now = LocalDateTime.now();
   System.out.println(dtf.format(now));
*/
public class DBOperation {

   private static Connection con;
   private static Statement st;

    public static void setDataOrDelete(String Query, String msg) {

        Connector c1 = new Connector();
        try {

            con = c1.connect();

            st = con.createStatement();
            st.executeUpdate(Query); // same as st.execute(Query);

            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public static ResultSet getData(String query) {
        Connector c2 = new Connector();
        try {
            con = c2.connect();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
            return null;
        } 
    }
}