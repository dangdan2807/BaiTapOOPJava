package Module4.Bai4;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class GiaoDichBDS {
    protected String maGD;
    protected LocalDate ngayGD;
    protected double donGia;
    protected double dienTich;

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
        if(maGD.length() == 0 || maGD.equals(""))
            maGD = "chua xac dinh";
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
        if(ngayGD.isAfter(LocalDate.now()))
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
     * 
     */
    public GiaoDichBDS() {
        this("", LocalDate.of(2000, 1, 1), 0, 0);
    }

    /**
     * @param maGD
     * @param ngayGD
     * @param donGia
     * @param dienTich
     */
    public GiaoDichBDS(String maGD, LocalDate ngayGD, double donGia, double dienTich) {
        this.maGD = maGD;
        this.ngayGD = ngayGD;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    public abstract double thanhTien();

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("%-16s %-12s %-15s %-13.2f", maGD, dtf.format(ngayGD), df.format(donGia), dienTich);
    }
}
