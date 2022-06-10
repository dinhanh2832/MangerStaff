package com.company.service.Impl;

import com.company.model.Position;
import com.company.model.Staff;
import com.company.service.ServicePosition;
import com.company.service.ServiceStaff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceStaffImpl implements ServiceStaff {

    List<Staff> staffList = new ArrayList<>();
    ServicePositionImpl servicePosition = new ServicePositionImpl();

    public ServiceStaffImpl(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public ServiceStaffImpl() {
//        staffList.add(new Staff(1,"anh",18,"hn",servicePosition.getPositionList().get(0)));
//        staffList.add(new Staff(2,"anh",18,"hn",servicePosition.getPositionList().get(1)));
//        staffList.add(new Staff(3,"anh",18,"hn",servicePosition.getPositionList().get(2)));
//        staffList.add(new Staff(4,"anh",18,"hn",servicePosition.getPositionList().get(0)));
        staffList = readDataFromFile("DsNV.txt");
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(Staff staff) {
        int checkId = staffList.get(staffList.size() - 1).getId() + 1;
        staff.setId(checkId);
        staffList.add(staff);
        writeToFile("DsNV.txt",staffList);
    }

    @Override
    public void update(Staff staff, int id) {
        int index = findIndexById(id);
        staffList.set(index, staff);
        writeToFile("DsNV.txt",staffList);
    }

    @Override
    public void deleteById(int id) {
        int index = findIndexById(id);
        staffList.remove(index);
        writeToFile("DsNV.txt",staffList);
    }

    @Override
    public void print() {
        List<Staff> list = readDataFromFile("DsNV.txt");
        for (Staff st: list) {
            System.out.println(st);
        }
    }
    public boolean checkId(int id){
        for (Staff st: staffList) {
            if(id == st.getId()){
                return true;
            }
        }
        return false;
    }
    public static void writeToFile(String path, List<Staff> staffList) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(staffList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Staff> readDataFromFile(String path){
        List<Staff> staff = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            staff = (List<Staff>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return staff;
    }
}
