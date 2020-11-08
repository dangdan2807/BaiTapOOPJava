
import java.util.Scanner;

public class test {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
        } //while (!checkInput && (id != 1));
        System.out.println("ID là: " + id);
    }
}
