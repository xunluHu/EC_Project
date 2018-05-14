package com.xunluyaoyao.web.pojo;

public class OrderItem {
    private int id;
    private int pid;
    private int uid;
    private int number;
    private Product product;
    private float subTotal;

    public float getSubTotal() {
        return this.subTotal = product != null ? product.getOriginalPrice() * number : 0;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
