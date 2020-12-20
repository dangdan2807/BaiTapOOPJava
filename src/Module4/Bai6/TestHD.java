package Module4.Bai6;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class TestHD {
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

    public static HoaDon nhap(int n) {
        String data = "";
        if (n == 1)
            data = "gio";
        else
            data = "ngay";
        System.out.println("Nhap thong tin cua hoa don " + data);

        String maHoaDon = "", tenKH = "", maPhong = "";
        int ngay = 0, thang = 0, nam = 0, donGia = 0, soNgayThue = 0, soGioThue = 0;
        maHoaDon = Input(maHoaDon, " ma Hoa Don");
        ngay = Input(ngay, "ngay lap hd");
        thang = Input(thang, "thang lap hd");
        nam = Input(nam, "nam lap hd");
        tenKH = Input(tenKH, "ten KH");
        maPhong = Input(maPhong, "ma phong");
        donGia = Input(donGia, "don gia");
        HoaDon x;
        if (n == 1) {
            // hoa don theo gio
            soGioThue = Input(soGioThue, "so gio thue");
            x = new HoaDonGio(maHoaDon, LocalDate.of(nam, thang, ngay), tenKH, maPhong, donGia, soGioThue);
        } else {
            // hoa don theo ngay
            soNgayThue = Input(soNgayThue, "so ngay thue");
            x = new HoaDonNgay(maHoaDon, LocalDate.of(nam, thang, ngay), tenKH, maPhong, donGia, soNgayThue);
        }
        return x;
    }

    public static void menu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Thêm Hoa Don");
        System.out.println("2. Xuất Hoa Don");
        System.out.println("3. Thong ke so luong hoa don theo gio");
        System.out.println("4. Thong ke so luong hoa don theo ngay");
        System.out.println("5. Tính Tong thành tiền của Hoa Don trong thang x, nam y");
        System.out.println("0. Thoát");
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        DanhSachHoaDon ds = new DanhSachHoaDon();
        int choose = 0, chon = 0;
        boolean check = false;
        // test case
        ds.them(new HoaDonGio("G01", LocalDate.of(2020, 5, 12), "A", "A", 100000, 15));
        ds.them(new HoaDonGio("G02", LocalDate.of(2020, 5, 1), "B", "A", 100000, 17));
        ds.them(new HoaDonNgay("N01", LocalDate.of(2019, 7, 12), "D", "B", 150000, 3));
        // ds.them(new HoaDonNgay("N02", LocalDate.of(2017, 5, 12), "E", "B", 150000, 10));

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
                    System.out.println("1. Tạo hoa don theo gio");
                    System.out.println("2. Tạo hoa don theo ngay");
                    while (!check) {
                        chon = Input(chon, "lua chon");
                        if (chon == 1 || chon == 2)
                            check = true;
                    }
                    HoaDon x;
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
                    System.out.println("Thong Ke So Luong HD Theo: " + ds.thongKeSoLuongHDTheoGio());
                    dungMangHinh();
                    break;
                case 4:
                    xoaMangHinh();
                    System.out.println("Thong Ke So Luong HD Ngay: " + ds.thongKeSoLuongHDTheoNgay());
                    dungMangHinh();
                    break;
                case 5:
                    xoaMangHinh();
                    int thang = 0, nam = 0;
                    thang = Input(thang, "thang");
                    nam = Input(nam, "nam");
                    System.out
                            .println("Tong Thanh Tien cua cac hoa don: " + df.format(ds.tinhTongThanhTien(thang, nam)));
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
