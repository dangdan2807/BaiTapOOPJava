package Module3.Bai2;

import java.time.LocalDate;

public class TestSach {
    public static void main(String[] args) {
        QLSach ds = new QLSach();

        ds.themSach(new SachGK("GK01", LocalDate.of(2019, 11, 26), 500, 5, "Kim Dong", "moi"));
        ds.themSach(new SachGK("GK02", LocalDate.of(2020, 11, 26), 450, 3, "Tuoi Tre", "cu"));
        ds.themSach(new SachTK("TK01", LocalDate.of(2020, 11, 26), 600, 3, "Kim Dong", 5));
        ds.themSach(new SachTK("TK02", LocalDate.of(2020, 11, 26), 250, 7, "Tuoi Tre", 3));

        ds.tinhTienTungLoaiSach();
        ds.tinhTBCongSTK();
        ds.xuatSGK("kim Dong");
        ds.xuatSach();
    }
}
