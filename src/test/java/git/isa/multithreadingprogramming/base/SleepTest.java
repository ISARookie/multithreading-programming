package git.isa.multithreadingprogramming.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/4/24 11:41 AM
 */
public class SleepTest {
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        Thread threadA = new Thread(()->{
            lock.lock();
            try {
                System.out.println("child threadA is in sleep");
                Thread.sleep(10000);
                System.out.println("child threadA is in awakened");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });
        Thread threadB = new Thread(()->{
            lock.lock();
            try {
                System.out.println("child threadB is in sleep");
                Thread.sleep(10000);
                System.out.println("child threadB is in awakened");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        threadA.start();
        threadB.start();
    }
}
