package com.cshbxy.pojo;

import java.util.List;

public class Category {
    private int id;
    private String typename;
    private List<Product2> product2List;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public List<Product2> getProduct2List() {
        return product2List;
    }

    public void setProduct2List(List<Product2> product2List) {
        this.product2List = product2List;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", product2List=" + product2List +
                '}';
    }
}
