package com.cshbxy;

public class User2 {
    private int id;
    private String name;
    private int password;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}
