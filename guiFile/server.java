package guiFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
  public static void main(String[] args) {
    // ServerSocket serverSocket = new ServerSocket(8888);
    // File myFile = new File("s.pdf");
    // while (true) {
    // Socket socket = serverSocket.accept();
    // byte[] mybytearray = new byte[(int) myFile.length()];
    // BufferedInputStream bis = new BufferedInputStream(new
    // FileInputStream(myFile));
    // bis.read(mybytearray, 0, mybytearray.length);
    // OutputStream os = socket.getOutputStream();
    // os.write(mybytearray, 0, mybytearray.length);
    // os.flush();
    // bis.close();
    // socket.close();
    // }

    try {
      ServerSocket serverSocket = new ServerSocket(8888);
      System.out.println("Server created...");

      try {
        while (true) {
          Socket socket = serverSocket.accept();
          System.out.println("Accepted " + socket);

          while (true) {
              // Nhan thong tin file muon truyen di tu client
              DataInputStream in = 
                new DataInputStream(socket.getInputStream());
              DataOutputStream out = 
                new DataOutputStream(socket.getOutputStream());

              // Tao mang chua du lieu file gui den
              byte[] mybytearray = new byte[in.readByte()];

              while (in.read(mybytearray) > 0) { // Neu file co du lieu thi moi duoc nhan
                
                System.out.println("Da nhan yeu cau gui file tu client");
                
                // Nhap duong dan chua file tu client gui den
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhan duong dan luu file");
                String sendTo = sc.nextLine();

                // Tao xuat du lieu ra duong dan server cung cap
                FileOutputStream fos = new FileOutputStream(sendTo);
                // BufferedOutputStream bos = new BufferedOutputStream(fos);
                
                // Ghi file vao duong dan server cung cap
                fos.write(mybytearray, 0, mybytearray.length);

                // Thong bao cho client biet sevrer da nhan duoc file
                out.writeUTF("File da gui thanh cong" + "\n");
                System.out.println("Da nhan duoc file");

                // Dong cac luong
                sc.close();
                fos.close();
            }
          }
        }
      } catch (Exception e) {
        System.out.println("Khong ket noi duoc client!");
      }
    } catch (Exception e) {
      System.out.println("Khong tao duoc server!");
    }

  }
}
