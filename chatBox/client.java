package chatBox;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * client
 */
public class client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String msg;
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
                }
            } catch (Exception e) {
                System.out.println("Ket noi bi gian doan!");
            }
        } catch (Exception e) {
            System.out.println("Khong tao duoc client!");
        }
    }
}