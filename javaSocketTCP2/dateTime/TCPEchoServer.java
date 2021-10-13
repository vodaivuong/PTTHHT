package javaSocketTCP2.dateTime;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                    //Chờ yêu cầu từ client
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
                        //Tạo thuộc tính date
                        Date dt = new Date();
                        
                        //Đọc thông tin từ socket
                        sentence_from_client = inFromClient.readLine();  
                        
                        //Hiển thị yêu cầu từ client
                        System.out.println("Yeu cau: " + sentence_from_client);

                        //Xử lý yêu cầu từ cilent
                        if (sentence_from_client.equalsIgnoreCase("2")) {
                            SimpleDateFormat dft = new SimpleDateFormat("E dd.MM.yyyy");
                            sentence_to_client = dft.format(dt);
                        } else if (sentence_from_client.equalsIgnoreCase("1")) {
                            SimpleDateFormat dfd = new SimpleDateFormat("HH:mm:ss");
                            sentence_to_client = dfd.format(dt);
                        } else if (sentence_from_client.equalsIgnoreCase("3")) {
                            SimpleDateFormat df = new SimpleDateFormat("E dd.MM.yyyy 'at' HH:mm:ss");
                            sentence_to_client = df.format(dt);
                        } else if (sentence_from_client.equalsIgnoreCase("4")) {
                            break;
                        } else {
                            sentence_to_client = "Yeu cau khong dung";
                        }

                        //Thông báo trên server 
                        System.out.println("Da xu ly");

                        //ghi dữ liệu ra socket
                        outToClient.writeBytes(sentence_to_client + '\n');

                    }
                    
                }
            } catch (IOException e) {
                System.out.println("Khong co ket noi voi client!");
            }
         } catch (IOException e) {
            System.out.println("Khong tao duoc server!");
        } 
    }
}
