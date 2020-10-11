package Module2.Bai3;

import java.util.Scanner;

public class TestTamGiac {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		TamGiac tg1 = new TamGiac(3, 3, 3);
		
		TamGiac tg2 = new TamGiac();
		tg2.setmA(3);
		tg2.setmB(3);
		tg2.setmC(5);
		
		TamGiac tg3 = new TamGiac();
		System.out.print("Nhập cạnh mA: ");
		float a = scan.nextFloat();
		System.out.print("Nhập cạnh mB: ");
		float b = scan.nextFloat();
		System.out.print("Nhập cạnh mC: ");
		float c = scan.nextFloat();
		
		tg3.setmA(a);
		tg3.setmB(b);
		tg3.setmC(c);
		
		System.out.println(TamGiac.tieuDe());
		System.out.println(tg1.toString());
		System.out.println(tg2.toString());
		System.out.println(tg3.toString());
	}

}
