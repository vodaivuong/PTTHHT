import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccountImp extends UnicastRemoteObject implements AccountItf{
    // Khoi tao gia tri trong Account
    String Name;
    String Num;
    double Balance;

    // Khoi tao doi tuong Account 
    protected AccountImp() throws RemoteException {
        super();
    }
    protected AccountImp(String name, String num, double balance) throws RemoteException{
        this.Name = name;
        this.Num = num;
        this.Balance = balance;
    }

    public void nhapThongTin(String name, String num, double balance){
        this.setName(name);
        this.setNum(num);
        this.setBalance(balance);
    }

    // Khoi tao phuong thuc get-set gia tri
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return Name;
    }
    public void setNum(String num) {
        this.Num = num;
    }
    public String getNum() {
        return Num;
    }
    public void setBalance(double balance) {
        this.Balance = balance;
    }
    public double getBalance() {
        return Balance;
    }

    // Khoi tao cac xu ly cua Account
    public double withDraw(double tienRut) {
        Balance = Balance - tienRut; 
        return Balance;
    }

    @Override
    public String inManHinh() throws RemoteException {
        return "Ten TK: " + Name + "\nSTK: " + Num + "\nSo tien hien co: " + Balance;
    }

    // 
    // public void inManHinh() {
    //     System.out.println("Tai khoan cua ban: ");
    //     System.out.println("Ten TK: " + Name);
    //     System.out.println("STK: " + Num);
    //     System.out.println("Tien hien co: " + Balance);
    // }
}
