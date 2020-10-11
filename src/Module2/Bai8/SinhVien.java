package Module2.Bai8;

public class SinhVien {
    private String maSV;
    private String hoTen;

    /**
     * @param maSV
     * @param hoTen
     */
    public SinhVien(String maSV, String hoTen) {
        this.maSV = maSV;
        this.hoTen = hoTen;
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
        this.hoTen = hoTen;
    }

    public String toString() {
        return String.format("%7s | %-20s", maSV, hoTen);
    }
}
