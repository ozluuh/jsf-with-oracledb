package com.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_CUSTOMER_SAMPLE")
public class Customer {

    @Id
    private Long id;

    private String name;

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + "]";
    }

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
