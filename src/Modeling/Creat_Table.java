
package Modeling;
public class Creat_Table {
    public static void main(String []args)
    {
//      String Query= "create table login_info(ph_id int not null,email varchar(255) not null,password varchar(255) not null)";
//      String Query="create table pharmacist(id int not null,firstname varchar(255) not null,lastname varchar(255) not null,age int not null,hired_date varchar(50) not null,gender varchar(50) not null,phoneNumber varchar(100) not null,email varchar(255) not null,password varchar(255) not null,salary int not null,mng_id int not null)";
//      String  Query="create table products(med_name varchar(255) not null,price int not null,expired_date varchar(50) not null,quantity int not null,category varchar(255) not null,description varchar(255) not null )";
//      String Query="alter table login_info add constraint fx foreign key(ph_id) references pharmacist(id)";
//        String Query="ALTER TABLE supplier CHANGE supplier_id supplier_id INT(11) NOT NULL AUTO_INCREMENT";
//        String Query="drop table supplier_prod_rel";
//        String Query="insert into supplier_prod_rel values('panadol',2,1)";
//        String Query="alter table supplier_prod_rel supp_id int not null";
//        String Query="alter table supplier add date varchar(255)";
//        String Query="delete from supplier_prod_rel where date= 12/12/3030";
//        String Query="alter table supplier drop date ";
//          String Query="drop table pharmacist";
//        String Query="delete from supplier_prod_rel where supp_id = 5 ";
//        String sam="samaa";
//        String Query="delete from products where med_name =  '"+sam+"' ";
//        String Query="insert into supplier_prod_rel values('ddaa',1,1,'12/12/3030')";
        
        /*-------------------------------------------------------------------------------------------------------*/
        /*                                      supplier table                                            */
//      String Query="create table supplier(supplier_id int not null,Company_name varchar(255),city varchar(255),region varchar(255),postal_code varchar(50),phone varchar(100))";
//      String Query= "CREATE TABLE supplier_prod_rel(prod_name VARCHAR(255),supp_id INT,ph_id INT,date varchar(255), FOREIGN KEY (ph_id) REFERENCES pharmacist(id),FOREIGN KEY (supp_id) REFERENCES supplier(supplier_id),FOREIGN KEY (prod_name) REFERENCES products(med_name))";
//        String Query="create table Reservation(pharmacist_ID int not null,Customer_ID int not null,Product_Name varchar(255)not null,Quantity int not null,Reservation_date varchar(255)not null)";

      //String Query="create table supplier(supplier_id int not null,Company_name varchar(255),city varchar(255),region varchar(255),postal_code varchar(50),phone varchar(100))";
   //String Query= "CREATE TABLE supplier_prod_rel(prod_name VARCHAR(255),supp_id INT,ph_id INT,date varchar(255), FOREIGN KEY (ph_id) REFERENCES pharmacist(id),FOREIGN KEY (supp_id) REFERENCES supplier(supplier_id),FOREIGN KEY (prod_name) REFERENCES products(med_name))";
       // String Query="create table Reservation(pharmacist_ID int not null,Customer_ID int not null,Product_Name varchar(255)not null,Quantity int not null,Reservation_date varchar(255)not null)";

//            - Make (supplier_id) in supplier table primary key , AND DON'T MAKE IT AUTO INCREMENT 
//            - Make (med_name) in products table primary key
        
        /*-------------------------------------------------------------------------------------------------------*/
       /**** Tables ****/  

//     String Query="create table pharmacist(id int not null,firstname varchar(255) not null,lastname varchar(255) not null,age int not null,hired_date varchar(50) not null,pharmacist_gender varchar(50) not null,phoneNumber varchar(100) not null,email varchar(255) not null,password varchar(255) not null,salary int not null,mng_id int not null)";

//     String Query="create table pharmacist(id int not null,firstname varchar(255) not null,lastname varchar(255) not null,age int not null,hired_date varchar(50) not null,pharmacist_gender varchar(50) not null,phoneNumber varchar(100) not null,email varchar(255) not null,password varchar(255) not null,salary int not null,mng_id int not null)";
//      String Query="create table products(med_name varchar(255) not null,price int not null,expired_date varchar(50) not null,quantity int not null,category varchar(255) not null,description varchar(255) not null )";
//      String Query="create table customer(customer_id int not null,customer_firstname varchar(255) not null,customer_lastname varchar(255) not null,city varchar(255) not null,street varchar(255) not null,gender varchar(50) not null,phoneNumber_1 varchar(100) not null)";
//      String Query="create table orders (order_number int not null,order_price int not null,date varchar(50) not null,Payment_Type varchar(50) not null,delivery_ID int not null)";     
//      String Query="create table order_relation(Ph_ID int not null, C_ID int not null, ProductName varchar(255) not null , order_ID int not null )";
//      String Query="create table delivery (delivery_ID int not null, delivery_phoneNumber varchar(50) not null, name varchar(100) not null)";


     

       /*** DataBase Configurations ***/ 

//        Please Pay attention to the following :
//         1- Delete all tables in database and re- create it to make sure every thing working as it should be.
//         2- Run Each Query separatly , First Create Tables. 
//         3- Second Make Following Constrains: 
//            - Make (id) in pharmacist table primary key , AND DON'T MAKE IT AUTO INCREMENT 
//            - Make (delivery_ID) in delivery table primary key , AND DON'T MAKE IT AUTO INCREMENT 
//            - Make (customer_id) in customer table primary key and auto increment 
//            - Make (order_number) in orders table primary key and auto increment 
//            - Make (med_name) in products table primary key 
//         4- Then Run the Following Constrains Statments:

//              String Query="alter table orders add constraint ppx FOREIGN KEY (delivery_ID) REFERENCES Delivery(delivery_ID)";  // relation between order and delivery
//              String Query="alter table order_relation add constraint fx FOREIGN KEY (Ph_ID) REFERENCES pharmacist(id)";                    //  ...
//              String Query="alter table order_relation add constraint fxx FOREIGN KEY (C_ID) REFERENCES customer(customer_id)";             //  ...  > relations of order_relation
//              String Query="alter table order_relation add constraint fxxx FOREIGN KEY (ProductName) REFERENCES products(med_name)";        //  ...  
//              String Query="alter table order_relation add constraint fxxxx FOREIGN KEY (order_ID) REFERENCES orders(order_number)";        //  ...         
//                String Query="alter table reservation add constraint res FOREIGN KEY (pharmacist_ID) REFERENCES pharmacist(id)" ;    
//               String Query="alter table reservation add constraint ress FOREIGN KEY (Customer_ID) REFERENCES customer(customer_id)" ;
//               String Query ="alter table reservation add constraint resss FOREIGN KEY (Product_Name) REFERENCES products(med_name)";

                //5- Run the Follwing queryies as it is: 

//               String Query="insert into customer (customer_firstname,customer_lastname,city,street,gender,phoneNumber_1) values ('No Info' ,' ' ,'No Info' , 'No Info','No Info','No Info')";
              String Query="insert into delivery (delivery_ID, delivery_phoneNumber , name) values ('0' , 'NO INFO', 'NO INFO')";


              DBOperation.setDataOrDelete(Query,"created"); 
        
    }
}
