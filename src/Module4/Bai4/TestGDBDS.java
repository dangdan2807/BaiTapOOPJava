package Module4.Bai4;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class TestGDBDS {
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

    public static GiaoDichBDS nhap(int n) {
        GiaoDichBDS gd;
        System.out.println("Nhap thong tin giao dich\n");

        String maGD = "", loai = "", diaChi = "";
        int ngay = 0, thang = 0, nam = 0, donGia = 0, dienTich = 0;
        maGD = Input(maGD, "ma GD");
        ngay = Input(ngay, "ngay GD");
        thang = Input(thang, "thang gd");
        nam = Input(nam, "nam gd");
        donGia = Input(donGia, "don gia");
        dienTich = Input(dienTich, "dien tich");
        if (n == 1) {
            // GDDat
            loai = Input(loai, "loai dat");
            gd = new GDDat(maGD, LocalDate.of(nam, thang, ngay), donGia, dienTich, loai);
        } else {
            // GDNha
            loai = Input(loai, "loai nha");
            diaChi = Input(diaChi, "dia chi");
            gd = new GDNha(maGD, LocalDate.of(nam, thang, ngay), donGia, dienTich, loai, diaChi);
        }
        return gd;
    }

    public static void menu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Thêm Giao Dịch");
        System.out.println("2. Xuất Giao Dịch");
        System.out.println("3. Xuất tổng số lượng của từng loại giao dịch");
        System.out.println("4. Tính trung bình thành tiền của giao dịch đất");
        System.out.println("5. Xuất ra các giao dịch của tháng 9 năm 2013");
        System.out.println("0. Thoát");
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        QLGDBDS ds = new QLGDBDS();
        int choose = 0, chon = 0;
        boolean check = false;
        ds.themGD(new GDDat("Dat01", LocalDate.of(2013, 9, 13), 10000000, 200, "C"));
        ds.themGD(new GDDat("Dat02", LocalDate.of(2015, 5, 15), 15000000, 100, "B"));
        ds.themGD(new GDDat("Dat03", LocalDate.of(2019, 12, 28), 20000000, 100, "A"));
        ds.themGD(new GDNha("Nha01", LocalDate.of(2020, 8, 7), 20000000, 100, "thuong",
                "9 Nguyễn Văn Bảo, Q.Gò Vấp, TP.HCM"));
        ds.themGD(new GDNha("Nha02", LocalDate.of(2013, 7, 26), 25000000, 200, "cao cap",
                "7 Nguyễn Thái Bình, Q.Gò Vấp, TP.HCM"));
        // ds.themGD(new GDNha("Nha03", LocalDate.of(2018, 8, 4), 30000000, 250, "Cao
        // Cấp", "15 Lê Lợi, Q.Gò Vấp, TP.HCM"));

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
                    System.out.println("1. Tạo giao dịch đất");
                    System.out.println("2. Tạo giao dịch nhà");
                    while (!check) {
                        chon = Input(chon, "lua chon");
                        if (chon == 1 || chon == 2)
                            check = true;
                    }
                    GiaoDichBDS gd;
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
                    ds.tinhSoLuongTungLoaiGD();
                    dungMangHinh();
                    break;
                case 4:
                    xoaMangHinh();
                    System.out.println("Xuất tổng thành tiền của GD đất: " + df.format(ds.tinhTBTienCuaGDDat()));
                    dungMangHinh();
                    break;
                case 5:
                    xoaMangHinh();
                    ds.xuatDsGD2013();
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