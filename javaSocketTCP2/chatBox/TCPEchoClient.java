package javaSocketTCP2.chatBox;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;
// import java.util.Scanner;

public class TCPEchoClient {
    static String sentence_to_server;
    static String sentence_from_server;
    public static void main(String[] args) {
        int port = 8081;
        String serverName = "127.0.0.1";
        try {
            // Scanner sc = new Scanner(System.in);
            // System.out.println("Nhap dia chi IP: ");
            // serverName = sc.nextLine();
            // System.out.println("Nhap port: ");
            // port = sc.nextInt();

            // Khoi tao socket
            Socket s = new Socket(serverName, port);
            System.out.println("Client created...");
            
            try {
                System.out.println("Connect to " + s);

                //Tạo inputStream nối với Socket
                BufferedReader inFromServer =
                new BufferedReader(new
                InputStreamReader(s.getInputStream()));

                //Tạo OutputStream nối với Socket
                DataOutputStream outToServer =
                new DataOutputStream(s.getOutputStream());

                // Gui du lieu cho sever
                while (true) {
                    //Tạo Inputstream(từ bàn phím)
                    System.out.print("Input from client: ");
                    BufferedReader inFromUser =
                        new BufferedReader(new InputStreamReader(System.in));
                        
                    //Lấy chuỗi ký tự nhập từ bàn phím
                    sentence_to_server = inFromUser.readLine();
                    if (sentence_to_server.equalsIgnoreCase("")) {
                        s.close();
                        break;
                    }

                    //Gửi chuỗi ký tự tới Server thông qua outputStream đã nối với Socket (ở trên)
                    outToServer.writeBytes(sentence_to_server + '\n');
                
                    //Đọc tin từ Server thông qua InputSteam đã nối với socket
                    sentence_from_server = inFromServer.readLine();
                
                    //print kết qua ra màn hình
                    System.out.println("SERVER: " + sentence_from_server);

                }
                // sc.close();
            } catch (IOException e) {
                System.out.println("Ket noi bi tu choi!");
            }
        } catch (IOException e) {
            System.out.println("Khong tao duoc client!");
        }
    }
}
