package classJava;

public class PhanSo {
    private int tu, mau;

    //Khoi tao doi tuong
    public PhanSo(int tu, int mau) {
        super();
        this.tu = tu;
        this.mau = mau;
    }
     
     public int getTu() {
        return tu;
    }
 
    public void setTu(int tu) {
        this.tu = tu;
    }
 
    public int getMau() {
        return mau;
    }
 
    public void setMau(int mau) {
        this.mau = mau;
    }

    //In ra man hinh
    void inManHinh(){
        System.out.println(getTu() + "/" + getMau());
    }

    //Nghich dao phan so
    void nghichDao(){
        
    }
    
    public int timUSCLN(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
    //Toi gian phan so
    public void toiGianPhanSo() {
        int i = timUSCLN(this.getTu(), this.getMau());
        this.setTu(this.getTu() / i);
        this.setMau(this.getMau() / i);
    }
    //Tra ve gia tri thuc cua phan so
    // public double giaTRiThuc(){
    //     PhanSo x;
    //     double gt;
    //     gt = x.tu / x.mau;
    //     return gt;
    // }

    //Cong 2 phan so
    public void congPhanSo(PhanSo ps) {
        int ts = this.getTu() * ps.getMau() + ps.getTu() * this.getMau();
        int ms = this.getMau() * ps.getMau();
        PhanSo phanSoTong = new PhanSo(ts, ms);
        phanSoTong.toiGianPhanSo();
        System.out.println("Tong 2 phan so = " + phanSoTong.tu + "/" + phanSoTong.mau);
    }
    //Tru 2 phan so
    public void truPhanSo(PhanSo ps) {
        int ts = this.getTu() * ps.getMau() - ps.getTu() * this.getMau();
        int ms = this.getMau() * ps.getMau();
        PhanSo phanSoHieu = new PhanSo(ts, ms);
        phanSoHieu.toiGianPhanSo();
        System.out.println("Hieu 2 phan so = " + phanSoHieu.tu + "/" + phanSoHieu.mau);
    }
    //Nhan 2 phan so
    public void nhanPhanSo(PhanSo ps) {
        int ts = this.getTu() * ps.getTu();
        int ms = this.getMau() * ps.getMau();
        PhanSo phanSoTich = new PhanSo(ts, ms);
        phanSoTich.toiGianPhanSo();
        System.out.println("Tich 2 phan so = " + phanSoTich.tu + "/" + phanSoTich.mau);
    }
    //Chia 2 phan so
    public void chiaPhanSo(PhanSo ps) {
        int ts = this.getTu() * ps.getMau();
        int ms = this.getMau() * ps.getTu();
        PhanSo phanSoThuong = new PhanSo(ts, ms);
        phanSoThuong.toiGianPhanSo();
        System.out.println("Thuong 2 phan so = " + phanSoThuong.tu + "/" + phanSoThuong.mau);
    }

    public static void main(String[] args) {
        PhanSo ps1 = new PhanSo(3,9);
        PhanSo ps2 = new PhanSo(2,8);

        //Toi gian phan so
        ps1.toiGianPhanSo();
        ps2.toiGianPhanSo();
        System.out.println("Phan so toi gian: ");
        //In man hinh
        ps1.inManHinh();
        ps2.inManHinh();

        //Gia tri thuc cua phan so
        // System.out.println("Gia tri thuc cua ps1 = " + ps1.giaTRiThuc());
        // System.out.println("Gia tri thuc cua ps1 = " + ps2.giaTRiThuc());

        // Cong tru nhan chia 2 phan so
        ps1.congPhanSo(ps2);
        ps1.truPhanSo(ps2);
        ps1.nhanPhanSo(ps2);
        ps1.chiaPhanSo(ps2);

        //
        // ps1.nghichDao();
        // System.out.println("Phan so sau khi nghich dao: ");
        // ps1.inManHinh();
    }
}
