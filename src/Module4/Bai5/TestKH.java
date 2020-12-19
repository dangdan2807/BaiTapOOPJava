package Module4.Bai5;

import java.io.*;
import java.text.*;
import java.time.*;
import java.util.*;

public class TestKH {
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

    public static KhachHang nhap(int n) {
        KhachHang gd;
        System.out.println("Nhap thong tin giao dich\n");

        String maKH = "", tenKH = "", loai = "";
        int ngay = 0, thang = 0, nam = 0, soKW = 0, donGia = 0, dinhMuc = 0;
        maKH = Input(maKH, "ma KH");
        tenKH = Input(tenKH, "ten KH");
        ngay = Input(ngay, "ngay lap hd");
        thang = Input(thang, "thang lap hd");
        nam = Input(nam, "nam lap hd");
        soKW = Input(soKW, "so KW");
        donGia = Input(donGia, "don gia");
        if (n == 2) {
            // khach hang nuoc ngoai
            loai = Input(loai, "quoc tich");
            gd = new KHNuocNgoai(maKH, tenKH, LocalDate.of(nam, thang, ngay), soKW, donGia, loai);
        } else {
            // khach hang viet name
            loai = Input(loai, "doi tuong(sinh hoat/kinh doanh/san xuat)");
            dinhMuc = Input(dinhMuc, "din hMuc");
            gd = new KHVietNam(maKH, tenKH, LocalDate.of(nam, thang, ngay), soKW, donGia, loai, dinhMuc);
        }
        return gd;
    }

    public static void menu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Thêm Khách Hàng");
        System.out.println("2. Xuất Khách Hàng");
        System.out.println("3. Xuất tổng số lượng của từng loại Khách Hàng");
        System.out.println("4. Tính trung bình thành tiền của Khách Hàng người Nước Ngoài");
        System.out.println("5. Xuất ra các Khách Hàng của tháng 9 năm 2018");
        System.out.println("0. Thoát");
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        QLKhachHang ds = new QLKhachHang();
        int choose = 0, chon = 0;
        boolean check = false;
        // ds.themKH(new KHVietNam("VN01", "Phạm Văn Toàn", LocalDate.of(2018, 9, 25), 100, 3000, "Sinh hoạt", 200));
        // ds.themKH(new KHVietNam("VN02", "Nguyễn Tấn Thanh", LocalDate.of(2020, 9, 16), 210, 3000, "Kinh Doanh", 200));
        // ds.themKH(new KHNuocNgoai("NN01", "Trần Thanh Minh", LocalDate.of(2017, 4, 3), 200, 3200, "USA"));
        // ds.themKH(new KHNuocNgoai("NN02", "Trần Ngọc Ngân", LocalDate.of(2018, 9, 3), 100, 3200, "Singapore"));

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
                    System.out.println("1. Tạo khách hàng người Việt Nam");
                    System.out.println("2. Tạo khách hàng người nước ngoài");
                    while (!check) {
                        chon = Input(chon, "lua chon");
                        if (chon == 1 || chon == 2)
                            check = true;
                    }
                    KhachHang gd;
                    gd = nhap(chon);
                    ds.themKH(gd);
                    break;
                case 2:
                    xoaMangHinh();
                    ds.xuatDS();
                    dungMangHinh();
                    break;
                case 3:
                    xoaMangHinh();
                    ds.tinhTongSoLuongTungLoaiKH();
                    dungMangHinh();
                    break;
                case 4:
                    xoaMangHinh();
                    System.out.println("Xuất tổng thành tiền của khách hàng người nước ngoài: "
                            + df.format(ds.tinhTBThanhTienKHNN()));
                    dungMangHinh();
                    break;
                case 5:
                    xoaMangHinh();
                    ds.xuatDSHD092018();
                    dungMangHinh();
                    break;
                default:
                    System.out.println("Khong hop le !!!");
                    dungMangHinh();
                    break;
            }
        } while (true);
    }
}
