package Module4.Bai3;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class TestGD {
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

    public static GiaoDich nhap(int n) {
        System.out.println("Nhap thong tin giao dich: ");
        Scanner s = new Scanner(System.in);
        System.out.print("Nhập mã GD: ");
        String magd = s.nextLine();
        s = new Scanner(System.in);
        int ngay = 0, thang = 0, nam = 0;
        System.out.print("nhap ngay: ");
        ngay = nhapSo(ngay);
        System.out.print("nhap thang: ");
        thang = nhapSo(thang);
        System.out.print("nhap nam: ");
        nam = nhapSo(nam);
        System.out.print("nhap don gia: ");
        double donGia = s.nextDouble();
        System.out.print("nhap so luong gd: ");
        int soLuong = 0; 
        soLuong = nhapSo(soLuong);
        double tiGia = 1;
        if (n == 2) {
            System.out.print("nhap ti gia");
            tiGia = nhapSo(tiGia);
            System.out.print("nhap loai tien te: ");
        } else
            System.out.print("nhap loai Vang: ");
        s = new Scanner(System.in);
        String loai = s.nextLine();
        GiaoDich gd;
        if (n == 2)
            gd = new GDTienTe(magd, LocalDate.of(nam, thang, ngay), donGia, soLuong, tiGia, loai);
        else
            gd = new GDVang(magd, LocalDate.of(nam, thang, ngay), donGia, soLuong, loai);
        return gd;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        QLGD ds = new QLGD();
        int choose, chon = 0;
        String temp;
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
            clrscr();
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm Giao Dịch");
            System.out.println("2. Xuất Giao Dịch");
            System.out.println("3. Xuất tổng số lượng của từng loại giao dịch");
            System.out.println("4. Tính trung bình thành tiền của giao dịch tiền tệ");
            System.out.println("5. Xuất danh sách tất cả các giao dịch lớn hơn 1 tỷ");
            System.out.println("0. Thoát");
            System.out.println("\nNhập lựa chọn: ");
            try {
                choose = input.nextInt();
            } catch (Exception e) {
                System.out.println("Nhập số nguyên dương");
                choose = -1;
            }

            switch (choose) {
                case 0:
                    System.out.println("Kết thúc Chương trình");
                    return;
                case 1:
                    clrscr();
                    input = new Scanner(System.in);
                    System.out.println("1. Tạo giao dịch vàng");
                    System.out.println("2. Tạo giao dịch tiền tệ");
                    boolean checkInput = true;
                    while (true) {
                        try {
                            System.out.println("Nhập số: ");
                            chon = input.nextInt();
                            checkInput = true;
                        } catch (Exception e) {
                            checkInput = false;
                            input.nextLine();
                        }
                        if (checkInput == true && (chon == 1 || chon == 2))
                            break;
                    }
                    GiaoDich gd;
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
                    ds.soLuongTungLoaiGD();
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 4:
                    clrscr();
                    System.out.println("Trung bình thành tiền của giao dịch tiền tệ: " + ds.tinhTBThanhTienCuaGDTT());
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 5:
                    clrscr();
                    ds.xuatGD1Ty();
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
