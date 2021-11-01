import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * HelloInteface
 */
public interface AccountItf extends Remote{
    public void nhapThongTin(String name, String num, double balance) throws RemoteException;
    public double withDraw(double rutTien)  throws RemoteException;
    public String inManHinh() throws RemoteException;
}