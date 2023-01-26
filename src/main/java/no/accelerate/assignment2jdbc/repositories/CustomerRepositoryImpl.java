package no.accelerate.assignment2jdbc.repositories;

import no.accelerate.assignment2jdbc.Models.Customer;
import no.accelerate.assignment2jdbc.Models.CustomerCountry;
import no.accelerate.assignment2jdbc.Models.CustomerGenre;
import no.accelerate.assignment2jdbc.Models.CustomerSpender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private final String url;
    private final String username;
    private final String password;

    public CustomerRepositoryImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password
    ){
        this.url =url;
        this.username = username;
        this.password = password;
    }

    /**
     * Read all the customers in the customer table. Returns a list of all customers.
     */
    @Override
    public List<Customer> findAll() {
        //Sql query to get all customers
        String sql = "SELECT * FROM customer ORDER BY customer_id";
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next() ) {
                Customer customer = new Customer(
                        result.getInt("customer_id"),
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

    /**
     * Read a specific customer from the customer table. Returns the customer based on id.
     */
    @Override
    public Customer findById(Integer id){
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        Customer customer = null;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            // Execute statement
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    /**
     * Reads a specific customer by name from the customer table. Returns the customer.
     */
    @Override
    public Customer getCustomerByName(String firstName, String lastName){
        String sql = "SELECT * FROM customer WHERE first_name LIKE ? AND last_name LIKE ?";
        Customer customer = null;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            // Execute statement
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    /**
     * Returns a list of customers from the customer table. The list
     * starts at offset with limit amount of customers.
     */
    @Override
    public List<Customer> pageOfCustomers(int limit, int offset){
        String sql = "SELECT * FROM customer ORDER BY customer_id LIMIT ? OFFSET ?";
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next()) {
                Customer customer = new Customer(
                        result.getInt("customer_id"),
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

    /**
     * Inserts the new customer.
     */
    @Override
    public int insert(Customer customer) {
        String sql = "INSERT INTO customer (first_name,last_name,country,postal_code,phone,email) VALUES (?,?,?,?,?,?)";
        int result = 0;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.firstname());
            statement.setString(2, customer.lastname());
            statement.setString(3, customer.country());
            statement.setString(4, customer.postalcode());
            statement.setString(5, customer.phone());
            statement.setString(6, customer.email());
            // Execute statement
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Updates the new customer.
     */
    @Override
    public void update(Customer customer, Integer id) {
        //Sql query for updating a customer
        String sql = "UPDATE customer " +
                "SET first_name = ?, last_name = ?, country = ?, postal_code = ?, phone = ?, email = ? " +
                "WHERE customer_id = ?";
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.firstname());
            statement.setString(2, customer.lastname());
            statement.setString(3, customer.country());
            statement.setString(4, customer.postalcode());
            statement.setString(5, customer.phone());
            statement.setString(6, customer.email());
            statement.setInt(7, id);
            // Execute statement
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * country with the most customers.
     * Returns the country with th most customers.
     */
    public CustomerCountry countryMostCustomers(){
        String sql = "SELECT country, count(*) FROM customer GROUP BY country ORDER BY count(*) DESC LIMIT 1";
        CustomerCountry winnerCountry = null;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next() ) {
                winnerCountry = new CustomerCountry(result.getString("country"),
                                                    result.getInt("count")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return winnerCountry;
    }

    /**
     * Gets Customer who is the highest spender.
     */
    public CustomerSpender highestSpender(){
        String sql = "SELECT CONCAT(first_name, ' ', last_name) as full_name, total FROM customer INNER JOIN invoice ON customer.customer_id = invoice.customer_id " +
                        "GROUP BY customer.customer_id, total ORDER BY total DESC LIMIT 1";
        CustomerSpender winnerSpender = null;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next() ) {
                winnerSpender = new CustomerSpender(result.getString("full_name"),
                        result.getDouble("total")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return winnerSpender;
    }

    /**
     * For a given customer, getting their most popular genre.
     * Returns a list with one or more CustomerGenres, depending
     * on if there is a tie between multiple genres.
     */
    @Override
    public List<CustomerGenre> mostPopularGenre(int id){
        String sql = "SELECT CONCAT(?, ' ', ?) as full_name," +
                "genre.name as genre, count(*) as total FROM customer " +
                "INNER JOIN invoice ON invoice.customer_id = customer.customer_id INNER JOIN invoice_line ON invoice.invoice_id = invoice_line.invoice_id INNER JOIN track ON track.track_id = invoice_line.track_id INNER JOIN genre ON track.genre_id = genre.genre_id WHERE customer.customer_id = ? GROUP BY customer.customer_id, genre.genre_id ORDER BY count(*) DESC FETCH FIRST 1 ROWS WITH TIES";

        List<CustomerGenre> winnerGenre = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, findById(id).firstname());
            statement.setString(2, findById(id).lastname());
            statement.setInt(3, id);

            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next() ) {
                winnerGenre.add(new CustomerGenre(result.getString("full_name"),
                        result.getString("genre"),
                        result.getString("total")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return winnerGenre;
    }

}
