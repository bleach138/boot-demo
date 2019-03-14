package netty;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by hjhuang on 2018/6/14.
 */
public class TestFuture {

    @Test
    public void test()  throws Exception{
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(" task1 ");
            }
        };

        Callable<Integer> task2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(" task2 ");
                return  new Integer(100);
            }
        };

        Future<?> f1 = executor.submit(task1);
        Future<Integer> f2 = executor.submit(task2);


        while (f1.isDone()) {
            System.out.println("f1 done");
            break;
        }

//        while (true) {
////            System.out.println("f1@@@@:" + f1.isDone());
//            if (f1.isDone()) {
//                System.out.println("f1 done");
//                break;
//            }
//        }

        System.out.println("Future:1 done");

        while (true) {
            if (f2.isDone()) {
                System.out.println("f2 " + f2.get());
                break;
            }
        }
    }
}
