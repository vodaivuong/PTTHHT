package javaSocketTCP2.chatBox;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Processing extends Thread {
    Socket s;

    Processing(Socket s){
        this.s = s;
    }

    public void run() {
        try {
            String from_client;
            String to_client;
            //Tạo input stream, nối tới Socket
            BufferedReader inFromClient =
            new BufferedReader(new
                InputStreamReader(s.getInputStream())); 
        
            //Tạo outputStream, nối tới socket
            DataOutputStream outToClient =
                new DataOutputStream(s.getOutputStream());

            while (true) {
                //Doc du lieu gui tu client
                from_client = inFromClient.readLine();
                
                // print dữ liệu ra màn hình
                System.out.println("CLIENT: " + from_client);

                //Tạo Inputstream(từ bàn phím)
                System.out.print("Input from server: ");
                BufferedReader inFromServer =
                    new BufferedReader(new InputStreamReader(System.in));
                to_client = inFromServer.readLine();

                outToClient.writeBytes(to_client + '\n');
            }
        } catch (IOException e) {
            System.out.println("Khong ket noi duoc voi client!");
        }
    }
}
