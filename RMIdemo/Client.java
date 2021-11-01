import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry(7777);
            AccountItf aItf = (AccountItf) reg.lookup("Account1");
            // AccountItf aItf = (AccountItf) Naming.lookup("rmi://localhost:6666/Account1");

            
            // // System.out.println("So tien sau khi rut la: " + aItf.withDraw(10000));
            aItf.nhapThongTin("Vuong", "072201001458", 100000);
            System.out.println("Tai khoan cua ban: \n" + aItf.inManHinh());

            double tienRut;
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap so tien muon rut: ");
            tienRut = sc.nextDouble();
            System.out.println("So tien sau khi rut " + aItf.withDraw(tienRut));

            sc.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
