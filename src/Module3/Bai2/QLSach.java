package Module3.Bai2;

public class QLSach {
    private Sach[] ds = new Sach[100];
    private int count;

    /**
     * 
     */
    public QLSach() {
        count = 0;
        for (int i = 0; i < 100; i++) {
            ds[i] = new Sach();
        }
    }

    public boolean themSach(Sach s) {
        if(s != null)
        {
            if(count > 100)
            {
                System.out.println("Không thể thêm được, Mảng Full!!");
                return false;
            }
            else
            {
                for (int i = 0; i < count; i++) {
                    if(ds[i].getMaSach().equalsIgnoreCase(s.getMaSach()))
                    {
                        System.out.println("Sách đã tồn tại.");
                        return false;
                    }
                }
            }
            ds[count] = s;
            count++;
            return true;
        }
        return false;
    }

    public void tinhTienTungLoaiSach() {
        double tienSGK = 0, tienSTK = 0;
        for (int i = 0; i < count; i++) {
            if(ds[i] instanceof SachGK)
                tienSGK += ds[i].tinhTien();
            if(ds[i] instanceof SachTK)
                tienSTK += ds[i].tinhTien();
        }
        System.out.println("Tổng tiền loại Sách GK: " + tienSGK);
        System.out.println("Tổng tiền loại Sách TK: " + tienSTK);
    }

    public void tinhTBCongSTK() {
        double tien = 0;
        int dem = 0;
        for (int i = 0; i < count; i++) {
            if(ds[i] instanceof SachTK)
            {    
                tien += ds[i].getDonGia();
                dem++;
            }
        }
        tien = tien / dem;
        System.out.println("Tổng Trung bình cộng của STK: " + tien);
    }

    public void xuatSGK(String k) {
        System.out.println("\nXuất danh sách Sách Giáo Khoa của NXB " + k);
        for (int i = 0; i < count; i++)
            if(ds[i] instanceof SachGK && ds[i].nxb.equalsIgnoreCase(k))
                System.out.println(ds[i].toString());
    }

    public void xuatSach() {
        System.out.println("\nXuất danh sách hiện có");
        for (int i = 0; i < count; i++)
        {
            System.out.println(ds[i].toString());
        }
    }
}
