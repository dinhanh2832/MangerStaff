package com.company.service.Impl;

import com.company.model.Position;
import com.company.model.Staff;
import com.company.service.ServicePosition;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServicePositionImpl implements ServicePosition {

    List<Position> positionList =new ArrayList<>();

    public ServicePositionImpl() {
//        positionList.add(new Position(1,"trưởng phòng", 10000));
//        positionList.add(new Position(2,"Kế toán", 9000));
//        positionList.add(new Position(3,"Nhân viên", 8000));
        positionList = readDataFromFile("Position.txt");
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < positionList.size(); i++) {
            if (positionList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(Position position) {
        int checkId = positionList.get(positionList.size() - 1).getId() + 1;
        position.setId(checkId);
        positionList.add(position);
        writeToFile("Position.txt",positionList);
    }

    @Override
    public void update(Position position, int id) {
        int index = findIndexById(id);
        positionList.set(index, position);
        writeToFile("Position.txt",positionList);
    }

    @Override
    public void deleteById(int id) {
        int index = findIndexById(id);
        positionList.remove(index);
        writeToFile("Position.txt",positionList);
    }

    @Override
    public void print() {
        for (Position st: positionList) {
            System.out.println(st);
        }
    }
    public boolean checkId(int id){
        for (Position st: positionList) {
            if(id == st.getId()){
                return true;
            }
        }
        return false;
    }
    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public static void writeToFile(String path, List<Position> positionList) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(positionList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Position> readDataFromFile(String path){
        List<Position> staff = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            staff = (List<Position>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return staff;
    }
}
