package javaSocketTCP2.docKyTu;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.net.Socket;

public class TCPEchoClient {
    static String sentence_to_server;
    static String sentence_from_server;
    public static void main(String[] args) {
        try {
            // Khoi tao socket
            Socket s = new Socket("127.0.0.1", 8081);
            System.out.println("Client created..." + s);
            
            try {
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
                    if (sentence_to_server.equalsIgnoreCase("@")) {
                        break;
                    }

                    //Đóng socket khi khong nhap gi
                    // if (sentence_to_server.equalsIgnoreCase("")) {
                    //     s.close(); 
                    //     break;
                    // }

                    //Gửi chuỗi ký tự tới Server thông qua outputStream đã nối với Socket (ở trên)
                    outToServer.writeBytes(sentence_to_server + '\n');
                
                    //Đọc tin từ Server thông qua InputSteam đã nối với socket
                    sentence_from_server = inFromServer.readLine();

                    //print kết qua ra màn hình
                    System.out.println("SERVER: " + sentence_from_server);
                }
            } catch (Exception e) {
                System.out.println("Ngat ket noi!");
            }
        } catch (Exception e) {
            System.out.println("Khong tao duoc client!");
        }
    }
}
