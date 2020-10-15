package Module3.Bai1;

public class DanhSachChuyenXe {
    private Xe[] dsXe = new Xe[100];
    private int count;

    /**
     * 
     */
    public DanhSachChuyenXe() {
        count = 0;
        for (int i = 0; i < 100; i++) {
            dsXe[i] = new Xe();
        }
    }

    public boolean themXe(Xe xe) {
        if (xe != null) {
            if (count > 100) {
                System.out.println("Không thể thêm được, Mảng Full!!");
                return false;
            } else {
                for (int i = 0; i < count; i++) {
                    if (dsXe[i].getMaSoChuyen().equalsIgnoreCase(xe.getMaSoChuyen())) {
                        System.out.println("Chuyến xe đã tồn tại");
                        return false;
                    }
                }
            }
            dsXe[count] = xe;
            count++;
            return true;
        }
        return false;
    }

    public void xuatXeNoiThanh() {
        System.out.println("\nXuất danh sách xe Nội Thành");
        for (int i = 0; i < count; i++) {
            if (dsXe[i] instanceof NoiThanh)
                System.out.println(dsXe[i].toString());
        }
    }

    public void xuatXeNgoaiThanh() {
        System.out.println("\nXuất danh sách xe Ngoại Thành");
        for (int i = 0; i < count; i++) {
            if (dsXe[i] instanceof NgoaiThanh)
                System.out.println(dsXe[i].toString());
        }
    }

    public void xuatXe() {
        for (int i = 0; i < count; i++) {
            System.out.println(dsXe[i].toString());
        }
    }

    public double tinhTien() {
        double tien = 0;
        for (int i = 0; i < count; i++) {
            tien += dsXe[i].getDoanhThu();
        }
        return tien;
    }

    public void tinhTienTungLoaiXe() {
        double tienNT = 0, tienNgT = 0;
        for (int i = 0; i < count; i++) {
            if (dsXe[i] instanceof NoiThanh)
                tienNT += dsXe[i].getDoanhThu();
            if (dsXe[i] instanceof NgoaiThanh)
                tienNgT += dsXe[i].getDoanhThu();
        }
        System.out.println("\nTổng Tiền Xe Nội Thành: " + tienNT);
        System.out.println("Tổng Tiền Xe Ngoại Thành: " + tienNgT);
    }
}
