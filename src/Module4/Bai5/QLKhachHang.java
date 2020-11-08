package Module4.Bai5;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class QLKhachHang {
    private ArrayList<KhachHang> ds;

    /**
     * 
     */
    public QLKhachHang() {
        ds = new ArrayList<KhachHang>();
    }

    public boolean themKH(KhachHang x) {
        if (x != null) {
            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i).getMaKH().equalsIgnoreCase(x.getMaKH())) {
                    System.out.println("Khách hàng đã tồn tại!!!");
                    return false;
                }
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public void tinhTongSoLuongTungLoaiKH() {
        DecimalFormat df = new DecimalFormat("#,##0");
        int demKHVN = 0, demKHNN = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof KHVietNam)
                ++demKHVN;
            if (ds.get(i) instanceof KHNuocNgoai)
                ++demKHNN;
        }
        System.out.println("\nTổng số khách hàng Việt Nam: " + df.format(demKHVN));
        System.out.println("Tổng số khách hàng nước ngoài: " + df.format(demKHNN));
    }

    public double tinhTBThanhTienKHNN() {
        double tien = 0;
        int count = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof KHNuocNgoai) {
                ++count;
                tien += ((KHNuocNgoai) ds.get(i)).thanhTien();
            }
        }
        if(count == 0)
            return 0;
        return (double) (tien / count);
    }

    public void xuatDSHD092018() {
        System.out.println("\nXuất những Giao Dịch trong tháng 9 năm 2018");
        System.out.printf("%-16s %-23s %-12s %-7s %-12s %-23s %-10s %-15s\n", "Mã KH", "Họ Tên", "Ngày Lập HD", "Số KW",
                "Đơn Giá", "Đối tượng/Quốc tịnh", "Định Mức", "Thành Tiền");
        for (int i = 0; i < ds.size(); i++)
            if (ds.get(i).getNgayLapHD().getMonth().getValue() == 9 && ds.get(i).getNgayLapHD().getYear() == 2018)
                System.out.println(ds.get(i).toString());
    }

    public void xuatDS() {
        System.out.println("\nXuất tất các các giao dịch");
        System.out.printf("%-16s %-23s %-12s %-7s %-12s %-23s %-10s %-15s\n", "Mã KH", "Họ Tên", "Ngày Lập HD", "Số KW",
                "Đơn Giá", "Đối tượng/Quốc tịch", "Định Mức", "Thành Tiền");
        for (int i = 0; i < ds.size(); i++)
            System.out.println(ds.get(i).toString());
    }
}
