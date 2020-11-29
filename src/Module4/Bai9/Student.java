package Module4.Bai9;

import java.text.DecimalFormat;

public class Student extends Person {
    private double diemMH1;
    private double diemMH2;

    /**
     * @return double return the diemMH1
     */
    public double getDiemMH1() {
        return diemMH1;
    }

    /**
     * @param diemMH1 the diemMH1 to set
     */
    public void setDiemMH1(double diemMH1) {
        if(diemMH1 < 0)
            diemMH1 = 0;
        else if(diemMH1 >= 10)
            diemMH1 = 10;
        this.diemMH1 = diemMH1;
    }

    /**
     * @return double return the diemMH2
     */
    public double getDiemMH2() {
        return diemMH2;
    }

    /**
     * @param diemMH2 the diemMH2 to set
     */
    public void setDiemMH2(double diemMH2) {
        if(diemMH2 < 0)
            diemMH2 = 0;
        else if(diemMH2 >= 10)
            diemMH2 = 10;
        this.diemMH2 = diemMH2;
    }

    /**
     * @param hoTen
     * @param diaChi
     * @param diemMH1
     * @param diemMH2
     */
    public Student(String hoTen, String diaChi, double diemMH1, double diemMH2) {
        super(hoTen, diaChi);
        setDiemMH1(diemMH1);
        setDiemMH2(diemMH2);
    }

    /**
     * 
     */
    public Student() {
        super("", "");
        setDiemMH1(0f);
        setDiemMH2(0f);
    }

    public double tinhDiemTB() {
        return (diemMH1 + diemMH2) / 2;
    }

    public String danhGia() {
        String str = "";
        double diemTB = tinhDiemTB();
        if(diemTB >= 8)
            str = "HS Gioi";
        else if(diemTB < 8 && diemTB >= 6.5)
            str = "HS Kha";
        else if (diemTB < 6.5 && diemTB >= 5)
            str = "HS TB";
        else if (diemTB < 5 && diemTB >= 3.5)
            str = "HS Yeu";
        else 
            str = "HS Kem";
        return str;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return super.toString()
                + String.format("%-10s %-10s %-10s %-10s %-20s", df.format(diemMH1), df.format(diemMH2), "", df.format(tinhDiemTB()), danhGia());
    }
}
