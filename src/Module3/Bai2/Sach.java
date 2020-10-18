package Module3.Bai2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sach {
    protected String maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nxb;

    /**
     * @return String return the maSach
     */
    public String getMaSach() {
        return maSach;
    }

    /**
     * @param maSach the maSach to set
     */
    public void setMaSach(String maSach) {
        if (maSach.equals("") || maSach.length() == 0)
            maSach = "Chưa Xác Định";
        this.maSach = maSach;
    }

    /**
     * @return int return the ngayNhap
     */
    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    /**
     * @param ngayNhap the ngayNhap to set
     */
    public void setNgayNhap(LocalDate ngayNhap) {
        if (ngayNhap.isAfter(LocalDate.now()))
            ngayNhap = LocalDate.now();
        this.ngayNhap = ngayNhap;
    }

    /**
     * @return double return the donGia
     */
    public double getDonGia() {
        return donGia;
    }

    /**
     * @param donGia the donGia to set
     */
    public void setDonGia(double donGia) {
        if (donGia < 0)
            donGia = 0;
        this.donGia = donGia;
    }

    /**
     * @return int return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        if (soLuong < 0)
            soLuong = 1;
        this.soLuong = soLuong;
    }

    /**
     * @return String return the nxb
     */
    public String getNxb() {
        return nxb;
    }

    /**
     * @param nxb the nxb to set
     */
    public void setNxb(String nxb) {
        if (nxb.equals("") || nxb.length() == 0)
            nxb = "Chưa Xác Định";
        this.nxb = nxb;
    }

    /**
     * @param maSach
     * @param ngayNhap
     * @param donGia
     * @param soLuong
     * @param nxb
     */
    public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nxb) {
        setMaSach(maSach);
        setNgayNhap(ngayNhap);
        setDonGia(donGia);
        setSoLuong(soLuong);
        setNxb(nxb);
    }

    
    public double tinhTien() {
        return soLuong * donGia;
    }

    /**
     * 
     */
    public Sach() {
        this("Chưa xác định", LocalDate.now(), 0, 0, "Chưa xác định");
    }

    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-20s %-15s %-10.2f %-10d %-20s", maSach, dtf.format(ngayNhap), donGia, soLuong, nxb);
    }

}
