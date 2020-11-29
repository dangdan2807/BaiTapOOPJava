package Module4.Bai7;

import java.text.DecimalFormat;

public class BasePlusCommission extends Employee {
    private double hoaHong;
    private double luongDoanhSo;
    private double luongCoBan;

    /**
     * @return double return the luongDoanhSo
     */
    public double getLuongDoanhSo() {
        return luongDoanhSo;
    }

    /**
     * @param luongDoanhSo the luongDoanhSo to set
     */
    public void setLuongDoanhSo(double luongDoanhSo) {
        if (luongDoanhSo < 0)
            luongDoanhSo = 0;
        this.luongDoanhSo = luongDoanhSo;
    }

    /**
     * @return double return the hoaHong
     */
    public double getHoaHong() {
        return hoaHong;
    }

    /**
     * @param hoaHong the hoaHong to set
     */
    public void setHoaHong(double hoaHong) {
        if (hoaHong < 0)
            hoaHong = 0;
        this.hoaHong = hoaHong;
    }

    /**
     * @return double return the luongCoBan
     */
    public double getLuongCoBan() {
        return luongCoBan;
    }

    /**
     * @param luongCoBan the luongCoBan to set
     */
    public void setLuongCoBan(double luongCoBan) {
        if (luongCoBan < 0)
            luongCoBan = 0;
        this.luongCoBan = luongCoBan;
    }

    /**
     * @param firstName
     * @param lastName
     * @param ssn
     * @param luongDoanhSo
     * @param hoaHong
     * @param luongCoBan
     */
    public BasePlusCommission(
            String firstName,
            String lastName,
            int ssn,
            double hoaHong,
            double luongDoanhSo,
            double luongCoBan) {
        super(firstName, lastName, ssn);
        setHoaHong(hoaHong);
        setLuongDoanhSo(luongDoanhSo);
        setLuongCoBan(luongCoBan);
    }

    /**
     * 
     */
    public BasePlusCommission() {
        this("", "", 0, 0, 0, 0);
    }

    @Override
    public double tinhLuong() {
        return (luongDoanhSo * hoaHong) + luongCoBan;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0");
        return super.toString() +
                String
                        .format(
                                "%-15s %-15s %-15s %-15s VND",
                                df.format(hoaHong),
                                df.format(luongDoanhSo),
                                df.format(luongCoBan),
                                df.format(tinhLuong()));
    }
}
