package javaBasic;

import java.util.Scanner;

public class Bai4 {
    public static void tongN(int n){
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println("Tong cua 1 den " + n + " = " + sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Nhap vao so n phan tu: ");
        n = sc.nextInt();
        tongN(n);
        sc.close();
    }
}
