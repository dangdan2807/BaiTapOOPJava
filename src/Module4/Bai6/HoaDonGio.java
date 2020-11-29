package Module4.Bai6;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class HoaDonGio extends HoaDon {
    private int soGioThue;

    /**
     * @return int return the soGioThue
     */
    public int getSoGioThue() {
        return soGioThue;
    }

    /**
     * @param soGioThue the soGioThue to set
     */
    public void setSoGioThue(int soGioThue) {
        if (soGioThue < 0)
            soGioThue = 0;
        this.soGioThue = soGioThue;
    }

    /**
     * @param maHoaDon
     * @param ngayHD
     * @param tenKH
     * @param maPhong
     * @param donGia
     * @param soGioThue
     */
    public HoaDonGio(String maHoaDon, LocalDate ngayHD, String tenKH, String maPhong, double donGia, int soGioThue) {
        super(maHoaDon, ngayHD, tenKH, maPhong, donGia);
        setSoGioThue(soGioThue);
    }

    public HoaDonGio() {
        this("", LocalDate.now(), "", "", 0, 0);
    }

    @Override
    public double thanhTien() {
        double tien = 0;
        if (soGioThue < 24)
            tien = soGioThue * donGia;
        if (soGioThue >= 24 && soGioThue <= 30)
            tien = 24 * donGia;
        else if (soGioThue > 30) {
            throw new ArithmeticException("So Gio Thue > 30");
        }
        return (double) tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        return super.toString() + String.format("%-17d %-15s", soGioThue, df.format(thanhTien()));
    }
}
