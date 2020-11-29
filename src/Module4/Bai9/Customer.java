package Module4.Bai9;

import java.text.DecimalFormat;

public class Customer extends Person {
    private String tenCongTy;
    private double giaTriHoaDon;

    /**
     * @return String return the tenCongTy
     */
    public String getTenCongTy() {
        return tenCongTy;
    }

    /**
     * @param tenCongTy the tenCongTy to set
     */
    public void setTenCongTy(String tenCongTy) {
        if (tenCongTy.length() == 0 || tenCongTy.equals(""))
            tenCongTy = "xxx";
        this.tenCongTy = tenCongTy;
    }

    /**
     * @return double return the giaTriHoaDon
     */
    public double getGiaTriHoaDon() {
        return giaTriHoaDon;
    }

    /**
     * @param giaTriHoaDon the giaTriHoaDon to set
     */
    public void setGiaTriHoaDon(double giaTriHoaDon) {
        if (giaTriHoaDon < 0)
            giaTriHoaDon = 0;
        this.giaTriHoaDon = giaTriHoaDon;
    }

    /**
     * @param hoTen
     * @param diaChi
     * @param tenCongTy
     * @param giaTriHoaDon
     * @param danhGia
     */
    public Customer(String hoTen, String diaChi, String tenCongTy, double giaTriHoaDon) {
        super(hoTen, diaChi);
        setTenCongTy(tenCongTy);
        setGiaTriHoaDon(giaTriHoaDon);
    }

    /**
     * 
     */
    public Customer() {
        super("", "");
        setTenCongTy("");
        setGiaTriHoaDon(0);
    }

    @Override
    public String danhGia() {
        String str = "";
        if (giaTriHoaDon >= 10000000)
            str = "VIP";
        else if (giaTriHoaDon < 10000000 && giaTriHoaDon >= 7000000)
            str = "Than Thiet";
        else if (giaTriHoaDon < 7000000 && giaTriHoaDon >= 5000000)
            str = "Vang";
        else if (giaTriHoaDon < 5000000 && giaTriHoaDon >= 3000000)
            str = "Bac";
        else if (giaTriHoaDon < 3000000 && giaTriHoaDon >= 1000000)
            str = "Dong";
        else
            str = "Thuong";
        return str;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return super.toString() + String.format("%-10s %-10s %-10s %-10s %-20s", tenCongTy, df.format(giaTriHoaDon), "", "", danhGia());
    }
}
