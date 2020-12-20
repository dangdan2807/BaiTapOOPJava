package Module4.Bai7;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    ArrayList<Employee> ds;
    private Scanner scan;

    /**
     * 
     */
    public EmployeeManager() {
        ds = new ArrayList<Employee>();
    }

    public boolean them(Employee x) {
        if (x != null) {
            for (Employee i : ds) {
                if (i.getSsn() == x.getSsn()) {
                    System.out.println("Nhan Vien da ton tai !!!");
                    return false;
                }
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public boolean xoaTheoSSN(int ssn) {
        int tempInput = 0;
        boolean check = false;
        scan = new Scanner(System.in);
        for (Employee i : ds) {
            if (i.getSsn() == ssn) {
                System.out.println("Ban co chac chan: ");
                System.out.println("1. co");
                System.out.println("2. khong");
                while (!check) {
                    try {
                        scan = new Scanner(System.in);
                        System.out.println("Nhập lựa chọn: ");
                        tempInput = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("Không hợp lệ nhập lại: ");
                        check = false;
                    }
                    if (tempInput == 1 || tempInput == 2)
                        check = true;
                }
                if (tempInput == 1) {
                    ds.remove(i);
                    return true;
                } else
                    return false;
            }
        }
        return false;
    }

    public int thongKeSoLuongNhanVien() {
        return ds.size();
    }

    public void thongKeSoLuongTungLoaiNhanVien() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        double countSE = 0, countHE = 0, countCE = 0, countBPC = 0;
        for (Employee i : ds) {
            if (i instanceof SalariedEmployee)
                countSE++;
            else if (i instanceof HourlyEmployee)
                countHE++;
            else if (i instanceof CommissionEmployee)
                countCE++;
            else
                countBPC++;
        }
        System.out.println("Thong ke so luong tung loai nhan vien:");
        System.out.println("So Luong Nhan Vien Salaried Employee: " + df.format(countSE));
        System.out.println("So Luong Nhan Vien Hourly Employee: " + df.format(countHE));
        System.out.println("So Luong Nhan Vien Commission Employee: " + df.format(countCE));
        System.out.println("So Luong Nhan Vien Base Plus Commission: " + df.format(countBPC));
    }

    public double tongLuong() {
        double tien = 0;
        for (Employee i : ds) {
            tien += i.tinhLuong();
        }
        return tien;
    }

    public void tongLuongTungLoaiNhanVien() {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        double tienSE = 0, tienHE = 0, tienCE = 0, tienBPC = 0;
        for (Employee i : ds) {
            if (i instanceof SalariedEmployee)
                tienSE += i.tinhLuong();
            else if (i instanceof HourlyEmployee)
                tienHE += i.tinhLuong();
            else if (i instanceof CommissionEmployee)
                tienCE += i.tinhLuong();
            else
                tienBPC += i.tinhLuong();
        }
        System.out.println("Tong Tien Cua Loai Salaried Employee: " + df.format(tienSE));
        System.out.println("Tong Tien Cua Loai Hourly Employee: " + df.format(tienHE));
        System.out.println("Tong Tien Cua Loai Commission Employee: " + df.format(tienCE));
        System.out.println("Tong Tien Cua Loai Base Plus Commission: " + df.format(tienBPC));
    }

    public double tinhTongTrungBinhLuong() {
        int count = 0;
        double tien = 0;
        for (Employee i : ds) {
            tien += i.tinhLuong();
            count++;
        }
        return (tien / count);
    }

    public boolean capNhapThongTinNhanVien(int ssn, Employee x) {
        if (x != null) {
            for (Employee i : ds) {
                if (i.getSsn() == ssn) {
                    if (x instanceof SalariedEmployee && i instanceof SalariedEmployee) {
                        i = x;
                        return true;
                    } else if (x instanceof HourlyEmployee && i instanceof HourlyEmployee) {
                        i = x;
                        return true;
                    } else if (x instanceof CommissionEmployee && i instanceof CommissionEmployee) {
                        i = x;
                        return true;
                    } else if (x instanceof BasePlusCommission && i instanceof BasePlusCommission) {
                        i = x;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void xuatDSSalariedEmployee() {
        System.out.println("\nXuat Danh Sach Nhan Vien Salaried Employee");
        System.out.printf("%-20s %-20s %-10s %-15s %-15s %-15s %-15s\n", "Ho", "Ten", "SSN", "So Tuan", "Luong Tuan",
                "", "Tong Luong");
        for (Employee i : ds) {
            if (i instanceof SalariedEmployee)
                System.out.println(i);
        }
    }

    public void xuatDSHourlyEmployee() {
        System.out.println("\nXuat Danh Sach Nhan Vien Hourly Employee");
        System.out.printf("%-20s %-20s %-10s %-15s %-15s %-15s %-15s\n", "Ho", "Ten", "SSN", "So Gio", "Luong Gio", "",
                "Tong Luong");
        for (Employee i : ds) {
            if (i instanceof HourlyEmployee)
                System.out.println(i);
        }
    }

    public void xuatDSCommissionEmployee() {
        System.out.println("\nXuat Danh Sach Nhan Vien Commission Employee");
        System.out.printf("%-20s %-20s %-10s %-15s %-15s %-15s %-15s\n", "Ho", "Ten", "SSN", "Hoa Hong", "Luong DT", "",
                "Tong Luong");
        for (Employee i : ds) {
            if (i instanceof CommissionEmployee)
                System.out.println(i);
        }
    }

    public void xuatDSBasePlusCommission() {
        System.out.println("\nXuat Danh Sach Nhan Vien Base Plus Commission");
        System.out.printf("%-20s %-20s %-10s %-15s %-15s %-15s %-15s\n", "Ho", "Ten", "SSN", "Hoa Hong", "Luong DT",
                "Luong CB", "Tong Luong");
        for (Employee i : ds) {
            if (i instanceof BasePlusCommission)
                System.out.println(i);
        }
    }

    public void xuatDS() {
        System.out.println("\nXuat Danh Sach Nhan Vien");
        System.out.printf("%-20s %-20s %-10s %-15s %-15s %-15s %-15s\n", "Ho", "Ten", "SSN", "", "Luong", "Luong CB",
                "Tong Luong");
        for (Employee i : ds) {
            System.out.println(i);
        }
    }
}
