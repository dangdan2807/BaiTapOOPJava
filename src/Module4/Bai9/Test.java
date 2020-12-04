package Module4.Bai9;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    static Scanner input = new Scanner(System.in);

    public static void dungMangHinh() {
        // 1. dừng màng hình
        // 0. không dừng màng hính
        int n = 1;
        if (n == 1) {
            System.out.println("\nẤn phím bất kì để tiếp tục");
            input = new Scanner(System.in);
            input.nextLine();
        }
    }

    // Clears Screen console in java
    // chi ap dung cho console (cmd/teminal)
    public static void xoaMangHinh() {
        // 1. xóa màng hình
        // 0. không xóa màng hính
        int n = 1;
        if (n == 1) {
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            } catch (IOException | InterruptedException ex) {
            }
        }
    }

    // Overloading
    public static int Input(int n, String str) {
        boolean check = false;
        while (!check) {
            try {
                input = new Scanner(System.in);
                System.out.print("Nhap " + str + ": ");
                n = input.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Khong hop le !!!");
                check = false;
            }
        }
        return n;
    }

    // Overloading
    public static double Input(double n, String str) {
        boolean check = false;
        while (!check) {
            try {
                input = new Scanner(System.in);
                System.out.print("Nhap " + str + ": ");
                n = input.nextDouble();
                check = true;
            } catch (Exception e) {
                System.out.println("Khong hop le !!!");
                check = false;
            }
        }
        return n;
    }

    // Overloading
    public static String Input(String n, String str) {
        boolean check = false;
        while (!check) {
            input = new Scanner(System.in);
            System.out.print("Nhap " + str + ": ");
            n = input.nextLine();
            if (n.equals("") || n.length() == 0) {
                System.out.println("Khong duoc rong !!!");
                check = false;
            } else
                check = true;
        }
        return n;
    }

    public static Person nhap(int n) {
        String str = "";
        if (n == 1)
            str = "Student";
        else if (n == 2)
            str = "Employee";
        else
            str = "Customer";
        System.out.println("Nhap thong tin cua " + str);

        String hoTen = "";
        hoTen = Input(hoTen, "ho Ten");

        String diaChi = "";
        diaChi = Input(diaChi, "dia Chi");

        double diemMH1 = 0, diemMH2 = 0;
        String tienDo = "";
        Person x = null;
        if (n == 1) {
            // Student
            diemMH1 = Input(diemMH1, "diem MH1");
            diemMH2 = Input(diemMH2, "diem MH2");
            x = new Student(hoTen, diaChi, diemMH1, diemMH2);
        } else if (n == 2) {
            // Employee
            diemMH1 = Input(diemMH1, "he so luong");
            diemMH2 = Input(diemMH2, "luong co ban");
            tienDo = Input(tienDo, "tien do hoan thanh (dat/ khong dat)");
            x = new Employee(hoTen, diaChi, diemMH1, diemMH2, tienDo);
        } else {
            // Customer
            tienDo = Input(tienDo, "ten cong ty");
            diemMH1 = Input(diemMH1, "gia tri hoa don");
            x = new Customer(hoTen, diaChi, tienDo, diemMH1);
        }
        return x;
    }

    public static void menu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Them Person");
        System.out.println("2. Xuat DS Person");
        System.out.println("3. Xoa hang hoa theo ma hang");
        System.out.println("4. Sap xep hang hoa tang dan theo ten");
        System.out.println("0. Thoat chuong trinh");
        System.out.println("=============================");
    }

    public static void main(String[] args) {
        Management ds = new Management();
        int choose = 0, chon = 0;
        boolean check = false;
        int checkInput = 0;
        String hoTen = "";
        ds.them(new Student("Nguyen Van A", "Q.7, tp.hcm", 8, 4));
        ds.them(new Student("Nguyen Van B", "Q.7, tp.hcm", 8, 10));
        ds.them(new Employee("Tran Van A", "Q.7, tp.hcm", 2.5, 2000000, "co"));
        ds.them(new Employee("Tran Van B", "Q.7, tp.hcm", 1.3, 3000000, "khong"));
        ds.them(new Customer("Vo Thi A", "Q.7, tp.hcm", "COOP A", 7800000));
        ds.them(new Customer("Vo Thi B", "Q.7, tp.hcm", "COOP C", 3000000));

        do {
            xoaMangHinh();
            menu();
            choose = Input(choose, "lua chon");

            switch (choose) {
                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    break;
                case 1:
                    xoaMangHinh();
                    input = new Scanner(System.in);
                    System.out.println("1. Them Student");
                    System.out.println("2. Them Employee");
                    System.out.println("3. Them Customer");
                    while (!check) {
                        chon = Input(chon, "lua chon");
                        if (chon == 1 || chon == 2 || chon == 3)
                            check = true;
                    }
                    Person x = nhap(chon);
                    ds.them(x);
                    dungMangHinh();
                    break;
                case 2:
                    xoaMangHinh();
                    ds.xuatDS();
                    dungMangHinh();
                    break;
                case 3:
                    xoaMangHinh();
                    hoTen = Input(hoTen, "ho ten");
                    checkInput = ds.xoa(hoTen);
                    if (checkInput == 1)
                        System.out.println("xoa thanh cong");
                    else if (checkInput == 0)
                        System.out.println("Ban quyet dinh khong xoa");
                    else
                        System.out.println("khong tim thay");
                    dungMangHinh();
                    break;
                case 4:
                    xoaMangHinh();
                    System.out.println("Sap xep tang dan theo ten");
                    ds.sapXepTheoTen();
                    System.out.println("sap xep hoan tat");
                    dungMangHinh();
                    break;
                default:
                    System.out.println("Lua chon khong hop le !!!");
                    dungMangHinh();
                    break;
            }
        } while (choose != 0);
    }
}
