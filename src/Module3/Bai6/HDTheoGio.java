package Module3.Bai6;

import java.text.*;
import java.time.*;

public class HDTheoGio extends HoaDon {
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
     * @param maHD
     * @param ngayHD
     * @param tenKH
     * @param maPhong
     * @param donGia
     * @param soGioThue
     */
    public HDTheoGio(String maHD, LocalDate ngayHD, String tenKH, String maPhong, double donGia, int soGioThue) {
        super(maHD, ngayHD, tenKH, maPhong, donGia);
        setSoGioThue(soGioThue);
    }

    /**
     * 
     */
    public HDTheoGio() {
        this("", LocalDate.now(), "", "", 0.0, 0);
    }

    public double thanhTien() {
        double tien = 0;
        if (soGioThue <= 24)
            tien = soGioThue * donGia;
        else if(soGioThue > 24 && soGioThue <= 30)
            tien = 24 * donGia;
        else if(soGioThue > 30)
            throw new ArithmeticException("Lỗi!!! số giờ thuê lớp hơn 30 giờ");
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0");
        DecimalFormat df2 = new DecimalFormat("#,##0.00 VND");
        return super.toString() + String.format("%-15s %-20s", df.format(soGioThue), df2.format(thanhTien()));
    }
}
