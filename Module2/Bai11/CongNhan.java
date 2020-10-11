package Module2.Bai11;

public class CongNhan {
    private String ho;
    private String ten;
    private int soSP;

    /**
     * @return String return the ho
     */
    public String getHo() {
        return ho;
    }

    /**
     * @param ho the ho to set
     */
    public void setHo(String ho) {
        this.ho = ho;
    }

    /**
     * @return String return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return int return the soSP
     */
    public int getSoSP() {
        return soSP;
    }

    /**
     * @param soSP the soSP to set
     */
    public void setSoSP(int soSP) {
        if(soSP < 0)
            soSP = 0;
        this.soSP = soSP;
    }

    /**
     * @param ho
     * @param ten
     * @param soSP
     */
    public CongNhan(String ho, String ten, int soSP) {
        this.ho = ho;
        this.ten = ten;
        setSoSP(soSP);
    }

    /**
     * 
     */
    public CongNhan() {
        this("", "", 0);
    }

    public double tinhLuong() {
        double tien = 0;
        if(soSP < 200)
            tien = soSP * 0.5;
        else if(soSP >= 200 && soSP < 400)
            tien = soSP * 0.55;
        else if(soSP >= 400 && soSP < 600)
            tien = soSP * 0.6;
        else
            tien = soSP * 0.65;
        return tien;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10d %-10.2f", ho, ten, soSP, tinhLuong());
    }
}
