package Module4.Bai8;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HSanhSu extends HangHoa {
    private String nsx;
    private LocalDate ngayNhap;

    /**
     * @return String return the nsx
     */
    public String getNsx() {
        return nsx;
    }

    /**
     * @param nsx the nsx to set
     */
    public void setNsx(String nsx) {
        if (nsx.length() == 0 || nsx.equals(""))
            nsx = "xxx";
        this.nsx = nsx;
    }

    /**
     * @return LocalDate return the ngayNhap
     */
    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    /**
     * @param ngayNhap the ngayNhap to set
     */
    public void setNgayNhap(LocalDate ngayNhap) {
        if (ngayNhap.isAfter(LocalDate.now()))
            ngayNhap = LocalDate.now();
        this.ngayNhap = ngayNhap;
    }

    /**
     * @param maHang
     * @param tenHang
     * @param donGia
     * @param soLuong
     * @param nsx
     * @param ngayNhap
     */
    public HSanhSu(String maHang, String tenHang, double donGia, int soLuong, String nsx, LocalDate ngayNhap) {
        super(maHang, tenHang, donGia, soLuong);
        setNsx(nsx);
        setNgayNhap(ngayNhap);
    }

    /**
     * 
     */
    public HSanhSu() {
        super("", "", 0, 0);
        setNsx("");
        setNgayNhap(LocalDate.of(1970, 1, 1));
    }

    @Override
    public double VAT() {
        return 0.1;
    }

    @Override
    public String danhGia() {
        String result = "";
        // lấy ra số ngày chênh lệch giữa 2 ngày (tháng, năm)
        long days = ChronoUnit.DAYS.between(ngayNhap, LocalDate.now());
        if (soLuong > 50 &&  days> 10)
            result = "ban cham";
        return result;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.##");
        String vat = df.format(VAT() * 100) + "%";
        return super.toString()
                + String.format("%-20s %-13s %-13s %-10s %-10s", nsx, dtf.format(ngayNhap), "", vat, danhGia());
    }
}
