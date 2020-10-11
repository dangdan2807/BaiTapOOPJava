package Module2.Bai6;

public class TestAccount {
    public static void main(String[] args) {
        Account acc1 = new Account(72354, "Ted Murphy", 102.56);
        Account acc2 = new Account(69713, "Jane Smith", 40.00);
        Account acc3 = new Account(93757, "Edward Demsey", 759.32);

        System.out.println("Gởi thêm số tiền cho acc1 là 25.85, cho acc2 là 500.00");
        acc1.deposit(25.85);
        acc2.deposit(500);
        
        System.out.println("Rút khỏi acc2 số tiền là 430.75, mức phí 1.50.");
        acc2.withdraw(430.75, 1.5);
        
        System.out.println("Tính tiền lãi cho acc3");
        acc3.addInterest();
        
        System.out.println(Account.tieuDe());
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());
        System.out.println(acc3.toString());

        System.out.println("\nChuyển tiền từ acc2 sang cho acc1 số tiền là 100.00");
        acc2.transfer(acc1, 100);

        System.out.println(Account.tieuDe());
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());
    }
}