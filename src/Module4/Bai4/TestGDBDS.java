package Module4.Bai4;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class TestGDBDS {
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

    public static GiaoDichBDS nhap(int n) {
        GiaoDichBDS gd;
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap thong tin giao dich\n");

        System.out.print("Nhap ma gd: ");
        String magd = scan.nextLine();
        System.out.print("Nhap ngay gd: ");
        int ngay = 0;
        ngay = nhapSo(ngay);
        System.out.print("Nhap thang gd: ");
        int thang = 0;
        thang = nhapSo(thang);
        System.out.print("Nhap nam gd: ");
        int nam = 0;
        nam = nhapSo(nam);
        System.out.print("Nhap don gia: ");
        double donGia = 0;
        donGia = nhapSo(donGia);
        System.out.print("Nhap dien tich: ");
        double dienTich = 0;
        dienTich = nhapSo(dienTich);
        String loai, diaChi;
        if (n == 1) {
            // GDDat
            System.out.print("Nhap loai dat: ");
            scan = new Scanner(System.in);
            loai = scan.nextLine();
            gd = new GDDat(magd, LocalDate.of(nam, thang, ngay), donGia, dienTich, loai);
        } else {
            // GDNha
            System.out.print("Nhap loai nha: ");
            scan = new Scanner(System.in);
            loai = scan.nextLine();
            System.out.print("Nhap dia chi: ");
            scan = new Scanner(System.in);
            diaChi = scan.nextLine();
            gd = new GDNha(magd, LocalDate.of(nam, thang, ngay), donGia, dienTich, loai, diaChi);
        }
        return gd;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0");
        QLGDBDS ds = new QLGDBDS();
        int choose, chon = 0;
        String temp;
        // ds.themGD(new GDDat("Dat01", LocalDate.of(2013, 9, 13), 10000000, 200, "C"));
        // ds.themGD(new GDDat("Dat02", LocalDate.of(2015, 5, 15), 15000000, 100, "B"));
        // ds.themGD(new GDDat("Dat03", LocalDate.of(2019, 12, 28), 20000000, 100,
        // "A"));
        // ds.themGD(new GDNha("Nha01", LocalDate.of(2020, 8, 7), 20000000, 100,
        // "thuong", "9 Nguyễn Văn Bảo, Q.Gò Vấp, TP.HCM"));
        // ds.themGD(new GDNha("Nha02", LocalDate.of(2013, 7, 26), 25000000, 200, "cao
        // cap", "7 Nguyễn Thái Bình, Q.Gò Vấp, TP.HCM"));
        // ds.themGD(new GDNha("Nha03", LocalDate.of(2018, 8, 4), 30000000, 250, "Cao
        // Cấp", "15 Lê Lợi, Q.Gò Vấp, TP.HCM"));

        // ds.tinhSoLuongTungLoaiGD();
        // System.out.printf("Tổng TB tiền của GD Đất: %s",
        // df.format(ds.tinhTBTienCuaGDDat()));
        // ds.xuatDsGD2013();

        // ds.xuatDS();
        do {
            clrscr();
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm Giao Dịch");
            System.out.println("2. Xuất Giao Dịch");
            System.out.println("3. Xuất tổng số lượng của từng loại giao dịch");
            System.out.println("4. Tính trung bình thành tiền của giao dịch đất");
            System.out.println("5. Xuất ra các giao dịch của tháng 9 năm 2013");
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
                    System.out.println("1. Tạo giao dịch đất");
                    System.out.println("2. Tạo giao dịch nhà");
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
                    GiaoDichBDS gd;
                    gd = nhap(chon);
                    ds.themGD(gd);
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
                    ds.tinhSoLuongTungLoaiGD();
                    
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 4:
                    clrscr();
                    System.out.println("Xuất tổng thành tiền của GD đất: " + df.format(ds.tinhTBTienCuaGDDat()));
                    
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 5:
                    clrscr();
                    ds.xuatDsGD2013();

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
