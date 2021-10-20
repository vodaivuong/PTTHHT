package tinhToan;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        int yeuCau;
        int ketQua = 0;
        int n;
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Server created...");

            try {
                while (true) {
                    Socket socket = ss.accept();
                    System.out.println("Server accepted " + socket);

                    while (true) {
                        // Khoi tao nhap xuat socket
                        DataInputStream in = 
                            new DataInputStream(socket.getInputStream());
                        DataOutputStream out = 
                            new DataOutputStream(socket.getOutputStream());

                        // Doc yeu cau tu client
                        yeuCau = in.readInt();
                        if (yeuCau == 4) { // Neu nhap 4 thi thoat khoi socket
                            break;
                        }
                        n = in.readInt();
                        
                        // Xu ly yeu cau tinh toan
                        switch (yeuCau) {
                            case 1:
                                for (int i = 0; i < n; i++) {
                                    ketQua += 2*i + 1;
                                }
                                break;
                            case 2:
                                for (int i = 0; i < n; i++) {
                                    ketQua += i*(i + 1);
                                }
                                break;
                            case 3:
                                ketQua = -n;
                                break;
                            default:
                                break;
                        }

                        // Gui ket qua den socket
                        out.writeInt(ketQua);
        
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
