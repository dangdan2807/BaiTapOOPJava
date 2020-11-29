package Module4.Bai7;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {
    static Scanner input = new Scanner(System.in);

    // dừng màng hình để xem kết quả
    public static void dungMangHinh() {
        // check co dung hay khong
        int n = 1;
        if (n == 1) {
            System.out.println("\nẤn phím bất kì để tiếp tục");
            input = new Scanner(System.in);
            input.nextLine();
        }
    }

    // Clears Screen console in java
    public static void clrscr() {
        // chi ap dung cho console (cmd/teminal)
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

    // Overloading Input()
    public static String Input(String str) {
        boolean check = false;
        while (!check) {
            input = new Scanner(System.in);
            str = input.nextLine();
            if (str.equals(""))
                System.out.println("Khong duoc rong!!!, nhap lai: ");
            else
                check = true;
        }
        return str;
    }

    // Overloading Input()
    public static int Input(int chon) {
        boolean check = true;
        while (true) {
            try {
                chon = input.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không hợp lệ nhập lại: ");
                check = false;
                input.nextLine();
            }
            if (check == true)
                break;
        }
        return chon;
    }

    // Overloading Input()
    public static double Input(double chon) {
        boolean check = true;
        while (true) {
            try {
                chon = input.nextDouble();
                check = true;
            } catch (Exception e) {
                System.out.print("\nKhông hợp lệ nhập lại: ");
                check = false;
                input.nextLine();
            }
            if (check == true)
                break;
        }
        return chon;
    }

    public static Employee nhap(int n) {
        String data = "";
        if (n == 1)
            data = "Salaried Employee";
        else if (n == 2)
            data = "Hourly Employee";
        else if (n == 3)
            data = "Commission Employee";
        else if (n == 4)
            data = "Base Plus Commission";
        System.out.println("Nhap thong tin cua hoa don " + data);

        System.out.print("Nhap Ho: ");
        String lastName = "";
        lastName = Input(lastName);

        System.out.print("Nhap Ten: ");
        String firstName = "";
        firstName = Input(firstName);

        System.out.print("Nhap ssn: ");
        int ssn = 1;
        ssn = Input(ssn);

        double luong = 0, luongCoBan = 0, hoaHong = 0;
        int loai = 0;
        Employee x = null;
        if (n == 1) {
            // Salaried Employee
            System.out.print("Nhap luong theo tuan: ");
            luong = Input(luong);
            System.out.print("Nhap so tuan lam viec: ");
            loai = Input(loai);
            x = new SalariedEmployee(firstName, lastName, ssn, loai, luong);
        } else if (n == 2) {
            // Hourly Employee
            System.out.print("Nhap luong theo gio: ");
            luong = Input(luong);
            System.out.print("Nhap so gio lam viec: ");
            loai = Input(loai);
            x = new HourlyEmployee(firstName, lastName, ssn, loai, luong);
        } else if (n == 3) {
            // Commission Employee
            System.out.print("Nhap luong theo gio: ");
            luong = Input(luong);
            System.out.print("Nhap so gio lam viec: ");
            hoaHong = Input(hoaHong);
            x = new CommissionEmployee(firstName, lastName, ssn, hoaHong, luong);
        } else if (n == 4) {
            // Base Plus Commission
            System.out.print("Nhap luong theo gio: ");
            luong = Input(luong);
            System.out.print("Nhap so gio lam viec: ");
            hoaHong = Input(hoaHong);
            System.out.print("Nhap luong co ban: ");
            luongCoBan = Input(luongCoBan);
            x = new BasePlusCommission(firstName, lastName, ssn, hoaHong, luong, luongCoBan);
        }
        return x;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        EmployeeManager ds = new EmployeeManager();
        int choose = 0, chon = 0;
        boolean kt = false;
        // test case
        ds.them(new SalariedEmployee("A", "1", 1, 1, 500000));
        ds.them(new SalariedEmployee("A", "2", 2, 4, 500000));
        ds.them(new HourlyEmployee("B", "1", 3, 30, 25000));
        ds.them(new HourlyEmployee("B", "2", 4, 50, 25000));
        ds.them(new CommissionEmployee("C", "1", 5, 0.5, 20000000));
        ds.them(new CommissionEmployee("C", "2", 6, 1, 25000000));
        ds.them(new BasePlusCommission("D", "1", 7, 0.5, 10000000, 5000000));
        ds.them(new BasePlusCommission("D", "1", 8, 0.7, 20000000, 5000000));
        do {
            clrscr();
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm 1 nhan vien");
            System.out.println("2. Xuất danh sach nhan vien");
            System.out.println("3. Xoa 1 nhan vien");
            System.out.println("4. Cap nhat thong tin nhan vien");
            System.out.println("5. Thong ke Tong so luong nhan vien");
            System.out.println("6. Thong ke so luong tung loai nhan vien");
            System.out.println("7. Tinh tong luong");
            System.out.println("8. Tinh tong luong tung loai nhan vien");
            System.out.println("9. Tinh tong trung binh luong nhan vien");
            System.out.println("10. Xuat danh sach cac Salaried Employee");
            System.out.println("11. Xuat danh sach cac Hourly Employee");
            System.out.println("12. Xuat danh sach cac commission Employee");
            System.out.println("13. Xuat danh sach cac Base Plus Commission");
            System.out.println("0. Thoát");
            System.out.println("\nNhập lựa chọn: ");
            choose = Input(choose);

            switch (choose) {
                case 0:
                    System.out.println("Kết thúc Chương trình");
                    return;
                case 1:
                    clrscr();
                    input = new Scanner(System.in);
                    System.out.println("1. Them Salaried Employee");
                    System.out.println("2. Them Hourly Employee");
                    System.out.println("3. Them Commission Employee");
                    System.out.println("4. Them Base Plus Commission");
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
                        if (checkInput == true && (chon == 1 || chon == 2 || chon == 3 || chon == 4))
                            break;
                    }
                    Employee x;
                    x = nhap(chon);
                    ds.them(x);
                    break;
                case 2:
                    clrscr();
                    ds.xuatDS();
                    dungMangHinh();
                    break;
                case 3:
                    clrscr();
                    int ssn = 0;
                    System.out.println("Xoa Nhan vien theo ma ssn");
                    System.out.println("Nhap ssn: ");
                    ssn = Input(ssn);
                    kt = ds.xoaTheoSSN(ssn);
                    if(kt == true)
                        System.out.println("Xoa thanh cong");
                    else
                        System.out.println("Khong tim thay Nhan vien");
                    dungMangHinh();
                    break;
                case 4:
                    clrscr();
                    System.out.println("coming soon .....");
                    dungMangHinh();
                    break;
                case 5:
                    clrscr();
                    System.out.println("Tong so luong nhan vien: " + ds.thongKeSoLuongNhanVien());
                    dungMangHinh();
                    break;
                case 6:
                    clrscr();
                    ds.thongKeSoLuongTungLoaiNhanVien();
                    dungMangHinh();
                    break;
                case 7:
                    clrscr();
                    System.out.println("Tong luong cua tat ca nhan vien: " + df.format(ds.tongLuong()));
                    dungMangHinh();
                    break;
                case 8:
                    clrscr();
                    System.out.println("Tong luong tung loai nhan vien: ");
                    ds.tongLuongTungLoaiNhanVien();
                    dungMangHinh();
                    break;
                case 9:
                    clrscr();
                    System.out.println("Tong trung binh luong cua tat ca nhan vien: " + df.format(ds.tinhTongTrungBinhLuong()));
                    dungMangHinh();
                    break;
                case 10:
                    clrscr();
                    ds.xuatDSSalariedEmployee();
                    dungMangHinh();
                    break;
                case 11:
                    clrscr();
                    ds.xuatDSHourlyEmployee();
                    dungMangHinh();
                    break;
                case 12:
                    clrscr();
                    ds.xuatDSCommissionEmployee();
                    dungMangHinh();
                    break;
                case 13:
                    clrscr();
                    ds.xuatDSBasePlusCommission();
                    dungMangHinh();
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    dungMangHinh();
                    break;
            }
        } while (true);
    }
}
