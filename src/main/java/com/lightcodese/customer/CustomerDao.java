package com.lightcodese.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);
}
