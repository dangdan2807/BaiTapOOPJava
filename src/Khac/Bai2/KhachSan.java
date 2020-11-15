package Khac.Bai2;

import java.util.Scanner;

public class KhachSan {
    private int count;
    private PhongTro[] ds;
    private Scanner scan = new Scanner(System.in);

    /**
     * 
     */
    public KhachSan() {
        count = 0;
        ds = new PhongTro[100];
        for (int i = 0; i < 100; i++)
            ds[i] = new PhongTro();
    }

    public boolean themPT(PhongTro x) {
        if (x != null) {
            if (count > 100) {
                System.out.println("Danh sach da day");
                return false;
            } else {
                for (int i = 0; i < count; i++) {
                    if (ds[i].getKh().getCmnd() == x.getKh().getCmnd()) {
                        System.out.println("Nguoi thue nay da ton tai!!!");
                        return false;
                    }
                }
                ds[count] = x;
                count++;
                return true;
            }
        }
        return false;
    }

    public void xoaPT() {
        int cmmd;
        System.out.print("Nhap cmmd can xoa: ");
        cmmd = scan.nextInt();
        for (int i = 0; i < count; i++) {
            if (ds[i].getKh().getCmnd() == cmmd) {
                for (int j = i; j < count - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                count--;
                break;
            }
        }
    }

    public void xuatDS() {
        System.out.println("\n Xuat Danh Sach Khach thue tro");
        System.out.printf("%-10s %-25s %-15s %-15s %-12s %-15s %-15s\n", "CMND", "Ho va Ten", "Ngay Sinh", "So Ngay Thue", "loai Phong", "Gia Phong", "Thanh Tien");
        for (int i = 0; i < count; i++) {
            System.out.println(ds[i]);
        }
    }
}
