package git.isa.multithreadingprogramming.base;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/4/24 5:34 PM
 */
public class DeadLockTest {
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread() + "get ResourceA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread() + "waiting get resourceB");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + "get resourceB");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread() + "get ResourceB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread() + "waiting get resourceA");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + "get resourceA");
                }
            }
        });

        threadA.start();
        threadB.start();
    }

}
