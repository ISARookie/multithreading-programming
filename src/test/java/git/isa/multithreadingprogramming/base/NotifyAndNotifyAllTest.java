package git.isa.multithreadingprogramming.base;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/4/23 5:14 PM
 */
public class NotifyAndNotifyAllTest {
    private static volatile Object resourceA = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("threadA get resourceA lock");
                try {
                    System.out.println("theadA begin wait");
                    resourceA.wait();
                    System.out.println("theadA end wait");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread threadB = new Thread(()->{
            synchronized (resourceA) {
                System.out.println("threadB get resourceA lock");
                try {
                    System.out.println("threadB begin wait");
                    resourceA.wait();
                    System.out.println("threadB end wait");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread threadC = new Thread(()->{
            synchronized (resourceA) {
                System.out.println("threadC begin notify");
                resourceA.notifyAll();
            }
        });
        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("OVER");
    }
}
