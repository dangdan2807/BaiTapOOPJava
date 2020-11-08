package Module4.Bai5;

import java.io.*;
import java.text.*;
import java.time.*;
import java.util.*;

public class TestKH {
    static Scanner input = new Scanner(System.in);

    // Clears Screen in java
    public static void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
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

    // Overloading NhapSo()
    public static double nhapSo(double chon) {
        boolean checkInput = true;
        while (true) {
            try {
                chon = input.nextDouble();
                checkInput = true;
            } catch (Exception e) {
                System.out.print("\nKhông hợp lệ nhập lại: ");
                checkInput = false;
                input.nextLine();
            }
            if (checkInput == true)
                break;
        }
        return chon;
    }

    public static KhachHang nhap(int n) {
        KhachHang gd;
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap thong tin giao dich\n");

        System.out.print("Nhap ma khach hang: ");
        String maKH = scan.nextLine();
        System.out.print("Nhap ten khach hang: ");
        scan = new Scanner(System.in);
        String tenKH = scan.nextLine();
        System.out.print("Nhap ngay lap hd: ");
        int ngay = 0;
        ngay = nhapSo(ngay);
        System.out.print("Nhap thang lap hd: ");
        int thang = 0;
        thang = nhapSo(thang);
        System.out.print("Nhap nam lap hd: ");
        int nam = 0;
        nam = nhapSo(nam);
        System.out.print("Nhap so KW: ");
        int soKW = 0;
        soKW = nhapSo(soKW);
        System.out.print("Nhap don gia: ");
        double donGia = 0;
        donGia = nhapSo(donGia);
        String loai;
        int dinhMuc = 0;
        if (n == 2) {
            // khach hang nuoc ngoai
            System.out.print("Nhap quoc tich: ");
            scan = new Scanner(System.in);
            loai = scan.nextLine();
            gd = new KHNuocNgoai(maKH, tenKH, LocalDate.of(nam, thang, ngay), soKW, donGia, loai);
        } else {
            // khach hang viet name
            System.out.print("Nhap doi tuong(sinh hoat/kinh doanh/san xuat): ");
            scan = new Scanner(System.in);
            loai = scan.nextLine();
            System.out.print("Nhap dinh muc: ");
            dinhMuc = nhapSo(dinhMuc);
            gd = new KHVietNam(maKH, tenKH, LocalDate.of(nam, thang, ngay), soKW, donGia, loai, dinhMuc);
        }
        return gd;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        QLKhachHang ds = new QLKhachHang();
        int choose, chon = 0;
        String temp;

        // ds.themKH(new KHVietNam("VN01", "Phạm Văn Toàn", LocalDate.of(2018, 9, 25),
        // 100, 3000, "Sinh hoạt", 200));
        // ds.themKH(new KHVietNam("VN02", "Nguyễn Tấn Thanh", LocalDate.of(2020, 9,
        // 16), 210, 3000, "Kinh Doanh", 200));
        // ds.themKH(new KHNuocNgoai("NN01", "Trần Thanh Minh", LocalDate.of(2017, 4,
        // 3), 200, 3200, "USA"));
        // ds.themKH(new KHNuocNgoai("NN02", "Trần Ngọc Ngân", LocalDate.of(2018, 9, 3),
        // 100, 3200, "Singapore"));

        // ds.tinhTongSoLuongTungLoaiKH();
        // System.out.printf("Tổng TB tiền của Khách hàng nước ngoài: %s",
        // df.format(ds.tinhTBThanhTienKHNN()));
        // ds.xuatDSHD092018();
        // ds.xuatDS();

        do {
            clrscr();
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm Khách Hàng");
            System.out.println("2. Xuất Khách Hàng");
            System.out.println("3. Xuất tổng số lượng của từng loại Khách Hàng");
            System.out.println("4. Tính trung bình thành tiền của Khách Hàng người Nước Ngoài");
            System.out.println("5. Xuất ra các Khách Hàng của tháng 9 năm 2018");
            System.out.println("0. Thoát");
            System.out.println("\nNhập lựa chọn: ");
            try {
                choose = input.nextInt();
            } catch (Exception e) {
                System.out.println("Nhập số nguyên dương: ");
                choose = -1;
            }

            switch (choose) {
                case 0:
                    System.out.println("Kết thúc Chương trình");
                    return;
                case 1:
                    clrscr();
                    input = new Scanner(System.in);
                    System.out.println("1. Tạo khách hàng người Việt Nam");
                    System.out.println("2. Tạo khách hàng người nước ngoài");
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
                    KhachHang gd;
                    gd = nhap(chon);
                    ds.themKH(gd);
                    break;
                case 2:
                    clrscr();
                    ds.xuatDS();

                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 3:
                    clrscr();
                    ds.tinhTongSoLuongTungLoaiKH();

                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 4:
                    clrscr();
                    System.out.println("Xuất tổng thành tiền của khách hàng người nước ngoài: "
                            + df.format(ds.tinhTBThanhTienKHNN()));

                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 5:
                    clrscr();
                    ds.xuatDSHD092018();

                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                default:
                    break;
            }
        } while (true);
    }
}
