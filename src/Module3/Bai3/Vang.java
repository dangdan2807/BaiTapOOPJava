package Module3.Bai3;

import java.text.DecimalFormat;
import java.time.LocalDate;

// package Module3.Bai3;

public class Vang extends GiaoDich {
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
        if(loaiVang.length() == 0 || loaiVang.equals(""))
            loaiVang = "Chưa xác định";
        this.loaiVang = loaiVang;
    }

    /**
     * @param maGD
     * @param ngayGD
     * @param donGia
     * @param soLuong
     * @param loaiVang
     */
    public Vang(String maGD, LocalDate ngayGD, double donGia, int soLuong, String loaiVang) {
        super(maGD, ngayGD, donGia, soLuong);
        setLoaiVang(loaiVang);
    }

    @Override
    public double tinhTien() {
        return super.tinhTien();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return super.toString() + String.format("%-20s %-20s", loaiVang, df.format(tinhTien()));
    }
}
