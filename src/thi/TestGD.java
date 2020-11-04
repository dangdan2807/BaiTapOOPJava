package thi;

import java.time.LocalDate;

public class TestGD {
    public static void main(String[] args) {
        QuanLyGD ds = new QuanLyGD();

        ds.themGD(new GiaoDich("VN01", LocalDate.of(2020, 10, 23), 1000, 1000, 1, "VN"));
        ds.themGD(new GiaoDich("VN02", LocalDate.of(2020, 9, 15), 1000, 2000, 1, "VN"));
        ds.themGD(new GiaoDich("USD01", LocalDate.of(2020, 3, 1), 1000, 2500, 23, "USD"));
        ds.themGD(new GiaoDich("USD02", LocalDate.of(2020, 4, 23), 1000, 2000, 23, "USD"));

        ds.intDSGD();

        System.out.printf("Tong thanh tien cua tat ca giao dich: %.2f", ds.tinhTongTien());

        System.out.println("\nSap xep danh sach");
        ds.sapXepTien();
        ds.intDSGD();

    }
}
