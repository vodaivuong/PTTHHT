// Ví dụ về thread trong java bởi extends lớp Thread
// public class MultiThread extends Thread{
//     public void run() {
//         System.out.println("Luong dang chay...");
//     }
//     public static void main(String[] args) {
//         MultiThread mt1 = new MultiThread();
//         mt1.start();
//     }
// }

// Ví dụ về thread trong java bởi extends Runnable interface
public class MultiThread implements Runnable{
    public void run() {
        System.out.println("Luong dang chay...");
    }
    public static void main(String[] args) {
        MultiThread mt1 = new MultiThread();
        Thread t1 = new Thread(mt1);
        t1.start();
    }
}
