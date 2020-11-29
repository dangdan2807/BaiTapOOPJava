package Module4.Bai7;

import java.text.DecimalFormat;

public class CommissionEmployee extends Employee {
    private double luongDoanhSo;
    private double hoaHong;

    /**
     * @return double return the luongDoanhSo
     */
    public double getluongDoanhSo() {
        return luongDoanhSo;
    }

    /**
     * @param luongDoanhSo the luongDoanhSo to set
     */
    public void setluongDoanhSo(double luongDoanhSo) {
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
     * @param firstName
     * @param lastName
     * @param ssn
     * @param luongDoanhSo
     * @param hoaHong
     */
    public CommissionEmployee(String firstName, String lastName, int ssn, double hoaHong, double luongDoanhSo) {
        super(firstName, lastName, ssn);
        setluongDoanhSo(luongDoanhSo);
        setHoaHong(hoaHong);
    }

    /**
     * 
     */
    public CommissionEmployee() {
        this("", "", 0, 0, 0);
    }

    @Override
    public double tinhLuong() {
        return luongDoanhSo * hoaHong;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0");
        return super.toString() + 
                String.format("%-15s %-15s %-15s %-15s VND", df.format(hoaHong), df.format(luongDoanhSo), "", df.format(tinhLuong()));
    }
}
