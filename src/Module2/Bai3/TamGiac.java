package Module2.Bai3;

public class TamGiac {
	private float mA;
	private float mB;
	private float mC;

	public TamGiac() {
		super();
	}

	public TamGiac(float mA, float mB, float mC) {
		if (dieuKien(mA, mB, mC) == 1) {
			this.mA = mA;
			this.mB = mB;
			this.mC = mC;
		} else {
			this.mA = 0;
			this.mB = 0;
			this.mC = 0;
		}
	}

	public float getmA() {
		return mA;
	}

	public void setmA(float mA) {
		if (dieuKien(mA, mB, mC) == 1 || mA > 0)
			this.mA = mA;
	}

	public float getmB() {
		return mB;
	}

	public void setmB(float mB) {
		if (dieuKien(mA, mB, mC) == 1 || mB > 0)
			this.mB = mB;
	}

	public float getmC() {
		return mC;
	}

	public void setmC(float mC) {
		if (dieuKien(mA, mB, mC) == 1 || mC > 0)
			this.mC = mC;
	}

	public int dieuKien(float mA, float mB, float mC) {
		if ((mA < mB + mC) && (mB < mA + mC) && (mC < mA + mB))
			return 1;
		return 0;
	}

	public float tinhChuVi() {
		if (dieuKien(mA, mB, mC) == 0)
			return 0;
		return (mA + mB + mC) / 2;
	}

	public float tinhDienTich() {
		float p = tinhChuVi();
		return (float) Math.sqrt(p * (p - mA) * (p - mB) * (p - mC));
	}

	public String kieuTamGiac() {
		if (dieuKien(mA, mB, mC) == 1) {
			if (mA == mB && mB == mC || mA == mC && mC == mB || mB == mA
					&& mA == mC)
				return "Tam Giác Đều";
			else if (mA == mB || mA == mC || mB == mC)
				return "Tam Giác Cân";
			else
				return "Tam Giác Thường";
		}
		return "Không phải tam giác";
	}

	public static String tieuDe() {
		return String.format(" %-5s %-5s %-5s %-20s %-8s %-10s", "mA", "mB", "mC", "Kiểu Tam Giác", "Chu Vi", "Diện Tích");
	}

	public String toString() {
		return String.format("%5.2f %5.2f %5.2f  %-19s %5.2f\t%5.2f", mA, mB, mC,
				kieuTamGiac(), tinhChuVi(), tinhDienTich());
	}
}
