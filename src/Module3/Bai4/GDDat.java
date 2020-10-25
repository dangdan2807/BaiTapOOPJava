package Module3.Bai4;

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

    public double tinhTien() {
        double tien = 0;
        if (loaiDat.equalsIgnoreCase("B") || loaiDat.equalsIgnoreCase("C"))
            tien = getDienTich() * getDonGia();
        else if (loaiDat.equalsIgnoreCase("A"))
            tien = getDienTich() * getDonGia() * 1.5;
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("%-65s %-10s %-40s %-15s", super.toString(), loaiDat, "", df.format(tinhTien()));
    }
}
