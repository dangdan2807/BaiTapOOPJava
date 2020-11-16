package DeThi2019;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class TestNhanVien {
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

    public static NhanVien nhap(int n) {
        NhanVien nv;
        Scanner scan = new Scanner(System.in);

        System.out.print("Nhap ma NV: ");
        String maNV = scan.next();
        scan = new Scanner(System.in);

        System.out.print("Nhap ten NV: ");
        String hoTen = scan.nextLine();
        scan = new Scanner(System.in);

        System.out.print("Nhap ngay vao lam");
        int ngay = 0;
        ngay = nhapSo(ngay);
        System.out.print("Nhap thang vao lam");
        int thang = 0;
        thang = nhapSo(thang);
        System.out.print("Nhap nam ngay vao lam");
        int nam = 0;
        nam = nhapSo(nam);

        int soNgayCong = 0;
        double heSoLuong = 0;
        String tienDo = "";
        if (n == 1) {
            // Nhan vien bien che
            scan = new Scanner(System.in);
            System.out.print("Nhap he so luong: ");
            heSoLuong = nhapSo(heSoLuong);

            scan = new Scanner(System.in);
            System.out.print("Da tien Do hoan thanh cong viec(co/khong): ");
            tienDo = scan.next();

            nv = new NhanVienBienChe(maNV, hoTen, LocalDate.of(nam, thang, ngay), heSoLuong, tienDo);
        } else {
            // nhan vien hop dong
            scan = new Scanner(System.in);
            System.out.print("Nhap so ngay cong: ");
            soNgayCong = nhapSo(soNgayCong);

            nv = new NhanVienHopDong(maNV, hoTen, LocalDate.of(nam, thang, ngay), soNgayCong);
        }
        return nv;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        QLNhanVien ds = new QLNhanVien();
        int choose, chon = 0;
        String temp;
        boolean kt = false;

        ds.them(new NhanVienBienChe("BC01", "Nguyen Van A", LocalDate.of(2020, 3, 23), 3.0f, "khong"));
        ds.them(new NhanVienBienChe("BC02", "Nguyen Van B", LocalDate.of(2020, 3, 23), 5.0f, "khong"));
        ds.them(new NhanVienHopDong("HD01", "Tran Van B", LocalDate.of(2019, 4, 23), 21));
        ds.them(new NhanVienHopDong("HD02", "Tran Van C", LocalDate.of(2018, 2, 13), 16));
        ds.them(new NhanVienHopDong("HD03", "Tran Van D", LocalDate.of(2016, 4, 25), 13));

        do {
            clrscr();
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm Nhan Vien");
            System.out.println("2. Xuất Danh Sach Nhan Vien");
            System.out.println("3. Tinh Tong Tien Luong");
            System.out.println("4. Cap Nhap So Ngay Cong");
            System.out.println("5. Xuat DS Nhan Vien Khong Hoan Thanh Dung Tien Do");
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
                    System.out.println("1. Them Nhan Vien Bien Che");
                    System.out.println("2. Them Nhan Vien Hop Dong");
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
                    NhanVien x;
                    x = nhap(chon);
                    ds.them(x);
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
                    System.out.println("\nTinh Tong Tien Luong Phai Tra CHo Nhan Vien Trong 1 Thang: "
                            + df.format(ds.tinhTongTienLuong()));
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 4:
                    clrscr();
                    input = new Scanner(System.in);
                    System.out.print("Nhap ma NV can cap nhat: ");
                    temp = input.next();
                    kt = ds.capNhapSoNgayCong(temp);
                    if (kt == true)
                        System.out.println("Cap Nhat Thanh Cong");
                    else
                        System.out.println("Khong tim thay Nhan Vien");
                    // dừng màng hình để xem kết quả
                    System.out.println("\nẤn phím bất kì để tiếp tục");
                    input.nextLine();
                    temp = input.nextLine();
                    break;
                case 5:
                    clrscr();
                    ds.DSNVKhongHoanThanh();
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
