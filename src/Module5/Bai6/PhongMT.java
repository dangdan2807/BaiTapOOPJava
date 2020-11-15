package Module5.Bai6;

import java.text.DecimalFormat;

public class PhongMT extends PhongHoc {
    private int mayTinh;

    /**
     * @return int return the mayTinh
     */
    public int getMayTinh() {
        return mayTinh;
    }

    /**
     * @param mayTinh the mayTinh to set
     */
    public void setMayTinh(int mayTinh) {
        if (mayTinh < 0)
            mayTinh = 0;
        this.mayTinh = mayTinh;
    }

    public PhongMT(String maPhong, String dayNha, double dienTich, int soBongDen, int mayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        setMayTinh(mayTinh);
    }

    public PhongMT() {
        this("", "", 0f, 0, 0);
    }

    @Override
    public int kiemTra() {
        double dt = dienTich / mayTinh;
        if (dt > 1.5)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        String kt = "";
        if(kiemTra() == 1)
            kt = "Dat";
        else
            kt = "Khong Dat";
        DecimalFormat df = new DecimalFormat("#,##0");
        return super.toString() + String.format("%-20s %-15s %-10s %-20s", "", "", df.format(mayTinh), kt);
    }
}
