/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFunctions;

import Control.Pharmacist_operations;
import Control.Products_Operations;
import Control.supplier_operations;
import Modeling.Pharmacist_Model;
import Modeling.Products_Model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import loginform.Supplier;
import loginform.newproduct;
import loginform.products;

/**
 *
 * @author LEGION
 */
public class GuiSupplier {
        public String mobileNumberPattern = "^01[0125][0-9]{8}$";
        public String DatePattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public boolean validateFields(String med, String pr, String qua, String Expired_date, String cat, String description, String company_id, String company_name, String Tele, String City,String Region, String Postal_code, String Date, String phar_id) {
        String med_name = med;
        String price = pr;
        String quantity = qua;
        String expired_date = Expired_date;
        String categ = (String)cat;
        String desc= description;
        String Company_id= company_id;
        String Company_name= company_name;
        String Telephone=Tele;
        String region= Region;
        String postal_code=Postal_code;
        String city = (String)City;
        String date=Date;
        String ph_id=phar_id;
        
        
        return expired_date.matches(DatePattern) && Telephone.matches(mobileNumberPattern) &&  !med_name.equals("")   &&  !ph_id.equals("") &&  !date.equals("") && !price.equals("") && !quantity.equals("") && !expired_date.equals("") && !Company_name.equals("") && !city.equals("") && !region.equals("") && !Telephone.equals("") && !postal_code.equals("")  && !desc.equals("") && !categ.equals("") ;

    }
    public boolean IsVaildExpiredDate1(String Expired_date) {
        boolean vaild = true;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String entered_date = Expired_date;
        StringTokenizer entered = new StringTokenizer(entered_date, "/");
        StringTokenizer Now = new StringTokenizer(dtf.format(now), "/");
        int DayEntered = Integer.parseInt(entered.nextToken());
        int MonthEntered = Integer.parseInt(entered.nextToken());
        int YearEntered = Integer.parseInt(entered.nextToken());
        int YearNow = Integer.parseInt(Now.nextToken());
        int MonthNow = Integer.parseInt(Now.nextToken());
        int DayNow = Integer.parseInt(Now.nextToken());
        if (YearNow > YearEntered) // not vaild
        {
            vaild = false;
        } else if (YearNow == YearEntered) {
            if (MonthNow > MonthEntered) {
                vaild = false;
            } else if (MonthNow == MonthEntered) {
                if (DayNow >= DayEntered) {
                    vaild = false;
                }
            }
        }
        return vaild;
    }
    
    public boolean IsVaildExpiredDate2(String date) {
        boolean vaild = true;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String entered_date = date;
        StringTokenizer entered = new StringTokenizer(entered_date, "/");
        StringTokenizer Now = new StringTokenizer(dtf.format(now), "/");
        int DayEntered = Integer.parseInt(entered.nextToken());
        int MonthEntered = Integer.parseInt(entered.nextToken());
        int YearEntered = Integer.parseInt(entered.nextToken());
        int YearNow = Integer.parseInt(Now.nextToken());
        int MonthNow = Integer.parseInt(Now.nextToken());
        int DayNow = Integer.parseInt(Now.nextToken());
        if (YearNow > YearEntered) // not vaild
        {
            vaild = false;
        } else if (YearNow == YearEntered) {
            if (MonthNow > MonthEntered) {
                vaild = false;
            } else if (MonthNow == MonthEntered) {
                if (DayNow >= DayEntered) {
                    vaild = false;
                }
            }
        }
        return vaild;
    }
    
    public int addButton(String company_id, String tele,String Company_name,String city,String region,String postal_code,String prod_name,String phar_id, String Date, String quantity, String price , String Expire_date, String categ, String desc)
    {
        int flag=0;
        if (validateFields(prod_name, price, quantity, Expire_date, categ, desc, company_id, Company_name, tele, city, region, postal_code, Date, phar_id)) {
            flag=1;
            
            if (IsVaildExpiredDate1(Expire_date) && IsVaildExpiredDate2(Date)) {
               
                flag=2;
                boolean terminated = false;
               
               /*                         search pharamcist                           */
               int pharmacist_id =Integer.parseInt(phar_id);
             Pharmacist_Model pharmacist_op = Pharmacist_operations.Search_Pharmacist(pharmacist_id);
             if ( pharmacist_op == null)
             {
                 flag=4;
                JOptionPane.showMessageDialog(null, "There's No Pharmacist with This ID", "Message", JOptionPane.WARNING_MESSAGE);
                 terminated = true;
             }
             else
             {
                 /*                             search supplier and product                        */
               int supplier_id=Integer.parseInt(company_id);
               ArrayList<Object> supplier_op = supplier_operations.SearchToCheck(supplier_id);
               String med_name=prod_name;
               Products_Model prod_op=Products_Operations.Search_Product(med_name);
                if( supplier_op == null) // supplier not exist 
               {
                    flag=5;
                   supplier_operations.insert_SupplierData(Integer.parseInt(company_id),Company_name, city, region, postal_code, tele);
               }
                if(prod_op == null) // product not exist
               {
                    flag=6;
                    Products_Operations.insert_ProductData(prod_name, Integer.parseInt(price), Expire_date, Integer.parseInt(quantity), categ, desc);
               }
               else 
               {
                   int StoredQuantity=prod_op.getQuantity();
                   int Quantity= StoredQuantity+ Integer.parseInt(quantity);
                   Products_Operations.Edit_Product(prod_name,  Integer.parseInt(price), Expire_date, Quantity );
               }
               
                supplier_operations.insertSupplier_prod_rel(prod_name,Integer.parseInt(company_id),Integer.parseInt(phar_id),Date);
                products obj = new products();
                obj.show_table();
                Supplier ob= new Supplier();
                ob.setVisible(true);
                ob.show_table();
                newproduct prod=new newproduct();
                prod.dispose();
               }
             }
             
               
            else 
            {
                flag=3;
              JOptionPane.showMessageDialog(null, "Expired Date or Date is not Vaild", "Message", JOptionPane.WARNING_MESSAGE);
              

            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter Correct information", "Message", JOptionPane.WARNING_MESSAGE);
            flag=0;
            System.out.println("sara salah ");
        }
        return flag;
    }
    
}
