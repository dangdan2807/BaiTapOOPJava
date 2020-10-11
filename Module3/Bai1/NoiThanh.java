package Module3.Bai1;

public class NoiThanh extends Xe{
    private double soKm;
    private String soTuyen;

    /**
     * @return double return the soKm
     */
    public double getSoKm() {
        return soKm;
    }

    /**
     * @param soKm the soKm to set
     */
    public void setSoKm(double soKm) {
        if(soKm < 0)
            soKm = 0;
        this.soKm = soKm;
    }

    /**
     * @return String return the soTuyen
     */
    public String getSoTuyen() {
        return soTuyen;
    }

    /**
     * @param soTuyen the soTuyen to set
     */
    public void setSoTuyen(String soTuyen) {
        if(soTuyen.length() == 0 || soTuyen.equals(""))
            soTuyen = "Chưa xác định";
        this.soTuyen = soTuyen;
    }

    /**
     * @param maSoChuyen
     * @param name
     * @param soXe
     * @param doanhThu
     * @param soKm
     * @param soTuyen
     */
    public NoiThanh(String maSoChuyen, String name, String soXe, double doanhThu, double soKm, String soTuyen) {
        super(maSoChuyen, name, soXe, doanhThu);
        setSoKm(soKm);
        setSoTuyen(soTuyen);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-20.2f %-15s", soKm, soTuyen);
    }
}
