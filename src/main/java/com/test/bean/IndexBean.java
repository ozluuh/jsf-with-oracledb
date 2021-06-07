package com.test.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {

    public void execute() {
        System.out.println("\n\n\nIf you see this on server log, it successful worked");
    }
}
