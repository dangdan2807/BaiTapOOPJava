package Module4.Bai11;

import java.text.DecimalFormat;

public class xeOToTai extends Xe {
    private double trongTai;

    /**
     * @return double return the trongTai
     */
    public double getTrongTai() {
        return trongTai;
    }

    /**
     * @param trongTai the trongTai to set
     */
    public void setTrongTai(double trongTai) {
        if (trongTai < 1)
            trongTai = 1;
        this.trongTai = trongTai;
    }

    /**
     * @param maXe
     * @param tenXe
     * @param donGia
     * @param trongTai
     */
    public xeOToTai(String maXe, String tenXe, double donGia, double trongTai) {
        super(maXe, tenXe, donGia);
        setTrongTai(trongTai);
    }

    @Override
    public double VAT() {
        return 10;
    }

    @Override
    public String loaiXe() {
        String str = "Xe o to Tai";
        return str;
    }

    @Override
    public double thueTruocBa() {
        return 2;
    }

    @Override
    public double thanhTien() {
        return donGia + (donGia * (VAT() + thueTruocBa()) / 100);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return super.toString() + String.format("%-10s %-10s %-20s %-10s %-10s %-10s", trongTai + " tan", "", loaiXe(),
                df.format(VAT()) + "%", df.format(thueTruocBa()) + "%", df.format(thanhTien())) + " VND";
    }
}
