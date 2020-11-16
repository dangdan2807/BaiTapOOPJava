package Module4.Bai6;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class HoaDon {
    protected String maHoaDon;
    protected LocalDate ngayHD;
    protected String tenKH;
    protected String maPhong;
    protected double donGia;

    /**
     * @return String return the maHoaDon
     */
    public String getMaHoaDon() {
        return maHoaDon;
    }

    /**
     * @param maHoaDon the maHoaDon to set
     */
    public void setMaHoaDon(String maHoaDon) {
        if(maHoaDon.length() == 0 || maHoaDon.equalsIgnoreCase(""))
            maHoaDon = "chua xac dinh";
        this.maHoaDon = maHoaDon;
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
        if(ngayHD.isAfter(LocalDate.now()))
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
        if(tenKH.length() == 0 || tenKH.equalsIgnoreCase(""))
            tenKH = "chua xac dinh";
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
        if(maPhong.length() == 0 || maPhong.equalsIgnoreCase(""))
            maPhong = "999999";
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
        if (donGia < 0)
            donGia = 0;
        this.donGia = donGia;
    }

    /**
     * @param maHoaDon
     * @param ngayHD
     * @param tenKH
     * @param maPhong
     * @param donGia
     */
    public HoaDon(String maHoaDon, LocalDate ngayHD, String tenKH, String maPhong, double donGia) {
        setMaHoaDon(maHoaDon);  
        setNgayHD(ngayHD);
        setTenKH(tenKH);
        setMaPhong(maPhong);
        setDonGia(donGia);
    }

    /**
     * 
     */
    public HoaDon() {
        this("", LocalDate.now(), "", "", 0f);
    }

    public abstract double thanhTien();

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-20s %-15s %-20s %-15s %-10s ", maHoaDon, dtf.format(ngayHD), tenKH, maPhong, df.format(donGia));
    }
    
}
