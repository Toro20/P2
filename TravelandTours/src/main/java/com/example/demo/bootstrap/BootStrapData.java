package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final DivisionRepository divisionRepository;


    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Division division1 = divisionRepository.findDivisionByIdAndAndCountry_id(2L, 1L);
        Customer customer1 = new Customer("FN1", "LN1", "address1", "11111", "1111111111", division1);

        division1.getCustomers().add(customer1);
        customerRepository.save(customer1);

        Division division2 = divisionRepository.findDivisionByIdAndAndCountry_id(4L, 1L);
        Customer customer2 = new Customer("FN2", "LN2", "address2", "22222", "2222222222", division2);

        division2.getCustomers().add(customer2);
        customerRepository.save(customer2);

        Division division3 = divisionRepository.findDivisionByIdAndAndCountry_id(5L, 1L);
        Customer customer3 = new Customer("FN3", "LN3", "address3", "33333", "3333333333", division3);

        division3.getCustomers().add(customer3);
        customerRepository.save(customer3);

        Division division4 = divisionRepository.findDivisionByIdAndAndCountry_id(10L, 1L);
        Customer customer4 = new Customer("FN4", "LN4", "address4", "44444", "4444444444", division4);

        division4.getCustomers().add(customer4);
        customerRepository.save(customer4);

        Division division5 = divisionRepository.findDivisionByIdAndAndCountry_id(20L, 1L);
        Customer customer5 = new Customer("FN5", "LN5", "address5", "55555", "5555555555", division5);

        division5.getCustomers().add(customer5);
        customerRepository.save(customer5);

    }




}
