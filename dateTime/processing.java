package dateTime;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class processing extends Thread{
    String ketQua;
    int yeuCau;
    Socket socket;

    processing(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                // Khoi tao nhap xuat socket
                DataInputStream in = 
                    new DataInputStream(socket.getInputStream());
                DataOutputStream out = 
                    new DataOutputStream(socket.getOutputStream());
                // Doc yeu cau tu client
                yeuCau = in.readInt();
                System.out.println("Da nhan yeu cau " + yeuCau);

                Date date = new Date();

                // Xu ly yeu cau tinh toan
                switch (yeuCau) {
                    case 1:
                        SimpleDateFormat dft = new SimpleDateFormat("HH:mm:ss");
                        ketQua = dft.format(date);
                        break;
                    case 2:
                        SimpleDateFormat dfd = new SimpleDateFormat("E dd/MM/yyyy");
                        ketQua = dfd.format(date);
                        break;
                    case 3:
                        SimpleDateFormat df = new SimpleDateFormat("E dd/MM/yyyy 'at' HH:mm:ss");
                        ketQua = df.format(date);
                        break;
                    default:
                        break;
                }
                System.out.println("Da xu ly va gui ket qua");

                // Gui yeu cau den socket
                out.writeUTF(ketQua);
            }  
        } catch (Exception e) {
            System.out.println("Khong co ket noi voi client!");
        }
    } 
}
