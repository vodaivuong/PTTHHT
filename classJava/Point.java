package classJava;

import java.util.Scanner;

public class Point {
    Scanner sc = new Scanner(System.in);
    //Khoi tao gia tri
    int x, y;
        
        //Phuong thuc gan toa do
        void insertPoint(int x, int y){
            this.x = x;
            this.y = y;
        }

        //Phuong thuc nhap vao toa do
        void nhapToaDo(){
            int x1, y1;
            System.out.print("Nhap toa do x: ");
            x1 = sc.nextInt();
            System.out.print("Nhap toa do y: ");
            y1 = sc.nextInt();
            //Gan toa do cho diem do
            insertPoint(x1, y1);
        }

        //In ra man hinh
        void inManHinh(){
            System.out.println("(" + x + "," + y + ")");
        }

        //Tinh khoang cach tu diem do den goc toa do O(0,0)
        //Cong thuc sqrt(x*x + y*y)
        double khoangCach(){
            double kc = Math.sqrt(this.x*this.x + this.y*this.y);
            return kc;
        }

        public static void main(String[] args) {
            Point A = new Point();
            Point B = new Point();

            //Gan toan do (3,5) cho diem A
            A.insertPoint(3, 5);

            //Nhap tu ban phim vao toa do diem B
            B.nhapToaDo();

            //In ra man hinh 2 diem da tao
            System.out.print("Diem A");
            A.inManHinh();
            System.out.print("Diem B");
            B.inManHinh();

            //Khoang cach tu diem den goc toa do
            System.out.println("Khoang cach tu diem A den goc toa do = " + A.khoangCach());
            System.out.println("Khoang cach tu diem B den goc toa do = " + B.khoangCach());
        }
}
