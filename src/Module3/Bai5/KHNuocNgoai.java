package Module3.Bai5;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class KHNuocNgoai extends KhachHang {
    private String quocTich;

    /**
     * @return String return the quocTich
     */
    public String getQuocTich() {
        return quocTich;
    }

    /**
     * @param quocTich the quocTich to set
     */
    public void setQuocTich(String quocTich) {
        if (quocTich.length() == 0 || quocTich.equals(""))
            quocTich = "Chưa xác định";
        this.quocTich = quocTich;
    }

    /**
     * @param maKH
     * @param hoTen
     * @param ngayLapHD
     * @param soKW
     * @param donGia
     * @param quocTich
     */
    public KHNuocNgoai(String maKH, String hoTen, LocalDate ngayLapHD, int soKW, double donGia, String quocTich) {
        super(maKH, hoTen, ngayLapHD, soKW, donGia);
        setQuocTich(quocTich);
    }

    /**
     * 
     */
    public KHNuocNgoai() {
        this("", "", LocalDate.now(), 0, 0.0, "");
    }

    public double thanhTien() {
        return (double) soKW * donGia;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00 VND");
        return super.toString() + String.format("%-25s %-10s %-15s", quocTich, "", df.format(thanhTien()));
    }
}
