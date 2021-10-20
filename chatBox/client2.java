package chatBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client2 {
    public static void main(String[] args) {
        String msg;
        String msg2;
        Scanner sc = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 8810);
            System.out.println("Client created...");

            try {
                DataInputStream in = 
                    new DataInputStream(socket.getInputStream());

                DataOutputStream out = 
                    new DataOutputStream(socket.getOutputStream());

                while (true) {
                    // Nhap du lieu tu ban phim
                    System.out.println("Message: ");
                    msg = sc.nextLine();
                    if (msg.equalsIgnoreCase("exit")) {
                        socket.close();
                        break;
                    }

                    // Tin nhan duoc ghi vao socket
                    out.writeUTF(msg);

                    // Doc du lieu tu server gui lai
                    msg2 = in.readUTF();
                    System.out.println("Server: " + msg2);
                }

                
            } catch (Exception e) {
                System.out.println("Ket noi bi gian doan!");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Khong tao duoc client!");
        }
    }
}
