package git.isa.multithreadingprogramming.base;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/5/4 3:56 PM
 */
public class UnSafeTest {
    static final Unsafe unsafe;
    // 偏移量
    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
//            unsafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("state"));

            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            // state 在UnsafeTest中的偏移量
            stateOffset = unsafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        UnSafeTest test = new UnSafeTest();
        boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
