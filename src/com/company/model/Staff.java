package com.company.model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int id ;
    private String name;
    private int age;
    private String address;
    private Position position;

    public Staff( String name, int age, String address, Position position) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.position = position;
    }

    public Staff(int id, String name, int age, String address, Position position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.position = position;
    }

    public Staff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getIdPosition() {
        return position;
    }

    public void setIdPosition(Position idPosition) {
        this.position = idPosition;
    }

    @Override
    public String toString() {
        return "Nhân viên {" +
                "id = " + id +
                ", tên = " + name +
                ", tuổi = " + age +
                ", địa chỉ = " + address +
                ", chức vụ = "  + position.getPosition() +
                ", luong = "  + position.getSalary() +
                '}';
    }
}
