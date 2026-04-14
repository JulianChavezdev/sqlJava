package DAO;

import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
   String url = "jdbc:sqlite:entregable.sqlite3";


    public void insertCustomer(Customer c) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO customers (name, email, phone, age, money_spent, products_purchased) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getPhone());
            pstmt.setInt(4, c.getAge());
            pstmt.setDouble(5, c.getMoneySpent());
            pstmt.setInt(6, c.getProductsPurchased());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    public void updateCustomer(Customer c, int id) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "UPDATE customers SET name = ?, email = ?, phone = ?, age = ?, money_spent = ?, products_purchased = ? " +
                    "WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getPhone());
            pstmt.setInt(4, c.getAge());
            pstmt.setDouble(5, c.getMoneySpent());
            pstmt.setInt(6, c.getProductsPurchased());
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteCustomer(int id) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "DELETE FROM customers WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Customer getCustomerById(int id) {
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM customers WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                double moneySpent = rs.getDouble("money_spent");
                int productsPurchased = rs.getInt("products_purchased");
                customer = new Customer(name, email, phone, age, moneySpent, productsPurchased);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } return customer;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM customers";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                double moneySpent = rs.getDouble("money_spent");
                int productsPurchased = rs.getInt("products_purchased");
                Customer c = new Customer(name, email, phone, age, moneySpent, productsPurchased);
                customerList.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customerList;
    }

    public List<Customer> getCustomersOver30() {
        List<Customer> customersOver30 = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM customers WHERE age > 30";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                double moneySpent = rs.getDouble("money_spent");
                int productsPurchased = rs.getInt("products_purchased");
                Customer c = new Customer(name, email, phone, age, moneySpent, productsPurchased);
                customersOver30.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customersOver30;
    }

    public List<Customer> getCustomersSpendingOver500() {
        List<Customer> customersOver500 = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM customers WHERE money_spent > 500";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                double moneySpent = rs.getDouble("money_spent");
                int productsPurchased = rs.getInt("products_purchased");
                Customer c = new Customer(name, email, phone, age, moneySpent, productsPurchased);
                customersOver500.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customersOver500;
    }

    public List<Customer> getCustomersOrderBySpending() {
        List<Customer> customersOrdered = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM customers ORDER BY money_spent DESC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                double moneySpent = rs.getDouble("money_spent");
                int productsPurchased = rs.getInt("products_purchased");
                Customer c = new Customer(name, email, phone, age, moneySpent, productsPurchased);
                customersOrdered.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customersOrdered;
    }

    public List<Customer> getTop3PurchasingCustomers() {
        List<Customer> topPurchasers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM customers ORDER BY products_purchased DESC LIMIT 3";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                double moneySpent = rs.getDouble("money_spent");
                int productsPurchased = rs.getInt("products_purchased");
                Customer c = new Customer(name, email, phone, age, moneySpent, productsPurchased);
                topPurchasers.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return topPurchasers;
    }

    public double getTotalRevenue() {
        double totalSum = 0.0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT SUM(money_spent) AS total_sum FROM customers";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                totalSum = rs.getDouble("total_sum");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return totalSum;
    }

    public double getAverageProductsPurchased() {
        double average = 0.0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT AVG(products_purchased) AS avg_products FROM customers";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                average = rs.getDouble("avg_products");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return average;
    }

    public double getAverageSpendingOver25() {
        double average = 0.0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT AVG(money_spent) AS avg_money " +
                    "FROM customers WHERE age > 25 " +
                    "AND products_purchased > 3";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                average = rs.getDouble("avg_money");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return average;
    }

    public int countCustomersSpendingOver100() {
        int count = 0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT COUNT(id) AS count_100 " +
                    "FROM customers WHERE money_spent > 100";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count_100");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return count;
    }

    public int countCustomersBetween30And50() {
        int count = 0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT COUNT(id) AS count_age " +
                    "FROM customers WHERE age BETWEEN 30 AND 50";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count_age");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return count;
    }

    public List<Customer> getCustomersSpendingOver200() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM customers WHERE money_spent > 200 " +
                    "ORDER BY products_purchased ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                double moneySpent = rs.getDouble("money_spent");
                int productsPurchased = rs.getInt("products_purchased");
                Customer c = new Customer(name, email, phone, age, moneySpent, productsPurchased);
                customerList.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customerList;
    }

    public Customer getYoungestHighSpender() {
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM customers WHERE money_spent > 400 ORDER BY age  LIMIT 1";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                double moneySpent = rs.getDouble("money_spent");
                int productsPurchased = rs.getInt("products_purchased");
                customer = new Customer(name, email, phone, age, moneySpent, productsPurchased);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customer;
    }
}