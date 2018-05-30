package com.xunluyaoyao.web.pojo;

import java.util.List;

public class Category {
    private Integer id;

    private String name;

    private List<Product> products;

    private List<Category> nextCategorys;

    public List<Category> getNextCategorys() {
        return nextCategorys;
    }

    public void setNextCategorys(List<Category> nextCategorys) {
        this.nextCategorys = nextCategorys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
