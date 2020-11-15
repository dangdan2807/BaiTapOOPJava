package Module4.Bai2;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class QLSach {
    private ArrayList<Sach> ds;

    /**
     * 
     */
    public QLSach() {
        ds = new ArrayList<Sach>();
    }

    public boolean themSach(Sach x) {
        if (x != null) {
            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i).getMaSach().equalsIgnoreCase(x.getMaSach())) {
                    System.out.println("Sách đã tồn tại.");
                    return false;
                }
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public void tinhTienTungLoaiSach() {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        double tienSGK = 0, tienSTK = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof SachGK)
                tienSGK += ds.get(i).tinhTien();
            if (ds.get(i) instanceof SachTK)
                tienSTK += ds.get(i).tinhTien();
        }
        System.out.println("Tổng tiền loại Sách GK: " + df.format(tienSGK));
        System.out.println("Tổng tiền loại Sách TK: " + df.format(tienSTK));
    }

    public double tinhTBCongSTK() {
        double tien = 0;
        int dem = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof SachTK) {
                tien += ds.get(i).tinhTien();
                dem++;
            }
        }
        tien = tien / dem;
        return tien;
    }

    public void xuatSGKNXBK(String k) {
        System.out.println("\nXuất danh sách Sách Giáo Khoa của  " + k);
        System.out.printf("%-15s %-15s %-10s %-10s %-20s %-15s %-20s\n", "Ma Sach", "Ngay Nhap", "Don Gia", "So Luong", "NXB", "Tinh Trang", "Thanh Tien");
        for (int i = 0; i < ds.size(); i++)
            if (ds.get(i).getNxb().equalsIgnoreCase(k))
                System.out.println(ds.get(i).toString());
    }

    public void xuatSach() {
        System.out.println("\nXuất danh sách hiện có");
        System.out.printf("%-15s %-15s %-10s %-10s %-20s %-15s %-20s\n", "Ma Sach", "Ngay Nhap", "Don Gia", "So Luong", "NXB", "Thue", "Thanh Tien");
        for (int i = 0; i < ds.size(); i++) {
            System.out.println(ds.get(i).toString());
        }
    }
}
