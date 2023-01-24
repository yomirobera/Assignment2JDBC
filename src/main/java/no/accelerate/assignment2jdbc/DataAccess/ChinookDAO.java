package no.accelerate.assignment2jdbc.DataAccess;

import no.accelerate.assignment2jdbc.Models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChinookDAO {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public void testConnection() {
        try(Connection conn = DriverManager.getConnection(url,username,password)){
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    //Get all info from customer
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customer";
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next()) {
                Customer customer = new Customer(
                        result.getString("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }


/*    //2. Read a specific customer from database by id.
    String sq2 = "SELECT * FROM customers WHERE Id = ?";


    //3.Read a specific customer by name using LIKE Keyword
    String sql3 = "SELECT * FROM customer WHERE first_name LIKE ?";

    //4. Query that uses LIMIT AND OFFSET keywords to get a subset of the customer data.
    String sql4 = "SELECT * FROM customer LIMIT ? OFFSET ?";
    PreparedStatement statement = conn.prepareStatement(sql4);
    statement.setInt(1,limit);
    statement.setInt(2,offset);
    ResultSet result = statement.executeQuery();

    //5 Inserting in customers table
    String sql5 = "INSERT INTO customers (first_name,last_name,country,postal_code,phone,email) VALUES (?,?,?,?,?,?)";
    PreparedStatement statement = conn.prepareStatement(sql5);
    statement.setString(1,firstname);
    statement.setString(2,lastname);
    statement.setString(3,country);
    statement.setString(4,postalcode);
    statement.setString(5,phonenumber);
    statement.setString(6,email);
    int customersInserted = statement.executeUpdate();


    //6. Updating customer
    String sql6 = "UPDATE customers SET first_name=?,last_name=?,country=?,postal_code=?,phone,email=? WHERE Id=?";
    PreparedStatement statement = conn.prepareStatement(sql6);
    statement.setString(1,firstname);
    statement.setString(2,lastname);
    statement.setString(3,county);
    statement.setString(4,postalcode);
    statement.setString(5,phone);
    statement.setString(6,email);
    statement.setString(7,Id);
    int customerUpdated = statement.executeUpdate();

    //7. Query that returns country with the most customers
    String sql7 = "SELECT country (*) as Customers_numbers FROM customers GROUP BY country ORDER BY Customers_numbers DESC";

    //8. (combining customer with invoice table?)
    //9. (combining customer with genre and track)

 */

}

