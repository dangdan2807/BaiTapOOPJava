package Module3.Bai1;

public class TestXe {
    public static void main(String[] args) {
        DanhSachChuyenXe ds = new DanhSachChuyenXe();
        ds.themXe(new NoiThanh("NoiT01", "Thái Minh Tú", "1539B", 200000f, 30f, "Tuyến 8"));
        ds.themXe(new NoiThanh("NoiT02", "Nguyễn Văn An", "1339A", 100000f, 30f, "Tuyến 8"));
        ds.themXe(new NgoaiThanh("NgoaiT01", "Trần Minh Toàn", "1519B", 240000f, "Vũng Tàu", 5));
        ds.themXe(new NgoaiThanh("NgoaiT02", "Nguyễn Khánh Thành", "1549C", 200200f, "Cà Mau", 10));

        ds.xuatXe();

        ds.xuatXeNoiThanh();
        ds.xuatXeNgoaiThanh();
        ds.tinhTienTungLoaiXe();
        System.out.print("\ntính Tổng Tiền các chuyến xe: " + ds.tinhTien());
    }
}
