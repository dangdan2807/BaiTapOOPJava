package Module4.Bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QLSach {
    private ArrayList<Sach> ds;

    /**
     * 
     */
    public QLSach() {
        ds = new ArrayList<Sach>();
    }

    public boolean themSach(Sach x) {
        if (x != null) {
            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i).getMaSach().equalsIgnoreCase(x.getMaSach())) {
                    System.out.println("Sách đã tồn tại.");
                    return false;
                }
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public void tinhTienTungLoaiSach() {
        double tienSGK = 0, tienSTK = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof SachGK)
                tienSGK += ds.get(i).tinhTien();
            if (ds.get(i) instanceof SachTK)
                tienSTK += ds.get(i).tinhTien();
        }
        System.out.println("Tổng tiền loại Sách GK: " + tienSGK);
        System.out.println("Tổng tiền loại Sách TK: " + tienSTK);
    }

    public void tinhTBCongSTK() {
        double tien = 0;
        int dem = 0;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof SachTK) {
                tien += ds.get(i).getDonGia();
                dem++;
            }
        }
        tien = tien / dem;
        System.out.println("Tổng Trung bình cộng của STK: " + tien);
    }

    public void sapXepThanhTienTangDan() {
        Collections.sort(ds, new Comparator<Sach>() {
            public int compare(Sach s1, Sach s2) {
                return Double.compare(s1.tinhTien(), s2.tinhTien());
            }
        });
    }

    public ArrayList<SachGK> sapXepThanhTienSachGKTangDan(ArrayList<SachGK> arr) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof SachGK) {
                arr.add((SachGK) ds.get(i));
            }
        }
        Collections.sort(arr, new Comparator<SachGK>() {
            public int compare(SachGK s1, SachGK s2) {
                return Double.compare(s1.tinhTien(), s2.tinhTien());
            }
        });
        return arr;
    }

    public ArrayList<SachTK> sapXepThanhTienSachTKGiamDan(ArrayList<SachTK> arr) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof SachTK) {
                arr.add((SachTK) ds.get(i));
            }
        }
        Collections.sort(arr, new Comparator<SachTK>() {
            public int compare(SachTK s1, SachTK s2) {
                return Double.compare(s2.tinhTien(), s1.tinhTien());
            }
        });
        return arr;
    }

    public void xuatSGKNxbK(String k) {
        System.out.println("\nXuất danh sách Sách Giáo Khoa của  " + k);
        for (int i = 0; i < ds.size(); i++)
            if (ds.get(i).getNxb().equalsIgnoreCase(k))
                System.out.println(ds.get(i).toString());
    }

    public static void xuatSGK(ArrayList<SachGK> arr) {
        System.out.println("\nXuất danh sách Sách Giáo Khoa:");
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).getMaSach().equalsIgnoreCase("Chưa Xác Định"))
                System.out.println(arr.get(i).toString());
        }
    }

    public static void xuatSTK(ArrayList<SachTK> arr) {
        System.out.println("\nXuất danh sách Sách Tham Khao:");
        for (int i = 0; i < arr.size(); i++)
            if (!arr.get(i).getMaSach().equalsIgnoreCase("Chưa Xác Định"))
                System.out.println(arr.get(i).toString());
    }

    public void xuatSach() {
        System.out.println("\nXuất danh sách hiện có");
        for (int i = 0; i < ds.size(); i++) {
            System.out.println(ds.get(i).toString());
        }
    }

    public void xuatSachXuatBan() {
        System.out.println("\nXuất ra những sách xuất bản vào tháng 5 năm 2016\n");
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getNgayNhap().getMonth().getValue() == 5 && ds.get(i).getNgayNhap().getYear() == 2016)
                System.out.println(ds.get(i).toString());
        }
    }
}
