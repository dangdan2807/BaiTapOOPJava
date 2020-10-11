package Module2.Bai10;

public class CD {
    private int maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

    /**
     * @return int return the maCD
     */
    public int getMaCD() {
        return maCD;
    }

    /**
     * @param maCD the maCD to set
     */
    public void setMaCD(int maCD) {
        if(maCD < 0)
            maCD = 999999;
        this.maCD = maCD;
    }

    /**
     * @return String return the tuaCD
     */
    public String getTuaCD() {
        return tuaCD;
    }

    /**
     * @param tuaCD the tuaCD to set
     */
    public void setTuaCD(String tuaCD) {
        if(tuaCD.equals("") || tuaCD.length() == 0)
            tuaCD = "Chưa xác định";
        this.tuaCD = tuaCD;
    }

    /**
     * @return int return the soBaiHat
     */
    public int getSoBaiHat() {
        return soBaiHat;
    }

    /**
     * @param soBaiHat the soBaiHat to set
     */
    public void setSoBaiHat(int soBaiHat) {
        if(soBaiHat < 0)
            soBaiHat = 1;
        this.soBaiHat = soBaiHat;
    }

    /**
     * @return double return the giaThanh
     */
    public double getGiaThanh() {
        return giaThanh;
    }

    /**
     * @param giaThanh the giaThanh to set
     */
    public void setGiaThanh(double giaThanh) {
        if(giaThanh < 0)
            giaThanh = 1;
        this.giaThanh = giaThanh;
    }

	/**
	 * @param soBaiHat
	 * @param giaThanh
	 */
	public CD(int soBaiHat, double giaThanh) {
        this.maCD = 999999;
        this.tuaCD = "Chưa xác định";
        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
    }

	/**
	 * @param maCD
	 * @param tuaCD
	 * @param soBaiHat
	 * @param giaThanh
	 */
	public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
        setMaCD(maCD);
        setTuaCD(tuaCD);
        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
	}
    
    /**
     * 
	 */
    public CD() {
        this(0, "Chưa xác định", 0, 0.0f);
    }
    
    @Override
    public String toString() {
        return String.format("%-7d %-25s %-10d %-20.2f", maCD, tuaCD, soBaiHat, giaThanh);
    }
}
