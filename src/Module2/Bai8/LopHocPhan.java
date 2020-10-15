package Module2.Bai8;

public class LopHocPhan {
    private String maLHP;
    private String tenLHP;
    private String tenGV;
    private String thongTinLopHoc;
    private SinhVien[] dsSV;
    private int count;

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
        if (tenGV.length() == 0 || tenGV.equals(""))
            tenGV = "Chưa xác định";
        this.tenGV = tenGV;
    }

    /**
     * @param maLHP the maLHP to set
     */
    public void setMaLHP(String maLHP) {
        if (maLHP.length() == 0 || maLHP.equals(""))
            maLHP = "Chưa xác định";
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
        if (tenLHP.length() == 0 || tenLHP.equals(""))
            tenLHP = "Chưa xác định";
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
        if (thongTinLopHoc.length() == 0 || thongTinLopHoc.equals(""))
            thongTinLopHoc = "Chưa xác định";
        this.thongTinLopHoc = thongTinLopHoc;
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
    public LopHocPhan(String maLHP, String tenLHP, String tenGV, String thongTinLopHoc) {
        setMaLHP(maLHP);
        setTenLHP(tenLHP);
        setTenGV(tenGV);
        setThongTinLopHoc(thongTinLopHoc);
        count = 0;
        dsSV = new SinhVien[100];
        for (int i = 0; i < 100; i++) {
            dsSV[i] = new SinhVien();
        }

    }

    public boolean themHV(SinhVien x) {
        if (x != null) {
            if (count > 100) {
                System.out.println("Không thể thêm được, Mảng Full!!");
                return false;
            } else {
                for (int i = 0; i < count; i++) {
                    if (dsSV[i].getMaSV().equalsIgnoreCase(x.getMaSV())) {
                        System.out.println("mã học viên đã tồn tài");
                        return false;
                    }
                }
            }
            dsSV[count] = x;
            count++;
            return true;
        }
        return false;
    }

    public int getSoLuongSV() {
        return count;
    }

    public String ThongTinLopHocPhan() {
        return String.format(
                "- Mã LHP: %s\n- Tên LHP: %s\n- Tên GV: %s\n- Thông tin buổi học: %s\n\nDanh sách sinh viên:\n", maLHP,
                tenLHP, tenGV, thongTinLopHoc);
    }

    public void xuatSV() {
        for (int i = 0; i < count; i++)
        {
            System.out.println(dsSV[i].toString());
        }
    }

    public String toString() {
        System.out.println(ThongTinLopHocPhan());
        xuatSV();
        return String.format("%-18s %d", "Tổng số sinh viên:", getSoLuongSV());
    }
}
