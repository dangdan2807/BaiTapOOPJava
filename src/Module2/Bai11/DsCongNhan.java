package Module2.Bai11;

import java.util.Arrays;
import java.util.Comparator;

public class DsCongNhan {
    private int count;
    private CongNhan[] ds;

    /**
     * 
     */
    public DsCongNhan(int n) {
        count = 0;
        ds = new CongNhan[n];
    }

    public boolean themCN(CongNhan cn) {
        if (count >= ds.length)
            return false;
        ds[count] = cn;
        count++;
        return true;
    }

    public int soLuongCN() {
        return count;
    }

    public void XuatDsCN200() {
        System.out.printf("%-10s %-15s %-10s %-10s\n=================================\n", "Họ", "Tên", "So SP", "Lương");
        for (int i = 0; i < count; i++) {
            if(ds[i].getSoSP() >= 200)
                System.out.println(ds[i]);
        }
    }

    public void sapXepCN() {
        Arrays.sort(ds, 0, count, new Comparator<CongNhan>(){
            public int compare(CongNhan cn1, CongNhan cn2)
            {
                return Integer.compare(cn1.getSoSP(), cn2.getSoSP());
            }
        });
    }

    public void XuatDsCN() {
        System.out.printf("%-10s %-15s %-10s %-10s\n=================================\n", "Họ", "Tên", "So SP", "Lương");
        for (int i = 0; i < count; i++) {
            System.out.println(ds[i]);
        }
    }
}
