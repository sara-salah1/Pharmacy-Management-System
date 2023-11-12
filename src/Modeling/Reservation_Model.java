/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeling;

/**
 *
 * @author Ahmed Sherif
 */
public class Reservation_Model {
    private int PH_ID,CU_ID,quantity;
    private String Product_Name,Date;

    public Reservation_Model(int PH_ID, int CU_ID, int quantity, String Product_Name, String Date) {
        this.PH_ID = PH_ID;
        this.CU_ID = CU_ID;
        this.quantity = quantity;
        this.Product_Name = Product_Name;
        this.Date = Date;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }


    public int getPH_ID() {
        return PH_ID;
    }

    public void setPH_ID(int PH_ID) {
        this.PH_ID = PH_ID;
    }

    public int getCU_ID() {
        return CU_ID;
    }

    public void setCU_ID(int CU_ID) {
        this.CU_ID = CU_ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String Product_Name) {
        this.Product_Name = Product_Name;
    }
    
}
