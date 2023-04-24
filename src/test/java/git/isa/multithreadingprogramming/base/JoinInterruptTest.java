package git.isa.multithreadingprogramming.base;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/4/24 11:25 AM
 */
public class JoinInterruptTest {
    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            System.out.println("threadOne begin run!");
            for (; ; ) {

            }
        });
        final Thread mainThread = Thread.currentThread();

        Thread threadTwo = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mainThread.interrupt();
        });

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread:" + e);
        }
    }
}
