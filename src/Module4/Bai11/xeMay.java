package Module4.Bai11;

import java.text.DecimalFormat;

public class xeMay extends Xe {
    private int dungTich;

    /**
     * @return int return the dungTich
     */
    public int getDungTich() {
        return dungTich;
    }

    /**
     * @param dungTich the dungTich to set
     */
    public void setDungTich(int dungTich) {
        if (dungTich < 0)
            dungTich = 100;
        this.dungTich = dungTich;
    }

    /**
     * @param maXe
     * @param tenXe
     * @param donGia
     * @param dungTich
     */
    public xeMay(String maXe, String tenXe, double donGia, int dungTich) {
        super(maXe, tenXe, donGia);
        setDungTich(dungTich);
    }

    /**
     * 
     */
    public xeMay() {
        super("xxx", "xxx", 0);
        this.dungTich = 100;
    }

    @Override
    public double VAT() {
        return 10;
    }

    @Override
    public String loaiXe() {
        String str = "Xe May";
        return str;
    }

    @Override
    public double thueTruocBa() {
        return 5;
    }

    @Override
    public double thanhTien() {
        return donGia + (donGia * (VAT() + thueTruocBa()) / 100);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return super.toString() + String.format("%-10s %-10s %-20s %-10s %-10s %-10s", dungTich + " cc", "", loaiXe(),
                df.format(VAT()) + "%", df.format(thueTruocBa()) + "%", df.format(thanhTien())) + " VND";
    }
}
