package Module4.Bai6;

import java.util.ArrayList;

public class DanhSachHoaDon {
    ArrayList<HoaDon> ds;

    /**
     * @param ds
     */
    public DanhSachHoaDon() {
        ds = new ArrayList<HoaDon>();
    }

    public boolean them(HoaDon x) {
        if (x != null) {
            for (HoaDon i : ds) {
                if (i.getMaHoaDon().equalsIgnoreCase(x.getMaHoaDon())) {
                    System.out.println("Hoa Don Da ton tai!!!!");
                    return false;
                }
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public int thongKeSoLuongHDTheoGio() {
        int count = 0;
        for (HoaDon i : ds) {
            if (i instanceof HoaDonGio) {
                count++;
            }
        }
        return count;
    }

    public int thongKeSoLuongHDTheoNgay() {
        int count = 0;
        for (HoaDon i : ds) {
            if (i instanceof HoaDonNgay) {
                count++;
            }
        }
        return count;
    }

    public double tinhTongThanhTien(int thang, int nam) {
        double tien = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getNgayHD().getMonth().getValue() == thang && ds.get(i).getNgayHD().getYear() == nam) {
                if(ds.get(i) instanceof HoaDonGio)
                    tien += ((HoaDonGio)ds.get(i)).thanhTien();
                else
                    tien += ((HoaDonNgay)ds.get(i)).thanhTien();
            }
        }
        return tien;
    }

    public void xuatDS() {
        System.out.println("\nXuat DS Cac Hoa Don");
        for (HoaDon i : ds) {
            System.out.println(i);
        }
    }
}
