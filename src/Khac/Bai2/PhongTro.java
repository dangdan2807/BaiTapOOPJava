package Khac.Bai2;

import java.text.DecimalFormat;

public class PhongTro {
    private int soNgayThue;
    private String loaiPhong;
    private double giaPhong;
    private Nguoi kh;

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
     * @return String return the LoaiPhong
     */
    public String getLoaiPhong() {
        return loaiPhong;
    }

    /**
     * @param loaiPhong the LoaiPhong to set
     */
    public void setLoaiPhong(String loaiPhong) {
        if (loaiPhong.equalsIgnoreCase("cao cap") || loaiPhong.equalsIgnoreCase("cao cấp"))
            this.loaiPhong = loaiPhong;
        else
            this.loaiPhong = "thường";
    }

    /**
     * @return double return the giaPhong
     */
    public double getGiaPhong() {
        return giaPhong;
    }

    /**
     * @param giaPhong the giaPhong to set
     */
    public void setGiaPhong(double giaPhong) {
        if (giaPhong < 0)
            giaPhong = 0;
        this.giaPhong = giaPhong;
    }

    /**
     * @return KhachHang return the kh
     */
    public Nguoi getKh() {
        return kh;
    }

    /**
     * @param kh the kh to set
     */
    public void setKh(Nguoi kh) {
        this.kh = kh;
    }

    /**
     * @param soNgayThue
     * @param loaiPhong
     * @param giaPhong
     * @param kh
     */
    public PhongTro(int soNgayThue, String loaiPhong, double giaPhong, Nguoi kh) {
        setSoNgayThue(soNgayThue);
        setLoaiPhong(loaiPhong);
        setGiaPhong(giaPhong);
        this.kh = kh;
    }

    /**
     * 
     */
    public PhongTro() {
        this(0, "thường", 0, new Nguoi());
    }

    public double tinhTien() {
        double gia1Ngay = giaPhong / 30;
        return (double) (gia1Ngay * soNgayThue);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        return kh.toString() + String.format("%-15d %-12s %-15s %-15s", soNgayThue, loaiPhong, df.format(giaPhong), df.format(tinhTien()));
    }
}
