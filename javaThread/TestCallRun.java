public class TestCallRun extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Luong dang chay " + i);
        }
    }
    public static void main(String[] args) {
        TestCallRun t1 = new TestCallRun();
        TestCallRun t2 = new TestCallRun();

        t1.start();
        t2.start();
    }
}
