package Module4.Bai7;

import java.text.DecimalFormat;

public class SalariedEmployee extends Employee {
    private double luongTuan;
    private int soTuan;

    /**
     * @return double return the luongTuan
     */
    public double getLuongTuan() {
        return luongTuan;
    }

    /**
     * @param luongTuan the luongTuan to set
     */
    public void setLuongTuan(double luongTuan) {
        if (luongTuan < 0)
            luongTuan = 0;
        this.luongTuan = luongTuan;
    }

    /**
     * @return int return the soTuan
     */
    public int getSoTuan() {
        return soTuan;
    }

    /**
     * @param soTuan the soTuan to set
     */
    public void setSoTuan(int soTuan) {
        if (soTuan < 0)
            soTuan = 0;
        this.soTuan = soTuan;
    }

    /**
     * @param firstName
     * @param lastName
     * @param ssn
     * @param luongTuan
     * @param soTuan
     */
    public SalariedEmployee(String firstName, String lastName, int ssn, int soTuan, double luongTuan) {
        super(firstName, lastName, ssn);
        setLuongTuan(luongTuan);
        setSoTuan(soTuan);
    }

    /**
     * 
     */
    public SalariedEmployee() {
        this("", "", 0, 0, 0);
    }

    @Override
    public double tinhLuong() {
        return luongTuan * soTuan;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return super.toString() +
                String.format("%-15s %-15s %-15s %-15s VND", df.format(soTuan), df.format(luongTuan), "", df.format(tinhLuong()));
    }
}
