import java.net.ServerSocket;
import java.net.Socket;

public class TCPforSeverDual {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8081);
            System.out.println("Server phuc vu song song");
            while (true) {
                try {
                    Socket s = ss.accept();

                    Processing p = new Processing(s);
                    p.start();
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
