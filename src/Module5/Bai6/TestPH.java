package Module5.Bai6;

import java.io.IOException;
import java.util.Scanner;

public class TestPH {
    static Scanner input = new Scanner(System.in);
    private static Scanner scan = new Scanner(System.in);

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

    public static PhongHoc nhap(int n) {
        PhongHoc ph;
        String maPhong = "", dayNha = "", mayChieu = "", chuyenNganh = "", bonChua = "";
        int soBongDen = 0, mayTinh = 0, sucChua = 0;
        double dienTich = 0;
        maPhong = Input(maPhong, "ma phong");
        dayNha = Input(dayNha, "day nha");
        dienTich = Input(dienTich, "dien tich");
        soBongDen = Input(soBongDen, "so bong den");
        if (n == 1) {
            // PhongLT
            System.out.print("Phong co may chieu hay khong (co / khong): ");
            mayChieu = scan.next();
            ph = new PhongLT(maPhong, dayNha, dienTich, soBongDen, mayChieu);
        } else if (n == 2) {
            // PhongTN
            chuyenNganh = Input(chuyenNganh, "chuyen nganh");
            sucChua = Input(sucChua, "suc chua");
            bonChua = Input(bonChua, "Phong co bon Chua hay khong (co / khong)");
            ph = new PhongTN(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, bonChua);
        } else {
            // PhongMT
            mayTinh = Input(mayTinh, "so luong may tinh");
            ph = new PhongMT(maPhong, dayNha, dienTich, soBongDen, mayTinh);
        }
        return ph;
    }

    public static void menu() {
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
    }

    public static void main(String[] args) {
        QuanLyPH ds = new QuanLyPH();
        int choose = 0, chon = 0;
        String temp = "";
        boolean kt = false, check = false;

        ds.themPH(new PhongMT("MT01", "B", 180, 10, 60));
        ds.themPH(new PhongMT("MT02", "B", 150, 10, 30));
        ds.themPH(new PhongTN("TN01", "A", 130, 20, "CN Thuc Pham", 30, "Co"));
        ds.themPH(new PhongTN("TN02", "A", 100, 420, "CN Hoa Hoc", 30, "Khong"));
        ds.themPH(new PhongLT("LT01", "C", 120, 15, "Co"));
        ds.themPH(new PhongLT("LT02", "D", 200, 15, "Khong"));

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
                    input = new Scanner(System.in);
                    System.out.println("1. Them Phong Hoc Ly Thuyet");
                    System.out.println("2. Them Phong Hoc Thi Nghiem");
                    System.out.println("3. Them Phong Hoc May Tinh");
                    while (!check) {
                        chon = Input(chon, "lua chon");
                        if (chon == 1 || chon == 2 || chon == 3)
                            check = true;
                    }
                    PhongHoc gd;
                    gd = nhap(chon);
                    ds.themPH(gd);
                    break;
                case 2:
                    xoaMangHinh();
                    ds.xuatDS();
                    dungMangHinh();
                    break;
                case 3:
                    xoaMangHinh();
                    System.out.println("\nTim Kiem Phong Hoc");
                    temp = Input(temp, "ma phong");
                    ds.timKiemPH(temp);
                    dungMangHinh();
                    break;
                case 4:
                    xoaMangHinh();
                    ds.xuatDSDatChuan();
                    dungMangHinh();
                    break;
                case 5:
                    xoaMangHinh();
                    ds.sapXepDSTangTheoDayNha();
                    System.out.println("Sap xep thanh cong");
                    dungMangHinh();
                    break;
                case 6:
                    xoaMangHinh();
                    ds.sapXepDSGiamTheoDienTich();
                    System.out.println("Sap xep thanh cong");
                    dungMangHinh();
                    break;
                case 7:
                    xoaMangHinh();
                    ds.sapXepDSTangTheoSoBongDien();
                    System.out.println("Sap xep thanh cong");
                    dungMangHinh();
                    break;
                case 8:
                    xoaMangHinh();
                    System.out.println("Cap Nhat So Luong May tinh cho mot Phong Hoc May tinh");
                    temp = Input(temp, "ma phong");

                    kt = ds.capNhatSoMayTinh(temp);
                    if (kt == true)
                        System.out.println("Cap Nhat Thanh Cong");
                    else
                        System.out.println("Cap Nhat That Bai");
                    kt = false;
                    dungMangHinh();
                    break;
                case 9:
                    xoaMangHinh();
                    System.out.println("Xoa Mot Phong Hoc:");
                    temp = Input(temp, "ma phong");

                    kt = ds.xoaPH(temp);
                    if (kt == true)
                        System.out.println("Cap Nhat Thanh Cong");
                    else
                        System.out.println("Cap Nhat That Bai");
                    kt = false;
                    dungMangHinh();
                    break;
                case 10:
                    xoaMangHinh();
                    System.out.println("Xuat tổng số phòng học: " + ds.tongSoPhongHoc());
                    dungMangHinh();
                    break;
                case 11:
                    xoaMangHinh();
                    ds.xuatDSPH60MT();
                    dungMangHinh();
                    break;
                default:
                    break;
            }
        } while (true);
    }
}