package git.isa.multithreadingprogramming.advanced;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/5/10 11:19 AM
 */
public class Atomic {
    private static AtomicLong atomicLong = new AtomicLong();

    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arrayTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(()->{
            int size = arrayOne.length;
            for (int i = 0; i < size; ++i) {
                if (arrayOne[i] == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });

        Thread threadTwo = new Thread(()->{
            int size = arrayTwo.length;
            for (int i = 0; i < size; ++i) {
                if (arrayTwo[i] == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("count 0:" + atomicLong.get());

    }

}
