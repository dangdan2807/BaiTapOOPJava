package Module3.Bai2;

import java.util.Arrays;
import java.util.Comparator;

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
        if (s != null) {
            if (count > 100) {
                System.out.println("Không thể thêm được, Mảng Full!!");
                return false;
            } else {
                for (int i = 0; i < count; i++) {
                    if (ds[i].getMaSach().equalsIgnoreCase(s.getMaSach())) {
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
            if (ds[i] instanceof SachGK)
                tienSGK += ((SachGK) ds[i]).tinhTien();
            if (ds[i] instanceof SachTK)
                tienSTK += ((SachTK) ds[i]).tinhTien();
        }
        System.out.println("Tổng tiền loại Sách GK: " + tienSGK);
        System.out.println("Tổng tiền loại Sách TK: " + tienSTK);
    }

    public void tinhTBCongSTK() {
        double tien = 0;
        int dem = 0;
        for (int i = 0; i < count; i++) {
            if (ds[i] instanceof SachTK) {
                tien += ((SachTK) ds[i]).getDonGia();
                dem++;
            }
        }
        tien = tien / dem;
        System.out.println("Tổng Trung bình cộng của STK: " + tien);
    }

    public void sapXepThanhTienTangDan() {
        Arrays.sort(ds, 0, count, new Comparator<Sach>() {
            public int compare(Sach s1, Sach s2) {
                return Double.compare(s1.tinhTien(), s2.tinhTien());
            }
        });
    }

    public SachGK[] sapXepThanhTienSachGKTangDan(SachGK[] arr) {
        int dem = 0;
        for (int i = 0; i < 100; i++)
            arr[i] = new SachGK();
        for (int i = 0; i < count; i++) {
            if (ds[i] instanceof SachGK) {
                arr[dem] = (SachGK) ds[i];
                dem++;
            }
        }
        Arrays.sort(arr, 0, count, new Comparator<SachGK>() {
            public int compare(SachGK s1, SachGK s2) {
                return Double.compare(s1.tinhTien(), s2.tinhTien());
            }
        });
        return arr;
    }

    public SachTK[] sapXepThanhTienSachTKGiamDan(SachTK[] arr) {
        int dem = 0;
        for (int i = 0; i < 100; i++)
            arr[i] = new SachTK();
        for (int i = 0; i < count; i++) {
            if (ds[i] instanceof SachTK) {
                arr[dem] = (SachTK) ds[i];
                dem++;
            }
        }
        Arrays.sort(arr, 0, count, new Comparator<SachTK>() {
            public int compare(SachTK s1, SachTK s2) {
                return Double.compare(s2.tinhTien(), s1.tinhTien());
            }
        });
        return arr;
    }

    public void xuatSGKNxbK(String k) {
        System.out.println("\nXuất danh sách Sách Giáo Khoa của  " + k);
        for (int i = 0; i < count; i++)
            if (ds[i].getNxb().equalsIgnoreCase(k))
                System.out.println(ds[i].toString());
    }

    public static void xuatSGK(SachGK[] arr) {
        System.out.println("\nXuất danh sách Sách Giáo Khoa:");
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].getMaSach().equalsIgnoreCase("Chưa Xác Định"))
                System.out.println(arr[i].toString());
        }
    }

    public static void xuatSTK(SachTK[] arr) {
        System.out.println("\nXuất danh sách Sách Tham Khao:");
        for (int i = 0; i < arr.length; i++)
            if (!arr[i].getMaSach().equalsIgnoreCase("Chưa Xác Định"))
                System.out.println(arr[i].toString());
    }

    public void xuatSach() {
        System.out.println("\nXuất danh sách hiện có");
        for (int i = 0; i < count; i++) {
            System.out.println(ds[i].toString());
        }
    }

    public void xuatSachXuatBan() {
        System.out.println("\nXuất ra những sách xuất bản vào tháng 5 năm 2016\n");
        for (int i = 0; i < count; i++) {
            if (ds[i].getNgayNhap().getMonth().getValue() == 5 && ds[i].getNgayNhap().getYear() == 2016)
                System.out.println(ds[i].toString());
        }
    }
}
