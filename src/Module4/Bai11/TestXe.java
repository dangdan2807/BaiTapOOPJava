package Module4.Bai11;

import java.text.DecimalFormat;

public class TestXe {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        QuanLyXe ds = new QuanLyXe();

        ds.them(new xeDap("XD01", "xe dap 01", 1000000));
        ds.them(new xeDap("XD02", "xe dap 02", 2000000));
        ds.them(new xeMay("XM01", "xe may 01", 10000000, 150));
        ds.them(new xeMay("XM02", "xe may 02", 12300000, 100));
        ds.them(new xeOToKhach("XK01", "xe o to khach 01", 300000000, 20));
        ds.them(new xeOToKhach("XK02", "xe o to khach 02", 500000000, 40));
        ds.them(new xeOToTai("XT01", "xe o to tai 01", 17000000, 1));
        ds.them(new xeOToTai("XT02", "xe o to tai 01", 130000000, 10));

        ds.xuatDS();
        ds.xuatDSXeDap();
        ds.xuatDSXeMay();
        ds.xuatDSXeOToKhach();
        ds.xuatDSXeOToTai();

        System.out.println("Tong so luong xe dap: " + df.format(ds.tongSoXeDap()));
        System.out.println("Tong so luong xe may: " + df.format(ds.tongSoXeMay()));
        System.out.println("Tong so luong xe o to khach: " + df.format(ds.tongSoXeOToKhach()));
        System.out.println("Tong so luong xe o to tai: " + df.format(ds.tongSoXeOToTai()));

        System.out.println("Tong trung binh thanh tien: " + df.format(ds.tongTrungBinhThanhTien()) + " VND");

        ds.sapXepTangDanTheoThanhTien();
        System.out.println("Sap xep DS tang dan theo thanh tien");
        ds.xuatDS();
    }
}
