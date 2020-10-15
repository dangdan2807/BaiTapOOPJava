package Module2.Bai8;

public class SinhVien {
    private String maSV;
    private String hoTen;

    /**
     * @param maSV
     * @param hoTen
     */
    public SinhVien(String maSV, String hoTen) {
        setMaSV(maSV);
        setHoTen(hoTen);
    }

    public SinhVien() {
        this("", "");
    }

    /**
     * @return String return the maSV
     */
    public String getMaSV() {
        return maSV;
    }

    /**
     * @param maSV the maSV to set
     */
    public void setMaSV(String maSV) {
        if(maSV.length() == 0 || maSV.equals(""))
            maSV = "0";
        this.maSV = maSV;
    }

    /**
     * @return String return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        if (hoTen.length() == 0 || hoTen.equals(""))
            hoTen = "Chưa xác định";
        this.hoTen = hoTen;
    }

    public String toString() {
        return String.format("%7s | %-20s", maSV, hoTen);
    }
}
