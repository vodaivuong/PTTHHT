package chatBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        String msg;
        try {
            ServerSocket serverSocket = new ServerSocket(8810);
            System.out.println("Server created...");

            try {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted client..." + socket);

                while (true) {
                    DataInputStream in = 
                        new DataInputStream(socket.getInputStream());

                    DataOutputStream out = 
                        new DataOutputStream(socket.getOutputStream());

                    while (true) {
                        msg = in.readUTF();
                        if (msg.equalsIgnoreCase("exit")) {
                            socket.close();
                            break;
                        }
                        System.out.println("Client: " + msg);
                    }  
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
