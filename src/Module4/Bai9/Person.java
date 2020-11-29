package Module4.Bai9;

public abstract class Person {
    protected String hoTen;
    protected String diaChi;

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
        if(hoTen.length() == 0 || hoTen.equals(""))
            hoTen = "xxx";
        this.hoTen = hoTen;
    }

    /**
     * @return String return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        if(diaChi.length() == 0 || diaChi.equals(""))
            diaChi = "xxx";
        this.diaChi = diaChi;
    }

    /**
     * @param hoTen
     * @param diaChi
     */
    public Person(String hoTen, String diaChi) {
        setHoTen(hoTen);
        setDiaChi(diaChi);
    }

    public abstract String danhGia();

    public String toString() {
        return String.format("%-20s %-20s ", hoTen, diaChi);
    }
}