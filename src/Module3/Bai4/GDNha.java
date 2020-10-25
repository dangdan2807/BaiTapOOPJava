package Module3.Bai4;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GDNha extends GiaoDichBDS {
    private String loaiNha;
    private String diaChi;

    /**
     * @return String return the loaiNha
     */
    public String getLoaiNha() {
        return loaiNha;
    }

    /**
     * @param loaiNha the loaiNha to set
     */
    public void setLoaiNha(String loaiNha) {
        if (loaiNha.equalsIgnoreCase("cao Cấp") || loaiNha.equalsIgnoreCase("thường")
                || loaiNha.equalsIgnoreCase("cao cap") || loaiNha.equalsIgnoreCase("thuong"))
            this.loaiNha = loaiNha;
        else
            this.loaiNha = "thuong";
    }

    /**
     * @return String return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        if (diaChi.length() == 0 || diaChi.equals(""))
            diaChi = "";
        this.diaChi = diaChi;
    }

    /**
     * @param maGD
     * @param ngayGD
     * @param donGia
     * @param dienTich
     * @param loaiNha
     * @param diaChi
     */
    public GDNha(String maGD, LocalDate ngayGD, double donGia, double dienTich, String loaiNha, String diaChi) {
        super(maGD, ngayGD, donGia, dienTich);
        setLoaiNha(loaiNha);
        setDiaChi(diaChi);
    }

    public double tinhTien() {
        double tien = 0;
        if(loaiNha.equalsIgnoreCase("thuong"))
            tien = getDienTich() * getDonGia() * 0.9;
        else
            tien = getDienTich() * getDonGia();
        return tien;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("%-65s %-10s %-40s %-15s", super.toString(), loaiNha, diaChi, df.format(tinhTien()));
    }
}
