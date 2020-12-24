package Module4.Bai11;

import java.text.DecimalFormat;

public class xeOToKhach extends Xe {
    private int soGheHK;

    /**
     * @return the soGheHK
     */
    public int getSoGheHK() {
        return soGheHK;
    }

    /**
     * @param soGheHK the soGheHK to set
     */
    public void setSoGheHK(int soGheHK) {
        if (soGheHK < 0)
            soGheHK = 0;
        this.soGheHK = soGheHK;
    }

    /**
     * @param maXe
     * @param tenXe
     * @param donGia
     * @param soGheHK
     */
    public xeOToKhach(String maXe, String tenXe, double donGia, int soGheHK) {
        super(maXe, tenXe, donGia);
        setSoGheHK(soGheHK);
    }

    /**
     * 
     */
    public xeOToKhach() {
        super("xxx", "xxx", 0);
        this.soGheHK = 0;
    }

    @Override
    public double VAT() {
        return 10;
    }

    @Override
    public String loaiXe() {
        String str = "Xe o to Khach";
        return str;
    }

    @Override
    public double thueTruocBa() {
        return 20;
    }

    public double thueTieuThuDacBiet() {
        double thue = 50;
        if (soGheHK >= 5)
            thue = 30;
        return thue;
    }

    @Override
    public double thanhTien() {
        return donGia + (donGia * (VAT() + thueTruocBa() + thueTieuThuDacBiet()) / 100);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return super.toString()
                + String.format("%-10s %-10s %-20s %-10s %-10s %-10s",  df.format(soGheHK) + " Ghế", df.format(thueTieuThuDacBiet()) + "%",
                        loaiXe(), df.format(VAT()) + "%", df.format(thueTruocBa()) + "%", df.format(thanhTien()))
                + " VND";
    }
}
