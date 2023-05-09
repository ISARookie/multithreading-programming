package git.isa.multithreadingprogramming.advanced;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/5/9 6:14 PM
 */
public class RandomTest {
    public static void main(String[] args) {
//        Random random = new Random();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
