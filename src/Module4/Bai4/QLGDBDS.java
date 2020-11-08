package Module4.Bai4;

import java.util.ArrayList;

public class QLGDBDS {
    private ArrayList<GiaoDichBDS> ds;

    /**
     * 
     */
    public QLGDBDS() {
        ds = new ArrayList<GiaoDichBDS>();
    }

    public boolean themGD(GiaoDichBDS gd) {
        if (gd != null) {
            for (int i = 0; i < ds.size(); i++) {
                if (gd.getMaGD().equalsIgnoreCase(ds.get(i).getMaGD())) {
                    System.out.println("Giao dịch đã tồn tại!");
                    return false;
                }
            }
            ds.add(gd);
            return true;
        }
        return false;
    }

    public void tinhSoLuongTungLoaiGD() {
        int slGDNha = 0, slGDDat = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof GDDat)
                slGDDat++;
            if (ds.get(i) instanceof GDNha)
                slGDNha++;
        }
        System.out.println("\nTổng số giao dịch Nhà: " + slGDNha);
        System.out.println("Tổng số giao dịch Đất: " + slGDDat);
    }

    public double tinhTBTienCuaGDDat() {
        double tien = 0;
        int count = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof GDDat) {
                tien +=( (GDDat) ds.get(i)).thanhTien();
                count++;
            }
        }
        if(count == 0)
            return 0;
        return (tien / count);
    }

    public void xuatDsGD2013() {
        System.out.println("\nXuất những Giao Dịch trong tháng 9 năm 2013");
        System.out.printf("\n%-16s %-12s %-15s %-13s %-10s %-40s %-15s\n", "Mã GD", "Ngày GD", "Đơn Giá", "Diện tích",
                "Loại", "Địa chỉ", "Thành Tiền");
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getNgayGD().getMonth().getValue() == 9 && ds.get(i).getNgayGD().getYear() == 2013)
                System.out.println(ds.get(i).toString());
        }
    }

    public void xuatDS() {
        System.out.println("\nXuất tất các các giao dịch");
        System.out.printf("\n%-16s %-12s %-15s %-13s %-10s %-40s %-15s\n", "Mã GD", "Ngày GD", "Đơn Giá", "Diện tích",
                "Loại", "Địa chỉ", "Thành Tiền");
        for (int i = 0; i < ds.size(); i++)
            System.out.println(ds.get(i).toString());
    }
}
