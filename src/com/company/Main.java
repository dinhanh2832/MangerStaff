package com.company;

import com.company.model.Position;
import com.company.model.Staff;
import com.company.service.Impl.ServicePositionImpl;
import com.company.service.Impl.ServiceStaffImpl;
import com.company.service.ServiceStaff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ServiceStaffImpl serviceStaff = new ServiceStaffImpl();
        ServicePositionImpl servicePosition = new ServicePositionImpl();
//        ServicePositionImpl.writeToFile("Position.txt",servicePosition.getPositionList());
//        ServiceStaffImpl.writeToFile("DsNV.txt",serviceStaff.getStaffList());
//        ServiceStaffImpl.readDataFromFile("DsNV.txt");

        boolean choice = false;
        while (!choice) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Đây là mục lục !!!!!");
            System.out.println("1. Xem danh sách nhân viên");
            System.out.println("2. Thêm mới 1 nhân viên");
            System.out.println("3. Sửa nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Quản lý chức vụ");
            System.out.println("6. Sửa đổi chức vụ nhân viên");
            System.out.println("0. Exit");
            System.out.println("Nhập mục yên cầu");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    serviceStaff.print();
                    break;
                case 2:
                    System.out.println("Nhập tên: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    System.out.println("Nhập địa chỉ: ");
                    scanner.nextLine();
                    String address = scanner.nextLine();
                    System.out.println("Chọn chức vụ: ");
                    boolean choice2 = false;
                    Position position = new Position();
                    while (!choice2) {
                        System.out.println("Danh sách chức vụ !!!!!");
                        List<Integer> list3 = new ArrayList<>();
                        List<Position> positionList = servicePosition.getPositionList();
                        for (int i = 0; i < positionList.size(); i++) {
                            System.out.println(i + ". " + positionList.get(i).getPosition() + ", mức lương: " + positionList.get(i).getSalary());
                            list3.add(i);
                        }
                        System.out.println("Chọn chức vụ cần thêm: ");
                        int checkConfirmRe2 = scanner.nextInt();
                        boolean check = false;// cờ
                        for (int x : list3) {
                            if (x == checkConfirmRe2) {
                                check = true;
                            }
                        }
                        if (check) {
                            position.setId(checkConfirmRe2);
                            position.setPosition(servicePosition.getPositionList().get(checkConfirmRe2).getPosition());
                            position.setSalary(servicePosition.getPositionList().get(checkConfirmRe2).getSalary());
                            choice2 = true;
                        } else {
                            System.out.println("Vui lòng chọn số có trong danh sách");
                        }

                    }

                    Staff staff = new Staff(name, age, address, position);
                    serviceStaff.add(staff);
                    break;
                case 3:
                    Staff staff1 = new Staff();
                    System.out.println("Nhập vào id cần sửa");
                    int idCheck = scanner.nextInt();
                    if (serviceStaff.checkId(idCheck)) {
                        staff1 = serviceStaff.getStaffList().get(serviceStaff.findIndexById(idCheck));
                        System.out.println("Tìm thấy nhân viên");
                        System.out.println(staff1);
                        System.out.println("Nhập tên: ");
                        scanner.nextLine();
                        String udName = scanner.nextLine();
                        staff1.setName(udName);
                        System.out.println("Nhập tuổi: ");
                        int udAge = scanner.nextInt();
                        staff1.setAge(udAge);
                        System.out.println("Nhập địa chỉ: ");
                        scanner.nextLine();
                        String udAddress = scanner.nextLine();
                        staff1.setAddress(udAddress);
                        serviceStaff.update(staff1, idCheck);
                    } else {
                        System.out.println("Không tìm thấy nhân viên có id là " + idCheck);
                    }
                    break;
                case 4:
                    System.out.println("Nhập vào id cần xóa");
                    int idCheckDelete = scanner.nextInt();
                    if (serviceStaff.checkId(idCheckDelete)) {
                        Staff staff2 = serviceStaff.getStaffList().get(serviceStaff.findIndexById(idCheckDelete));
                        System.out.println(staff2);
                        boolean checkConfirm = false;
                        while (!checkConfirm) {
                            System.out.println("Bạn có chắc chắn muốn xóa ?");
                            System.out.println("1. Có");
                            System.out.println("2. Không");
                            int checkConfirmRe = scanner.nextInt();
                            switch (checkConfirmRe) {
                                case 1:
                                    serviceStaff.deleteById(idCheckDelete);
                                    System.out.println("Xóa thành công!!");
                                    checkConfirm = true;
                                    break;
                                case 2:
                                    checkConfirm = true;
                                    break;
                            }
                        }

                    } else {
                        System.out.println("Không tìm thấy nhân viên có id là " + idCheckDelete);
                    }
                    break;
                case 5:
                    boolean choince3 = false;
                    while (!choince3) {
                        System.out.println("Danh mục quản lý !!!");
                        System.out.println("1. Xem danh sách chức vụ");
                        System.out.println("2. Sửa chức vụ");
                        System.out.println("3. Thêm chức vụ mới");
                        System.out.println("4. Xóa chức vụ");
                        System.out.println("5. Thoát");
                        int input = scanner.nextInt();
                        switch (input) {
                            case 1:
                                servicePosition.print();
                                break;
                            case 2:
                                System.out.println("Nhập id cần sửa: ");
                                int idPos = scanner.nextInt();
                                if (servicePosition.checkId(idPos)) {
                                    Position position1 = new Position();
                                    System.out.println("Tìm thấy chức vụ");
                                    System.out.println(servicePosition.getPositionList().get(servicePosition.findIndexById(idPos)));
                                    System.out.println("Nhập vào tên chức vụ mới:");
                                    scanner.nextLine();
                                    String namePos = scanner.nextLine();
                                    System.out.println("Nhập vào mức lương: ");
                                    int salaryPos = scanner.nextInt();
                                    position1.setPosition(namePos);
                                    position1.setSalary(salaryPos);
                                    position1.setId(idPos);
                                    servicePosition.update(position1, idPos);
                                } else {
                                    System.out.println("Không tìm thấy chức vụ");
                                }
                                break;
                            case 3:
                                System.out.println("Nhập vào tên chức vụ:");
                                scanner.nextLine();
                                String namePos = scanner.nextLine();
                                System.out.println("Nhập vào mức lương: ");
                                int salaryPos = scanner.nextInt();
                                servicePosition.add(new Position(namePos, salaryPos));
                                break;
                            case 4:
                                System.out.println("Nhập vào Id chức vụ cần xóa:");
                                int idPosDelete = scanner.nextInt();
                                if (servicePosition.checkId(idPosDelete)) {
                                    System.out.println("Tìm thấy chức vụ");
                                    System.out.println(servicePosition.getPositionList().get(servicePosition.findIndexById(idPosDelete)));
                                    boolean checkConfirm1 = false;
                                    while (!checkConfirm1) {
                                        System.out.println("Bạn có chắc chắn muốn xóa ?");
                                        System.out.println("1. Có");
                                        System.out.println("2. Không");
                                        int checkConfirmRe = scanner.nextInt();
                                        switch (checkConfirmRe) {
                                            case 1:
                                                servicePosition.deleteById(idPosDelete);
                                                System.out.println("Xóa thành công!!");
                                                checkConfirm1 = true;
                                                break;
                                            case 2:
                                                checkConfirm1 = true;
                                                break;
                                        }
                                    }
                                }
                                break;
                            case 5:
                                choince3 = true;
                                break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Nhập vào id nhân viên cần sửa chức vụ:");
                    int idStaff = scanner.nextInt();
                    List<Position> list;
                    List<Integer> list2 = new ArrayList<>();
                    if (serviceStaff.checkId(idStaff)) {
                        System.out.println("Tìm tháy nhân viên");
                        System.out.println(serviceStaff.getStaffList().get(serviceStaff.findIndexById(idStaff)));
                        boolean checkConfirm2 = false;
                        list = servicePosition.getPositionList();
                        while (!checkConfirm2) {
                            System.out.println("Danh sách chức vụ");
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println(i + ". " + list.get(i).getPosition() + " mức lương: " + list.get(i).getSalary());
                                list2.add(i);
                            }
                            System.out.println("Chọn chức vụ cần đổi: ");
                            int checkConfirmRe1 = scanner.nextInt();
                            boolean check = false;
                            for (int x : list2) {
                                if (x == checkConfirmRe1) {
                                    check = true;
                                }
                            }
                            if (check) {
                                Position position1 = servicePosition.getPositionList().get(checkConfirmRe1);
                                serviceStaff.getStaffList().get(serviceStaff.findIndexById(idStaff)).setIdPosition(position1);
                                serviceStaff.update(serviceStaff.getStaffList().get(serviceStaff.findIndexById(idStaff)), idStaff);
                                System.out.println(serviceStaff.getStaffList().get(serviceStaff.findIndexById(idStaff)));
                                checkConfirm2 = true;
                            } else {
                                System.out.println("Vui lòng chọn số có trong danh sách");
                            }
                        }
                    } else {
                        System.out.println("Không tìm thấy nhân viên có id là " + idStaff);
                    }

                    break;
                case 0:
                    choice = true;
                    break;
                default:
                    System.out.println("Not select !");
            }
        }
    }
}
