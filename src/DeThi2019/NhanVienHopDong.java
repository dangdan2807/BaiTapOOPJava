package DeThi2019;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class NhanVienHopDong extends NhanVien {
    private int soNgayCong;

    /**
     * @return int return the soNgayCong
     */
    public int getSoNgayCong() {
        return soNgayCong;
    }

    /**
     * @param soNgayCong the soNgayCong to set
     */
    public void setSoNgayCong(int soNgayCong) {
        if (soNgayCong < 0)
            soNgayCong = 0;
        else if (soNgayCong >= 30)
            soNgayCong = 30;
        this.soNgayCong = soNgayCong;
    }

    /**
     * @param maNV
     * @param hoTen
     * @param ngayVaoLam
     * @param soNgayCong
     */
    public NhanVienHopDong(String maNV, String hoTen, LocalDate ngayVaoLam, int soNgayCong) {
        super(maNV, hoTen, ngayVaoLam);
        setSoNgayCong(soNgayCong);
    }

    /**
     * 
     */
    public NhanVienHopDong() {
        this("", "", LocalDate.now(), 0);
    }

    @Override
    public double tinhLuong() {
        double tien = 0;
        if (soNgayCong >= 15) {
            tien = soNgayCong * 150000;
            if(soNgayCong >= 20)
                tien = soNgayCong * 200000;
        }
        else
            tien = soNgayCong * 100000;

        // if(soNgayCong >= 20)
        // tien = soNgayCong * 200000;
        // else if(soNgayCong < 20 && soNgayCong >= 15)
        // tien = soNgayCong * 150000;
        // else if(soNgayCong < 15)
        // tien = soNgayCong * 100000;
        return tien;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.## VND");
        return super.toString() + String.format("%-15s %-17s %-15s", "", soNgayCong, df.format(tinhLuong()));
    }
}
