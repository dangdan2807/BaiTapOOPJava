package Module2.Bai10;

import java.util.Scanner;

public class TestCD {
    private static Scanner scan = new Scanner(System.in);

    public static CD nhapCD() {
        System.out.println("Nhập Thông Tin CD Mới\n");
        scan = new Scanner(System.in);
        System.out.print("Nhập mã CD: ");
        int maCd = scan.nextInt();
        System.out.print("Nhập tên CD: ");
        scan = new Scanner(System.in);
        String tenCD = scan.nextLine();
        System.out.print("Nhập số bài hát: ");
        int soBH = scan.nextInt();
        System.out.print("Nhập giá thành: ");
        double giaThanh = scan.nextDouble();
        CD temp = new CD(maCd, tenCD, soBH, giaThanh);
        return temp;
    }

    public static void main(String[] args) {
        int ma;
        String tua;
        CDList ds = new CDList(100);
        int luaChon;

        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm CD");
            System.out.println("2. Xuất danh sách CD");
            System.out.println("3. Xuất số lượng CD");
            System.out.println("4. Tính tổng giá thành");
            System.out.println("5. Tìm kiếm theo Mã CD");
            System.out.println("6. Sắp xếp danh sách giảm dần theo giá thành");
            System.out.println("7. Sắp xếp danh sách tăng dần theo tựa CD");
            System.out.println("8. Thêm CD Nhanh");
            System.out.println("9. Làm tất cả lựa chọn trên nhanh (bao gồm 8)");
            System.out.println("0. Thoát Chương Trình");
            System.out.print("Nhập lựa chọn: ");
            scan = new Scanner(System.in);
            luaChon = scan.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số lượng CD cần thêm: ");
                    int n = scan.nextInt();
                    for (int i = 0; i < n; i++) {
                        ds.themCD(nhapCD());
                    }
                    break;
                case 2:
                    System.out.println("Xuất danh sách các CD\n");
                    ds.xuatDS();
                    break;
                case 3:
                    System.out.println("\nSố Lượng CD: " + ds.soLuongCD() + "\n");
                    break;
                case 4:
                    System.out.println("\nTong tien CD: " + ds.tinhTong() + "\n");
                    break;
                case 5:
                    System.out.print("Nhap ma CD can tim: ");
                    ma = scan.nextInt();
                    if (!ds.timMa(ma))
                        System.out.println("Không tìm thấy");
                    break;
                case 6:
                    System.out.println("Sắp xếp giá thành giảm dần");
                    ds.sapXepGiaThanh();
                    break;
                case 7:
                    System.out.println("Sắp xếp tựa CD tăng dần");
                    ds.sapXepTua();
                    break;
                case 8:
                    ds.themCD(new CD(1, "Chúc Bé Ngủ Ngon", 5, 100000));
                    ds.themCD(new CD(2, "Anh Hùng Xạ Điêu", 7, 405000));
                    ds.themCD(new CD(3, "Hiệp Khách Hành", 2, 200000));
                    ds.themCD(new CD(4, "Thiên Long Bát Bộ", 4, 70000));
                    System.out.println("\nĐã thêm 4 CD mẫu\n");
                    break;
                case 9:
                    ds.themCD(new CD(1, "Chúc Bé Ngủ Ngon", 5, 100000));
                    ds.themCD(new CD(2, "Anh Hùng Xạ Điêu", 7, 405000));
                    ds.themCD(new CD(3, "Hiệp Khách Hành", 2, 200000));
                    ds.themCD(new CD(4, "bolero", 4, 70000));

                    System.out.println("Xuất danh sách các CD\n");
                    ds.xuatDS();

                    System.out.println("\nSo Luong CD: " + ds.soLuongCD());
                    System.out.println("\nTong tien CD: " + ds.tinhTong());

                    System.out.print("Nhap ma CD can tim: ");
                    ma = scan.nextInt();
                    if (!ds.timMa(ma))
                        System.out.println("Không tìm thấy");

                    scan = new Scanner(System.in);
                    System.out.print("Nhap tua CD can tim: ");
                    tua = scan.nextLine();
                    if (!ds.timTua(tua))
                        System.out.println("Không tìm thấy");

                    System.out.println("Sắp xếp giá thành tăng dần");
                    ds.sapXepGiaThanh();
                    ds.xuatDS();

                    System.out.println("Sắp xếp tựa CD tăng dần");
                    ds.sapXepTua();
                    ds.xuatDS();
                    break;
                default:
                    break;
            }
        } while (luaChon != 0);
    }
}
