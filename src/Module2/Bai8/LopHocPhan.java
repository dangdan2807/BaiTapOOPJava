package Module2.Bai8;

public class LopHocPhan {
    private String maLHP;
    private String tenLHP;
    private String tenGV;
    private String thongTinLopHoc;
    private SinhVien[] dsSV;

    /**
     * @return String return the maLHP
     */
    public String getMaLHP() {
        return maLHP;
    }

    /**
     * @return the tenGV
     */
    public String getTenGV() {
        return tenGV;
    }

    /**
     * @param tenGV the tenGV to set
     */
    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    /**
     * @param maLHP the maLHP to set
     */
    public void setMaLHP(String maLHP) {
        this.maLHP = maLHP;
    }

    /**
     * @return String return the tenLHP
     */
    public String getTenLHP() {
        return tenLHP;
    }

    /**
     * @param tenLHP the tenLHP to set
     */
    public void setTenLHP(String tenLHP) {
        this.tenLHP = tenLHP;
    }

    /**
     * @return String return the thongTinLopHoc
     */
    public String getThongTinLopHoc() {
        return thongTinLopHoc;
    }

    /**
     * @param thongTinLopHoc the thongTinLopHoc to set
     */
    public void setThongTinLopHoc(String thongTinLopHoc) {
        this.thongTinLopHoc = thongTinLopHoc;
    }

    /**
     * @return SinhVien[] return the dsSV
     */
    public SinhVien[] getDsSV() {
        return dsSV;
    }

    /**
     * @param dsSV the dsSV to set
     */
    public void setDsSV(SinhVien[] dsSV) {
        this.dsSV = dsSV;
    }

    /**
     * 
     */
    public LopHocPhan() {
    }

    /**
     * @param maLHP
     * @param tenLHP
     * @param tenGV
     * @param thongTinLopHoc
     * @param dsSV
     */
    public LopHocPhan(String maLHP, String tenLHP, String tenGV, String thongTinLopHoc, SinhVien[] dsSV) {
        this.maLHP = maLHP;
        this.tenLHP = tenLHP;
        this.tenGV = tenGV;
        this.thongTinLopHoc = thongTinLopHoc;
        this.dsSV = dsSV;
    }

    public int getSoLuongSV() {
        return dsSV.length;
    }

    public String ThongTinLopHocPhan() {
        return String.format(
                "- Mã LHP: %s\n- Tên LHP: %s\n- Tên GV: %s\n- Thông tin buổi học: %s\n\nDanh sách sinh viên:\n", 
                maLHP, tenLHP, tenGV, thongTinLopHoc);
    }

    public String toString() {
        // String info = "- Mã LHP: " + maLHP +
        // "\n- Tên LHP: " + tenLHP +
        // "\n- Tên GV: " + tenGV +
        // "\n- Thông tin buổi học: " + thongTinLopHoc +
        // "\n\nDanh sách sinh viên:\n";

        String TempDsSV = "";
        for (SinhVien i : dsSV) {
            TempDsSV += i.toString() + "\n";
        }

        return String.format("%-5s%-1s%-18s %d", ThongTinLopHocPhan(), TempDsSV, "Tổng số sinh viên:", getSoLuongSV());
    }
}
