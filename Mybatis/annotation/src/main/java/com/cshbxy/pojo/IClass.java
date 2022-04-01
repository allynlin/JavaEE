package com.cshbxy.pojo;

import java.util.List;

public class IClass {
    private int id;
    private String classname;
    private List<IStudent> studentList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public List<IStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<IStudent> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "IClass{" +
                "id=" + id +
                ", classname='" + classname + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
