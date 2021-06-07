package com.test.bean;

import javax.faces.bean.ManagedBean;

import com.test.model.Customer;

@ManagedBean
public class IndexBean {

    private Customer customer = new Customer();

    public void execute() {
        System.out.println("\n\n\nStored: " + this.customer);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
