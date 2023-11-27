package com.example.th1.service.customer;

import com.example.th1.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceIMPL implements ICustomerService {
    public static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "John", "HN", "john@example.com"));
        customerList.add(new Customer(2, "Huy", "HN", "huy@example.com"));
        customerList.add(new Customer(3, "Thinh", "HN", "thinh@example.com"));
        customerList.add(new Customer(4, "Duc", "HN", "duc@example.com"));
        customerList.add(new Customer(5, "Tinh", "HN", "tinh@example.com"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        if(findById(customer.getCustomerId()) == null) {
            customerList.add(customer);
        }else {
            customerList.set(customerList.indexOf(customer),customer);
        }
    }

    @Override
    public void deleteById(int id) {
        customerList.remove(findById(id));
    }

    @Override
    public Customer findById(int id) {
        for (Customer c : customerList) {
            if (c.getCustomerId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public int getNewId() {
        int idMax = 0;
        for (Customer c : customerList) {
            if (c.getCustomerId() > idMax) {
                idMax = c.getCustomerId();
            }
        }
        return idMax + 1;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> foundList = new ArrayList<>();
        for (Customer c : customerList) {
            if (c.getCustomerName().toLowerCase().contains(name.toLowerCase().trim())) {
                foundList.add(c);
            }
        }
        return foundList;
    }
}
