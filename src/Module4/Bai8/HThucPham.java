package Module4.Bai8;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HThucPham extends HangHoa {
    private String ncc;
    private LocalDate ngaySX;
    private LocalDate ngayHH;

    /**
     * @return String return the ncc
     */
    public String getNcc() {
        return ncc;
    }

    /**
     * @param ncc the ncc to set
     */
    public void setNcc(String ncc) {
        if (ncc.length() == 0 || ncc.equals(""))
            ncc = "xxx";
        this.ncc = ncc;
    }

    /**
     * @return LocalDate return the ngaySX
     */
    public LocalDate getNgaySX() {
        return ngaySX;
    }

    /**
     * @param ngaySX the ngaySX to set
     */
    public void setNgaySX(LocalDate ngaySX) {
        if (ngaySX.isAfter(LocalDate.now()))
            ngaySX = LocalDate.now();
        this.ngaySX = ngaySX;
    }

    /**
     * @return LocalDate return the ngayHH
     */
    public LocalDate getNgayHH() {
        return ngayHH;
    }

    /**
     * @param ngayHH the ngayHH to set
     */
    public void setNgayHH(LocalDate ngayHH) {
        if (ngayHH.isBefore(ngaySX))
            ngayHH = ngaySX;
        this.ngayHH = ngayHH;
    }

    /**
     * @param maHang
     * @param tenHang
     * @param donGia
     * @param soLuong
     * @param ncc
     * @param ngaySX
     * @param ngayHH
     */
    public HThucPham(String maHang, String tenHang, double donGia, int soLuong, String ncc, LocalDate ngaySX,
            LocalDate ngayHH) {
        super(maHang, tenHang, donGia, soLuong);
        setNcc(ncc);
        setNgaySX(ngaySX);
        setNgayHH(ngayHH);
    }

    /**
     */
    public HThucPham() {
        super("", "", 0, 0);
        setNcc("");
        setNgaySX(LocalDate.of(1970, 1, 1));
        setNgayHH(LocalDate.of(1970, 1, 1));
    }

    @Override
    public double VAT() {
        return 0.05;
    }

    @Override
    public String danhGia() {
        String result = "";
        if (soLuong >= 1 && ngayHH.isAfter(LocalDate.now()))
            result = "Kho ban";
        return result;
    }

    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.##");
        String vat = df.format(VAT() * 100) + "%";
        return super.toString() + String.format("%-20s %-13s %-13s %-10s %-10s", ncc, dtf.format(ngaySX),
                dtf.format(ngayHH), vat, danhGia());
    }
}
