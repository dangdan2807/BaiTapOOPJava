package Module3.Bai2;

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

    @Override
    public String toString() {
        return super.toString() + String.format("%-10.2f %-20.2f", thue, tinhTien());
    }
}
