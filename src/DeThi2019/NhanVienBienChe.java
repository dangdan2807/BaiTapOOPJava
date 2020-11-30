package DeThi2019;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class NhanVienBienChe extends NhanVien {
    private double heSoLuong;
    private boolean tienDo;

    /**
     * @return double return the heSoLuong
     */
    public double getHeSoLuong() {
        return heSoLuong;
    }

    /**
     * @param heSoLuong the heSoLuong to set
     */
    public void setHeSoLuong(double heSoLuong) {
        if (heSoLuong < 2.34)
            heSoLuong = 2.34;
        else if (heSoLuong > 4.98)
            heSoLuong = 4.98;
        this.heSoLuong = heSoLuong;
    }

    /**
     * @return boolean return the tienDo
     */
    public boolean getTienDo() {
        return tienDo;
    }

    /**
     * @param tienDo the tienDo to set
     */
    public void setTienDo(boolean tienDo) {
        this.tienDo = tienDo;
    }

    /**
     * @param maNV
     * @param hoTen
     * @param ngayVaoLam
     * @param heSoLuong
     * @param tienDo
     */
    public NhanVienBienChe(String maNV, String hoTen, LocalDate ngayVaoLam, double heSoLuong, boolean tienDo) {
        super(maNV, hoTen, ngayVaoLam);
        setHeSoLuong(heSoLuong);
        setTienDo(tienDo);
    }

    /**
     * 
     */
    public NhanVienBienChe() {
        this("", "", LocalDate.now(), 0, false);
    }

    @Override
    public double tinhLuong() {
        double tien = 1400000 * heSoLuong;
        if (tienDo == true)
            tien += 2000000;
        else
            tien += 500000;
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        DecimalFormat df2 = new DecimalFormat("#,##0.## VND");
        String str  = (tienDo) ? "Hoan thanh" : "Khong hoan thanh";
        return super.toString()
                + String.format("%-15s %-17s %-15s", df.format(heSoLuong), str, df2.format(tinhLuong()));
    }
}
