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

    public static GiaoDich nhap(int n) {
        System.out.println("Nhap thong tin giao dich vang: ");
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập mã GD: ");
        String magd = s.nextLine();
        s = new Scanner(System.in);
        int ngay, thang, nam;
        System.out.println("nhap ngay: ");
        ngay = s.nextInt();
        System.out.println("nhap thang: ");
        thang = s.nextInt();
        System.out.println("nhap nam: ");
        nam = s.nextInt();
        System.out.println("nhap don gia: ");
        int donGia = s.nextInt();
        System.out.println("nhap so luong gd: ");
        int soLuong = s.nextInt();
        int tiGia = 1;
        if (n == 1) {
            System.out.println("nhap ti gia");
            tiGia = s.nextInt();
            System.out.println("nhap loai tien te: ");
        } else
            System.out.println("nhap loai Vang: ");
        s = new Scanner(System.in);
        String loai = s.nextLine();
        GiaoDich gd;
        if (n == 1)
            gd = new GDTienTe(magd, LocalDate.of(nam, thang, ngay), donGia, soLuong, tiGia, loai);
        else
            gd = new GDVang(magd, LocalDate.of(nam, thang, ngay), donGia, soLuong, loai);
        return gd;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        QLGD ds = new QLGD();
        int choose, chon = 0;
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
            // clrscr();
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm Giao Dịch");
            System.out.println("2. Xuất Giao Dịch");
            System.out.println("3. Xuất tổng thành tiền của giao dịch tiền tệ");
            System.out.println("4. Xuất danh sách tất cả các giao dịch lớn hơn 1 tỷ");
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
                    // clrscr();
                    input = new Scanner(System.in);
                    System.out.println("1. Tạo giao dịch vàng");
                    System.out.println("2. Tạo giao dịch tiền tệ");
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
                    GiaoDich gd;
                    gd = nhap(chon);
                    ds.themGD(gd);
                    break;
                case 2:
                    // clrscr();
                    ds.xuatDS();
                    break;
                case 3:
                    // clrscr();
                    System.out
                            .println("Xuất tổng thành tiền của GD tiền tệ: " + df.format(ds.tinhTBThanhTienCuaGDTT()));
                    break;
                case 4:
                    // clrscr();
                    ds.xuatGD1Ty();
                    break;
                default:
                    break;
            }

        } while (true);
    }
}
