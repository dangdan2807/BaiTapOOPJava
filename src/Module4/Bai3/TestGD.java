package Module4.Bai3;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class TestGD {
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

    public static GiaoDich nhap(int n) {
        System.out.println("Nhap thong tin giao dich: ");
        String maGD = "", loai = "";
        int ngay = 0, thang = 0, nam = 0, soLuong = 0;
        double donGia = 0, tiGia = 1;
        maGD = Input(maGD, "ma GD");
        ngay = Input(ngay, "ngay");
        thang = Input(thang, "thang");
        nam = Input(nam, "nam");
        donGia = Input(donGia, "don gia");
        soLuong = Input(soLuong, "so luong");
        if (n == 2) {
            tiGia = Input(tiGia, "ti gia");
            loai = Input(loai, "loai tien te");
        } else
            loai = Input(loai, "loai Vang");
        GiaoDich gd;
        if (n == 2)
            gd = new GDTienTe(maGD, LocalDate.of(nam, thang, ngay), donGia, soLuong, tiGia, loai);
        else
            gd = new GDVang(maGD, LocalDate.of(nam, thang, ngay), donGia, soLuong, loai);
        return gd;
    }

    public static void menu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Thêm Giao Dịch");
        System.out.println("2. Xuất Giao Dịch");
        System.out.println("3. Xuất tổng số lượng của từng loại giao dịch");
        System.out.println("4. Tính trung bình thành tiền của giao dịch tiền tệ");
        System.out.println("5. Xuất danh sách tất cả các giao dịch lớn hơn 1 tỷ");
        System.out.println("0. Thoát");
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        QLGD ds = new QLGD();
        int choose = 0, chon = 0;
        boolean check = false;
        // ds.themGD(new GDVang("Vang01", LocalDate.of(2020, 4, 1), 1000000000, 3,
        // "9999"));
        // ds.themGD(new GDVang("Vang02", LocalDate.of(2020, 3, 25), 5000000, 7,
        // "999"));
        // ds.themGD(new GDTienTe("VN01", LocalDate.of(2020, 9, 14), 1000000000, 1, 1f,
        // "VND"));
        // ds.themGD(new GDTienTe("VN02", LocalDate.of(2019, 4, 14), 10000000, 1, 21f,
        // "USD"));

        // System.out.println("Xuất tổng thành tiền của GD tiền tệ: " +
        // df.format(ds.tinhTBThanhTienCuaGDTT()));
        // ds.xuatGD1Ty();
        // ds.xuatDS();

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
                    System.out.println("1. Tạo giao dịch vàng");
                    System.out.println("2. Tạo giao dịch tiền tệ");
                    while (!check) {
                        chon = Input(chon, "lua chon");
                        if (chon == 1 || chon == 2)
                            check = true;
                    }
                    GiaoDich gd;
                    gd = nhap(chon);
                    ds.themGD(gd);
                    break;
                case 2:
                    xoaMangHinh();
                    ds.xuatDS();
                    dungMangHinh();
                    break;
                case 3:
                    xoaMangHinh();
                    ds.soLuongTungLoaiGD();
                    dungMangHinh();
                    break;
                case 4:
                    xoaMangHinh();
                    System.out.println(
                            "Trung bình thành tiền của giao dịch tiền tệ: " + df.format(ds.tinhTBThanhTienCuaGDTT()));
                    dungMangHinh();
                    break;
                case 5:
                    xoaMangHinh();
                    ds.xuatGD1Ty();
                    dungMangHinh();
                    break;
                default:
                    System.out.println("Lua chon khong hop le !!!");
                    dungMangHinh();
                    break;
            }
        } while (true);
    }
}
