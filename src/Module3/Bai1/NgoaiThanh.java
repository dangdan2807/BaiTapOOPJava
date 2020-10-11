package Module3.Bai1;

public class NgoaiThanh extends Xe{
    private String noiDen;
    private int soNgay;

    /**
     * @return String return the noiDen
     */
    public String getNoiDen() {
        return noiDen;
    }

    /**
     * @param noiDen the noiDen to set
     */
    public void setNoiDen(String noiDen) {
        if(noiDen.length() == 0 || noiDen.equals(""))
            noiDen = "Chưa xác định";
        this.noiDen = noiDen;
    }

    /**
     * @return int return the soNgay
     */
    public int getSoNgay() {
        return soNgay;
    }

    /**
     * @param soNgay the soNgay to set
     */
    public void setSoNgay(int soNgay) {
        if(soNgay < 0)
            soNgay = 0;
        this.soNgay = soNgay;
    }

    /**
     * @param maSoChuyen
     * @param name
     * @param soXe
     * @param doanhThu
     * @param noiDen
     * @param soNgay
     */
    public NgoaiThanh(String maSoChuyen, String name, String soXe, double doanhThu, String noiDen, int soNgay) {
        super(maSoChuyen, name, soXe, doanhThu);
        setNoiDen(noiDen);
        setSoNgay(soNgay);
    }

    public String toString() {
        return super.toString() + String.format("%-20s %-15d", noiDen, soNgay);
    }
}
