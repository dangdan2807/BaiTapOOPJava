package Module5.Bai6;

public class PhongLT extends PhongHoc{
    private String mayChieu;

    /**
     * @return boolean return the mayChieu
     */
    public String isMayChieu() {
        return mayChieu;
    }

    /**
     * @param mayChieu the mayChieu to set
     */
    public void setMayChieu(String mayChieu) {
        if(mayChieu.equalsIgnoreCase("co") || mayChieu.equalsIgnoreCase("Có"))
            mayChieu = "Có";
        else
            mayChieu = "Không";
        this.mayChieu = mayChieu;
    }

    public PhongLT(String maPhong, String dayNha, double dienTich, int soBongDen, String mayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        setMayChieu(mayChieu);
    }

    public PhongLT() {
        this("", "", 0, 0, "Khong");
    }

    @Override
    public int kiemTra() {
        if(mayChieu.equalsIgnoreCase("co") || mayChieu.equalsIgnoreCase("Có"))
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
        return super.toString() + String.format("%-20s %-15s %-10s %-20s", "", "", mayChieu, kt);
    }
}
