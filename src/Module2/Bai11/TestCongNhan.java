package Module2.Bai11;

import java.util.Scanner;

public class TestCongNhan {

    private static Scanner scan = new Scanner(System.in);

    public static CongNhan nhapCN(int n) {
        System.out.println("Nhập Thông Tin CN Thứ " + n + "\n");
        scan = new Scanner(System.in);
        System.out.print("Nhập họ: ");
        String ho = scan.nextLine();

        System.out.print("Nhập tên: ");
        scan = new Scanner(System.in);
        String ten = scan.nextLine();

        System.out.print("Nhập số SP: ");
        int soSP = scan.nextInt();

        CongNhan temp = new CongNhan(ho, ten, soSP);
        return temp;
    }

    public static void main(String[] args) {
        int luaChon;
        DsCongNhan ds = new DsCongNhan(100);
        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm CN");
            System.out.println("2. Xuất danh sách CN");
            System.out.println("3. Xuất số lượng CN");
            System.out.println("4. Xuất danh sách CN có hơn 200 SP");
            System.out.println("5. Sắp xếp CN theo SP giảm dần");
            System.out.println("6. Thêm CN Nhanh");
            System.out.println("7. Làm tất cả lựa chọn trên nhanh (bao gồm cả 6)");
            System.out.println("0. Thoát Chương Trình");
            System.out.print("Nhập lựa chọn: ");
            scan = new Scanner(System.in);
            luaChon = scan.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số lượng CN cần thêm: ");
                    int n = scan.nextInt();
                    for (int i = 0; i < n; i++) {
                        ds.themCN(nhapCN(i + 1));
                    }
                    break;
                case 2:
                    System.out.println("Xuất danh sách các CN\n");
                    ds.XuatDsCN();
                    break;
                case 3:
                    System.out.println("\nSố Lượng CN: " + ds.soLuongCN() + "\n");
                    break;
                case 4:
                    System.out.println("Xuất danh sách các CN có số SP lớn hơn 200\n");
                    ds.XuatDsCN200();
                    break;
                case 5:
                    System.out.println("Sắp xếp danh sách CN giảm dần");
                    ds.sapXepCN();
                    break;
                case 6:
                    ds.themCN(new CongNhan("Nguyễn", "Minh", 633));
                    ds.themCN(new CongNhan("Mai", "Hoàng", 370));
                    ds.themCN(new CongNhan("Võ", "Đăng", 135));
                    ds.themCN(new CongNhan("Nguyễn", "An", 463));
                    ds.themCN(new CongNhan("Phạm", "Thanh", 210));
                    System.out.println("\nĐã thêm 5 CN\n");
                    break;
                case 7:
                    ds.themCN(new CongNhan("Nguyễn", "Minh", 633));
                    ds.themCN(new CongNhan("Mai", "Hoàng", 370));
                    ds.themCN(new CongNhan("Võ", "Đăng", 135));
                    ds.themCN(new CongNhan("Nguyễn", "An", 463));
                    ds.themCN(new CongNhan("Phạm", "Thanh", 210));

                    System.out.println("Xuất danh sách các CN\n");
                    ds.XuatDsCN();

                    System.out.println("\nSố Lượng CN: " + ds.soLuongCN() + "\n");

                    System.out.println("\nXuất danh sách các CN có số SP lớn hơn 200\n");
                    ds.XuatDsCN200();

                    System.out.println("\nSắp xếp danh sách CN giảm dần");
                    ds.sapXepCN();
                    ds.XuatDsCN();
                    break;
                default:
                    break;
            }
        } while (luaChon != 0);

    }
}