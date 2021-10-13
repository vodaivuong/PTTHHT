package javaSocketTCP2.chatBox;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8081);
            System.out.println("Sever created...");
            System.out.println("Waiting client on 8081");

            while (true) {
                //Khoi tao socket va cho xac nhan
                Socket s = ss.accept();

                //Khoi chay trinh xu ly da luong
                Processing p = new Processing(s);
                p.start();

            }
        } catch (IOException e) {
            System.out.println("Khong tao duoc server!");
        }
    }
}
