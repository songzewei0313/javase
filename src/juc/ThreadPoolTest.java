package juc;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author szw
 * @date 2022/4/12 11:27
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                3,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Up up = new Up();
        up.setJsonArray(3);
        Down down = new Down();
        down.setJsonArray(13);
        try {
            poolExecutor.execute(up);
            poolExecutor.execute(down);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }
    }

    static class Up implements Runnable {
        private int i;

        public void setJsonArray(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            i*=3;
            System.out.println(Thread.currentThread().getName() + "===" + i);
        }
    }

    static class Down implements Runnable {
        private int i;

        public void setJsonArray(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "===" + i);
        }
    }
}
