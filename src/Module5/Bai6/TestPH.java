package Module5.Bai6;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class TestPH {
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

    public static PhongHoc nhap(int n) {
        PhongHoc ph;
        Scanner scan = new Scanner(System.in);

        System.out.print("Nhap ma phong: ");
        String maPhong = scan.next();
        scan = new Scanner(System.in);

        System.out.print("Nhap day nha: ");
        String dayNha = scan.next();
        scan = new Scanner(System.in);

        System.out.print("Nhap dien tich: ");
        double dienTich = 0;
        dienTich = nhapSo(dienTich);

        System.out.print("Nhap so bong den: ");
        int soBongDen = 0;
        soBongDen = nhapSo(soBongDen);
        scan = new Scanner(System.in);

        String mayChieu, chuyenNganh, bonChua;
        int mayTinh = 0, sucChua = 0;
        if (n == 1) {
            // PhongLT
            System.out.print("Phong co may chieu hay khong (co / khong): ");
            mayChieu = scan.next();
            ph = new PhongLT(maPhong, dayNha, dienTich, soBongDen, mayChieu);
        } else if (n == 2) {
            // PhongTN
            System.out.print("Nhap chuyen nganh: ");
            chuyenNganh = scan.nextLine();

            System.out.print("Nhap suc chua: ");
            sucChua = nhapSo(sucChua);
            scan = new Scanner(System.in);

            System.out.print("Phong co bon Chua hay khong (co / khong): ");
            bonChua = scan.next();
            ph = new PhongTN(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, bonChua);
        } else {
            // PhongMT
            System.out.println("Nhap so luong may tinh: ");
            mayTinh = nhapSo(mayTinh);
            ph = new PhongMT(maPhong, dayNha, dienTich, soBongDen, mayTinh);
        }
        return ph;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        QuanLyPH ds = new QuanLyPH();
        int choose, chon = 0;
        String temp;
        boolean kt = false;

        ds.themPH(new PhongMT("MT01", "B", 180, 10, 60));
        ds.themPH(new PhongMT("MT02", "B", 150, 10, 30));
        ds.themPH(new PhongTN("TN01", "A", 130, 20, "CN Thuc Pham", 30, "Co"));
        ds.themPH(new PhongTN("TN02", "A", 100, 420, "CN Hoa Hoc", 30, "Khong"));
        ds.themPH(new PhongLT("LT01", "C", 120, 15, "Co"));
        ds.themPH(new PhongLT("LT02", "D", 200, 15, "Khong"));

        do {
            clrscr();
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm Phong Hoc");
            System.out.println("2. Xuất Danh Sach Phong Hoc");
            System.out.println("3. Tim kiem Phong Hoc");
            System.out.println("4. Xuất Danh Sach Phong Hoc Dat Chuan");
            System.out.println("5. Sắp xếp danh sách tăng dần theo dãy nhà");
            System.out.println("6. Sắp xếp danh sách giảm dần theo diện tích");
            System.out.println("7. Sắp xếp danh sách tăng dần theo số bóng đèn");
            System.out.println("8. Cập nhật số máy tính cho một phòng máy tính");
            System.out.println("9. Xóa một phòng học");
            System.out.println("10. Xuat tổng số phòng học");
            System.out.println("11. Danh sách các phòng máy có 60 máy");
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
                    System.out.println("1. Them Phong Hoc Ly Thuyet");
                    System.out.println("2. Them Phong Hoc Thi Nghiem");
                    System.out.println("3. Them Phong Hoc May Tinh");
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
                        if (checkInput == true && (chon == 1 || chon == 2 || chon == 3))
                            break;
                    }
                    PhongHoc gd;
                    gd = nhap(chon);
                    ds.themPH(gd);
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
                    System.out.println("\nTim Kiem Phong Hoc");
                    System.out.print("Nhap ma Phong: ");
                    input = new Scanner(System.in);
                    String t = input.next();
                    ds.timKiemPH(t);
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 4:
                    clrscr();
                    ds.xuatDSDatChuan();

                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 5:
                    clrscr();
                    ds.sapXepDSTangTheoDayNha();
                    System.out.println("Sap xep thanh cong");
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 6:
                    clrscr();
                    ds.sapXepDSGiamTheoDienTich();
                    System.out.println("Sap xep thanh cong");
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 7:
                    clrscr();
                    ds.sapXepDSTangTheoSoBongDien();
                    System.out.println("Sap xep thanh cong");
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 8:
                    clrscr();
                    System.out.println("Cap Nhat So Luong May tinh cho mot Phong Hoc May tinh");
                    System.out.print("Nhap ma Phong: ");
                    input = new Scanner(System.in);
                    temp = input.next();

                    kt = ds.capNhatSoMayTinh(temp);
                    if (kt == true)
                        System.out.println("Cap Nhat Thanh Cong");
                    else
                        System.out.println("Cap Nhat That Bai");
                    kt = false;
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 9:
                    clrscr();
                    System.out.println("Xoa Mot Phong Hoc:");
                    System.out.print("Nhap ma Phong: ");
                    input = new Scanner(System.in);
                    temp = input.next();

                    kt = ds.xoaPH(temp);
                    if (kt == true)
                        System.out.println("Cap Nhat Thanh Cong");
                    else
                        System.out.println("Cap Nhat That Bai");
                    kt = false;
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 10:
                    clrscr();
                    System.out.println("Xuat tổng số phòng học: " + ds.tongSoPhongHoc());
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 11:
                    clrscr();
                    ds.xuatDSPH60MT();
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
