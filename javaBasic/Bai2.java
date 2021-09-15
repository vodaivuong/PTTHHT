package javaBasic;

import java.util.Scanner;

public class Bai2 {
    public static int kiemTraSoNguyenTo(int s){
        if(s < 2){
            return 1;
        }else{
            for (int i = 2; i <= Math.sqrt(s); i++) {
                if(s%i == 0)
                    return 1;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Nhap chuoi so can kiem tra
        int so;
        System.out.println("Nhap so can kiem tra: ");
        so = sc.nextInt();
        if(kiemTraSoNguyenTo(so) == 1){
            System.out.println("So " + so + " khong phai so nguyen to!!");
        }else{
            System.out.println("So " + so + " la so nguyen to");
        }
        sc.close();
    }
}
