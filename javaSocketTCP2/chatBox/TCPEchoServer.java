package javaSocketTCP2.chatBox;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {
    static String sentence_to_client;
    static String sentence_from_client;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8081);
            System.out.println("Sever created...");
            System.out.println("Waiting client on 8081");
            try {
                while (true) {
                    //chờ yêu cầu từ client
                    Socket s = ss.accept();
                    System.out.println("Accepted socket: " + s);
                    
                    //Tạo input stream, nối tới Socket
                    BufferedReader inFromClient =
                    new BufferedReader(new
                        InputStreamReader(s.getInputStream())); 
                
                    //Tạo outputStream, nối tới socket
                    DataOutputStream outToClient =
                        new DataOutputStream(s.getOutputStream());
                    
                    while (true) {
                        //Đọc thông tin từ socket
                        sentence_from_client = inFromClient.readLine();   

                        // print dữ liệu ra màn hình
                        System.out.println("CLIENT: " + sentence_from_client);

                        //Tạo Inputstream(từ bàn phím)
                        System.out.print("Input from server: ");
                        BufferedReader inFromServer =
                            new BufferedReader(new InputStreamReader(System.in));
                        sentence_to_client = inFromServer.readLine();

                        //ghi dữ liệu ra socket
                        outToClient.writeBytes(sentence_to_client + '\n');
      
                    }
                }
            } catch (IOException e) {
                System.out.println("Khong ket noi duoc voi client!");
            }
         } catch (IOException e) {
            System.out.println("Khong tao duoc server!");
        } 
    }
}
