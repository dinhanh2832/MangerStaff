package com.company.model;

import java.io.Serializable;

public class Position implements Serializable {
    private int id;
    private String position;
    private int salary;

    public Position(String position, int salary) {
        this.position = position;
        this.salary = salary;
    }

    public Position(int id,String position, int salary) {
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    public Position() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{ id = " + id +
                ", chức vụ = " + position +
                ", lương = " + salary +
                '}';
    }
}
