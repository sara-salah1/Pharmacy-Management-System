package Modeling;

/**
 *
 * @author Seifeldin Ahmed
 */
public class Pharmacist_Model {
    private String Firstname,Lastname,gender,phonenumber,email,password,Hired_date;
    private int  id,salary,age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHired_date() {
        return Hired_date;
    }

    public void setHired_date(String Hired_date) {
        this.Hired_date = Hired_date;
    }


    public Pharmacist_Model(int id,String Hired_date,String Firstname, String Lastname, String gender, String phonenumber, String email, String password, int salary, int age) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.age = age;
        this.id=id;
        this.Hired_date=Hired_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
