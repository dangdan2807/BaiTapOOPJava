package DeThi2019;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class NhanVienBienChe extends NhanVien {
    private double heSoLuong;
    private String tienDo;

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
        if(heSoLuong < 2.34)
            heSoLuong = 2.34;
        else if(heSoLuong > 4.98)
            heSoLuong = 4.98;
        this.heSoLuong = heSoLuong;
    }

    /**
     * @return boolean return the tienDo
     */
    public String getTienDo() {
        return tienDo;
    }

    /**
     * @param tienDo the tienDo to set
     */
    public void setTienDo(String tienDo) {
        if(tienDo.equalsIgnoreCase("hoan thanh") || tienDo.equalsIgnoreCase("hoàn thành") ||
        tienDo.equalsIgnoreCase("co") || tienDo.equalsIgnoreCase("Có"))
            tienDo = "co";
        else
            tienDo = "khong";
        this.tienDo = tienDo;
    }

    /**
     * @param maNV
     * @param hoTen
     * @param ngayVaoLam
     * @param heSoLuong
     * @param tienDo
     */
    public NhanVienBienChe(String maNV, String hoTen, LocalDate ngayVaoLam, double heSoLuong, String tienDo) {
        super(maNV, hoTen, ngayVaoLam);
        setHeSoLuong(heSoLuong);
        setTienDo(tienDo);
    }

    /**
     * 
     */
    public NhanVienBienChe() {
        this("", "", LocalDate.now(), 0, "khong");
    }

    @Override
    public double tinhLuong() {
        double tien = 0;
        double phuCap = 0;
        if(tienDo.equalsIgnoreCase("co") || tienDo.equalsIgnoreCase("Có"))
            phuCap = 2000000;
        else
            phuCap = 500000;
        tien = 1400000 * heSoLuong + phuCap;
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        DecimalFormat df2 = new DecimalFormat("#,##0.## VND");
        return super.toString() + String.format("%-15s %-15s %-15s", df.format(heSoLuong), tienDo, df2.format(tinhLuong()));
    }
}
