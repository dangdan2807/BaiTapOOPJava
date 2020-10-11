package Module2.Bai8;

public class TestSinhVien {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien("123", "Nguyễn Văn A");
        SinhVien sv2 = new SinhVien("543", "Lê Thị B");
        SinhVien sv3 = new SinhVien("321", "Lương Văn C");

        SinhVien[] array = new SinhVien[] { sv1, sv2, sv3 };

        String maLhp = "123456";
        String tenLhp = "LT Hướng Đối Tượng";
        String tenGv = "Cô Hà";
        String ThongTinLopHoc = "Thứ 7, tiết 4-6, phòng A1.1";
        LopHocPhan lhp = new LopHocPhan(maLhp, tenLhp, tenGv, ThongTinLopHoc, array);
        System.out.println(lhp.toString());
    }
}
