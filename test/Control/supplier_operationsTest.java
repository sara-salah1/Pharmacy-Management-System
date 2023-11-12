/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Modeling.DBOperation;
import Modeling.Products_Model;
import Modeling.Suppliers_Model;
import Modeling.supp_prod_rel_Model;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author LEGION
 */
public class supplier_operationsTest {
    
    public supplier_operationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        String Query="delete from supplier where supplier_id = 20";
        DBOperation.setDataOrDelete(Query, "deleted successfully");
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
    private boolean verifySupplierData(int supplier_id,String company_name, String city, String region, String postal_code, String phone) {
        ArrayList<Suppliers_Model> supplier = supplier_operations.get_suppliersData();
        
        for (Suppliers_Model suppliers : supplier) {
            String id= Integer.toString(supplier_id);
            String retid=Integer.toString(suppliers.getSupplier_id());
            if( retid.equals(id)&&
                suppliers.getCompany_name().equals(company_name) &&
                suppliers.getCity().equals(city) &&
                suppliers.getRegion().equals(region) &&
                suppliers.getPostal_code().equals(postal_code) &&
                suppliers.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
    
    
    @Test
public void testGet_PRodSuppDataNullResultSet() {
    ArrayList<Object> productList = null;
    ResultSet rs = null;
    
    // Execute an invalid SQL query to retrieve a null ResultSet object
    rs = DBOperation.getData("SELECT * FROM non_existing_table");
    
    // Call the method that retrieves data from the ResultSet object
    productList = supplier_operations.get_PRodSuppData();
    
    // Check that the ArrayList object is not null and has size 0
    assertNotNull(productList);
//    assertEquals(0, productList.size());
}

@Test
public void testGet_PRodSuppDataSQLException() {
    ArrayList<Object> productList = null;
    ResultSet rs = null;
    
    // Execute a valid SQL query to retrieve a non-empty ResultSet object
    rs = DBOperation.getData("SELECT * FROM supplier_prod_rel LIMIT 1");
    
    // Close the ResultSet object to force an SQLException
    try {
        rs.close();
    } catch (SQLException e) {
        // Ignore the exception
    }
    
    // Call the method that retrieves data from the ResultSet object
    productList = supplier_operations.get_PRodSuppData();
    
    // Check that the ArrayList object is null
    assertNotNull(productList);
}

  @Test
  public void testGetSuppliersDataNotNull() {
    ArrayList<Suppliers_Model> supplierList = supplier_operations.get_suppliersData();
    assertNotNull(supplierList);
    assertFalse(supplierList.isEmpty());
  }
//  @Test
//public void testGetSuppliersDataNullResultSet() throws SQLException {
//    ArrayList<Suppliers_Model> expectedResultSet = null;
////    ResultSet actualResultSet = DBOperation.getData("SELECT * FROM non_existing_table"); // Execute an invalid SQL query to retrieve a null ResultSet object
//    ArrayList<Suppliers_Model> arr=supplier_operations.get_suppliersData();
//    assertEquals(expectedResultSet, arr);
//}
  
  @Test
  public void testGetPRodSuppDataNotNull() {
    ArrayList<Object> supplierList = supplier_operations.get_PRodSuppData();
    assertNotNull(supplierList);
    assertFalse(supplierList.isEmpty());
  }
  
//  @Test
//  public void testGetPRodSuppDataNullResultSet() {
//     ArrayList<Suppliers_Model> expectedResultSet = null;
////    ResultSet actualResultSet = DBOperation.getData("SELECT * FROM non_existing_table"); // Execute an invalid SQL query to retrieve a null ResultSet object
//    ArrayList<Object> arr = supplier_operations.get_PRodSuppData();
//    assertEquals(expectedResultSet, arr);  
//  }
    
    
    
    
    
    
 

    /**
     * Test of insert_SupplierData method, of class supplier_operations.
     */
    @Test
    public void testInsert_SupplierData() {
        System.out.println("insert_SupplierData");
        
        int Company_id = 20 ;
        String Company_name = "itwork" ;
        String city = "Cairo ";
        String region = "cairo";
        String postal_code = "0999";
        String phone = "01028465420";
        supplier_operations.insert_SupplierData(Company_id, Company_name, city, region, postal_code, phone);
        
        
        boolean isInserted = verifySupplierData(Company_id, Company_name,city, region, postal_code, phone );
        assertTrue(isInserted);

    }
        
    /**
     * Test of get_PRodSuppData method, of class supplier_operations.
     */
    
    //look again 
    @Test
    public void testGet_PRodSuppData() {
        System.out.println("get_PRodSuppData");
        ArrayList<Object> result;
        result = supplier_operations.get_PRodSuppData();
        assertNotNull(result);
        assertFalse(result.isEmpty());

        }
    
    /**
     * Test of Search_supplier method, of class supplier_operations.
     */
    @Test
    public void testSearch_supplier() {
        System.out.println("Search_supplier");
        String Company_name = "comp";
        int supplier_id = 1;
        String med_name="panad";
        String date="12/12/2067";
        ArrayList<Object> result = supplier_operations.Search_supplier(Company_name);
        
        // Verify that the search supplier data successfully
        assertEquals(supplier_id, ((Suppliers_Model)result.get(0)).getSupplier_id());
        assertEquals(Company_name, ((Suppliers_Model)result.get(0)).getCompany_name());
        assertEquals(med_name, ((Products_Model)result.get(1)).getMed_name());
        assertEquals(date, ((supp_prod_rel_Model)result.get(2)).getDate());
    }
    
    @Test
    public void testSearch_supplier2() {
        System.out.println("Search_supplier2");
        String Company_name = "not inserted ";
        ArrayList<Object> result = supplier_operations.Search_supplier(Company_name);
        assertNotNull(result);
    }

    /**
     * Test of SearchToCheck method, of class supplier_operations.
     */
    @Test
    public void testSearchToCheck() {
        System.out.println("SearchToCheck");
        // must read company id from gui 
        int Company_ID = 2;
        ArrayList<Object> result = supplier_operations.SearchToCheck(Company_ID);
        assertNotNull(result);
        assertFalse(result.isEmpty());

    }

    /**
     * Test of edit_Supplier method, of class supplier_operations.
     */
    @Test
    public void testEdit_Supplier() {
        System.out.println("edit_Supplier");
        int id = 1;
        String Company_name = "comp";
        String Telephone = "01011215679";
        String address = "Cairo,cairo,7878";
        supplier_operations.edit_Supplier(id, Company_name, Telephone, address);
        ArrayList<Suppliers_Model> supp = supplier_operations.get_suppliersData();
        boolean found = false;
            for (Suppliers_Model supplier : supp) {
                if (supplier.getSupplier_id() == id) {
                    found = true;
                    // Verify that the supplier data was updated correctly
                    assertEquals(Company_name, supplier.getCompany_name());
                    assertEquals(Telephone, supplier.getPhone());
                    assertEquals(address, supplier.getCity()+","+supplier.getRegion()+","+supplier.getPostal_code());
                    break;
                }
            }
        assertTrue(found);
        
    }
    
    
    @Test
    public void testEdit_SupplierNoAddr() {
        System.out.println("edit_Supplier");
        int id = 1;
        String Company_name = "comp";
        String Telephone = "01011215679";
        String address = "";
        supplier_operations.edit_Supplier(id, Company_name, Telephone, address);
    }

    /**
     * Test of SearchEdit method, of class supplier_operations.
     */
    @Test
    public void testSearchEdit() {
        System.out.println("exist company id");
        int Company_id = 2;
        ArrayList<Object> result = supplier_operations.SearchEdit(Company_id);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testSearch_Edit() {
        System.out.println("exist company id ");
        int supplier_id = 4;
        String company_name="ahmed";
        String region = "cairo";
        String city = "Luxor";
        String postal_code = "1243";
        String phone = "01098760987";
        
       ArrayList<Object> result = supplier_operations.SearchEdit(supplier_id);

        assertEquals(company_name, ((Suppliers_Model)result.get(0)).getCompany_name());
        assertEquals(city, ((Suppliers_Model)result.get(0)).getCity());
        assertEquals(region, ((Suppliers_Model)result.get(0)).getRegion());
        assertEquals(postal_code, ((Suppliers_Model)result.get(0)).getPostal_code());
        assertEquals(phone, ((Suppliers_Model)result.get(0)).getPhone());
    }
    
    
    @Test
    public void testSearchEditIDNotExist() {
        System.out.println("not found");
        int Company_id = 300;    //supplier id not exist
        ArrayList<Object> result = supplier_operations.SearchEdit(Company_id);
        assertNull(result);
    }

    /**
     * Test of view_Supplier method, of class supplier_operations.
     */
    @Test
    public void testView_Supplier() {
        System.out.println("view_Supplier");
        int company_id = 1;     // supplier id exist
        ArrayList<Suppliers_Model> result = supplier_operations.view_Supplier(company_id);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
    
    @Test 
    public void testView_SupplierEnterNull() {
        System.out.println("view_Supplier");
        int company_id = 300;    // supplier id not exist 
        ArrayList<Object> emptyList = new ArrayList<>();
        ArrayList<Suppliers_Model> result = supplier_operations.view_Supplier(company_id);
        assertEquals(emptyList,result);
    }
    
    
}
