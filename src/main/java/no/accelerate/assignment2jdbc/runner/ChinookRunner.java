package no.accelerate.assignment2jdbc.runner;


import no.accelerate.assignment2jdbc.Models.Customer;
import no.accelerate.assignment2jdbc.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ChinookRunner implements CommandLineRunner {

    @Autowired
    private final CustomerRepository customerRepository;

    public ChinookRunner(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //customerRepository.findAll().forEach(System.out::println);
        //customerRepository.getCustomerById(5);
        //customerRepository.getCustomerByName("Julia", "Barnett");
        //customerRepository.pageOfCustomers(5, 10).forEach(System.out::println);
        Customer yomi = new Customer(1, "Yomi", "Robera",
                "Norway", "0123", "40995599", "yomidw@gmail.com");
        //customerRepository.insert(yomi);
        Customer simen = new Customer(1, "Simen", "Skaarseth",
                "Norway", "1234", "99887766", "simen@gmail.com");
        customerRepository.update(simen, 62);
        customerRepository.findAll().forEach(System.out::println);
        //System.out.println(customerRepository.countryMostCustomers());
        System.out.println(customerRepository.highestSpender());
        Customer messi = new Customer(1, "Lionel", "Messi",
                "Argentina", "1234", "99887466", "messi@gmail.com");
        //customerRepository.insert(messi);
        System.out.println(customerRepository.mostPopularGenre(messi));
    }
}
