public class TestSleep extends Thread{
    // Truong hop su dung Sleep
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Luong dang chay " + i);
        }
    }

    // Truong hop khong su dung khong Sleep
    // public void run() {
    //     for (int i = 0; i < 5; i++) {
    //         System.out.println("Luong dang chay " + i);
    //     }
    // }
    public static void main(String[] args) {
        TestSleep t1 = new TestSleep();
        TestSleep t2 = new TestSleep();

        t1.start();
        t2.start();
    }
}
