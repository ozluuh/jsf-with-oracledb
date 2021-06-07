package com.test.bean;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import com.test.dao.ConnectionFactory;
import com.test.dao.Persisted;
import com.test.model.Customer;

@ManagedBean
public class IndexBean {

    private static final EntityManager em = ConnectionFactory.getInstance().createEntityManager();

    private Customer customer = new Customer();

    private Persisted<Customer, Long> dao = new Persisted<Customer, Long>(em);

    public void execute() {
        dao.save(customer);

        try {
            dao.commit();
            System.out.println("\n\n\nStored: " + this.customer);
        } catch (Exception e) {
            System.out.println("\n\n\n" + e.getMessage());
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
