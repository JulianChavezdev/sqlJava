 import DAO.CustomerDAO;
 import model.Customer;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;

 void main() {
 CustomerDAO cd = new CustomerDAO();
 Customer c = new Customer("Julian", "Julian@example.com", "60044444", 25, 1600, 2);

 //cd.insertCustomer(c);
  System.out.println("Customer inserted successfully " + c);
 //c.setAge(26);
 //cd.updateCustomer(c,11);
  System.out.println("Customer updated successfully " + c.getAge());
 //cd.deleteCustomer(11);
  System.out.println("Customer deleted successfully " + c);

  System.out.println("Customer details successfully " + cd.getCustomerById(2));
  System.out.println("All Customers " + cd.getAllCustomers());
  System.out.println("Customers over 30 " + cd.getCustomersOver30());
  System.out.println("Customers spending over 500€ " + cd.getCustomersSpendingOver500());
  System.out.println("Customers order by money spended " + cd.getCustomersOrderBySpending());
  System.out.println("Top 3 purchasing Customers " + cd.getTop3PurchasingCustomers());
  System.out.println("Total revenue " + cd.getTotalRevenue());
  System.out.println("Average " + cd.getAverageProductsPurchased());
  System.out.println("Average spended for customers over 25 " + cd.getAverageSpendingOver25());
  System.out.println("Count of customers that spend over 100€ " + cd.countCustomersSpendingOver100());
  System.out.println("Count of costumers over 30 y 50 years " + cd.countCustomersBetween30And50());
  System.out.println("Costumers spending  over 200€ ordered by purchased products " + cd.getCustomersSpendingOver200());
  System.out.println("Costumer younger that spend more than 400€ " +cd.getYoungestHighSpender());


 }
