package dateTime;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;



public class client {
    public static void main(String[] args) {
        int yeuCau;
        String ketQua;
        String serverName = "localhost";
        int port = 8888;

        // Nhap thong tin ket noi server
        Scanner sc = new Scanner(System.in);
        // System.out.println("Nhap dia chi server: ");
        // serverName = sc.nextLine();
        // System.out.println("Nhap cong ket noi: ");
        // port = sc.nextInt();

        try {
            // Khoi tao socket
            Socket socket = new Socket(serverName, port);
            System.out.println("Client created...");

            while (true) {
                try {
                    // Khai bao nhap xuat socket
                    DataInputStream in =  
                    new DataInputStream(socket.getInputStream());
                    DataOutputStream out =
                        new DataOutputStream(socket.getOutputStream());
                    
                    System.out.println("-----------Menu-----------");
                    System.out.println("1. Time");
                    System.out.println("2. Date");
                    System.out.println("3. Date & Time");
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
                    
                    // Gui yeu cau cho server
                    out.writeInt(yeuCau);

                    // Nhan thog tin server gui ve
                    ketQua = in.readUTF();
                    System.out.println("Bay gio la: " + ketQua + '\n');

                } catch (Exception e) {
                    System.out.println("Khong ket noi duoc server!");
                }
            }
        } catch (Exception e) {
            System.out.println("Khong tao duoc client!");
        }
    }
}


