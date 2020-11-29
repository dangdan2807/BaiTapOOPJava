package Module4.Bai7;

import java.text.DecimalFormat;

public class HourlyEmployee extends Employee {
    private int soGio;
    private double luongTrenGio;

    /**
     * @return int return the soGio
     */
    public int getSoGio() {
        return soGio;
    }

    /**
     * @param soGio the soGio to set
     */
    public void setSoGio(int soGio) {
        if (soGio < 0)
            soGio = 0;
        this.soGio = soGio;
    }

    /**
     * @return double return the luongTrenGio
     */
    public double getLuongTrenGio() {
        return luongTrenGio;
    }

    /**
     * @param luongTrenGio the luongTrenGio to set
     */
    public void setLuongTrenGio(double luongTrenGio) {
        if (luongTrenGio < 0)
            luongTrenGio = 0;
        this.luongTrenGio = luongTrenGio;
    }

    /**
     * @param firstName
     * @param lastName
     * @param ssn
     * @param soGio
     * @param luongTrenGio
     */
    public HourlyEmployee(String firstName, String lastName, int ssn, int soGio, double luongTrenGio) {
        super(firstName, lastName, ssn);
        setSoGio(soGio);
        setLuongTrenGio(luongTrenGio);
    }

    /**
     * 
     */
    public HourlyEmployee() {
        this("", "", 0, 0, 0);
    }

    @Override
    public double tinhLuong() {
        double tien = 0;
        if (soGio <= 40)
            tien = soGio * luongTrenGio;
        else if (soGio > 40)
            tien = 40 * luongTrenGio + (soGio - 40) * luongTrenGio * 1.5;
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return super.toString() +
                String.format("%-15s %-15s %-15s %-15s VND", df.format(soGio), df.format(luongTrenGio), "", df.format(tinhLuong()));
    }
}
