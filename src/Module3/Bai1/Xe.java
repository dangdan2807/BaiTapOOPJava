package Module3.Bai1;

public class Xe {
    protected String maSoChuyen;
    protected String name;
    protected String soXe;
    protected double doanhThu;

    /**
     * @return int return the maSoChuyen
     */
    public String getMaSoChuyen() {
        return maSoChuyen;
    }

    /**
     * @param maSoChuyen the maSoChuyen to set
     */
    public void setMaSoChuyen(String maSoChuyen) {
        if(maSoChuyen.length() == 0 || maSoChuyen.equals(""))
            maSoChuyen = "Chưa Xác định";
        this.maSoChuyen = maSoChuyen;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if(name.length() == 0 || name.equals(""))
            this.name = "Chưa xác định";
        this.name = name;
    }

    /**
     * @return String return the soXe
     */
    public String getSoXe() {
        return soXe;
    }

    /**
     * @param soXe the soXe to set
     */
    public void setSoXe(String soXe) {
        if(soXe.length() == 0 || soXe.equals(""))
            soXe = "Chưa xác định";
        this.soXe = soXe;
    }

    /**
     * @return double return the doanhThu
     */
    public double getDoanhThu() {
        return doanhThu;
    }

    /**
     * @param doanhThu the doanhThu to set
     */
    public void setDoanhThu(double doanhThu) {
        if(doanhThu < 0.0)
            doanhThu = 0;
        this.doanhThu = doanhThu;
    }

    /**
     * @param maSoChuyen
     * @param name
     * @param soXe
     * @param doanhThu
     */
    public Xe(String maSoChuyen, String name, String soXe, double doanhThu) {
        setMaSoChuyen(maSoChuyen);
        setName(name);
        setSoXe(soXe);
        setDoanhThu(doanhThu);
    }

    /**
     * 
     */
    public Xe() {
        this("", "", "", 0.0);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10s %-20.2f", maSoChuyen, name, soXe, doanhThu);
    }
}
