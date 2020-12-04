package DeThi2019;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TestNhanVien {
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
        int n = 1;
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
    public static int Input(int n) {
        boolean check = false;
        while (!check) {
            try {
                input = new Scanner(System.in);
                n = input.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.print("Khong hop le, nhap lai: ");
                check = false;
                input.nextLine();
            }
        }
        return n;
    }

    // Overloading
    public static double Input(double n) {
        boolean check = false;
        while (!check) {
            try {
                input = new Scanner(System.in);
                n = input.nextDouble();
                check = true;
            } catch (Exception e) {
                System.out.print("\nKhong hop le, nhap lai: ");
                check = false;
                input.nextLine();
            }
        }
        return n;
    }

    // Overloading
    public static String Input(String n) {
        boolean check = false;
        while (!check) {
            input = new Scanner(System.in);
            n = input.nextLine();
            if (n.equals("") || n.length() == 0) {
                System.out.println("Khong duoc rong !!!");
                check = false;
            } else
                check = true;
        }
        return n;
    }

    public static NhanVien nhap(int n) {
        NhanVien nv;

        System.out.print("Nhap ma NV: ");
        String maNV = "";
        maNV = Input(maNV);

        System.out.print("Nhap ten NV: ");
        String hoTen = "";
        hoTen = Input(hoTen);

        System.out.print("Nhap ngay vao lam: ");
        int ngay = 0;
        ngay = Input(ngay);
        System.out.print("Nhap thang vao lam: ");
        int thang = 0;
        thang = Input(thang);
        System.out.print("Nhap nam ngay vao lam: ");
        int nam = 0;
        nam = Input(nam);

        int soNgayCong = 0, temp = 0;
        double heSoLuong = 0;
        boolean tienDo;
        if (n == 1) {
            // Nhan vien bien che
            System.out.print("Nhap he so luong: ");
            heSoLuong = Input(heSoLuong);

            System.out.print("Da tien Do hoan thanh cong viec(1/0): ");
            while (true) {
                temp = Input(temp);
                if (temp == 1) {
                    tienDo = true;
                    break;
                } else if (temp == 0) {
                    tienDo = false;
                    break;
                }
            }
            nv = new NhanVienBienChe(maNV, hoTen, LocalDate.of(nam, thang, ngay), heSoLuong, tienDo);
        } else {
            // nhan vien hop dong
            System.out.print("Nhap so ngay cong: ");
            soNgayCong = Input(soNgayCong);
            nv = new NhanVienHopDong(maNV, hoTen, LocalDate.of(nam, thang, ngay), soNgayCong);
        }
        return nv;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        QLNhanVien ds = new QLNhanVien();
        ArrayList<NhanVien> ds2 = new ArrayList<NhanVien>();
        int choose = 0, chon = 0;
        String temp;
        boolean kt = false;

        ds.them(new NhanVienBienChe("BC01", "Nguyen Van A", LocalDate.of(2020, 3, 23), 3.0f, true));
        ds.them(new NhanVienBienChe("BC02", "Nguyen Van B", LocalDate.of(2020, 3, 23), 5.0f, false));
        ds.them(new NhanVienHopDong("HD01", "Tran Van B", LocalDate.of(2019, 4, 23), 21));
        ds.them(new NhanVienHopDong("HD02", "Tran Van C", LocalDate.of(2018, 2, 13), 16));
        ds.them(new NhanVienHopDong("HD03", "Tran Van D", LocalDate.of(2016, 4, 25), 13));

        do {
            xoaMangHinh();
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm Nhan Vien");
            System.out.println("2. Xuất Danh Sach Nhan Vien");
            System.out.println("3. Tinh Tong Tien Luong");
            System.out.println("4. Cap Nhap So Ngay Cong");
            System.out.println("5. Xuat DS Nhan Vien Khong Hoan Thanh Dung Tien Do");
            System.out.println("6. Tra ve DS Nhan Vien Hoan Thanh Dung Tien Do");
            System.out.println("0. Thoát");
            System.out.print("\nNhập lựa chọn: ");
            choose = Input(choose);

            switch (choose) {
                case 0:
                    System.out.println("Kết thúc Chương trình");
                    return;
                case 1:
                    xoaMangHinh();
                    input = new Scanner(System.in);
                    System.out.println("1. Them Nhan Vien Bien Che");
                    System.out.println("2. Them Nhan Vien Hop Dong");
                    while (true) {
                        System.out.print("Nhập lựa chọn: ");
                            chon = Input(chon);
                        if (chon == 1 || chon == 2)
                            break;
                    }
                    NhanVien x;
                    x = nhap(chon);
                    ds.them(x);
                    break;
                case 2:
                    xoaMangHinh();
                    ds.xuatDS();
                    // dừng màng hình để xem kết quả
                    dungMangHinh();
                    break;
                case 3:
                    xoaMangHinh();
                    System.out.println("\nTinh Tong Tien Luong Phai Tra Cho Nhan Vien Trong 1 Thang: "
                            + df.format(ds.tinhTongTienLuong()));
                    // dừng màng hình để xem kết quả
                    dungMangHinh();
                    break;
                case 4:
                    xoaMangHinh();
                    input = new Scanner(System.in);
                    System.out.print("Nhap ma NV can cap nhat: ");
                    temp = input.next();
                    kt = ds.capNhapSoNgayCong(temp);
                    if (kt == true)
                        System.out.println("Cap Nhat Thanh Cong");
                    else
                        System.out.println("Khong tim thay Nhan Vien");
                    // dừng màng hình để xem kết quả
                    dungMangHinh();
                    break;
                case 5:
                    xoaMangHinh();
                    ds.DSNVKhongHoanThanh();
                    // dừng màng hình để xem kết quả
                    dungMangHinh();
                    break;
                case 6:
                    xoaMangHinh();
                    ds2 = ds.LayDSNVHoanThanh();
                    for (NhanVien i : ds2) {
                        System.out.println(i);
                    }
                    // dừng màng hình để xem kết quả
                    dungMangHinh();
                    break;
                default:
                    break;
            }
        } while (true);
    }
}
