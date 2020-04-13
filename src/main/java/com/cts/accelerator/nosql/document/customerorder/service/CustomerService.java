package com.cts.accelerator.nosql.document.customerorder.service;

import com.cts.accelerator.nosql.document.customerorder.RecordNotFoundException;
import com.cts.accelerator.nosql.document.customerorder.domain.Customer;
import com.cts.accelerator.nosql.document.customerorder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

      public Customer updateCustomer(String customerId, Customer customerRec) {
        return customerRepository.findById(customerId)
                .map(customer -> {
                    customer.setName(customerRec.getName());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new RecordNotFoundException("Customer not found with id " + customerId));

    }

    public void deleteCustomer(String customerId) {
        Customer customer =
                customerRepository
                        .findById(customerId)
                        .orElseThrow(() -> new RecordNotFoundException("Customer not found on :: " + customerId));

        customerRepository.delete(customer);
    }
}
