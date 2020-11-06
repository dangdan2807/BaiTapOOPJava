package Module3.Bai6;

import java.text.*;
import java.time.*;
import java.time.format.*;

public class HoaDon {
    protected String maHD;
    protected LocalDate ngayHD;
    protected String tenKH;
    protected String maPhong;
    protected double donGia;

    /**
     * @return String return the maHD
     */
    public String getMaHD() {
        return maHD;
    }

    /**
     * @param maHD the maHD to set
     */
    public void setMaHD(String maHD) {
        if(maHD.length() == 0 || maHD.equals(""))
            maHD = "Chua xac dinh";
        this.maHD = maHD;
    }

    /**
     * @return LocalDate return the ngayHD
     */
    public LocalDate getNgayHD() {
        return ngayHD;
    }

    /**
     * @param ngayHD the ngayHD to set
     */
    public void setNgayHD(LocalDate ngayHD) {
        if (ngayHD.isAfter(LocalDate.now()))
            ngayHD = LocalDate.now();
        this.ngayHD = ngayHD;
    }

    /**
     * @return String return the tenKH
     */
    public String getTenKH() {
        return tenKH;
    }

    /**
     * @param tenKH the tenKH to set
     */
    public void setTenKH(String tenKH) {
        if(tenKH.length() == 0 || tenKH.equals(""))
            tenKH = "Chua xac dinh";
        this.tenKH = tenKH;
    }

    /**
     * @return String return the maPhong
     */
    public String getMaPhong() {
        return maPhong;
    }

    /**
     * @param maPhong the maPhong to set
     */
    public void setMaPhong(String maPhong) {
        if(maPhong.length() == 0 || maPhong.equals(""))
            maPhong = "Chua xac dinh";
        this.maPhong = maPhong;
    }

    /**
     * @return double return the donGia
     */
    public double getDonGia() {
        return donGia;
    }

    /**
     * @param donGia the donGia to set
     */
    public void setDonGia(double donGia) {
        if(donGia < 0.0)
            donGia = 0.0;
        this.donGia = donGia;
    }

    /**
     * @param maHD
     * @param ngayHD
     * @param tenKH
     * @param maPhong
     * @param donGia
     */
    public HoaDon(String maHD, LocalDate ngayHD, String tenKH, String maPhong, double donGia) {
        setMaHD(maHD);
        setNgayHD(ngayHD);
        setTenKH(tenKH);
        setMaPhong(maPhong);
        setDonGia(donGia);
    }

    /**
     * 
     */
    public HoaDon() {
        this("", LocalDate.now(), "", "", 0.0);
    }

    @Override
    public String toString() {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("%-15s %-15s %-25s %-15s %-15s ", maHD, dft.format(ngayHD), tenKH, maPhong, df.format(donGia));
    }
}
