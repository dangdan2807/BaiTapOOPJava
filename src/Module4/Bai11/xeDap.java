package Module4.Bai11;

import java.text.DecimalFormat;

public class xeDap extends Xe {
    public xeDap(String maXe, String tenXe, double donGia) {
        super(maXe, tenXe, donGia);
    }

    public xeDap() {
        super("xxx", "xxx", 0f);
    }

    @Override
    public String loaiXe() {
        String str = "Xe Dap";
        return str;
    }

    @Override
    public double VAT() {
        return 0;
    }

    @Override
    public double thueTruocBa() {
        return 0;
    }

    @Override
    public double thanhTien() {
        return donGia;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return super.toString() + String.format("%-10s %-10s %-20s %-10s %-10s %-10s", "", "", loaiXe(),
                df.format(VAT()) + "%", df.format(thueTruocBa()) + "%", df.format(thanhTien())) + " VND";
    }
}
