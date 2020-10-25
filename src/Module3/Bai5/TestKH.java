package Module3.Bai5;

import java.text.*;
import java.time.*;

public class TestKH {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0");
        QLKhachHang ds = new QLKhachHang();

        ds.themKH(new KHVietNam("VN01", "Phạm Văn Toàn", LocalDate.of(2018, 9, 25), 100, 3000, "Sinh hoạt", 200));
        ds.themKH(new KHVietNam("VN02", "Nguyễn Tấn Thanh", LocalDate.of(2020, 9, 16), 210, 3000, "Kinh Doanh", 200));
        ds.themKH(new KHNuocNgoai("NN01", "Trần Thanh Minh", LocalDate.of(2017, 4, 3), 200, 3200, "USA"));
        ds.themKH(new KHNuocNgoai("NN02", "Trần Ngọc Ngân", LocalDate.of(2018, 9, 3), 100, 3200, "Singapore"));

        ds.tinhTongSoLuongTungLoaiKH();
        System.out.printf("Tổng TB tiền của Khách hàng nước ngoài: %s", df.format(ds.tinhTBThanhTienKHNN()));
        ds.xuatDSHD092018();
        ds.xuatDS();
    }
}
