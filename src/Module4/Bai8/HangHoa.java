package Module4.Bai8;

import java.text.DecimalFormat;

public abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected double donGia;
    protected int soLuong;

    /**
     * @return String return the maHang
     */
    public String getMaHang() {
        return maHang;
    }

    /**
     * @param maHang the maHang to set
     */
    private void setMaHang(String maHang) {
        if (maHang.length() == 0 || maHang.equals(""))
            maHang = "xxx";
        this.maHang = maHang;
    }

    /**
     * @return String return the tenHang
     */
    public String getTenHang() {
        return tenHang;
    }

    /**
     * @param tenHang the tenHang to set
     */
    public void setTenHang(String tenHang) {
        if (tenHang.length() == 0 || tenHang.equals(""))
            tenHang = "xxx";
        this.tenHang = tenHang;
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
     * @return double return the soLuong
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
     * @param maHang
     * @param tenHang
     * @param donGia
     * @param soLuong
     */
    public HangHoa(String maHang, String tenHang, double donGia, int soLuong) {
        setMaHang(maHang);
        setTenHang(tenHang);
        setDonGia(donGia);
        setSoLuong(soLuong);
    }

    public abstract double VAT();

    public abstract String danhGia();

    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return String.format("%-12s %-20s %-13s %-10s ", maHang, tenHang, df.format(donGia), df.format(soLuong));
    }
}
