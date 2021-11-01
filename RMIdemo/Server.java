import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        
        try {
            // AccountItf aItf = new AccountImp();
            // System.out.println("Khoi tao doi tuong Account Imp....");

            // Naming.rebind("rmi://localhost:6666/Account1", aItf);
            // System.out.println("Accoount1 da duoc dang ky");

            AccountItf aItf = new AccountImp();
            System.out.println("Khoi tao IMPL");
            LocateRegistry.createRegistry(7777);
            Registry reg = LocateRegistry.getRegistry(7777);
            reg.bind("Account1", aItf);
            System.out.println("Acc Registed");

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
