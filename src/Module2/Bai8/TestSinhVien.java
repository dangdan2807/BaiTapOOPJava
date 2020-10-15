package Module2.Bai8;

public class TestSinhVien {
    public static void main(String[] args) {
        String maLhp = "123456";
        String tenLhp = "LT Hướng Đối Tượng";
        String tenGv = "Cô Hà";
        String ThongTinLopHoc = "Thứ 7, tiết 4-6, phòng A1.1";
        LopHocPhan lhp = new LopHocPhan(maLhp, tenLhp, tenGv, ThongTinLopHoc);
        lhp.themHV(new SinhVien("123", "Nguyễn Văn A"));
        lhp.themHV(new SinhVien("543", "Lê Thị B"));
        lhp.themHV(new SinhVien("321", "Lương Văn C"));

        System.out.println(lhp.toString());
    }
}
