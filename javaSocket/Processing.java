import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Processing extends Thread{
    Socket s;

    Processing(Socket s){
        this.s = s;
    }

    public void run() {
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            while (true) {
                int ch = is.read();

                // Neu ky tu doc khong dung thi dung
                if (ch == -1)
                    break;
                System.out.println((char) ch);
                os.write(ch);
            }
            System.out.println("Da nhan du lieu");
            System.out.println("San sang nhan du lieu");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
