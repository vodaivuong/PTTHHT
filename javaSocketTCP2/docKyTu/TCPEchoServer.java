package javaSocketTCP2.docKyTu;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {
    static String sentence_to_client;
    static String sentence_from_client;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8081);
            System.out.println("Sever created..." + ss);
            System.out.println("Waiting for a client...");
            try {
                while (true) {
                    //chờ yêu cầu từ client
                    Socket s = ss.accept();
                    System.out.println("Server accepted: " + s);
                    
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
                        if (sentence_from_client.equalsIgnoreCase("0")) {
                            sentence_to_client = "khong" + '\n';
                        }else if (sentence_from_client.equalsIgnoreCase("1")) {
                            sentence_to_client = "mot" + '\n';
                        }else if (sentence_from_client.equalsIgnoreCase("2")) {
                            sentence_to_client = "hai" + '\n';
                        }else if (sentence_from_client.equalsIgnoreCase("3")) {
                            sentence_to_client = "ba" + '\n';
                        }else if (sentence_from_client.equalsIgnoreCase("4")) {
                            sentence_to_client = "bon" + '\n';
                        }else if (sentence_from_client.equalsIgnoreCase("5")) {
                            sentence_to_client = "nam" + '\n';
                        }else if (sentence_from_client.equalsIgnoreCase("6")) {
                            sentence_to_client = "sau" + '\n';
                        }else if (sentence_from_client.equalsIgnoreCase("7")) {
                            sentence_to_client = "bay" + '\n';
                        }else if (sentence_from_client.equalsIgnoreCase("8")) {
                            sentence_to_client = "tam" + '\n';
                        }else if (sentence_from_client.equalsIgnoreCase("9")) {
                            sentence_to_client = "chin" + '\n';
                        } else {
                            sentence_to_client = "khong phai so nguyen" + '\n';
                        }

                        //ghi dữ liệu ra socket
                        outToClient.writeBytes(sentence_to_client); 

                        //print dữ liệu ra màn hình
                        System.out.println("CLIENT: " + sentence_from_client);
                        System.out.print("FROM TO CLIENT: " + sentence_to_client);
                    }
                }
            } catch (Exception e) {
                System.out.println("Khong ket noi duoc voi client!");
            }
         } catch (Exception e) {
            System.out.println("Khong tao duoc server!");
        } 
    }
}
