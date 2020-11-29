package Module4.Bai6;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class HoaDonNgay extends HoaDon {
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
        if (soNgayThue < 0)
            soNgayThue = 0;
        this.soNgayThue = soNgayThue;
    }

    /**
     * @param maHoaDon
     * @param ngayHD
     * @param tenKH
     * @param maPhong
     * @param donGia
     * @param soNgayThue
     */
    public HoaDonNgay(String maHoaDon, LocalDate ngayHD, String tenKH, String maPhong, double donGia, int soNgayThue) {
        super(maHoaDon, ngayHD, tenKH, maPhong, donGia);
        setSoNgayThue(soNgayThue);
    }

    /**
     * 
     */
    public HoaDonNgay() {
        this("", LocalDate.now(), "", "", 0, 0);
    }

    @Override
    public double thanhTien() {
        double tien = 0;
        int ngayConLai = 0;
        if (soNgayThue > 7)
            ngayConLai = soNgayThue - 7;
        tien = (soNgayThue - ngayConLai) * donGia + (ngayConLai * donGia * 0.8);
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        return super.toString() + String.format("%-17d %-15s", soNgayThue, df.format(thanhTien()));
    }
}
