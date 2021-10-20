package chatBox;

import java.net.ServerSocket;
import java.net.Socket;

public class server2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8810);
            System.out.println("Server created...");

           while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Accepted client..." + socket);

                    processing p = new processing(socket);
                    p.start();
                } catch (Exception e) {
                    System.out.println("Ket noi bi gian doan!");
                }
           }
        } catch (Exception e) {
            System.out.println("Khong tao duoc server!");
        }
    }
}
