package Module4.Bai2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class TestSach {
    static Scanner input = new Scanner(System.in);
    private static Scanner scan = new Scanner(System.in);

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
                input.next();
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
                input.next();
            }
            if (checkInput == true)
                break;
        }
        return chon;
    }

    public static Sach nhapSach(int n) {
        Sach x;
        System.out.println("Nhap ma sach: ");
        String maSach = scan.next();

        System.out.println("Nhap ngay nhap: ");
        int ngay = 0;
        ngay = nhapSo(ngay);
        System.out.println("Nhap thang nhap: ");
        int thang = 0;
        thang = nhapSo(thang);
        System.out.println("Nhap nam nhap: ");
        int nam = 0;
        nam = nhapSo(nam);

        System.out.println("Nhap don gia: ");
        double donGia = 0;
        donGia = nhapSo(donGia);

        System.out.println("Nhap so luong: ");
        int soLuong = 0;
        soLuong = nhapSo(soLuong);

        scan = new Scanner(System.in);
        System.out.println("Nhap nha xuat ban: ");
        String nxb = scan.nextLine();

        scan = new Scanner(System.in);
        String tinhTrang;
        double thue = 0;
        if (n == 1) {
            // Sach GK
            System.out.println("Nhap tinh trang: ");
            tinhTrang = scan.nextLine();
            x = new SachGK(maSach, LocalDate.of(nam, thang, ngay), donGia, soLuong, nxb, tinhTrang);
        } else {
            // Sach TK
            System.out.println("Nhap thue: ");
            thue = nhapSo(thue);
            x = new SachTK(maSach, LocalDate.of(nam, thang, ngay), donGia, soLuong, nxb, thue);
        }
        return x;
    }

    public static void main(String[] args) {
        QLSach ds = new QLSach();

        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        int choose, chon = 0;
        String temp;
        temp = "";
        // ds.themSach(new SachGK("GK01", LocalDate.of(2016, 5, 26), 50000, 5, "NXB Kim
        // Dong", "moi"));
        // ds.themSach(new SachGK("GK02", LocalDate.of(2020, 11, 26), 45000, 3, "NXB
        // Giao Duc", "cu"));
        // ds.themSach(new SachGK("GK03", LocalDate.of(2019, 11, 26), 45000, 3, "NXB
        // Tre", "moi"));

        // ds.themSach(new SachTK("TK01", LocalDate.of(2020, 11, 26), 60000, 3, "NXB Kim
        // Dong", 5));
        // ds.themSach(new SachTK("TK02", LocalDate.of(2020, 11, 26), 25000, 7, "NXB
        // Tre", 3.5));
        // ds.themSach(new SachTK("TK03", LocalDate.of(2020, 11, 26), 25000, 7, "NXB
        // Giao Duc", 7));
        do {
            clrscr();
            System.out.println("========== MENU ==========");
            System.out.println("1. Them Sach");
            System.out.println("2. Xuất Sach");
            System.out.println("3. Xuất tổng số lượng của từng loại Sach");
            System.out.println("4. Tính trung bình thành tiền của Sach Tham Khao");
            System.out.println("5. Xuất ra các Sach Giao Khoa cua nha xuat ban");
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
                    System.out.println("1. Tạo Sách Giao Khoa");
                    System.out.println("2. Tạo Sách Tham Khoa");
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
                    Sach gd;
                    gd = nhapSach(chon);
                    ds.themSach(gd);
                    break;
                case 2:
                    clrscr();
                    ds.xuatSach();

                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 3:
                    clrscr();
                    ds.tinhTienTungLoaiSach();

                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 4:
                    clrscr();
                    System.out.println("Tính trung bình thành tiền của Sach Tham Khao: "
                            + df.format(ds.tinhTBCongSTK()));

                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 5:
                    clrscr();
                    
                    String k = "";
                    input = new Scanner(System.in);
                    System.out.println("Nhap Nha xuat ban can tim: ");
                    k = input.nextLine();
                    ds.xuatSGKNXBK(k);
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    break;
                default:
                    break;
            }
        } while (true);
    }
}
