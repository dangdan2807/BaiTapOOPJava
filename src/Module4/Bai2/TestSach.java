package Module4.Bai2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class TestSach {
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

    public static Sach nhapSach(int n) {
        Sach x;
        int ngay = 0, thang = 0, nam = 0, donGia = 0, soLuong = 0;
        double thue = 0;
        String maSach = "", nxb = "", tinhTrang = "";
        maSach = Input(maSach, "ma sach");
        ngay = Input(ngay, "ngay nhap");
        thang = Input(thang, "thang nhap");
        nam = Input(nam, "nam nhap");
        donGia = Input(donGia, "don gia");
        soLuong = Input(soLuong, "so luong");
        nxb = Input(nxb, "NXB");
        if (n == 1) {
            // Sach GK
            tinhTrang = Input(tinhTrang, "tinh trang");
            x = new SachGK(maSach, LocalDate.of(nam, thang, ngay), donGia, soLuong, nxb, tinhTrang);
        } else {
            // Sach TK
            thue = Input(thue, "thue");
            x = new SachTK(maSach, LocalDate.of(nam, thang, ngay), donGia, soLuong, nxb, thue);
        }
        return x;
    }

    public static void menu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Them Sach");
        System.out.println("2. Xuất Sach");
        System.out.println("3. Xuất tổng số lượng của từng loại Sach");
        System.out.println("4. Tính trung bình thành tiền của Sach Tham Khao");
        System.out.println("5. Xuất ra các Sach Giao Khoa cua nha xuat ban");
        System.out.println("0. Thoát");
    }

    public static void main(String[] args) {
        QLSach ds = new QLSach();
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        int choose = 0, chon = 0;
        boolean check = false;
        // ds.themSach(new SachGK("GK01", LocalDate.of(2016, 5, 26), 50000, 5, "Kim Dong", "moi"));
        // ds.themSach(new SachGK("GK02", LocalDate.of(2020, 11, 26), 45000, 3, "Giao Duc", "cu"));
        // ds.themSach(new SachGK("GK03", LocalDate.of(2019, 11, 26), 45000, 3, "Tre", "moi"));

        // ds.themSach(new SachTK("TK01", LocalDate.of(2020, 11, 26), 60000, 3, "Kim Dong", 5));
        // ds.themSach(new SachTK("TK02", LocalDate.of(2020, 11, 26), 25000, 7, "Tre", 3.5));
        // ds.themSach(new SachTK("TK03", LocalDate.of(2020, 11, 26), 25000, 7, "Giao Duc", 7));
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
                    System.out.println("1. Tạo Sách Giao Khoa");
                    System.out.println("2. Tạo Sách Tham Khoa");
                    while (!check) {
                        chon = Input(chon, "lua chon");
                        if (chon == 1 || chon == 2)
                            check = true;
                    }
                    Sach gd;
                    gd = nhapSach(chon);
                    ds.themSach(gd);
                    break;
                case 2:
                    xoaMangHinh();
                    ds.xuatSach();
                    dungMangHinh();
                    break;
                case 3:
                    xoaMangHinh();
                    ds.tinhTienTungLoaiSach();
                    dungMangHinh();
                    break;
                case 4:
                    xoaMangHinh();
                    System.out
                            .println("Tính trung bình thành tiền của Sach Tham Khao: " + df.format(ds.tinhTBCongSTK()));
                    dungMangHinh();
                    break;
                case 5:
                    xoaMangHinh();

                    String tempNxb = "";
                    tempNxb = Input(tempNxb, "nha xuat ban can tim");
                    ds.xuatSGKNXBK(tempNxb);
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
