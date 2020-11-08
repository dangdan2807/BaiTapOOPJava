package Module4.Bai4;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GDDat extends GiaoDichBDS {
    private String loaiDat;

    /**
     * @return String return the loaiDat
     */
    public String getLoaiDat() {
        return loaiDat;
    }

    /**
     * @param loaiDat the loaiDat to set
     */
    public void setLoaiDat(String loaiDat) {
        if (loaiDat.equalsIgnoreCase("A") || loaiDat.equalsIgnoreCase("B") || loaiDat.equalsIgnoreCase("C"))
            this.loaiDat = loaiDat;
        else
            this.loaiDat = "C";
    }

    /**
     * @param maGD
     * @param ngayGD
     * @param donGia
     * @param dienTich
     * @param loaiDat
     */
    public GDDat(String maGD, LocalDate ngayGD, double donGia, double dienTich, String loaiDat) {
        super(maGD, ngayGD, donGia, dienTich);
        setLoaiDat(loaiDat);
    }

    /**
     */
    public GDDat() {
        this("", LocalDate.now(), 0, 0, "");
    }

    @Override
    public double thanhTien() {
        double tien = 0;
        if (loaiDat.equalsIgnoreCase("B") || loaiDat.equalsIgnoreCase("C"))
            tien = dienTich * donGia;
        else if (loaiDat.equalsIgnoreCase("A"))
            tien = dienTich * donGia * 1.5;
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("%-56s %-10s %-40s %-15s", super.toString(), loaiDat, "", df.format(thanhTien()));
    }
}
