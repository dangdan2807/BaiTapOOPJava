package Module4.Bai3;

import java.util.ArrayList;

public class QLGD {
    ArrayList<GiaoDich> ds;

    /**
     * 
     */
    public QLGD() {
        ds = new ArrayList<GiaoDich>();
    }

    public boolean themGD(GiaoDich x) {
        if (x != null) {
            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i).getMaGD().equalsIgnoreCase(x.getMaGD())) {
                    System.out.println("Ma GD da ton tai");
                    return false;
                }
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public void soLuongTungLoaiGD() {
        int GDLoaiVang = 0;
        int GDTien = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof GDVang)
                GDLoaiVang++;
            if (ds.get(i) instanceof GDTienTe)
                GDTien++;
        }
        System.out.println("\nTổng số loại giao dịch loại Vàng: " + GDLoaiVang);
        System.out.println("Tổng số loại giao dịch loại tiền tệ: " + GDTien);
    }

    public double tinhTBThanhTienCuaGDTT() {
        double tien = 0;
        int count = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof GDTienTe) {
                tien += ds.get(i).thanhTien();
                ++count;
            }
        }
        if(count == 0)
            return 0;
        return (tien / count);
    }

    public void xuatGD1Ty() {
        System.out.println("\nXuat Danh Sach Tat Ca Giao Dich Co DOn Gia Lon Hon 1 Ty");
        System.out.printf("%-15s %-15s %-20s %-10s %-10s %-15s %-10s\n", "Ma GD", "Ngay GD", "Don Gia", "So Luong",
                "Ti Gia", "Loai", "Thanh Tien");
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getDonGia() >= 1000000000)
                System.out.println(ds.get(i).toString());
        }
    }

    public void xuatDS() {
        System.out.println("\nXuat Danh Sach Tat Ca Giao Dich");
        System.out.printf("%-15s %-15s %-20s %-10s %-10s %-15s %-10s\n", "Ma GD", "Ngay GD", "Don Gia", "So Luong",
                "Ti Gia", "Loai", "Thanh Tien");
        for (int i = 0; i < ds.size(); i++) {
            System.out.println(ds.get(i).toString());
        }
    }
}
