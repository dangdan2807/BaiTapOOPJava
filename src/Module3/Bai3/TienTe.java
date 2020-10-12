package Module3.Bai3;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class TienTe extends GiaoDich{
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
        if(tiGia < 0)
            tiGia = 0;
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
        if(loaiTien.equalsIgnoreCase("VND") || loaiTien.equalsIgnoreCase("USD") || loaiTien.equalsIgnoreCase("EURO"))
            this.loaiTien = loaiTien;
        else
            this.loaiTien = "VND";
    }

	/**
	 * @param maGD
	 * @param ngayGD
	 * @param donGia
	 * @param soLuong
	 * @param tiGia
	 * @param loaiTien
	 */
	public TienTe(String maGD, LocalDate ngayGD, double donGia, int soLuong, double tiGia, String loaiTien) {
		super(maGD, ngayGD, donGia, soLuong);
        setTiGia(tiGia);
        setLoaiTien(loaiTien);
	}

    public double tinhTien() {
        double tien = 0;
        if(loaiTien.equalsIgnoreCase("VND"))
            tien = getDonGia() * getSoLuong();
        else
            tien = getDonGia() * getSoLuong() * tiGia;
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return super.toString() + String.format("%-20s %-20s", loaiTien, df.format(tinhTien()));
    }
}
