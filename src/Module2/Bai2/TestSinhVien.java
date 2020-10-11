package Module2.Bai2;

import java.util.Scanner;

public class TestSinhVien {

	private static Scanner scan;

	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien(123456, "Pham Dang Dan", 8, 9);

		SinhVien sv2 = new SinhVien();
		sv2.setMaSV(123457);
		sv2.setHoTen("Nguyen Van A");
		sv2.setDiemLT(-3f);
		sv2.setDiemTH(7f);

		SinhVien sv3 = new SinhVien();
		scan = new Scanner(System.in);
		
		System.out.print("Nhap ma so sinh vien: ");
		int masv = scan.nextInt();
		scan.nextLine();
		System.out.print("Nhap ho va ten: ");
		String hoTen = scan.nextLine();
		System.out.print("Nhap diem LT: ");
		float diemLT = scan.nextFloat();
		System.out.print("Nhap diem TH: ");
		float diemTH = scan.nextFloat();

		sv3 = new SinhVien(masv, hoTen, diemLT, diemTH);
		
		System.out.println("Xuat thong tin danh sach sinh vien: ");
		System.out.println(SinhVien.tieuDe());
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
	}
}

