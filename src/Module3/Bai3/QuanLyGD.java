package Module3.Bai3;

public class QuanLyGD {
    private GiaoDich[] ds = new GiaoDich[100];
    private int count;

    /**
     * 
     */
    public QuanLyGD() {
        count = 0;
        for (int i = 0; i < 100; i++) {
            ds[i] = new GiaoDich();
        }
    }

    public boolean themGD(GiaoDich gd) {
        if(gd != null)
        {
            if(count > 100)
            {
                System.out.println("Không thể thêm được, Mảng Full!!");
                return false;
            }
            else
            {
                for(int i = 0; i < count; i++)
                {
                    if(ds[i].getMaGD().equalsIgnoreCase(gd.getMaGD()))
                    {
                        System.out.println("Giao dich đã tồn tại!!");
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
        int slGDV = 0, slGDT = 0;
        for (int i = 0; i < count; i++)
        {
            if(ds[i] instanceof Vang)
                slGDV++;
            if(ds[i] instanceof TienTe)
                slGDT++;
        }
        System.out.println("\nTổng số giao dịch Vàng: " + slGDV);
        System.out.println("Tổng số giao dịch Tiền tệ: " + slGDT);
    }

    public double tinhTBTienCuaGDTT() {
        double tien = 0;
        int dem = 0;
        for (int i = 0; i < count; i++) {
            if(ds[i] instanceof TienTe)
            {
                tien += ds[i].tinhTien();
                dem++;
            }
        }
        return (tien / dem);
    }

    public void xuatGD1Ty() {
        System.out.println("\nXuất danh sách các giao dịch lớn hơn 1 tỷ");
        for(int i = 0; i < count; i++)
            if(ds[i].donGia >= 1000000000)
                System.out.println(ds[i].toString());
    }

    public void xuatGD() {
        System.out.println("\nXuất danh sách tất cả các giao dịch");
        for (int i = 0; i < count; i++)
            System.out.println(ds[i].toString());
    }
}