package com.lightcodese.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDao {
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer nhat = new Customer(1,"Nhat","nhat@gmail.com",22);
        customers.add(nhat);
        Customer messi = new Customer(2,"Messi","messi@gmail.com",36);
        customers.add(messi);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}
