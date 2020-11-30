package DeThi2019;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class NhanVien {
    private String maNV;
    private String hoTen;
    private LocalDate ngayVaoLam;

    /**
     * @return String return the maNV
     */
    public String getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(String maNV) {
        if(maNV.length() == 0 || maNV.equals(""))
            maNV = "xxx";
        this.maNV = maNV;
    }

    /**
     * @return String return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        if(hoTen.length() == 0 || hoTen.equals(""))
            hoTen = "xxx";
        this.hoTen = hoTen;
    }

    /**
     * @return LocalDate return the ngayVaoLam
     */
    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NhanVien)) {
            return false;
        }
        NhanVien nhanVien = (NhanVien) o;
        return Objects.equals(maNV, nhanVien.maNV);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(maNV);
    }


    /**
     * @param ngayVaoLam the ngayVaoLam to set
     */
    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        if(ngayVaoLam.isBefore(LocalDate.now()))
            ngayVaoLam = LocalDate.now();
        this.ngayVaoLam = ngayVaoLam;
    }

    /**
     * @param maNV
     * @param hoTen
     * @param ngayVaoLam
     */
    public NhanVien(String maNV, String hoTen, LocalDate ngayVaoLam) {
        setMaNV(maNV);
        setHoTen(hoTen);
        setNgayVaoLam(ngayVaoLam);
    }

    /**
     * 
     */
    public NhanVien() {
        this("", "", LocalDate.now());
    }

    public abstract double tinhLuong();

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-10s %-20s %-15s ", maNV, hoTen, dtf.format(ngayVaoLam));
    }
}
