package DeThi2019;

import java.util.ArrayList;
import java.util.Scanner;

public class QLNhanVien {
    ArrayList<NhanVien> ds;

    static Scanner input = new Scanner(System.in);

    /**
     * 
     */
    public QLNhanVien() {
        ds = new ArrayList<NhanVien>();
    }

    public boolean them(NhanVien x) {
        if (x != null) {
            if (ds.contains(x)) {
                System.out.println("Nhan Vien da ton tai !!!");
                return false;
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public double tinhTongTienLuong() {
        double tien = 0;
        for (NhanVien i : ds) {
            tien += i.tinhLuong();
        }
        return tien;
    }

    // Overloading NhapSo()
    public static int nhapSo(int chon) {

        boolean checkInput = true;
        while (true) {
            try {
                chon = input.nextInt();
                checkInput = true;
            } catch (Exception e) {
                System.out.println("Không hợp lệ nhập lại: ");
                checkInput = false;
                input.nextLine();
            }
            if (checkInput == true)
                break;
        }
        return chon;
    }

    public boolean capNhapSoNgayCong(String maNV) {
        for (NhanVien i : ds) {
            if (i instanceof NhanVienHopDong) {
                if (i.getMaNV().equalsIgnoreCase(maNV)) {
                    System.out.println("So Ngay Cong hien tai: " + ((NhanVienHopDong) i).getSoNgayCong());
                    int ngay = 0;
                    System.out.print("Nhap so ngay cong: ");
                    ngay = nhapSo(ngay);
                    ((NhanVienHopDong) i).setSoNgayCong(ngay);
                    return true;
                }
            }
        }
        return false;
    }

    public void DSNVKhongHoanThanh() {
        System.out.println("\nXuat Danh Sach Nhan Vien Khong Hoan Thanh Dung Tien Do");
        System.out.printf("%-10s %-20s %-15s %-15s %-17s %-15s\n", "Ma NV", "Ten NV", "Ngay Vao Lam", "He So Luong",
                "Tien Do CV", "Luong");
        for (NhanVien i : ds) {
            if (i instanceof NhanVienBienChe)
                if (((NhanVienBienChe) i).getTienDo() == false) {
                    System.out.println(i);
                }
        }
    }

    public ArrayList<NhanVien> LayDSNVHoanThanh() {
        ArrayList<NhanVien> ds2 = new ArrayList<NhanVien>();
        for (NhanVien i : ds) {
            if (i instanceof NhanVienBienChe)
                if (((NhanVienBienChe) i).getTienDo() == true) {
                    ds2.add(i);
                }
        }
        return ds2;
    }

    public void xuatDS() {
        System.out.println("\nXuat Danh Sach Nhan Vien");
        System.out.printf("%-10s %-20s %-15s %-15s %-17s %-15s\n", "Ma NV", "Ten NV", "Ngay Vao Lam", "He So Luong",
                "Tien Do CV", "Luong");
        for (NhanVien i : ds) {
            System.out.println(i);
        }
    }
}
