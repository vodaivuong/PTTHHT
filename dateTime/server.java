package dateTime;

import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        int port = 8888;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server created...");
            System.out.println("Waiting for client on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted " + socket);

                processing p = new processing(socket);
                p.start();
            }
        } catch (Exception e) {
            System.out.println("Khong tao duoc server!");
        }
    }
}
