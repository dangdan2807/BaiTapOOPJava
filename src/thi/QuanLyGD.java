package thi;

import java.util.Arrays;
import java.util.Comparator;

public class QuanLyGD {
    private int count;
    private GiaoDich[] ds;

    /**
     * 
     */
    public QuanLyGD() {
        count = 0;
        ds = new GiaoDich[100];
        for (int i = 0; i < 100; i++) {
            ds[i] = new GiaoDich();
        }
    }

    public boolean themGD(GiaoDich x) {
        if (x != null) {
            if (count > 100) {
                System.out.println("Mang da day!!");
                return false;
            } else {
                for (int i = 0; i < count; i++) {
                    if (ds[i].getMaGD().equalsIgnoreCase(x.getMaGD())) {
                        System.out.println("Ma GD da ton tai");
                        return false;
                    }
                }
                ds[count] = x;
                count++;
                return true;
            }
        }
        return false;
    }

    public void intDSGD() {
        for (int i = 0; i < count; i++) {
            System.out.println(ds[i].toString());
        }
    }

    public double tinhTongTien() {
        double tien = 0;
        for (int i = 0; i < count; i++) {
            tien += ds[i].thanhTien();
        }
        return tien;
    }

    public void sapXepTien() {
        Arrays.sort(ds, 0, count, new Comparator<GiaoDich>() {
            public int compare(GiaoDich o1, GiaoDich o2)
            {
                return Double.compare(o1.thanhTien(), o2.thanhTien());
            }
        });
    }


}
