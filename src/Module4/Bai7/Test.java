package Module4.Bai7;

import java.io.IOException;
import java.text.DecimalFormat;
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
        int n = 0;
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

    public static Employee nhap(int n) {
        String data = "";
        if (n == 1)
            data = "Salaried Employee";
        else if (n == 2)
            data = "Hourly Employee";
        else if (n == 3)
            data = "Commission Employee";
        else if (n == 4)
            data = "Base Plus Commission";
        System.out.println("Nhap thong tin cua hoa don " + data);

        String lastName = "", firstName = "";
        int ssn = 1, loai = 0;
        double luong = 0, luongCoBan = 0, hoaHong = 0;
        lastName = Input(lastName, "ho");
        firstName = Input(firstName, "ten");
        ssn = Input(ssn, "SSN");
        Employee x = null;
        if (n == 1) {
            // Salaried Employee
            luong = Input(luong, "luong theo tuan");
            loai = Input(loai, "so tuan lam viec");
            x = new SalariedEmployee(firstName, lastName, ssn, loai, luong);
        } else if (n == 2) {
            // Hourly Employee
            luong = Input(luong, "luong theo gio");
            loai = Input(loai, "so gio lam viec");
            x = new HourlyEmployee(firstName, lastName, ssn, loai, luong);
        } else if (n == 3) {
            // Commission Employee
            luong = Input(luong, "luong theo gio");
            hoaHong = Input(hoaHong, "so gio lam viec");
            x = new CommissionEmployee(firstName, lastName, ssn, hoaHong, luong);
        } else if (n == 4) {
            // Base Plus Commission
            luong = Input(luong, "luong theo gio");
            hoaHong = Input(hoaHong, "so gio lam viec");
            luongCoBan = Input(luongCoBan, "luong co ban");
            x = new BasePlusCommission(firstName, lastName, ssn, hoaHong, luong, luongCoBan);
        }
        return x;
    }

    public static void menu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Thêm 1 nhan vien");
        System.out.println("2. Xuất danh sach nhan vien");
        System.out.println("3. Xoa 1 nhan vien");
        System.out.println("4. Thong ke Tong so luong nhan vien");
        System.out.println("5. Thong ke so luong tung loai nhan vien");
        System.out.println("6. Tinh tong luong");
        System.out.println("7. Tinh tong luong tung loai nhan vien");
        System.out.println("8. Tinh tong trung binh luong nhan vien");
        System.out.println("9. Xuat danh sach cac Salaried Employee");
        System.out.println("10. Xuat danh sach cac Hourly Employee");
        System.out.println("11. Xuat danh sach cac commission Employee");
        System.out.println("12. Xuat danh sach cac Base Plus Commission");
        System.out.println("0. Thoát");
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        EmployeeManager ds = new EmployeeManager();
        int choose = 0, chon = 0;
        boolean check = false, kt = false;
        // test case
        ds.them(new SalariedEmployee("A", "1", 1, 1, 500000));
        ds.them(new SalariedEmployee("A", "2", 2, 4, 500000));
        ds.them(new HourlyEmployee("B", "1", 3, 30, 25000));
        ds.them(new HourlyEmployee("B", "2", 4, 50, 25000));
        ds.them(new CommissionEmployee("C", "1", 5, 0.5, 20000000));
        ds.them(new CommissionEmployee("C", "2", 6, 1, 25000000));
        ds.them(new BasePlusCommission("D", "1", 7, 0.5, 10000000, 5000000));
        ds.them(new BasePlusCommission("D", "1", 8, 0.7, 20000000, 5000000));
        do {
            xoaMangHinh();
            menu();
            choose = Input(choose, "lua chon");
            System.out.println("");
            switch (choose) {
                case 0:
                    System.out.println("Kết thúc Chương trình");
                    return;
                case 1:
                    xoaMangHinh();
                    input = new Scanner(System.in);
                    System.out.println("1. Them Salaried Employee");
                    System.out.println("2. Them Hourly Employee");
                    System.out.println("3. Them Commission Employee");
                    System.out.println("4. Them Base Plus Commission");
                    while (!check) {
                        chon = Input(chon, "lua chon");
                        if (chon == 1 || chon == 2 || chon == 3 || chon == 4)
                        check = true;
                    }
                    Employee x;
                    x = nhap(chon);
                    ds.them(x);
                    break;
                case 2:
                    xoaMangHinh();
                    ds.xuatDS();
                    dungMangHinh();
                    break;
                case 3:
                    xoaMangHinh();
                    int ssn = 0;
                    System.out.println("Xoa Nhan vien theo ma ssn");
                    ssn = Input(ssn, "nhap SSN");
                    kt = ds.xoaTheoSSN(ssn);
                    if (kt == true)
                        System.out.println("Xoa thanh cong");
                    else
                        System.out.println("Khong tim thay Nhan vien");
                    dungMangHinh();
                    break;
                case 4:
                    xoaMangHinh();
                    System.out.println("Tong so luong nhan vien: " + ds.thongKeSoLuongNhanVien());
                    dungMangHinh();
                    break;
                case 5:
                    xoaMangHinh();
                    ds.thongKeSoLuongTungLoaiNhanVien();
                    dungMangHinh();
                    break;
                case 6:
                    xoaMangHinh();
                    System.out.println("Tong luong cua tat ca nhan vien: " + df.format(ds.tongLuong()));
                    dungMangHinh();
                    break;
                case 7:
                    xoaMangHinh();
                    System.out.println("Tong luong tung loai nhan vien: ");
                    ds.tongLuongTungLoaiNhanVien();
                    dungMangHinh();
                    break;
                case 8:
                    xoaMangHinh();
                    System.out.println(
                            "Tong trung binh luong cua tat ca nhan vien: " + df.format(ds.tinhTongTrungBinhLuong()));
                    dungMangHinh();
                    break;
                case 9:
                    xoaMangHinh();
                    ds.xuatDSSalariedEmployee();
                    dungMangHinh();
                    break;
                case 10:
                    xoaMangHinh();
                    ds.xuatDSHourlyEmployee();
                    dungMangHinh();
                    break;
                case 11:
                    xoaMangHinh();
                    ds.xuatDSCommissionEmployee();
                    dungMangHinh();
                    break;
                case 12:
                    xoaMangHinh();
                    ds.xuatDSBasePlusCommission();
                    dungMangHinh();
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    dungMangHinh();
                    break;
            }
        } while (true);
    }
}
