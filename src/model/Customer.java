package model;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private int age;
    private double moneySpent;
    private int productsPurchased;

    public Customer(String name, String email, String phone, int age, double moneySpent, int productsPurchased) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.moneySpent = moneySpent;
        this.productsPurchased = productsPurchased;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }

    public int getProductsPurchased() {
        return productsPurchased;
    }

    public void setProductsPurchased(int productsPurchased) {
        this.productsPurchased = productsPurchased;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", moneySpent=" + moneySpent +
                ", productsPurchased=" + productsPurchased +
                '}';
    }
}