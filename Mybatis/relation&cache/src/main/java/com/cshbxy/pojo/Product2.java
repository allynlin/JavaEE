package com.cshbxy.pojo;

public class Product2 {
    private int id;
    private String goodsname;
    private double price;
    private int typeid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    @Override
    public String toString() {
        return "Product2{" +
                "id=" + id +
                ", goodsname='" + goodsname + '\'' +
                ", price=" + price +
                ", typeid=" + typeid +
                '}';
    }
}
