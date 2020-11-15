package Module5.Bai6;

import java.text.DecimalFormat;

public class PhongTN extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private String bonChua;

    /**
     * @return String return the chuyenNganh
     */
    public String getChuyenNganh() {
        return chuyenNganh;
    }

    /**
     * @param chuyenNganh the chuyenNganh to set
     */
    public void setChuyenNganh(String chuyenNganh) {
        if (chuyenNganh.length() == 0 || chuyenNganh.equalsIgnoreCase(""))
            chuyenNganh = "chua xac dinh";
        this.chuyenNganh = chuyenNganh;
    }

    /**
     * @return int return the sucChua
     */
    public int getSucChua() {
        return sucChua;
    }

    /**
     * @param sucChua the sucChua to set
     */
    public void setSucChua(int sucChua) {
        if (sucChua < 0)
            sucChua = 0;
        this.sucChua = sucChua;
    }

    /**
     * @return String return the bonChua
     */
    public String getBonChua() {
        return bonChua;
    }

    /**
     * @param bonChua the bonChua to set
     */
    public void setBonChua(String bonChua) {
        if (bonChua.equalsIgnoreCase("co") || bonChua.equalsIgnoreCase("có"))
            bonChua = "co";
        else
            bonChua = "Khong";
        this.bonChua = bonChua;
    }

    @Override
    public int kiemTra() {
        if(bonChua.equalsIgnoreCase("co") || bonChua.equalsIgnoreCase("Có"))
            return 1;
        return 0;
    }

    /**
     * @param maPhong
     * @param dayNha
     * @param dienTich
     * @param soBongDen
     * @param chuyenNganh
     * @param sucChua
     * @param bonChua
     */
    public PhongTN(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh, int sucChua,
            String bonChua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        setChuyenNganh(chuyenNganh);
        setSucChua(sucChua);
        setBonChua(bonChua);
    }

    /**
     * 
     */
    public PhongTN() {
        this("", "", 0, 0, "", 0, "");
    }

    @Override
    public String toString() {
        String kt = "";
        if(kiemTra() == 1)
            kt = "Dat";
        else
            kt = "Khong Dat";
        DecimalFormat df = new DecimalFormat("#,##0");
        return super.toString() + String.format("%-20s %-15s %-10s %-20s", chuyenNganh, df.format(sucChua), bonChua, kt);
    }
}
