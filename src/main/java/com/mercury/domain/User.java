package com.mercury.domain;

public class User {

    private Integer id;
    private String name;

    /**
     * jackson 对对象与json转换需要无参构造函数
     */
    public User() {
        super();
    }

    public User(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
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
        this.name = name;
    }
}
