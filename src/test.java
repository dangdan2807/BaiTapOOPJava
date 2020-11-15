import java.util.Scanner;

public class test {
    private static Scanner sc = new Scanner(System.in);
    private static Scanner scan;

    public int nhapSo(int n) {
        boolean checkInput = true;
        int id = 0;
        while(true) {
            try {
                System.out.print("Hay nhap ID: ");
                id = sc.nextInt();
                checkInput = true;
            } catch (Exception e) {
                checkInput = false;
                sc.nextLine();
            }
            if(checkInput == true && (id == 1 || id == 2))
                break;
        }
        return id;
    }
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        String a = scan.next();
        System.out.println(a);
    }
}
