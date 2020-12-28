package Module4.Bai8;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QLHangHoa {
    ArrayList<HangHoa> ds;
    private Scanner scan;

    /**
     * 
     */
    public QLHangHoa() {
        ds = new ArrayList<HangHoa>();
    }

    public boolean them(HangHoa x) {
        if (x != null) {
            for (HangHoa i : ds) {
                if (i.getMaHang().equalsIgnoreCase(x.getMaHang())) {
                    System.out.println("Hang hoa da ton tai !!!");
                    return false;
                }
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public void xuatDS() {
        System.out.println("Xuat DS Hang Hoa");
        System.out.printf("%-12s %-20s %-13s %-10s %-20s %-13s %-13s %-10s %-10s\n", "Ma hang", "Ten hang", "Don Gia",
                "So Luong", "NSX/NCC", "Ngay SX/Nhap", "Ngay HH", "VAT", "Danh Gia");
        for (HangHoa i : ds) {
            System.out.println(i.toString());
        }
    }

    public void xuatDSHangDienMay() {
        System.out.println("Xuat DS Hang Dien May");
        System.out.printf("%-12s %-20s %-13s %-10s %-20s %-13s %-13s %-10s %-10s\n", "Ma hang", "Ten hang", "Don Gia",
                "So Luong", "NSX/NCC", "Ngay SX/Nhap", "Ngay HH", "VAT", "Danh Gia");
        for (HangHoa i : ds) {
            if (i instanceof HDienMay)
                System.out.println(i.toString());
        }
    }

    public void xuatDSHangSanhSu() {
        System.out.println("Xuat DS Hang Sanh Su");
        System.out.printf("%-12s %-20s %-13s %-10s %-20s %-13s %-13s %-10s %-10s\n", "Ma hang", "Ten hang", "Don Gia",
                "So Luong", "NSX/NCC", "Ngay SX/Nhap", "Ngay HH", "VAT", "Danh Gia");
        for (HangHoa i : ds) {
            if (i instanceof HSanhSu)
                System.out.println(i.toString());
        }
    }

    public void xuatDSHangThucPham() {
        System.out.println("Xuat DS Hang Thuc Pham");
        System.out.printf("%-12s %-20s %-13s %-10s %-20s %-13s %-13s %-10s %-10s\n", "Ma hang", "Ten hang", "Don Gia",
                "So Luong", "NSX/NCC", "Ngay SX/Nhap", "Ngay HH", "VAT", "Danh Gia");
        for (HangHoa i : ds) {
            if (i instanceof HThucPham)
                System.out.println(i.toString());
        }
    }

    public HangHoa timKiemHangHoa(String maHang) {
        HangHoa h = null;
        for (HangHoa i : ds) {
            if (i.getMaHang().equalsIgnoreCase(maHang)) {
                h = i;
                break;
            }
        }
        return h;
    }

    public void sapXepTheoTenHang() {
        Collections.sort(ds, new Comparator<HangHoa>() {
            public int compare(HangHoa h1, HangHoa h2) {
                return h1.getTenHang().compareToIgnoreCase(h2.getTenHang());
            }
        });
    }

    public void sapXepTheoSoLuongTon() {
        Collections.sort(ds, new Comparator<HangHoa>() {
            public int compare(HangHoa h1, HangHoa h2) {
                return Integer.compare(h2.getSoLuong(), h1.getSoLuong());
            }
        });
    }

    public void xuatDSHangKhoBan() {
        System.out.println("Xuat DS Hang Kho Ban");
        System.out.printf("%-12s %-20s %-13s %-10s %-20s %-13s %-13s %-10s %-10s\n", "Ma hang", "Ten hang", "Don Gia",
                "So Luong", "NSX/NCC", "Ngay SX/Nhap", "Ngay HH", "VAT", "Danh Gia");
        for (HangHoa i : ds) {
            if (i instanceof HThucPham)
                if (i.danhGia().equalsIgnoreCase("Kho ban"))
                    System.out.println(i.toString());
        }
    }

    public int xoa(String maHang) {
        scan = new Scanner(System.in);
        boolean check = false;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaHang().equalsIgnoreCase(maHang)) {
                int tempInput = 0;
                while (!check) {
                    System.out.println("Ban co chac ban: ");
                    System.out.println("1. co");
                    System.out.println("2. khong");
                    try {
                        scan = new Scanner(System.in);
                        tempInput = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("Khong hop le !!!");
                        check = false;
                    }
                    if (tempInput == 1 || tempInput == 2)
                        check = true;
                }
                if (tempInput == 1) {
                    ds.remove(i);
                    return 1;
                } else
                    return 0;
            }
        }
        return -1;
    }

    public boolean capNhapDonGiaHangHoa(String maHang) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        scan = new Scanner(System.in);
        double giaMoi = 0;
        boolean check = false;
        for (HangHoa i : ds) {
            if (i.getMaHang().equalsIgnoreCase(maHang)) {
                System.out.println("gia cu: " + df.format(i.getDonGia()));
                while (!check) {
                    try {
                        scan = new Scanner(System.in);
                        System.out.print("Nhap gia moi: ");
                        giaMoi = scan.nextDouble();
                        check = true;
                    } catch (Exception e) {
                        System.out.println("khong hop le");
                        check = false;
                    }
                }
                i.setDonGia(giaMoi);
                return true;
            }
        }
        return false;
    }
}
