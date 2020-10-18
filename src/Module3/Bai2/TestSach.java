package Module3.Bai2;

import java.time.LocalDate;

public class TestSach {
    public static void main(String[] args) {
        QLSach ds = new QLSach();

        ds.themSach(new SachGK("GK01", LocalDate.of(2016, 5, 26), 500, 5, "NXB Kim Dong", "moi"));
        ds.themSach(new SachGK("GK02", LocalDate.of(2020, 11, 26), 450, 3, "NXB Giao Duc", "cu"));
        ds.themSach(new SachGK("GK03", LocalDate.of(2019, 11, 26), 450, 3, "NXB Tre", "moi"));

        ds.themSach(new SachTK("TK01", LocalDate.of(2020, 11, 26), 600, 3, "NXB Kim Dong", 5));
        ds.themSach(new SachTK("TK02", LocalDate.of(2020, 11, 26), 250, 7, "NXB Tre", 3));
        ds.themSach(new SachTK("TK03", LocalDate.of(2020, 11, 26), 250, 7, "NXB Giao Duc", 7));

        ds.tinhTienTungLoaiSach();
        ds.tinhTBCongSTK();
        ds.xuatSGKNxbK("NXB kim Dong");
        ds.xuatSach();

        ds.sapXepThanhTienTangDan();
        System.out.println("Sắp xếp thành tiền tăng dần");
        ds.xuatSach();
        
        ds.xuatSachXuatBan();

        System.out.println("\nSap Xep Thanh Tien SachGK Tang Dan");
        SachGK[] arrSGK = new SachGK[100];
        ds.sapXepThanhTienSachGKTangDan(arrSGK);
        QLSach.xuatSGK(arrSGK);
        
        System.out.println("\nSap Xep Thanh Tien SachTK Giam Dan");
        SachTK[] arrSTK = new SachTK[100];
        ds.sapXepThanhTienSachTKGiamDan(arrSTK);
        QLSach.xuatSTK(arrSTK);


    }
}
