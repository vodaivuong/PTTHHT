package javaBasic;

import java.util.Scanner;

public class Bai3 {
    public static void giaiPT(int a1, int b1, int c1){
        float x;
        if (a1 == 0) {
            if(b1 == 0){
                System.out.println("Phuong trinh vo nghiem!");
            } else{
                x = -(c1/b1);
                System.out.println("Giai pt ta duoc x = " + x);
            }
        } else {
            float delta = b1*b1 - 4*a1*c1;
            float x1;
            float x2;
            // tính nghiệm
            if (delta > 0) {
                x1 = (float) ((-b1 + Math.sqrt(delta)) / (2*a1));
                x2 = (float) ((-b1 - Math.sqrt(delta)) / (2*a1));
                System.out.println("Phuong trinh co 2 nghiem la: "
                        + "x1 = " + x1 + " va x2 = " + x2);
            } else if (delta == 0) {
                x1 = (-b1 / (2 * a1));
                System.out.println("Phuong trinh co nghiem kep: "
                        + "x1 = x2 = " + x1);
            } else {
                System.out.println("Phuong trinh vo nghiem!");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        //Nhap a,b,c
        System.out.print("Nhap he so bac 2 a: ");
        a = sc.nextInt();
        System.out.print("Nhap he so bac 1 b: ");
        b = sc.nextInt();
        System.out.print("Nhap he so bac 0 c: ");
        c = sc.nextInt();
        // System.out.println(a + " " + b + " " + c);
        giaiPT(a, b, c);
        sc.close();
    }
}
