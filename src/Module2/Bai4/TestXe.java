package Module2.Bai4;

public class TestXe {
	public static void main(String[] args) {
		Xe[] xe = new Xe[3];
		xe[0] = new Xe("Nguyễn Thị Loan", "Future Neo", 35000000, 100);
		xe[1] = new Xe("Lê Minh Tính", "Ford Ranger", 250000000, 3000);
		xe[2] = new Xe("Nguyễn Minh Triết", "Landscape", 1000000000, 1500);

		System.out.println(Xe.TieuDe());
		for(int i = 0; i < 3; i++)
			System.out.println(xe[i].toString());
	}
}