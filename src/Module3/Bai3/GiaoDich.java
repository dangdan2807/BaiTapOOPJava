package Module3.Bai3;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiaoDich {
    protected String maGD;
    protected LocalDate ngayGD;
    protected double donGia;
    protected int soLuong;

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
            maGD = "Chưa xác định";
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
        if (ngayGD.isBefore(LocalDate.now()))
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
        if(donGia < 0)
            donGia = 0;
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
        if(soLuong < 0)
            soLuong = 0;
        this.soLuong = soLuong;
    }

    /**
     * @param maGD
     * @param ngayGD
     * @param donGia
     * @param soLuong
     */
    public GiaoDich(String maGD, LocalDate ngayGD, double donGia, int soLuong) {
        setMaGD(maGD);
        setNgayGD(ngayGD);
        setDonGia(donGia);
        setSoLuong(soLuong);
    }

    /**
     * 
     */
    public GiaoDich() {
        this("Chưa xác định", LocalDate.now(), 0, 0);
    }

    public double tinhTien() {
        return soLuong * donGia;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("%-10s %-20s %-20s %-15d", maGD, dtf.format(ngayGD), df.format(donGia), soLuong);
    }
}