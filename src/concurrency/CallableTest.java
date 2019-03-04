package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws Exception {

        Callable<Integer> myCallable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Callable called");
                Thread.sleep(4 * 1000);
                return 1991;
            }
        };

        FutureTask<Integer> fututre = new FutureTask<>(myCallable);
        fututre.run(); // так запускаем поток

        System.out.println("blablabla");
        System.out.println(fututre.get()); // эта штука блокируящая
    }
}
