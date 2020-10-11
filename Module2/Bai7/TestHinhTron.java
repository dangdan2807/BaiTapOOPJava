package Module2.Bai7;

public class TestHinhTron {
    public static void main(String[] args) {
        ToaDo p = new ToaDo("P", 5, 5);
        HinhTron hinhTron = new HinhTron(p, 10.5);
        System.out.println(hinhTron.toString());
    }
}