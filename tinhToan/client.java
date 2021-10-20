package tinhToan;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        int yeuCau;
        int ketQua;
        int n; // So phan tu

        try {
            // Khoi tao socket
            Socket socket= new Socket("127.0.0.1", 8888);
            System.out.println("Client created...");

            try {
                // Khoi tao nhap xuat socket
                DataInputStream in = 
                    new DataInputStream(socket.getInputStream());
                DataOutputStream out = 
                    new DataOutputStream(socket.getOutputStream());

                while (true) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("-----------Menu-----------");
                    System.out.println("1. Tong 1+3+5+7+...+(2n+1)");
                    System.out.println("2. Tong 1*2 + 2*3+...+n*(n+1)");
                    System.out.println("3. Bieu thuc 1-2+3-4+..+(2n+1)");
                    System.out.println("4. Exit");
                    System.out.println("------------End-----------");

                    // Nhap du lieu tu ban phim
                    System.out.println("Nhap yeu cau:");
                    yeuCau = sc.nextInt();
                    if (yeuCau == 4) { // Neu nhap 4 thi thoat khoi socket
                        System.out.println("Da thoat khoi he thong!");
                        socket.close();
                        break;
                    }
                    System.out.println("Gui tham so n: ");
                    n = sc.nextInt();

                    // Gui yeu cau den socket
                    out.writeInt(yeuCau);
                    out.writeInt(n);

                    // Nhan ket qua tra ve tu server
                    ketQua = in.readInt();
                    System.out.println("Ket qua cua yeu cau " + yeuCau + "= " + ketQua + "\n"); 
                }
            } catch (Exception e) {
                System.out.println("Ket noi bi tu choi!");
            }
        } catch (Exception e) {
            System.out.println("Khong tao duoc client!");
        }
    }
}
