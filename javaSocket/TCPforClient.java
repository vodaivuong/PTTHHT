import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPforClient {
    public static void main(String[] args) {
        try {
            // Khoi tao socket
            Socket s = new Socket("127.0.0.1", 8081);
            System.out.println("Client da duoc tao...");

            // Khoi tao phuong thuc nhap xuat
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            // Gui du lieu cho sever
            for (int i = '0'; i < '9'; i++) {
                os.write(i);

                // Doc du lieu ra man hinh
                int ch = is.read();
                System.out.println((char) ch);
                Thread.sleep(2000);
            }
            System.out.println("Da gui xong du lieu");
            // Dung socket neu khong con du lieu nua
            if(s != null){
                s.close();
            }

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}