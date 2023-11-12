/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFunctions;

import Control.supplier_operations;
import Modeling.Suppliers_Model;
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
public class GuiEditCompProdTest {
    
    public GuiEditCompProdTest() {
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
     * Test of validateFields method, of class GuiEditCompProd.
     */
    @Test
    public void testValidateFieldsEmpty() {
        System.out.println("Empty fields");
        String com_id = "";
        String com_name = "";
        String tele = "";
        String addr = "";
        GuiEditCompProd instance = new GuiEditCompProd();
        boolean expResult = false;
        boolean result = instance.validateFields(com_id, com_name, tele, addr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsNotEmpty() {
        System.out.println("Not Empty fields");
        String com_id = "1";
        String com_name = "comp";
        String tele = "01011215679";
        String addr = "Cairo,cairo,7878";
        GuiEditCompProd instance = new GuiEditCompProd();
        boolean expResult = true;
        boolean result = instance.validateFields(com_id, com_name, tele, addr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsEmpty2() {
        System.out.println("Empty fields");
        String com_id = "1";
        String com_name = "comp";
        String tele = "";
        String addr = "";
        GuiEditCompProd instance = new GuiEditCompProd();
        boolean expResult = false;
        boolean result = instance.validateFields(com_id, com_name, tele, addr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissingData1() {
        System.out.println("Empty fields");
        String com_id = "";
        String com_name = "comp";
        String tele = "01011215679";
        String addr = "Cairo,cairo,7878";
        GuiEditCompProd instance = new GuiEditCompProd();
        boolean expResult = false;
        boolean result = instance.validateFields(com_id, com_name, tele, addr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissingData2() {
        System.out.println("Empty fields");
        String com_id = "1";
        String com_name = "";
        String tele = "01011215679";
        String addr = "Cairo,cairo,7878";
        GuiEditCompProd instance = new GuiEditCompProd();
        boolean expResult = false;
        boolean result = instance.validateFields(com_id, com_name, tele, addr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissingData3() {
        System.out.println("Empty fields");
        String com_id = "1";
        String com_name = "comp";
        String tele = "";
        String addr = "Cairo,cairo,7878";
        GuiEditCompProd instance = new GuiEditCompProd();
        boolean expResult = false;
        boolean result = instance.validateFields(com_id, com_name, tele, addr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateFieldsmissingData4() {
        System.out.println("Empty fields");
        String com_id = "1";
        String com_name = "comp";
        String tele = "01011215679";
        String addr = "";
        GuiEditCompProd instance = new GuiEditCompProd();
        boolean expResult = false;
        boolean result = instance.validateFields(com_id, com_name, tele, addr);
        assertEquals(expResult, result);
    }

    /**
     * Test of EditAction method, of class GuiEditCompProd.
     */
    @Test
    public void testEditAction() {
        System.out.println("Empty fields");
        String comp_id = "";
        String comp_name = "";
        String tele = "";
        String addr = "";
        boolean expResult=false;
        GuiEditCompProd instance = new GuiEditCompProd();
        boolean result=instance.EditAction(comp_id, comp_name, tele, addr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEditAction2() {
        System.out.println("EditAction");
        String comp_id = "1";
        String comp_name = "comp";
        String tele = "01011215679";
        String addr = "Cairo,cairo,7778";
        boolean expResult=true;
        GuiEditCompProd instance = new GuiEditCompProd();
       boolean result=instance.EditAction(comp_id, comp_name, tele, addr);
        assertEquals(expResult, result);
    }
    
}
