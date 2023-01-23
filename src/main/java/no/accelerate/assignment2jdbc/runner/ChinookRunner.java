package no.accelerate.assignment2jdbc.runner;


import no.accelerate.assignment2jdbc.DataAccess.ChinookDAO;
import no.accelerate.assignment2jdbc.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ChinookRunner implements CommandLineRunner {
    private final CustomerRepository chinookDAO;

    public ChinookRunner(CustomerRepository chinookDAO) {
        this.chinookDAO = chinookDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        chinookDAO.toString();
    }
}
