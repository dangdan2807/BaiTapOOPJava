package Module3.Bai3;

import java.time.LocalDate;

public class TestGD {
    public static void main(String[] args) {
        QuanLyGD ds = new QuanLyGD();

        ds.themGD(new TienTe("TT01", LocalDate.of(2020, 12, 13), 1000000, 5, 1, "VND"));
        ds.themGD(new TienTe("TT02", LocalDate.of(2020, 12, 13), 300000000, 10, 2, "USD"));
        ds.themGD(new TienTe("TT03", LocalDate.of(2020, 12, 13), 15000000, 2, 2.1, "EURO"));
        ds.themGD(new Vang("V01", LocalDate.of(2020, 12, 13), 140000000, 5, "9999"));
        ds.themGD(new Vang("V02", LocalDate.of(2020, 12, 13), 1500000000, 1, "999"));

        ds.tinhSoLuongTungLoaiGD();
        System.out.println("Tổng Trung bình của GD tiền tệ: " + ds.tinhTBTienCuaGDTT());
        ds.xuatGD1Ty();
        ds.xuatGD();
    }
}
