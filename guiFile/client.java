package guiFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
  public static void main(String[] argv) {
    // Socket sock = new Socket("127.0.0.1", 123456);
    // byte[] mybytearray = new byte[1024];
    // InputStream is = sock.getInputStream();
    // FileOutputStream fos = new FileOutputStream("s.pdf");
    // BufferedOutputStream bos = new BufferedOutputStream(fos);
    // int bytesRead = is.read(mybytearray, 0, mybytearray.length);
    // bos.write(mybytearray, 0, bytesRead);
    // bos.close();
    // sock.close();

    String myFile;
    try {
      Socket socket = new Socket("localhost", 8888);
      System.out.println("Client created...");

      try {
        while (true) {
          DataInputStream in = 
            new DataInputStream(socket.getInputStream());
          DataOutputStream out = 
            new DataOutputStream(socket.getOutputStream());

          // Nhap ten file can gui di server
          Scanner sc = new Scanner(System.in);
          System.out.println("Nhan duong dan file can gui:");
          myFile = sc.nextLine();
          
          byte[] mybytearray = new byte[(int) myFile.length()];
          BufferedInputStream bis = 
            new BufferedInputStream(new FileInputStream(myFile));
          if (bis.read(mybytearray) > 0) {
            OutputStream os = socket.getOutputStream();
            os.write(mybytearray, 0, mybytearray.length);
            os.flush();
            System.out.println("Gui file...");
          }
          System.out.println(in.readUTF());
        }
      } catch (Exception e) {
        System.out.println("Khong ket noi duoc server!");
      }
    } catch (Exception e) {
      System.out.println("Khong tao duoc client!");
    }
    
  }
}
