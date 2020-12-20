package Module4.Bai9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Management {
    ArrayList<Person> ds;
    private Scanner scan;

    /**
     * 
     */
    public Management() {
        ds = new ArrayList<Person>();
    }

    public boolean them(Person x) {
        if (x != null) {
            for (Person i : ds) {
                if (i.getHoTen().equalsIgnoreCase(x.getHoTen())) {
                    System.out.println("Nguoi nay da ton tai !!!");
                    return false;
                }
            }
            ds.add(x);
            return true;
        }
        return false;
    }

    public int xoa(String maHang) {
        scan = new Scanner(System.in);
        boolean checkInput = true;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getHoTen().equalsIgnoreCase(maHang)) {
                int check = 0;
                while (checkInput) {
                    System.out.println("Ban co chac ban: ");
                    System.out.println("1. co");
                    System.out.println("2. khong");
                    try {
                        scan = new Scanner(System.in);
                        check = scan.nextInt();
                        checkInput = true;
                    } catch (Exception e) {
                        System.out.println("Khong hop le !!!");
                        checkInput = false;
                    }
                    if ((check == 1 || check == 2) && checkInput == true)
                        break;
                }
                if (check == 1) {
                    ds.remove(i);
                    return 1;
                } else
                    return 0;
            }
        }
        return -1;
    }

    public void sapXepTheoTen() {
        Collections.sort(ds, new Comparator<Person>() {
            public int compare(Person h1, Person h2) {
                return h1.getHoTen().compareToIgnoreCase(h2.getHoTen());
            }
        });
    }

    public void xuatDS() {
        System.out.println("Xuat DS");
        for (Person i : ds) {
            System.out.println(i.toString());
        }
    }
}
