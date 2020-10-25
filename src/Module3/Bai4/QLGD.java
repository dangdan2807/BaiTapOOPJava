package Module3.Bai4;

public class QLGD {
    private int count;
    private GiaoDichBDS[] ds = new GiaoDichBDS[100];

    /**
     * 
     */
    public QLGD() {
        count = 0;
        for (int i = 0; i < 100; i++)
            ds[i] = new GiaoDichBDS();
    }

    public boolean themGD(GiaoDichBDS gd) {
        if (gd != null) {
            if (count > 100) {
                System.out.println("Không thể thêm được, Mảng Full!!");
                return false;
            } else {
                for (int i = 0; i < count; i++) {
                    if (gd.getMaGD().equalsIgnoreCase(ds[i].getMaGD())) {
                        System.out.println("Giao dịch đã tồn tại!");
                        return false;
                    }
                }
            }
            ds[count] = gd;
            count++;
            return true;
        }
        return false;
    }

    public void tinhSoLuongTungLoaiGD() {
        int slGDNha = 0, slGDDat = 0;
        for (int i = 0; i < count; i++) {
            if (ds[i] instanceof GDDat)
                slGDDat++;
            if (ds[i] instanceof GDNha)
                slGDNha++;
        }
        System.out.println("\nTổng số giao dịch Nhà: " + slGDNha);
        System.out.println("Tổng số giao dịch Đất: " + slGDDat);
    }

    public double tinhTBTienCuaGDDat() {
        double tien = 0;
        int dem = 0;
        for (int i = 0; i < count; i++) {
            if (ds[i] instanceof GDDat) {
                tien += ((GDDat) ds[i]).tinhTien();
                dem++;
            }
        }
        return (tien / dem);
    }

    public void xuatDsGD2013() {
    	System.out.println("\nXuất những Giao Dịch trong tháng 9 năm 2013");
        System.out.printf("\n%-10s %-15s %-20s %-17s %-10s %-40s %-15s\n", "Mã GD", "Ngày GD", "Đơn Giá", "Diện tích", "Loại", "địa chỉ", "Thành Tiền");
        for (int i = 0; i < count; i++)
        {
            if(ds[i].getNgayGD().getMonth().getValue() == 9 && ds[i].getNgayGD().getYear() == 2013)
                System.out.println(ds[i].toString());
        }
    }

    public void xuatDS() {
    	System.out.println("\nXuất tất các các giao dịch");
        System.out.printf("\n%-10s %-15s %-20s %-17s %-10s %-40s %-15s\n", "Mã GD", "Ngày GD", "Đơn Giá", "Diện tích", "Loại", "địa chỉ", "Thành Tiền");
        for (int i = 0; i < count; i++)
            System.out.println(ds[i].toString());
    }
}
