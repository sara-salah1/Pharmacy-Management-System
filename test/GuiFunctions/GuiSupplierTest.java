/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFunctions;

import Modeling.DBOperation;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author LEGION
 */
public class GuiSupplierTest {
            public String mobileNumberPattern = "^01[0125][0-9]{8}$";
            public String DatePattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public GuiSupplierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         int supplier_id =9;
        String prod_name = "pann";
        String pro="samaa";
        
        String Query1="delete from supplier_prod_rel where supp_id = '"+supplier_id+"' ";
        DBOperation.setDataOrDelete(Query1, "");
        
        int supp=5;
        String Query2="delete from supplier_prod_rel where supp_id = '"+supp+"' ";
        DBOperation.setDataOrDelete(Query2, "");
        
        String query="delete from supplier where supplier_id = '"+supplier_id+"'";
        DBOperation.setDataOrDelete(query, "");
        
        String Query="delete from products where med_name='"+prod_name+"'";
        DBOperation.setDataOrDelete(Query, "");
        
        String Quer="delete from products where med_name='"+pro+"'";
        DBOperation.setDataOrDelete(Quer, "");
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
       
    }

    
    //passed
    @Test
    public void testValidateFieldsEmptyFields() {
        System.out.println("Empty feilds");
        String med = "";
        String pr = "";
        String qua = "";
        String Expired_date = "";
        String cat = "";
        String description = "";
        String company_id = "";
        String company_name = "";
        String Tele = "";
        String City = "";
        String Region = "";
        String Postal_code = "";
        String Date = "";
        String phar_id = "";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    // passed
    @Test
    public void testValidateFieldsNotEmptyFields() {
        System.out.println("Not Empty fields");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = true;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }

  //passed
    @Test
    public void testValidateFieldsEmpty() {
        System.out.println("Empty fields");
        String med = "panadol";
        String pr = "";
        String qua = "";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    //passed
    @Test
    public void testValidateFieldsEmpty2() {
        System.out.println("Empty fields");
        String med = "";
        String pr = "500";
        String qua = "500";
        String Expired_date = "12/11/2080";
        String cat = "";
        String description = "dc";
        String company_id = "";
        String company_name = "ahmed";
        String Tele = "01098760987";
        String City = "";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    //passed
    @Test
    public void testValidateFieldsEmpty3() {
        System.out.println("Empty feilds");
        String med = "panadol";
        String pr = "500";
        String qua = "500";
        String Expired_date = "";
        String cat = "tablets";
        String description = "dc";
        String company_id = "1";
        String company_name = "";
        String Tele = "";
        String City = "";
        String Region = "";
        String Postal_code = "";
        String Date = "";
        String phar_id = "";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    //passed
    @Test
    public void testValidateFieldsWrongDatePattern() {
        System.out.println("wrong date");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/9/287";     // wrong date
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsWrongExpiredDatePattern() {
        System.out.println("wrong expire product date");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/00/208";     // wrong expire product date
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsWrongPhonePattern() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "sara";       // Wrong Phone Pattern
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testValidateFieldsmissinddata1() {
        System.out.println("Wrong Phone Pattern");
        String med = "";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";       
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testValidateFieldsmissinddata2() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";       
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
     @Test
    public void testValidateFieldsmissinddata3() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";       
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
     @Test
    public void testValidateFieldsmissinddata4() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";      
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissinddata5() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";     
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissinddata6() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";     
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    
    
    @Test
    public void testValidateFieldsmissinddata7() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "";
        String company_name = "ahmed";
        String Tele = "01098760987";       
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissinddata8() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "";
        String Tele = "01098760987";      
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissinddata9() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "";       
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissinddata10() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";       
        String City = "";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissinddata11() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";       
        String City = "Luxor";
        String Region = "";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
     @Test
    public void testValidateFieldsmissinddata12() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";       
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "";
        String Date = "04/09/2087";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
     @Test
    public void testValidateFieldsmissinddata13() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";       
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "";
        String phar_id = "1";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissinddata14() {
        System.out.println("Wrong Phone Pattern");
        String med = "panadol";
        String pr = "500";
        String qua = "5";
        String Expired_date = "12/11/2080";
        String cat = "Topical medicines ";
        String description = "dc";
        String company_id = "4";
        String company_name = "ahmed";
        String Tele = "01098760987";       
        String City = "Luxor";
        String Region = "cairo";
        String Postal_code = "1243";
        String Date = "04/09/2087";
        String phar_id = "";
        boolean expResult = false;
       
        GuiSupplier instance = new GuiSupplier();
        boolean result = instance.validateFields(med, pr, qua, Expired_date, cat, description, company_id, company_name, Tele, City, Region, Postal_code, Date, phar_id);

        assertEquals(expResult, result);
    }
    

    /**
     * Test of IsVaildExpiredDate1 method, of class GuiSupplier.
     */
    // passed 
    @Test
    public void testIsVaildExpiredDate1() {
        System.out.println("valid Expire Date");
        String Expired_date = "12/12/2070";
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = true;
        boolean result = instance.IsVaildExpiredDate1(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    //passed 
    @Test
    public void testIsVaildExpiredDate2() {
        System.out.println("Invalid Expire Date");
        String Expired_date = "12/12/2010";     // old year
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = false;
        boolean result = instance.IsVaildExpiredDate1(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    // passed
    @Test
    public void testIsVaildExpiredDate3() {
        System.out.println("Invalid Expire Date");
        String Expired_date = "12/04/2023";   // old month 
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = false;
        boolean result = instance.IsVaildExpiredDate1(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    // passed
    @Test
    public void testIsVaildExpiredDate4() {
        System.out.println("Invalid Expire Date");
        String Expired_date = "14/06/2023";    // old day 
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = false;
        boolean result = instance.IsVaildExpiredDate1(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    // passed
    @Test
    public void testIsVaildExpiredDate5() {
        System.out.println("Invalid Expire Date");
        String Expired_date = "17/06/2023";     // day now = dayEntered 
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = false;
        boolean result = instance.IsVaildExpiredDate1(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    // passed
    @Test
    public void testIsVaildExpiredDate6() {
        System.out.println("valid Expire Date");
        String Expired_date = "30/06/2023";   // same year, same month, DayEntered > DayNow
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = true;
        boolean result = instance.IsVaildExpiredDate1(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsVaildExpiredDate7() {
        System.out.println("valid Expire Date");
        String Expired_date = "30/08/2023";   // same year, monthEntered > monthNow
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = true;
        boolean result = instance.IsVaildExpiredDate1(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    
    
    /**
     * Test of IsVaildExpiredDate1 method, of class GuiSupplier.
     */
    @Test
    public void testIsVaildDate1() {
        System.out.println("valid Date");
        String Expired_date = "12/12/2070";
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = true;
        boolean result = instance.IsVaildExpiredDate2(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsVaildDate2() {
        System.out.println("Invalid Date");
        String Expired_date = "12/12/2010";  // old year
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = false;
        boolean result = instance.IsVaildExpiredDate2(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsVaildDate3() {
        System.out.println("Invalid Date");
        String Expired_date = "12/04/2023";   // old month
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = false;
        boolean result = instance.IsVaildExpiredDate2(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsVaildDate4() {
        System.out.println("Invalid Date");
        String Expired_date = "10/06/2023";   // old day
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = false;
        boolean result = instance.IsVaildExpiredDate2(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsVaildDate5() {
        System.out.println("Invalid Date");
        String Expired_date = "17/06/2023";   // daynow = dayEntered
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = false;
        boolean result = instance.IsVaildExpiredDate2(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsVaildDate6() {
        System.out.println("valid Date");
        String Expired_date = "30/06/2023";
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = true;
        boolean result = instance.IsVaildExpiredDate2(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsVaildDate7() {
        System.out.println("valid Date");
        String Expired_date = "30/09/2023";
        GuiSupplier instance = new GuiSupplier();
        boolean expResult = true;
        boolean result = instance.IsVaildExpiredDate2(Expired_date);   // result --> true (valid)   , result -->false (invalid)
        assertEquals(expResult, result);
    }

    /**
     * Test of addButton method, of class GuiSupplier.
     */
    @Test   // done
    public void testAddButton() {
        System.out.println("Empty data entered ");
        String company_id = "";
        String tele = "";
        String Company_name = "";
        String city = "";
        String region = "";
        String postal_code = "";
        String prod_name = "";
        String phar_id = "";
        String Date = "";
        String quantity = "";
        String price = "";
        String Expire_date = "";
        String categ = "";
        String desc = "";
        GuiSupplier instance = new GuiSupplier();
        int flag=0;
        int exp=0;
        flag=instance.addButton(company_id, tele, Company_name, city, region, postal_code, prod_name, phar_id, Date, quantity, price, Expire_date, categ, desc);
        assertEquals(exp, flag);
    }
    
    @Test   //done
    public void testAddButtonWrongDate() {
        System.out.println("addButton");
        String company_id = "5";
        String tele = "01123435677";
        String Company_name = "valeo";
        String city = "Cairo ";
        String region = "cairo";
        String postal_code = "6565";
        String prod_name = "namnam";
        String phar_id = "1";
        String Date = "12/09/2010";     // wrond date entered 
        String quantity = "6";
        String price = "800";
        String Expire_date = "11/02/2045";
        String categ = "tables ";
        String desc = "sddd";
        GuiSupplier instance = new GuiSupplier();
        int flag=0;
        int exp=3;
        flag=instance.addButton(company_id, tele, Company_name, city, region, postal_code, prod_name, phar_id, Date, quantity, price, Expire_date, categ, desc);
        assertEquals(exp, flag);
    }
    
     
    @Test    // done
    public void testAddButtonProductAndCompanyExist() {
        System.out.println("product and company exist");
        String company_id = "5";
        String tele = "01028465420";
        String Company_name = "valeo";
        String city = "Cairo ";
        String region = "cairo";
        String postal_code = "6565";
        String prod_name = "namnam";
        String phar_id = "1";
        String Date = "12/11/2099";
        String quantity = "6";
        String price = "800";
        String Expire_date = "12/09/2030";  
        String categ = "tablet ";
        String desc = "sddd";
        GuiSupplier instance = new GuiSupplier();
        int flag=0;
        int exp=2;
        flag=instance.addButton(company_id, tele, Company_name, city, region, postal_code, prod_name, phar_id, Date, quantity, price, Expire_date, categ, desc);
        assertEquals(exp, flag);
    }
    
    
    
    @Test   // done
    public void testAddButton3() {
        System.out.println("pharmacy id not exist");
        String company_id = "5";
        String tele = "01123435677";
        String Company_name = "valeo";
        String city = "Cairo ";
        String region = "cairo";
        String postal_code = "6565";
        String prod_name = "namnam";
        String phar_id = "5";     // pharmacy id not exist 
        String Date = "12/12/2077";
        String quantity = "6";
        String price = "800";
        String Expire_date = "11/02/2045";
        String categ = "tables ";
        String desc = "sddd";
        GuiSupplier instance = new GuiSupplier();
        int flag=0;
        int exp=4;
        flag = instance.addButton(company_id, tele, Company_name, city, region, postal_code, prod_name, phar_id, Date, quantity, price, Expire_date, categ, desc);
        assertEquals(exp, flag);
    }
    
    // enter exist supplier , new prod when run and run again must change product and supplier data for the next two test cases
    @Test    //done
    public void testAddButton24() {
        System.out.println("exist supplier, new product");
        String company_id = "5";
        String tele = "01028465420";
        String Company_name = "valeo";
        String city = "Cairo ";
        String region = "cairo";
        String postal_code = "6565";
        String prod_name = "samaa";
        String phar_id = "1";
        String Date = "12/12/2090";
        String quantity = "5";
        String price = "500";
        String Expire_date = "12/11/2080";
        String categ = "Topical medicines ";
        String desc = "dc";
        GuiSupplier instance = new GuiSupplier();
        int flag=0;
        int exp=6;
        flag=instance.addButton(company_id, tele, Company_name, city, region, postal_code, prod_name, phar_id, Date, quantity, price, Expire_date, categ, desc);
        assertEquals(exp, flag);
    }
    
    
    // enter new supplier (insert new supplier and new product)
    @Test   //done
    public void testAddButton5() {
        System.out.println("enter new supplier(as well as new product)");
        String company_id = "9";    // new suppliers(deleted first in the beginning in setupClass function)
        String tele = "01011333679";  
        String Company_name = "olddd";
        String city = "Cairo ";
        String region = "cairo";
        String postal_code = "7898";
        String prod_name = "pann";
        String phar_id = "1";
        String Date = "12/11/2077";
        String quantity = "6";
        String price = "800";
        String Expire_date = "17/02/2045";
        String categ = "tables ";
        String desc = "sddd";
        GuiSupplier instance = new GuiSupplier();
        int flag=0;
        int exp=6;
        flag = instance.addButton(company_id, tele, Company_name, city, region, postal_code, prod_name, phar_id, Date, quantity, price, Expire_date, categ, desc);
        assertEquals(exp, flag);
    }
    
    
//    @Test
//    public void testAddButton6() {
//        System.out.println("Invalid date and ExpiredDate");
//        String company_id = "5";
//        String tele = "01028465420";
//        String Company_name = "comp";
//        String city = "Cairo ";
//        String region = "cairo";
//        String postal_code = "7878";
//        String prod_name = "newwww";
//        String phar_id = "1";
//        String Date = "01/09/2010";     // old date 
//        String quantity = "6";
//        String price = "800";
//        String Expire_date = "04/09/2010";    // old date 
//        String categ = "tables ";
//        String desc = "sddd";
//        GuiSupplier instance = new GuiSupplier();
//        int flag = 0;
//        int exp = 3;
//        flag = instance.addButton(company_id, tele, Company_name, city, region, postal_code, prod_name, phar_id, Date, quantity, price, Expire_date, categ, desc);
//        System.out.println(flag);
//        assertEquals(exp, flag);
//    }
    
    @Test
    public void testAddButtonWrongExpiredDate() {
        System.out.println("Wrong Expired Date");
        String company_id = "5";
        String tele = "01123435677";
        String Company_name = "valeo";
        String city = "Cairo ";
        String region = "cairo";
        String postal_code = "6565";
        String prod_name = "namnam";
        String phar_id = "1";
        String Date = "11/12/2090";
        String quantity = "6";
        String price = "800";
        String Expire_date = "11/02/2010";     //old expired date 
        String categ = "tables ";
        String desc = "sddd";
        GuiSupplier instance = new GuiSupplier();
        int flag=0;
        int exp=3;
        flag=instance.addButton(company_id, tele, Company_name, city, region, postal_code, prod_name, phar_id, Date, quantity, price, Expire_date, categ, desc);
        assertEquals(exp, flag);
    }
    
    
}
