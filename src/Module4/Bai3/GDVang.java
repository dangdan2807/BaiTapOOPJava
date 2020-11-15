package Module4.Bai3;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GDVang extends GiaoDich {
    private String loaiVang;

    /**
     * @return String return the loaiVang
     */
    public String getLoaiVang() {
        return loaiVang;
    }

    /**
     * @param loaiVang the loaiVang to set
     */
    public void setLoaiVang(String loaiVang) {
        this.loaiVang = loaiVang;
    }

    /**
     * @param maGD
     * @param ngayGD
     * @param donGia
     * @param soLuong
     * @param loaiVang
     */
    public GDVang(String maGD, LocalDate ngayGD, double donGia, int soLuong, String loaiVang) {
        super(maGD, ngayGD, donGia, soLuong);
        this.loaiVang = loaiVang;
    }

    /**
     * @param loaiVang
     */
    public GDVang() {
        this("chua xac dinh", LocalDate.now(), 0, 0, "chua xac dinh");
    }

    @Override
    public double thanhTien() {
        return (double) (soLuong * donGia);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        return super.toString() + String.format("%-10s %-15s %-10s", "", loaiVang, df.format(thanhTien()));
    }
}
