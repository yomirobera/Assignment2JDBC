package no.accelerate.assignment2jdbc;

import no.accelerate.assignment2jdbc.DataAccess.ChinookDAO;
import no.accelerate.assignment2jdbc.runner.ChinookRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment2JdbcApplication implements CommandLineRunner {


    public static void main(String[] args) {

        SpringApplication.run(Assignment2JdbcApplication.class, args);
        System.out.println("yo");
        ChinookDAO chinookDAO = new ChinookDAO();
        chinookDAO.testConnection();
        System.out.println("What it do");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
