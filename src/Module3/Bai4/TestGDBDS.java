package Module3.Bai4;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class TestGDBDS {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0");
        QLGD ds = new QLGD();

        ds.themGD(new GDDat("Dat01", LocalDate.of(2013, 9, 13), 10000000, 200, "C"));
        ds.themGD(new GDDat("Dat02", LocalDate.of(2015, 5, 15), 15000000, 100, "B"));
        ds.themGD(new GDDat("Dat03", LocalDate.of(2019, 12, 28), 20000000, 100, "A"));
        ds.themGD(new GDNha("Nha01", LocalDate.of(2020, 8, 7), 20000000, 100, "thuong", "9 Nguyễn Văn Bảo, Q. Gò Vấp, TP.HCM"));
        ds.themGD(new GDNha("Nha02", LocalDate.of(2013, 7, 26), 25000000, 200, "cao cap", "7 Nguyễn Thái Bình, Q. Gò Vấp, TP.HCM"));
        ds.themGD(new GDNha("Nha03", LocalDate.of(2018, 8, 4), 30000000, 250, "Cao Cấp", "15 Lê Lợi, Q. Gò Vấp, TP.HCM"));

        ds.tinhSoLuongTungLoaiGD();
        System.out.printf("Tổng TB tiền của GD Đất: %s", df.format(ds.tinhTBTienCuaGDDat()));
        ds.xuatDsGD2013();

        ds.xuatDS();
    }
}
