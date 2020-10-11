package Module2.Bai10;

import java.util.Arrays;
import java.util.Comparator;

public class CDList {
    private int count;
    private CD[] ds;

    /**
     * 
     */
    public CDList(int n) {
        count = 0;
        ds = new CD[n];
    }

    public boolean themCD(CD cd) {
        for (int i = 0; i < count; i++)
            if (ds[i].getMaCD() == cd.getMaCD())
                return false;
        if (count >= ds.length)
            return false;
        ds[count] = cd;
        count++;
        return true;
    }

    public int soLuongCD() {
        return count;
    }

    public Double tinhTong() {
        double tien = 0.00;
        for (int i = 0; i < count; i++) {
            tien += ds[i].getGiaThanh();
        }
        return tien;
    }

    
    public boolean timMa(int ma) {
        System.out.printf("%-7s %-25s %-10s %-15s\n", "Mã CD", "Tựa CD", "Số BH", "Giá Thành");
        for (int i = 0; i < count; i++) {
            if (ds[i].getMaCD() == ma) {
                System.out.println(ds[i]);
                return true;
            }
        }
        return false;
    }

    public boolean timTua(String tua) {
        System.out.printf("%-7s %-25s %-10s %-15s\n", "Mã CD", "Tựa CD", "Số BH", "Giá Thành");
        for (int i = 0; i < count; i++) {
            if (ds[i].getTuaCD().equalsIgnoreCase(tua)) {
                System.out.println(ds[i]);
                return true;
            }
        }
        return false;
    }
    
    public void sapXepGiaThanh() {
        Arrays.sort(ds, 0, count, new Comparator<CD>() {
            public int compare(CD o1, CD o2) {
                return Double.compare(o1.getGiaThanh(), o2.getGiaThanh());
            }
        });
    }
    
    public void sapXepTua() {
        Arrays.sort(ds, 0, count, new Comparator<CD>() {
            public int compare(CD o2, CD o1) {
                return o2.getTuaCD().compareToIgnoreCase(o1.getTuaCD());
            }
        });
    }
    
    public void xuatDS() {
        System.out.printf("%-7s %-25s %-10s %-15s\n", "Mã CD", "Tựa CD", "Số BH", "Giá Thành");
        for (int i = 0; i < count; i++) {
            System.out.println(ds[i]);
        }
    }
}
