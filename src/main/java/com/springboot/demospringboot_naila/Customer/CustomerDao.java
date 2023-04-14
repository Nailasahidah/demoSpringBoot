package com.springboot.demospringboot_naila.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> selectAllCustomers();

    Optional<Customer> selectCustomerById(Integer id);

    void insertCustomer(Customer customer);

    boolean existPersonWithEmail(String email);

    boolean exitsPersonWithId(Integer customerId);

    void deleteCustomerById(Integer customerId);

    void updateCustomer(Customer update);
}
