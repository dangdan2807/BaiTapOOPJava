package Module4.Bai8;

import java.text.DecimalFormat;

public class HDienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private int congSuat;

    /**
     * @return int return the thoiGianBaoHanh
     */
    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    /**
     * @param thoiGianBaoHanh the thoiGianBaoHanh to set
     */
    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if (thoiGianBaoHanh < 0)
            thoiGianBaoHanh = 0;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    /**
     * @return int return the congSuat
     */
    public int getCongSuat() {
        return congSuat;
    }

    /**
     * @param congSuat the congSuat to set
     */
    public void setCongSuat(int congSuat) {
        if (congSuat < 0)
            congSuat = 0;
        this.congSuat = congSuat;
    }

    /**
     * @param maHang
     * @param tenHang
     * @param donGia
     * @param soLuong
     * @param thoiGianBaoHanh
     * @param congSuat
     */
    public HDienMay(String maHang, String tenHang, double donGia, int soLuong, int thoiGianBaoHanh, int congSuat) {
        super(maHang, tenHang, donGia, soLuong);
        setThoiGianBaoHanh(thoiGianBaoHanh);
        setCongSuat(congSuat);
    }

    /**
     * 
     */
    public HDienMay() {
        super("", "", 0, 0);
        setThoiGianBaoHanh(0);
        setCongSuat(0);
    }

    @Override
    public double VAT() {
        return 0.1;
    }

    @Override
    public String danhGia() {
        String result = "";
        if (soLuong < 3)
            result = "ban duoc";
        return result;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        String vat = df.format(VAT() * 100) + "%";
        return super.toString() + String.format("%-20s %-13s %-13s %-10s %-10s", "", thoiGianBaoHanh,
                df.format(congSuat) + " W", vat, danhGia());
    }
}
