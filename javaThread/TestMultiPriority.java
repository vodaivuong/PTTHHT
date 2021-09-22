public class TestMultiPriority extends Thread{
    public void run() {
        System.out.println("Running thread name is: " + Thread.currentThread().getName());
        System.out.println("Running thread priority is: " + Thread.currentThread().getPriority());
    }
    public static void main(String[] args) {
        TestMultiPriority t1 = new TestMultiPriority();
        TestMultiPriority t2 = new TestMultiPriority();

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
