/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFunctions;

import Control.supplier_operations;
import javax.swing.JOptionPane;
import loginform.EditCompProd;
import loginform.Supplier;

/**
 *
 * @author LEGION
 */
public class GuiEditCompProd {
        public String DatePattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        
        public boolean validateFields(String com_id, String com_name, String tele, String addr) {
        String Company_id=com_id;
        String Company_name = com_name;
        String Telephone = tele;
        String address = addr;
        return   !address.equals("") && !Telephone.equals("") && !Company_name.equals("") && !Company_id.equals("");

        }
        
        
        public boolean EditAction(String comp_id, String comp_name, String tele, String addr)
        {
            boolean flag=false;
            if (validateFields(comp_id, comp_name, tele, addr)) {
                flag=true;
                supplier_operations.edit_Supplier(Integer.parseInt(comp_id),comp_name,tele, addr);
                Supplier ob= new Supplier();
                ob.setVisible(true);
                ob.show_table();
//                EditCompProd ed=new EditCompProd();
//                ed.dispose();
            
            
           } else {
            JOptionPane.showMessageDialog(null, "Please Enter Correct information", "Message", JOptionPane.WARNING_MESSAGE);
          }
            return flag;
        }
        
    
}
