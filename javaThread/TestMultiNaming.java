public class TestMultiNaming extends Thread{
    public void run() {
        System.out.println("Running...");
    }
    public static void main(String[] args) {
        TestMultiNaming t1 = new TestMultiNaming();
        TestMultiNaming t2 = new TestMultiNaming();
        System.out.println("Name of t1: " + t1.getName());
        System.out.println("Name of t2: " + t2.getName());

        t1.start();
        t2.start();

        t1.setName("Auto Find Image");
        System.out.println("After changing name of t1: " + t1.getName());
    }

    // public void run() {
    //     System.out.println(Thread.currentThread().getName());
    // }
    // public static void main(String[] args) {
    //     TestMultiNaming t1 = new TestMultiNaming();
    //     TestMultiNaming t2 = new TestMultiNaming();

    //     t1.start();
    //     t2.start();
    // }
}
