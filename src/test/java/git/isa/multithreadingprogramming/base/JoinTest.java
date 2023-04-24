package git.isa.multithreadingprogramming.base;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/4/24 11:04 AM
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("child threadOne over!");
        });
        Thread threadTwo = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("child threadTwo over!");
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");

        threadOne.join();
        threadTwo.join();
    }
}
