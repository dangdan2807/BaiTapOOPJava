package Module3.Bai6;

public class DanhSachHoaDon {
    private int count;
    private HoaDon[] danhSach;
    private int n;

    /**
     * 
     */
    public DanhSachHoaDon(int n) {
        count = 0;
        danhSach = new HoaDon[n];
        for (int i = 0; i < n; i++)
            danhSach[i] = new HoaDon();
    }

    public boolean them(HoaDon hd) {
        if (hd != null) {
            if (count > n) {
                System.out.println("Không thể thêm được, Mảng Full!!");
                return false;
            } else {
                for (int i = 0; i < count; i++) {
                    if (danhSach[i].getMaHD().equalsIgnoreCase(hd.getMaHD())) {
                        System.out.println("Hóa đơn đã tồi tại!!!");
                        return false;
                    }
                }
            }
            danhSach[count] = hd;
            count++;
            return true;
        }
        return false;
    }

    public int thongKeSoLuongHDTheoNgay() {
        int dem = 0;
        for (int i = 0; i < count; i++) {
            if (danhSach[i] instanceof HDTheoNgay)
                ++dem;
        }
        return dem;
    }

    public int thongKeSoLuongHDTheoGio() {
        int dem = 0;
        for (int i = 0; i < count; i++) {
            if (danhSach[i] instanceof HDTheoGio)
                ++dem;
        }
        return dem;
    }

    public double tinhTongThanhTien(int thang, int nam) {
        double tien = 0;
        for(int i = 0; i < count; i++)
        {
            if(danhSach[i].ngayHD.getMonth().getValue() == thang && danhSach[i].ngayHD.getYear() == nam)
            {
                if(danhSach[i] instanceof HDTheoGio)
                    tien += ((HDTheoGio)danhSach[i]).thanhTien();
                    else if(danhSach[i] instanceof HDTheoNgay)
                    tien += ((HDTheoNgay)danhSach[i]).thanhTien();
            }
        }
        return tien;
    }

    public String toString() {
        return "";
    }
}
