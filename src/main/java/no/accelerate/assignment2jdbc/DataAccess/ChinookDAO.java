package no.accelerate.assignment2jdbc.DataAccess;

import no.accelerate.assignment2jdbc.Models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class ChinookDAO {
    private String url;
    private String username;
    private String password;

    public ChinookDAO(
       @Value("${spring.datasource.url}") String url,
       @Value("${spring.datasource.username}") String username,
       @Value("${spring.datasource.password}") String password
       ){
        this.url =url;
        this.username = username;
        this.password = password;
    }

    public void testConnection() {
        try(Connection conn = DriverManager.getConnection(url,username,password)){
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Customer getCustomers(int id) {
        String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer WHERE customer_id = ?";
        Customer customer = null;
        try(Connection conn = DriverManager.getConnection(url,username,password)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            //Execute Query
             ResultSet result = statement.executeQuery();
             while (result.next()){
                 customer = new Customer(
                         result.getInt("customer_id"),
                         result.getString("first_name"),
                         result.getString("last_name"),
                         result.getString("country"),
                         result.getInt("postal_code"),
                         result.getInt("phone"),
                         result.getString("email")
                 );
             }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        /* String sql = "SELECT * FROM Customer"; */
        return customer;
    }

    public int insert(Customer customer) {
        return 0;
    }
}

