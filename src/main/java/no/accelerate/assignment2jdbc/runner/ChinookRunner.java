package no.accelerate.assignment2jdbc.runner;


import no.accelerate.assignment2jdbc.Models.Customer;
import no.accelerate.assignment2jdbc.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Alter the ChinookRunner to use the customer repository
@Component
public class ChinookRunner implements CommandLineRunner {

    @Autowired
    private final CustomerRepository customerRepository;

    public ChinookRunner(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) {
        printTask(1, "Read all customers");
        customerRepository.findAll().forEach(System.out::println);

        printTask(2, "Read a specific customer by id");
        System.out.println(customerRepository.findById(10));

        printTask(3, "Read a specific customer by name");
        System.out.println(customerRepository.getCustomerByName("Julia", "Barnett"));

        printTask(4, "Return a subset of customers with limit and offset");
        customerRepository.pageOfCustomers(7, 5).forEach(System.out::println);

        printTask(5, "Add a new customer");
        Customer yomi = new Customer(1, "Yomi", "Robera",
                "Norway", "0123", "40995577", "yomidw@gmail.com");
        customerRepository.insert(yomi);
        System.out.println(customerRepository.findById(customerRepository.findAll().size()));

        printTask(6, "Update an existing customer");
        Customer simen = new Customer(1, "Simen", "Skaarseth",
                "Norway", "1234", "99887755", "simen@gmail.com");
        customerRepository.update(simen, 30);
        customerRepository.pageOfCustomers(3, 28).forEach(System.out::println);
        printTask(7, "Return country with most customers");
        System.out.println(customerRepository.countryMostCustomers());

        printTask(8, "Return the highest spending customer");
        System.out.println(customerRepository.highestSpender());

        printTask(9, "Return their most popular genre of a customer");
        System.out.println("One genre: " + customerRepository.mostPopularGenre(6));
        System.out.println("Two genres: " + customerRepository.mostPopularGenre(12));
    }

    void printTask(int i, String s){
        System.out.println("\n********** TASK " + i + ": " + s + " **********");
    }
}
