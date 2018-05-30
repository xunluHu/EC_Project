package com.xunluyaoyao.web.pojo;

public class ProductExtension {
    private Integer id;

    private Integer pid;

    private String TYPE;

    private String pansource;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE == null ? null : TYPE.trim();
    }

    public String getPansource() {
        return pansource;
    }

    public void setPansource(String pansource) {
        this.pansource = pansource == null ? null : pansource.trim();
    }
}