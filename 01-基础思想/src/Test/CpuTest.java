package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CpuTest {
        private static ExecutorService executorService = Executors.newFixedThreadPool(5);

        public static void main(String[] args) {
            Task taskl = new Task();
            Task task2 = new Task();
            executorService.execute(taskl);
            executorService.execute(task2);
        }

        public static Object lock = new Object();

        static class Task implements Runnable {
            public void run() {
                synchronized (lock) {
                    long sum = 0L;
                    while (true) {
                        sum += 1;
                    }
                }
            }
        }
    }