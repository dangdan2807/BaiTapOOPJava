package Module3.Bai5;

public class QLKhachHang {
    private int count;
    private KhachHang[] ds = new KhachHang[100];

    /**
     * 
     */
    public QLKhachHang() {
        count = 0;
        for (int i = 0; i < 100; i++)
            ds[i] = new KhachHang();
    }

    public boolean themKH(KhachHang x) {
        if (x != null) {
            if (count > 100) {
                System.out.println("Không thể thêm được, Mảng Full!!");
                return false;
            } else {
                for (int i = 0; i < count; i++) {
                    if (ds[i].getMaKH().equalsIgnoreCase(x.getMaKH())) {
                        System.out.println("Khách hàng đã tồn tại!!!");
                        return false;
                    }
                }
            }
            ds[count] = x;
            count++;
            return true;
        }
        return false;
    }

    public void tinhTongSoLuongTungLoaiKH() {
        int demKHVN = 0, demKHNN = 0;
        for (int i = 0; i < count; i++) {
            if (ds[i] instanceof KHVietNam)
                ++demKHVN;
            if (ds[i] instanceof KHNuocNgoai)
                ++demKHNN;
        }
        System.out.println("\nTổng số khách hàng Việt Nam: " + demKHVN);
        System.out.println("Tổng số khách hàng nước ngoài: " + demKHNN);
    }

    public double tinhTBThanhTienKHNN() {
        double tien = 0;
        int dem = 0;
        for (int i = 0; i < count; i++) {
            if (ds[i] instanceof KHNuocNgoai) {
                ++dem;
                tien += ((KHNuocNgoai) ds[i]).thanhTien();
            }
        }
        return (double) (tien / dem);
    }

    public void xuatDSHD092018() {
        System.out.println("\nXuất những Giao Dịch trong tháng 9 năm 2018");
        System.out.printf("%-10s %-25s %-12s %-7s %-12s %-25s %-10s %-15s\n", "Mã KH", "Họ Tên", "Ngày Lập HD", "Số KW", "Đơn Giá", "Đối tượng/Quốc tịnh", "Định Mức", "Thành Tiền");
        for (int i = 0; i < count; i++)
            if(ds[i].getNgayLapHD().getMonth().getValue() == 9 && ds[i].getNgayLapHD().getYear() == 2018)
                System.out.println(ds[i].toString());
    }

    public void xuatDS() {
        System.out.println("\nXuất tất các các giao dịch");
        System.out.printf("%-10s %-25s %-12s %-7s %-12s %-25s %-10s %-15s\n", "Mã KH", "Họ Tên", "Ngày Lập HD", "Số KW", "Đơn Giá", "Đối tượng/Quốc tịch", "Định Mức", "Thành Tiền");
        for (int i = 0; i <count; i++)
            System.out.println(ds[i].toString());
    }
}
