package Khac.Bai2;

import java.time.LocalDate;
import java.util.Scanner;

public class TestKS {
    private static Scanner scan = new Scanner(System.in);

    public static PhongTro nhapPT() {
        System.out.print("Nhap so ngay thue: ");
        int soNgayThue = scan.nextInt();
        scan = new Scanner(System.in);
        System.out.print("Nhap loai phong: ");
        String loaiPhong = scan.nextLine();
        System.out.print("Nhap gia phong: ");
        double giaPhong = scan.nextDouble();
        System.out.print("Nhap so CMND cua nguoi thue: ");
        int cmnd = scan.nextInt();
        scan = new Scanner(System.in);
        System.out.print("Nhap ho ten nguoi thue: ");
        String hoVaTen = scan.nextLine();
        System.out.print("Nhap ngay sinh: ");
        int ngay = scan.nextInt();
        System.out.print("Nhap thang sinh: ");
        int thang = scan.nextInt();
        System.out.print("Nhap nam sinh: ");
        int nam = scan.nextInt();

        Nguoi a = new Nguoi(cmnd, hoVaTen, LocalDate.of(nam, thang, ngay));
        PhongTro pt = new PhongTro(soNgayThue, loaiPhong, giaPhong, a);
        // cach khac
        // PhongTro pt1 = new PhongTro(soNgayThue, loaiPhong, giaPhong, new Nguoi(cmnd, hoVaTen, LocalDate.of(nam, thang, ngay)));
        return pt;
    }

    public static void main(String[] args) {
        System.out.print("Nhap so luong phong tro can them: ");
        int n = scan.nextInt();
        KhachSan ks = new KhachSan();

        // test case cung
        // ks.themPT(new PhongTro(10, "thuong", 1000000, new Nguoi(1, "Nguyen Van A", LocalDate.of(2001, 3, 28))));
        // ks.themPT(new PhongTro(20, "thuong", 1000000, new Nguoi(3, "Nguyen Van B", LocalDate.of(2001, 6, 28))));
        // ks.themPT(new PhongTro(10, "cao cap", 2000000, new Nguoi(2, "Nguyen Van C", LocalDate.of(1993, 7, 15))));
        // ks.themPT(new PhongTro(30, "cao cap", 2000000, new Nguoi(4, "Nguyen Van D", LocalDate.of(1999, 4, 30))));

        for (int i = 0; i < n; i++)
            ks.themPT(nhapPT());

        ks.xuatDS();
        
        ks.xoaPT();
        ks.xuatDS();
    }
}
