package Module3.Bai6;

import java.text.*;
import java.time.*;

public class HDTheoNgay extends HoaDon {
    private int soNgayThue;

    /**
     * @return int return the soNgayThue
     */
    public int getSoNgayThue() {
        return soNgayThue;
    }

    /**
     * @param soNgayThue the soNgayThue to set
     */
    public void setSoNgayThue(int soNgayThue) {
        if(soNgayThue < 0)
            soNgayThue = 0;
        this.soNgayThue = soNgayThue;
    }

    /**
     * @param maHD
     * @param ngayHD
     * @param tenKH
     * @param maPhong
     * @param donGia
     * @param soNgayThue
     */
    public HDTheoNgay(String maHD, LocalDate ngayHD, String tenKH, String maPhong, double donGia, int soNgayThue) {
        super(maHD, ngayHD, tenKH, maPhong, donGia);
        setSoNgayThue(soNgayThue);
    }

    /**
     * 
     */
    public HDTheoNgay() {
        this("", LocalDate.now(), "", "", 0.0, 0);
    }

    public double thanhTien() {
        double tien = 0;
        if(soNgayThue <= 7)
            tien = soNgayThue * donGia;
        else
            tien = (7 * donGia) + ((soNgayThue - 7) * donGia * 0.8f);
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0");
        DecimalFormat df2 = new DecimalFormat("#,##0.00 VND");
        return super.toString() + String.format("%-15s %-20s", df.format(soNgayThue), df2.format(thanhTien()));
    }
}
