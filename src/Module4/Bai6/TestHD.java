package Module4.Bai6;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class TestHD {
    static Scanner input = new Scanner(System.in);

    // dừng màng hình để xem kết quả
    public static void dungMangHinh() {
        // check co dung hay khong
        int n = 1;
        if (n == 1) {
            System.out.println("\nẤn phím bất kì để tiếp tục");
            input = new Scanner(System.in);
            input.nextLine();
        }
    }

    // Clears Screen console in java
    public static void clrscr() {
        // chi ap dung cho console (cmd/teminal)
        int n = 1;
        if(n == 1)
        {
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            } catch (IOException | InterruptedException ex) {
            }
        }
    }

    // Overloading Input()
    public static String Input(String str) {
        boolean check = false;
        while (!check) {
            input = new Scanner(System.in);
            str = input.nextLine();
            if (str.equals(""))
                System.out.println("Khong duoc rong!!!, nhap lai: ");
            else
                check = true;
        }
        return str;
    }

    // Overloading Input()
    public static int Input(int chon) {
        boolean check = true;
        while (true) {
            try {
                chon = input.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không hợp lệ nhập lại: ");
                check = false;
                input.nextLine();
            }
            if (check == true)
                break;
        }
        return chon;
    }

    // Overloading Input()
    public static double Input(double chon) {
        boolean check = true;
        while (true) {
            try {
                chon = input.nextDouble();
                check = true;
            } catch (Exception e) {
                System.out.print("\nKhông hợp lệ nhập lại: ");
                check = false;
                input.nextLine();
            }
            if (check == true)
                break;
        }
        return chon;
    }

    public static HoaDon nhap(int n) {
        String data = "";
        if (n == 1)
            data = "gio";
        else
            data = "ngay";
        System.out.println("Nhap thong tin cua hoa don " + data);

        System.out.print("Nhap ma hoa don: ");
        String maHoaDon = "";
        maHoaDon = Input(maHoaDon);

        System.out.print("Nhap ngay lap hd: ");
        int ngay = 0;
        ngay = Input(ngay);

        System.out.print("Nhap thang lap hd: ");
        int thang = 0;
        thang = Input(thang);

        System.out.print("Nhap nam lap hd: ");
        int nam = 0;
        nam = Input(nam);

        System.out.print("Nhap ten khach hang: ");
        String tenKH = "";
        tenKH = Input(tenKH);

        System.out.print("Nhap ma phong: ");
        String maPhong = "";
        maPhong = Input(maPhong);

        System.out.print("Nhap don gia: ");
        double donGia = 0;
        donGia = Input(donGia);

        int soNgayThue = 0, soGioThue = 0;
        HoaDon x;
        if (n == 1) {
            // hoa don theo gio
            System.out.print("Nhap so gio thue: ");
            soGioThue = Input(soGioThue);
            x = new HoaDonGio(maHoaDon, LocalDate.of(nam, thang, ngay), tenKH, maPhong, donGia, soGioThue);
        } else {
            // hoa don theo ngay
            System.out.print("Nhap so ngay thue: ");
            soNgayThue = Input(soNgayThue);
            x = new HoaDonNgay(maHoaDon, LocalDate.of(nam, thang, ngay), tenKH, maPhong, donGia, soNgayThue);
        }
        return x;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        DanhSachHoaDon ds = new DanhSachHoaDon();
        int choose = 0, chon = 0;
        // test case
        // ds.them(new HoaDonGio("G01", LocalDate.of(2020, 5, 12), "A", "A", 100000, 15));
        // ds.them(new HoaDonGio("G02", LocalDate.of(2020, 5, 1), "B", "A", 100000, 17));
        // ds.them(new HoaDonNgay("N01", LocalDate.of(2019, 7, 12), "D", "B", 150000, 3));
        // ds.them(new HoaDonNgay("N02", LocalDate.of(2017, 5, 12), "E", "B", 150000, 10));

        do {
            clrscr();
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm Hoa Don");
            System.out.println("2. Xuất Hoa Don");
            System.out.println("3. Thong ke so luong hoa don theo gio");
            System.out.println("4. Thong ke so luong hoa don theo ngay");
            System.out.println("5. Tính Tong thành tiền của Hoa Don trong thang x, nam y");
            System.out.println("0. Thoát");
            System.out.println("\nNhập lựa chọn: ");
            choose = Input(choose);

            switch (choose) {
                case 0:
                    System.out.println("Kết thúc Chương trình");
                    return;
                case 1:
                    clrscr();
                    input = new Scanner(System.in);
                    System.out.println("1. Tạo hoa don theo gio");
                    System.out.println("2. Tạo hoa don theo ngay");
                    boolean checkInput = true;
                    while (true) {
                        try {
                            System.out.println("Nhập lựa chọn: ");
                            chon = input.nextInt();
                            checkInput = true;
                        } catch (Exception e) {
                            checkInput = false;
                            input.nextLine();
                        }
                        if (checkInput == true && (chon == 1 || chon == 2))
                            break;
                    }
                    HoaDon x;
                    x = nhap(chon);
                    ds.them(x);
                    break;
                case 2:
                    clrscr();
                    ds.xuatDS();
                    dungMangHinh();
                    break;
                case 3:
                    clrscr();
                    System.out.println("Thong Ke So Luong HD Theo: " + ds.thongKeSoLuongHDTheoGio());
                    dungMangHinh();
                    break;
                case 4:
                    clrscr();
                    System.out.println("Thong Ke So Luong HD Ngay: " + ds.thongKeSoLuongHDTheoNgay());
                    dungMangHinh();
                    break;
                case 5:
                    clrscr();
                    int thang = 0, nam = 0;
                    System.out.print("Nhap thang: ");
                    thang = Input(thang);
                    System.out.print("Nhap nam: ");
                    nam = Input(nam);
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
