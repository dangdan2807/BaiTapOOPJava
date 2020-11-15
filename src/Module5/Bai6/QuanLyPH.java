package Module5.Bai6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyPH {
    ArrayList<PhongHoc> ds;

    /**
     * 
     */
    public QuanLyPH() {
        ds = new ArrayList<PhongHoc>();
    }

    public boolean themPH(PhongHoc x) {
        if (x != null) {
            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i).getMaPhong().equalsIgnoreCase(x.getMaPhong())) {
                    System.out.println("Phong da ton tai !!!");
                    return false;
                }
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public void xuatDS() {
        System.out.println("\nXuat Danh Sach Phong Hoc");
        System.out.printf("%-16s %-16s %-10s %-10s %-20s %-15s %-10s %-20s\n", "Ma Phong", "Day Nha", "Dien Tich",
                "Bong Den", "Chuyen Nganh", "Suc Chua", "Thiet Bi", "Dat Chuan");
        for (PhongHoc i : ds) {
            System.out.println(i);
        }
    }

    public void timKiemPH(String maPhong) {
        int check = 0;
        for (PhongHoc i : ds) {
            if (i.getMaPhong().equalsIgnoreCase(maPhong)) {
                System.out.printf("%-16s %-16s %-10s %-10s %-20s %-15s %-10s %-20s\n", "Ma Phong", "Day Nha",
                        "Dien Tich", "Bong Den", "Chuyen Nganh", "Suc Chua", "Thiet Bi", "Dat Chuan");
                System.out.println(i);
                return;
            }
        }
        if (check == 0)
            System.out.println("Khong tim thay!!!");
    }

    public void xuatDSDatChuan() {
        int check = 0;
        System.out.println("\nXuat Danh Sach Phong Hoc Dat Chuan");
        System.out.printf("%-16s %-16s %-10s %-10s %-20s %-15s %-10s %-20s\n", "Ma Phong", "Day Nha", "Dien Tich",
                "Bong Den", "Chuyen Nganh", "Suc Chua", "Thiet Bi", "Dat Chuan");
        for (PhongHoc i : ds) {
            if (i.kiemTra() == 1) {
                System.out.println(i);
                check = 1;
            }
        }
        if (check == 0)
            System.out.println("Khong tim thay!!!");
    }

    public void sapXepDSTangTheoDayNha() {
        Collections.sort(ds, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc o1, PhongHoc o2) {
                return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
            }
        });
    }

    public void sapXepDSGiamTheoDienTich() {
        Collections.sort(ds, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc o1, PhongHoc o2) {
                return Double.compare(o2.getDienTich(), o1.getDienTich());
            }
        });
    }

    public void sapXepDSTangTheoSoBongDien() {
        Collections.sort(ds, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc o1, PhongHoc o2) {
                return Integer.compare(o1.getSoBongDen(), o2.getSoBongDen());
            }
        });
    }

    // Overloading NhapSo()
    public static int nhapSo(int chon) {
        Scanner input = new Scanner(System.in);
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

    public boolean capNhatSoMayTinh(String maPhong) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof PhongMT && ds.get(i).getMaPhong().equalsIgnoreCase(maPhong)) {
                System.out.println("So may tich hien tai: " + ((PhongMT) ds.get(i)).getMayTinh());
                System.out.print("Nhap so may tinh moi: ");
                int so = 0;
                so = nhapSo(so);
                ((PhongMT) ds.get(i)).setMayTinh(so);
                return true;
            }
        }
        return false;
    }

    public boolean xoaPH(String maPhong) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaPhong().equalsIgnoreCase(maPhong)) {
                int check = 0;
                System.out.println("Ban co chan chan: ");
                System.out.println("1. Chan chan");
                System.out.println("2. Khong");
                System.out.print("Nhap lua chon: ");
                check = nhapSo(check);
                if (check == 1) {
                    ds.remove(i);
                    return true;
                }else
                    return true;
            }
        }
        return false;
    }

    public int tongSoPhongHoc() {
        return ds.size();
    }

    public void xuatDSPH60MT() {
        int check = 0;
        System.out.println("\nXuat Danh Sach Phong Hoc Co 60 Mat Tinh");
        System.out.printf("%-16s %-16s %-10s %-10s %-20s %-15s %-10s %-20s\n", "Ma Phong", "Day Nha", "Dien Tich",
                "Bong Den", "Chuyen Nganh", "Suc Chua", "Bon Chua", "Dat Chuan");
        for (PhongHoc i : ds) {
            if (i instanceof PhongMT) {
                if (((PhongMT)i).getMayTinh() == 60) {
                    System.out.println(i);
                    check = 1;
                }
            }
        }
        if (check == 0)
            System.out.println("Khong tim thay!!!");
    }
}
