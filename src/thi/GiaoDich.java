package thi;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiaoDich {
    private String maGD;
    private LocalDate ngayGD;
    private double donGia;
    private int soLuong;
    private double tiGia;
    private String loaiTien;

    /**
     * @return String return the maGD
     */
    public String getMaGD() {
        return maGD;
    }

    /**
     * @param maGD the maGD to set
     */
    public void setMaGD(String maGD) {
        if (maGD.length() == 0 || maGD.equals(""))
            maGD = "Chua xac dinh";
        this.maGD = maGD;
    }

    /**
     * @return LocalDate return the ngayGD
     */
    public LocalDate getNgayGD() {
        return ngayGD;
    }

    /**
     * @param ngayGD the ngayGD to set
     */
    public void setNgayGD(LocalDate ngayGD) {
        if (ngayGD.isAfter(LocalDate.now()))
            ngayGD = LocalDate.now();
        this.ngayGD = ngayGD;
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
        if (donGia < 0.0)
            donGia = 0.0;
        this.donGia = donGia;
    }

    /**
     * @return int return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        if (soLuong < 0)
            soLuong = 0;
        this.soLuong = soLuong;
    }

    /**
     * @return double return the tiGia
     */
    public double getTiGia() {
        return tiGia;
    }

    /**
     * @param tiGia the tiGia to set
     */
    public void setTiGia(double tiGia) {
        if (tiGia < 0)
            tiGia = 1;
        this.tiGia = tiGia;
    }

    /**
     * @return String return the loaiTien
     */
    public String getLoaiTien() {
        return loaiTien;
    }

    /**
     * @param loaiTien the loaiTien to set
     */
    public void setLoaiTien(String loaiTien) {
        if (loaiTien.equalsIgnoreCase("USD"))
            loaiTien = "USD";
        else
            loaiTien = "VN";
        this.loaiTien = loaiTien;
    }

    /**
     * @param maGD
     * @param ngayGD
     * @param donGia
     * @param soLuong
     * @param tiGia
     * @param loaiTien
     */
    public GiaoDich(String maGD, LocalDate ngayGD, double donGia, int soLuong, double tiGia, String loaiTien) {
        setMaGD(maGD);
        setNgayGD(ngayGD);
        setDonGia(donGia);
        setSoLuong(soLuong);
        setTiGia(tiGia);
        setLoaiTien(loaiTien);
    }

    /**
     * 
     */
    public GiaoDich() {
        this("", LocalDate.now(), 0, 1, 0, "VN");
    }

    public double thanhTien() {
        double tien = 0;
        if (loaiTien.equalsIgnoreCase("VN"))
            tien = soLuong * donGia;
        else
            tien = soLuong * donGia * tiGia;
        return tien;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return String.format("%-20s %-15s %-10s %-10s %-10s %-10s %-10s", maGD, dtf.format(ngayGD), df.format(donGia),
                soLuong, df.format(tiGia), loaiTien, df.format(thanhTien()));
    }
}
