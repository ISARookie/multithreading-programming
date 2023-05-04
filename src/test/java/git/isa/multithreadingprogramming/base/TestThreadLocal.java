package git.isa.multithreadingprogramming.base;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/5/4 11:22 AM
 */
public class TestThreadLocal {
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello world");
        Thread thread = new Thread(()-> System.out.println("thread:" + threadLocal.get()));
        thread.start();

        System.out.println("main:" + threadLocal.get());
    }
}
