/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modeling.Customers_Model;
import Control.customers_operations;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;




/**
 *
 * @author ASUS
 */
public class customers_operationsTest {
    
    public customers_operationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of insert_CustomerData method, of class customers_operations.
     */
    @Test
    public void testInsert_CustomerData() {
        System.out.println("insert_CustomerData");
        String firstname = "louis";
        String lastname = "Tomlinson";
        String city = "Helwan";
        String street = "azzam";
        String gender = "Male";
        String phoneNumber_1 = "01157287709";
        customers_operations.insert_CustomerData(firstname, lastname, city, street, gender, phoneNumber_1);
        // TODO review the generated test code and remove the default call to fail.
       // Retrieve the customer from the database
     // Verify that the customer was inserted correctly
    boolean isInserted = verifyCustomerData(firstname, lastname, city, street, gender, phoneNumber_1);
    assertTrue(isInserted);
    
}
// verify data is inserted in the database
private boolean verifyCustomerData(String firstname, String lastname, String city, String street, String gender, String phoneNumber_1) {
    ArrayList<Customers_Model> customers = customers_operations.get_customersData();
    for (Customers_Model customer : customers) {
        if (customer.getFirstname().equals(firstname) &&
            customer.getLastname().equals(lastname) &&
            customer.getCity().equals(city) &&
            customer.getStreet().equals(street) &&
            customer.getGender().equals(gender) &&
            customer.getPhoneNumber_1().equals(phoneNumber_1)) {
            return true;
        }
    }
    return false;
}
        // Print the actual and expected values
   /* System.out.println("Actual values:");
    System.out.println("First name: " + customer.getFirstname());
    System.out.println("Last name: " + customer.getLastname());
    System.out.println("City: " + customer.getCity());
    System.out.println("Street: " + customer.getStreet());
    System.out.println("Phone number: " + customer.getPhoneNumber_1());
    System.out.println("Gender: " + customer.getGender());

    System.out.println("Expected values:");
    System.out.println("First name: " + firstname);
    System.out.println("Last name: " + lastname);
    System.out.println("City: " + city);
    System.out.println("Street: " + street);
    System.out.println("Phone number: " + phoneNumber_1);
    System.out.println("Gender: " + gender);  */

    
    
    /**
     * Test of get_customersData method, of class customers_operations.
     */
    
    @Test
    public void testGet_customersData() {
        System.out.println("get_customersData");
       // ArrayList<Customers_Model> expResult = null;
       // ArrayList<Customers_Model> result = customers_operations.get_customersData();
        //assertEquals(expResult, result);
        
        
    
    // Call the method to get the customers data
    ArrayList<Customers_Model> result = customers_operations.get_customersData();
    
    // Verify that the result is not null and not empty
    assertNotNull(result);
    assertFalse(result.isEmpty());
        
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of Search_customer method, of class customers_operations.
     */
    
    @Test
    public void testSearch_customer() {
        System.out.println("Search_customer");
        int customer_id = 3;
        String firstname = "sarah";
        String lastname = "farghaly";
        String city = "helwan";
        String street = "masged azzam";
        String gender = "female";
        String phoneNumber_1 = "01157287709";
        //Customers_Model expResult = null;
       Customers_Model customer = customers_operations.Search_customer(customer_id);
       //assertNotNull(result);
         // Verify that the search customer data successfully
        // assertEquals(expResult, result);
    //Customers_Model customer = result.get(0);
    assertEquals(firstname, customer.getFirstname());
    assertEquals(lastname, customer.getLastname());
    assertEquals(city, customer.getCity());
    assertEquals(street, customer.getStreet());
    assertEquals(gender, customer.getGender());
    assertEquals(phoneNumber_1, customer.getPhoneNumber_1());
      
    }

    /**
     * Test of Return_Customer_ID method, of class customers_operations.
     */
    
    @Test
    public void testReturn_Customer_ID() {
        System.out.println("Return_Customer_ID");
        int customer_id=15;
        String firstname = "John";
        String lastname = "Doe";
        String phoneNumber_1 = "123456789";
        Customers_Model customer = customers_operations.Return_Customer_ID(firstname, lastname, phoneNumber_1);
        assertEquals(customer_id, customer.getCustomer_id());
        // assertEquals(lastname, customer.getLastname());
        //assertEquals(phoneNumber_1, customer.getPhoneNumber_1());
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of Delete_customer method, of class customers_operations.
     */
    
    @Test
    public void testDelete_customer() {
        System.out.println("Delete_customer");
        int customer_id = 2;
         // Delete the customer from the database
        customers_operations.Delete_customer(customer_id);
        
      // TODO review the generated test code and remove the default call to fail.
 
       ArrayList<Customers_Model> customers = customers_operations.get_customersData();
       assertFalse(customers.isEmpty());

   
    // Verify that the customer no longer exists in the database
    customers = customers_operations.get_customersData();
    boolean customerFound = false;
    // for loop to detect that data is no longer there
    for (Customers_Model customer : customers) {
        if (customer.getCustomer_id() == customer_id) {
            customerFound = true;
            break;
        }
    }
    assertFalse(customerFound);
    
    }
    

}
