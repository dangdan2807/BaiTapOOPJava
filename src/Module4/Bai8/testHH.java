package Module4.Bai8;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class testHH {
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

    public static LocalDate nhapNgay(String str) {
        int ngay = 0, thang = 0, nam = 0;
        ngay = Input(ngay, str);
        thang = Input(thang, str);
        nam = Input(nam, str);
        return LocalDate.of(nam, thang, ngay);
    }

    public static HangHoa nhap(int n) {
        String str = "";
        if (n == 1)
            str = "Thuc Pham";
        else if (n == 2)
            str = "Dien May";
        else
            str = "Sanh Su";
        System.out.println("Nhap thong tin cua hang hoa" + str);

        String maHang = "", tenHang = "", nsx = "";
        double donGia = 0;
        int soLuong = 0, congSuat = 0, thoiGianBaoHanh = 0;
        LocalDate ngaySX, ngayHH;
        maHang = Input(maHang, "ma hang");
        tenHang = Input(tenHang, "ten hang");
        donGia = Input(donGia, "don gia");
        soLuong = Input(soLuong, "so luong");
        HangHoa x = null;
        if (n == 1) {
            // Hang thuc pham
            nsx = Input(nsx, "NCC");
            ngaySX = nhapNgay("ngay san xuat");
            ngayHH = nhapNgay("ngay het han");
            x = new HThucPham(maHang, tenHang, donGia, soLuong, nsx, ngaySX, ngayHH);

        } else if (n == 2) {
            // Hang dien may
            thoiGianBaoHanh = Input(thoiGianBaoHanh, "thoi Gian Bao Hanh");
            congSuat = Input(congSuat, "cong xuat");
            x = new HDienMay(maHang, tenHang, donGia, soLuong, thoiGianBaoHanh, congSuat);
        } else {
            // Hang sanh su
            nsx = Input(nsx, "NSX");
            ngaySX = nhapNgay("ngay nhap kho");
            x = new HSanhSu(maHang, tenHang, donGia, soLuong, nsx, ngaySX);
        }
        return x;
    }

    public static void menu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Them Hang Hoa");
        System.out.println("2. Xuat DS tat ca Hang Hoa");
        System.out.println("3. Xuat DS Hang Thuc Pham");
        System.out.println("4. Xuat DS Hang Dien May");
        System.out.println("5. Xuat DS Hang Sang Su");
        System.out.println("6. Tim kiem hang hoa theo ma");
        System.out.println("7. Sap xep hang hoa tang dan theo ten");
        System.out.println("8. Sap xep hang hoa giam dan theo so luong ton kho");
        System.out.println("9. Xuat DS hang thuc pham kho ban");
        System.out.println("10. Xoa hang hoa theo ma hang");
        System.out.println("11. Cap nhat don gia hang hoa");
        System.out.println("0. Thoat chuong trinh");
        System.out.println("=============================");
    }

    public static void main(String[] args) {

        QLHangHoa ds = new QLHangHoa();
        int choose = 0, chon = 0;
        boolean check = false;
        int checkInput = 0;
        boolean checkBool = false;
        String maHang = "";
        ds.them(new HThucPham("TP01", "Ca say kho", 75000, 10, "A", LocalDate.of(2020, 11, 25),
                LocalDate.of(2020, 12, 25)));
        ds.them(new HThucPham("TP02", "Thit say kho", 100000, 10, "B", LocalDate.of(2020, 11, 25),
                LocalDate.of(2020, 11, 28)));
        ds.them(new HDienMay("DM01", "Tivi LG", 10000000, 5, 24, 1000));
        ds.them(new HDienMay("DM02", "Tu lanh", 7000000, 2, 60, 1000));
        ds.them(new HSanhSu("SS01", "Binh", 1000000, 20, "C", LocalDate.of(2020, 11, 25)));
        ds.them(new HSanhSu("SS02", "Am tra", 700000, 100, "D", LocalDate.of(2020, 10, 25)));

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
                    System.out.println("1. Them hang thuc pham");
                    System.out.println("2. Them hang diem may");
                    System.out.println("3. Them hang sanh su");
                    while (!check) {
                        chon = Input(chon, "lua chon");
                        if (chon == 1 || chon == 2 || chon == 3)
                            check = true;
                    }
                    HangHoa x = nhap(chon);
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
                    ds.xuatDSHangThucPham();
                    dungMangHinh();
                    break;
                case 4:
                    xoaMangHinh();
                    ds.xuatDSHangDienMay();
                    dungMangHinh();
                    break;
                case 5:
                    xoaMangHinh();
                    ds.xuatDSHangSanhSu();
                    dungMangHinh();
                    break;
                case 6:
                    xoaMangHinh();
                    maHang = Input(maHang, "ma hang");
                    HangHoa temp = ds.timKiemHangHoa(maHang);
                    if (temp != null)
                        System.out.println(temp.toString());
                    else
                        System.out.println("Khong tim thay hang hoa");
                    dungMangHinh();
                    break;
                case 7:
                    xoaMangHinh();
                    System.out.println("Sap xep tang dan theo ten hang hoa");
                    ds.sapXepTheoTenHang();
                    System.out.println("sap xep hoan tat");
                    dungMangHinh();
                    break;
                case 8:
                    xoaMangHinh();
                    System.out.println("Sap xep giam dan theo so luong ton kho");
                    ds.sapXepTheoSoLuongTon();
                    System.out.println("sap xep hoan tat");
                    dungMangHinh();
                    break;
                case 9:
                    xoaMangHinh();
                    ds.xuatDSHangKhoBan();
                    dungMangHinh();
                    break;
                case 10:
                    xoaMangHinh();
                    maHang = Input(maHang, "ma hang");
                    checkInput = ds.xoa(maHang);
                    if (checkInput == 1)
                        System.out.println("xoa thanh cong");
                    else if (checkInput == 0)
                        System.out.println("Ban quyet dinh khong xoa");
                    else
                        System.out.println("khong tim thay hang hoa");
                    dungMangHinh();
                    break;
                case 11:
                    xoaMangHinh();
                    maHang = Input(maHang, "ma hang");
                    checkBool = ds.capNhapDonGiaHangHoa(maHang);
                    if (checkBool == true)
                        System.out.println("cap nhat thanh cong");
                    else
                        System.out.println("khong tim thay hang hoa");
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
