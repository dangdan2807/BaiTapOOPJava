package Module4.Bai2;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SachTK extends Sach {
    private double thue;

    /**
     * @return double return the thue
     */
    public double getThue() {
        return thue;
    }

    /**
     * @param thue the thue to set
     */
    public void setThue(double thue) {
        if(thue < 0)
            thue = 0;
        this.thue = thue;
    }

    /**
     * @param maSach
     * @param ngayNhap
     * @param donGia
     * @param soLuong
     * @param nxb
     * @param thue
     */
    public SachTK(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nxb, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nxb);
        setThue(thue);
    }

    /**
     * 
     */
    public SachTK() {
        this("", LocalDate.now(), 0, 0, "", 0);
    }

    @Override
    public double tinhTien() {
        return getSoLuong() * getDonGia() + thue;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        DecimalFormat df2 = new DecimalFormat("#,##0.##");
        return super.toString() + String.format("%-15s %-20s", df2.format(thue), df.format(tinhTien()));
    }
}
