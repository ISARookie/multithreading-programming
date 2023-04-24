package git.isa.multithreadingprogramming.base;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/4/24 4:25 PM
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(()->{
            // 未被中断不进入循环  isInterrupted(boolean ClearInterrupted) 中断将清楚中断标识之后获取依旧是false
            while (!Thread.interrupted()) {
            }
            System.out.println("threadOne isInterrupted:" + Thread.currentThread().isInterrupted());
        });
        threadOne.start();
        threadOne.interrupt();
        threadOne.join();
        System.out.println("OVER");
    }
}
