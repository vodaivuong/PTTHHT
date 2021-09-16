package classJava;

import java.util.Scanner;

public class Point {
    int x, y;
        
        //Phuong thuc khoi tao Diem
        void insertPoint(int x, int y){
            this.x = x;
            this.y = y;
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
            Scanner sc = new Scanner(System.in);
            Point A = new Point();
            Point B = new Point();

            //Gan toan do (3,5) cho diem A
            A.insertPoint(3, 5);

            //Tao toa do cho diem B
            int x1, y1;
            System.out.print("Nhap toa do x: ");
            x1 = sc.nextInt();
            System.out.print("Nhap toa do y: ");
            y1 = sc.nextInt();

            //Gan toa do vua tao cho B
            B.insertPoint(x1, y1);

            //Khoang cach tu diem A den goc toa do
            System.out.println("Khoang cach tu diem A den goc toa do = " + A.khoangCach());
            //Khoang cach tu diem B den goc toa do
            System.out.println("Khoang cach tu diem B den goc toa do = " + B.khoangCach());

            //In ra man hinh 2 diem da tao
            System.out.print("Diem A");
            A.inManHinh();
            System.out.print("Diem B");
            B.inManHinh();
            sc.close();
        }
}
