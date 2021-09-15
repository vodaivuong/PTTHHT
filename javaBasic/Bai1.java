package javaBasic;
import java.util.*;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println("Nhap chuoi can viet hoa: ");
        s = sc.nextLine();
        System.out.println("Chuoi sau khi duoc viet hoa: ");
        System.out.println(s.toUpperCase());
        sc.close();
    }
}
