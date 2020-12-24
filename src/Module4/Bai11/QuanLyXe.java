package Module4.Bai11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyXe {
    ArrayList<Xe> ds;

    /**
     * 
     */
    public QuanLyXe() {
        ds = new ArrayList<Xe>();
    }

    public boolean them(Xe x) {
        if (x != null) {
            if (ds.contains(x)) {
                System.out.println("Xe da ton tai !!!");
                return false;
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public int tongSoXeDap() {
        int count = 0;
        for (Xe i : ds) {
            if (i instanceof xeDap)
                count++;
        }
        return count;
    }

    public int tongSoXeMay() {
        int count = 0;
        for (Xe i : ds) {
            if (i instanceof xeMay)
                count++;
        }
        return count;
    }

    public int tongSoXeOToKhach() {
        int count = 0;
        for (Xe i : ds) {
            if (i instanceof xeOToKhach)
                count++;
        }
        return count;
    }

    public int tongSoXeOToTai() {
        int count = 0;
        for (Xe i : ds) {
            if (i instanceof xeOToTai)
                count++;
        }
        return count;
    }

    public double tongTrungBinhThanhTien() {
        double tien = 0;
        for (Xe i : ds) {
            tien += i.thanhTien();
        }
        return (tien / ds.size());
    }

    public void sapXepTangDanTheoThanhTien() {
        Collections.sort(ds, new Comparator<Xe>() {
            public int compare(Xe h1, Xe h2) {
                return Double.compare(h1.thanhTien(), h2.thanhTien());
            }
        });
    }

    public void xuatDS() {
        System.out.println("\nXuat Danh Sach");
        System.out.printf("%-15s %-20s %-15s %-10s %-10s %-20s %-10s %-10s %-10s\n", "Ma xe", "Ten xe", "Don Gia", "Khac", "thue TT",
                "Loai Xe", "VAT", "Thue TB", "Thanh Tien");
        for (Xe i : ds) {
            System.out.println(i);
        }
    }

    public void xuatDSXeDap() {
        System.out.println("\nXuat Danh Sach Xe Dap");
        System.out.printf("%-15s %-20s %-15s %-10s %-10s %-20s %-10s %-10s %-10s\n", "Ma xe", "Ten xe", "Don Gia", "Khac", "thue TT",
                "Loai Xe", "VAT", "Thue TB", "Thanh Tien");
        for (Xe i : ds) {
            if (i instanceof xeDap) {
                System.out.println(i);
            }
        }
    }

    public void xuatDSXeMay() {
        System.out.println("\nXuat Danh Sach Xe May");
        System.out.printf("%-15s %-20s %-15s %-10s %-10s %-20s %-10s %-10s %-10s\n", "Ma xe", "Ten xe", "Don Gia", "Khac", "thue TT",
                "Loai Xe", "VAT", "Thue TB", "Thanh Tien");
        for (Xe i : ds) {
            if (i instanceof xeMay) {
                System.out.println(i);
            }
        }
    }

    public void xuatDSXeOToKhach() {
        System.out.println("\nXuat Danh Sach Xe O To Khach");
        System.out.printf("%-15s %-20s %-15s %-10s %-10s %-20s %-10s %-10s %-10s\n", "Ma xe", "Ten xe", "Don Gia", "Khac", "thue TT",
                "Loai Xe", "VAT", "Thue TB", "Thanh Tien");
        for (Xe i : ds) {
            if (i instanceof xeOToKhach) {
                System.out.println(i);
            }
        }
    }

    public void xuatDSXeOToTai() {
        System.out.println("\nXuat Danh Sach Xe O To Tai");
        System.out.printf("%-15s %-20s %-15s %-10s %-10s %-20s %-10s %-10s %-10s\n", "Ma xe", "Ten xe", "Don Gia", "Khac", "thue TT",
                "Loai Xe", "VAT", "Thue TB", "Thanh Tien");
        for (Xe i : ds) {
            if (i instanceof xeOToTai) {
                System.out.println(i);
            }
        }
    }
}
