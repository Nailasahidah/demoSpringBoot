package com.springboot.demospringboot_naila.Customer;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpaCustomer")
public class CustomerJPADataAccessService implements CustomerDao{

    public CustomerJPADataAccessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private final CustomerRepository customerRepository;
    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public boolean existPersonWithEmail(String email) {
        return customerRepository.existsCustomerByEmail(email);
    }

    @Override
    public boolean exitsPersonWithId(Integer customerId) {
        return customerRepository.existsCustomerById(customerId);
    }

    @Override
    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public void updateCustomer(Customer update) {
        customerRepository.save(update);
    }
}
