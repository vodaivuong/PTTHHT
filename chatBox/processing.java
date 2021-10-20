package chatBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class processing extends Thread {
    Socket socket;

    processing(Socket socket) {
        this.socket = socket;
    }
    
    public void run() {
        String msg;
        String msg2;
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                DataInputStream in = 
                    new DataInputStream(socket.getInputStream());
    
                DataOutputStream out = 
                    new DataOutputStream(socket.getOutputStream());
    
                while (true) {
                    // Doc du lieu tu socket
                    msg = in.readUTF();
                    if (msg.equalsIgnoreCase("exit")) {
                        socket.close();
                        break;
                    }
                    System.out.println("Client: " + msg);
    
                    // Nhap du lieu tu ban phim
                    System.out.println("Message: ");
                    msg2 = sc.nextLine();
    
                    // Tin nhan duoc ghi vao socket
                    out.writeUTF(msg2);
                }  
            }
        } catch (Exception e) {
            System.out.println("Ket noi bi gian doan!");
        }
        sc.close();
    }
}
