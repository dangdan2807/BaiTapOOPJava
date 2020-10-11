package Module2.Bai7;

public class HinhTron {
    private ToaDo tam;
    private double banKinh;

    /**
     * @return ToaDo return the tam
     */
    public ToaDo getTam() {
        return tam;
    }

    /**
     * @param tam the tam to set
     */
    public void setTam(ToaDo tam) {
        this.tam = tam;
    }

    /**
     * @return double return the banKinh
     */
    public double getBanKinh() {
        return banKinh;
    }

    /**
     * @param banKinh the banKinh to set
     */
    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }

    /**
     * 
     */
    public HinhTron() {
    }

    /**
     * @param tam
     * @param banKinh
     */
    public HinhTron(ToaDo tam, double banKinh) {
        this.tam = tam;
        this.banKinh = banKinh;
    }

    public double tinhChuVi() {
        return 2 * banKinh * 3.14;
    }

    public double tinhDienTich() {
        return banKinh * banKinh * 3.14;
    }

    public String toString() {
        String str1 = "Diện tích và chu vi hình tròn tâm";
        String str2 = "có bán Kính";
        return String.format("%s %s %s %5.2fm là %5.2fm và %5.2fm", str1, tam.toString(), str2, banKinh, tinhDienTich(),
                tinhChuVi());
    }
}