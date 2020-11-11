package Khac.Bai2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Nguoi {
    private int cmnd;
    private String hoVaTen;
    private LocalDate ngaySinh;

    /**
     * @return int return the cmnd
     */
    public int getCmnd() {
        return cmnd;
    }

    /**
     * @param cmnd the cmnd to set
     */
    public void setCmnd(int cmnd) {
        if(cmnd < 0)
            cmnd = 0;
        this.cmnd = cmnd;
    }

    /**
     * @return String return the hoVaTen
     */
    public String getHoVaTen() {
        return hoVaTen;
    }

    /**
     * @param hoVaTen the hoVaTen to set
     */
    public void setHoVaTen(String hoVaTen) {
        if(hoVaTen.length() == 0 || hoVaTen.equals(""))
            hoVaTen = "Chưa xác định";
        this.hoVaTen = hoVaTen;
    }

    /**
     * @return LocalDate return the ngaySinh
     */
    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(LocalDate ngaySinh) {
        if(ngaySinh.isAfter(LocalDate.now()))
            ngaySinh = LocalDate.now();
        this.ngaySinh = ngaySinh;
    }

    /**
     * @param cmnd
     * @param hoVaTen
     * @param ngaySinh
     */
    public Nguoi(int cmnd, String hoVaTen, LocalDate ngaySinh) {
        setCmnd(cmnd);
        setHoVaTen(hoVaTen);
        setNgaySinh(ngaySinh);
    }

    /**
     * 
     */
    public Nguoi() {
        this(0, "", LocalDate.now());
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-10d %-25s %-15s ", cmnd, hoVaTen, dtf.format(ngaySinh));
    }
}
