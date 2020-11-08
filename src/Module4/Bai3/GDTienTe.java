package Module4.Bai3;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GDTienTe extends GiaoDich {
    private double tiGia;
    private String loaiTien;

    /**
     * @return double return the tiGia
     */
    public double getTiGia() {
        return tiGia;
    }

    /**
     * @param tiGia the tiGia to set
     */
    public void setTiGia(double tiGia) {
        if (tiGia < 0)
            tiGia = 1;
        this.tiGia = tiGia;
    }

    /**
     * @return String return the loaiTien
     */
    public String getLoaiTien() {
        return loaiTien;
    }

    /**
     * @param loaiTien the loaiTien to set
     */
    public void setLoaiTien(String loaiTien) {
        if (loaiTien.equalsIgnoreCase("USD"))
            loaiTien = "USD";
        else
            loaiTien = "VND";
        this.loaiTien = loaiTien;
    }

    /**
     * @param maGD
     * @param ngayGD
     * @param donGia
     * @param soLuong
     * @param tiGia
     * @param loaiTien
     */
    public GDTienTe(String maGD, LocalDate ngayGD, double donGia, int soLuong, double tiGia, String loaiTien) {
        super(maGD, ngayGD, donGia, soLuong);
        setTiGia(tiGia); 
        setLoaiTien(loaiTien);
    }

    /**
     * @param tiGia
     * @param loaiTien
     */
    public GDTienTe() {
        this("chua xac dinh", LocalDate.now(), 0, 0, 1, "VND");
    }

    @Override
    public double thanhTien() {
        double tien = 0;
        if (loaiTien.equalsIgnoreCase("VND"))
            tien = soLuong * donGia;
        else
            tien = soLuong * donGia * tiGia;
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        DecimalFormat df2 = new DecimalFormat("#,##0.## VND");
        return super.toString()
                + String.format("%-10s %-15s %-10s", df.format(tiGia), loaiTien, df2.format(thanhTien()));
    }
}
