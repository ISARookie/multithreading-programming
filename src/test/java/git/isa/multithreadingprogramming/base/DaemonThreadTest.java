package git.isa.multithreadingprogramming.base;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/4/24 6:09 PM
 */
public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(()-> {
            for (; ; ) {
            }
        });
//        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over");
    }
}
