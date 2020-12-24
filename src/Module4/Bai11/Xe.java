package Module4.Bai11;

import java.text.DecimalFormat;
import java.util.Objects;

public abstract class Xe {
    protected String maXe;
    protected String tenXe;
    protected double donGia;

    /**
     * @return String return the maXe
     */
    public String getMaXe() {
        return maXe;
    }

    /**
     * @param maXe the maXe to set
     */
    public void setMaXe(String maXe) {
        if (maXe.length() == 0 || maXe.equals(""))
            maXe = "xxx";
        this.maXe = maXe;
    }

    /**
     * @return String return the tenXe
     */
    public String getTenXe() {
        return tenXe;
    }

    /**
     * @param tenXe the tenXe to set
     */
    public void setTenXe(String tenXe) {
        if (tenXe.length() == 0 || tenXe.equals(""))
            tenXe = "xxx";
        this.tenXe = tenXe;
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
     * @param maXe
     * @param tenXe
     * @param donGia
     */
    public Xe(String maXe, String tenXe, double donGia) {
        setMaXe(maXe);
        setTenXe(tenXe);
        setDonGia(donGia);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Xe)) {
            return false;
        }
        Xe xe = (Xe) o;
        return Objects.equals(maXe, xe.maXe);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(maXe);
    }

    public abstract double VAT();

    public abstract String loaiXe();

    public abstract double thueTruocBa();

    public abstract double thanhTien();

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return String.format("%-15s %-20s %-15s ", maXe, tenXe, df.format(donGia));
    }
}
