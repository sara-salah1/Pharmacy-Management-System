package Modeling;

/**
 *
 * @author Seifeldin Ahmed
 */
public class Orders_Model {
 
    private String Payment_Type,date;
    private int  Order_number,price;

    public Orders_Model(int Order_number,int price, String date,String Payment_Type) {
        this.Payment_Type = Payment_Type;
        this.date = date;
        this.Order_number = Order_number;
        this.price = price;
    }

    public String getPayment_Type() {
        return Payment_Type;
    }

    public void setPayment_Type(String Payment_Type) {
        this.Payment_Type = Payment_Type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getOrder_number() {
        return Order_number;
    }

    public void setOrder_number(int Order_number) {
        this.Order_number = Order_number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
