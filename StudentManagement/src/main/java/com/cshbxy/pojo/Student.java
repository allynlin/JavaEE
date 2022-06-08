package com.cshbxy.pojo;

import java.io.Serializable;

/**
 * @author Allyn
 */
public class Student implements Serializable {
  private int id;
  private String username;
  private int age;
  private String userclass;

  private String pimage;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getUserclass() {
    return userclass;
  }

  public void setUserclass(String userclass) {
    this.userclass = userclass;
  }

  public String getPimage() {
    return pimage;
  }

  public void setPimage(String pimage) {
    this.pimage = pimage;
  }
}
