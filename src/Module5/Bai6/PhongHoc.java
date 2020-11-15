package Module5.Bai6;

import java.text.DecimalFormat;

public abstract class PhongHoc {
    protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    /**
     * @return String return the maPhong
     */
    public String getMaPhong() {
        return maPhong;
    }

    /**
     * @param maPhong the maPhong to set
     */
    public void setMaPhong(String maPhong) {
        if(maPhong.length() == 0 || maPhong.equalsIgnoreCase(""))
            maPhong = "chua xac dinh";
        this.maPhong = maPhong;
    }

    /**
     * @return String return the dayNha
     */
    public String getDayNha() {
        return dayNha;
    }

    /**
     * @param dayNha the dayNha to set
     */
    public void setDayNha(String dayNha) {
        if(dayNha.length() == 0 || dayNha.equalsIgnoreCase(""))
            dayNha = "chua xac dinh";
        this.dayNha = dayNha;
    }

    /**
     * @return double return the dienTich
     */
    public double getDienTich() {
        return dienTich;
    }

    /**
     * @param dienTich the dienTich to set
     */
    public void setDienTich(double dienTich) {
        if(dienTich < 0)
            dienTich = 0;
        this.dienTich = dienTich;
    }

    /**
     * @return int return the soBongDen
     */
    public int getSoBongDen() {
        return soBongDen;
    }

    /**
     * @param soBongDen the soBongDen to set
     */
    public void setSoBongDen(int soBongDen) {
        if(soBongDen < 0) 
            soBongDen = 0;
        this.soBongDen = soBongDen;
    }

    public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
        setMaPhong(maPhong);
        setDayNha(dayNha);
        setDienTich(dienTich);
        setSoBongDen(soBongDen);
    }

    public PhongHoc() {
        this("", "", 0, 0);
    }

    public abstract int kiemTra();

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return String.format("%-16s %-16s %-10s %-10s ", maPhong, dayNha, df.format(dienTich), df.format(soBongDen));
    }
}
