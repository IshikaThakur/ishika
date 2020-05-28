package com.ecommerceApp.ecommerceApp.rabbitMQ;

import com.ecommerceApp.ecommerceApp.entities.Product;

import java.io.Serializable;

public class Notification implements Serializable {
    private String msg;
    private Object object;

    public Notification() { }

    public Notification(String msg, Object object) {
        this.msg = msg;
        this.object = object;
    }

    public Notification(Product product) {
    }

    public Object getObject() { return object; }

    public void setObject(Object object) { this.object = object; }

    public String getMsg() { return msg; }

    public void setMsg(String msg) { this.msg = msg; }
}


