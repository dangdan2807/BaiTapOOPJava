package Module4.Bai9;

import java.text.DecimalFormat;

public class Employee extends Person {
    private double heSoLuong;
    private double luongCoBan;
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
        if (heSoLuong < 0)
            heSoLuong = 0;
        this.heSoLuong = heSoLuong;
    }

    /**
     * @return the luongCoBan
     */
    public double getTienLuong() {
        return luongCoBan;
    }

    /**
     * @param luongCoBan the luongCoBan to set
     */
    public void setLuongCoBan(double luongCoBan) {
        if (luongCoBan < 0)
            luongCoBan = 0;
        this.luongCoBan = luongCoBan;
    }

    /**
     * @return the tienDo
     */
    public String getTienDo() {
        return tienDo;
    }

    /**
     * @param tienDo the tienDo to set
     */
    public void setTienDo(String tienDo) {
        if(tienDo.equalsIgnoreCase("co"))
            tienDo = "Co";
        else
            tienDo = "Khong";
        this.tienDo = tienDo;
    }

    /**
     * @param hoTen
     * @param diaChi
     * @param heSoLuong
     */
    public Employee(String hoTen, String diaChi, double heSoLuong, double luongCoBan, String tienDo) {
        super(hoTen, diaChi);
        setHeSoLuong(heSoLuong);
        setLuongCoBan(luongCoBan);
        setTienDo(tienDo);
    }

    /**
     * 
     */
    public Employee() {
        super("", "");
        setHeSoLuong(0);
        setLuongCoBan(0);
        setTienDo("Khong");
    }

    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }

    public String danhGia() {
        String str = "";
        if(tienDo.equalsIgnoreCase("co"))
            str = "dat";
        else
            str = "khong dat";
        return str;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return super.toString() + String.format("%-10s %-10s %-10s %-10s %-20s", df.format(luongCoBan), df.format(heSoLuong),
                tienDo ,df.format(tinhLuong()), danhGia());
    }
}
