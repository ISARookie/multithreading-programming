package git.isa.multithreadingprogramming.base;

/**
 * @author cx
 * @version 1.0
 * @description:
 * @date 2023/5/4 10:50 AM
 */
public class ThreadLocalTest {
    static void print(String str) {
        System.out.println(str + ":" + localVariable.get());

//        localVariable.remove();
    }

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            localVariable.set("threadOne local variable");

            print("threadOne");

            System.out.println("threadOne remove after" + ":" + localVariable.get());
        });

        Thread threadTwo = new Thread(() -> {
            localVariable.set("threadTwo local variable");

            print("threadTwo");

            System.out.println("threadTwo remove after" + ":" + localVariable.get());
        });

        threadOne.start();
        threadTwo.start();
    }

}
