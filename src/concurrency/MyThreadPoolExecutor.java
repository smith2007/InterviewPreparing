package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor {


    private BlockingQueue<Runnable> queue;
    private List<Worker> workers = new ArrayList<>();
    private boolean isStopped = false;

    public MyThreadPoolExecutor(int noOfThreads, int maxNoOfTasks) {

        queue = new ArrayBlockingQueue<>(maxNoOfTasks);

        for (int i = 0; i < noOfThreads; i++) {
            workers.add(new Worker(queue));
        }
        for (Worker worker : workers) {
            worker.start();
        }
    }

    /**
     * метод execute, он принимает новую таску в качестве раннбл
     * и добавляет в очередь
     */
    public synchronized void execute(Runnable task) {
        if (this.isStopped){ //сперва проверим то что наш тред пул не остановлен
            throw new IllegalStateException("ThreadPool is stopped");
        }

        this.queue.add(task); // происходит добавление в очередь
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (Worker worker : workers) {
            worker.doStop();
        }
    }

    /**
     * наш кастомный тред - он же воркер, он будет предварительно создан и разгребать очередь
     * из раннблов
     */
    static class Worker extends Thread {

        private BlockingQueue taskQueue;
        private boolean isStopped = false;

        Worker(BlockingQueue queue) {
            taskQueue = queue;
        }

        public void run() {

            //крутимся в бесконечном цикле пока нас не остановят
            while (!isStopped()) {
                try {
                    //и разгребаем очередь, если очередь пустая ждем 24 часа
                    Runnable runnable = (Runnable) taskQueue.poll(24, TimeUnit.HOURS);
                    runnable.run();
                } catch (Exception e) {
                    //log or otherwise report exception,
                    //but keep pool thread alive.
                }
            }
        }

        synchronized void doStop() {
            isStopped = true;
            this.interrupt(); //break pool thread out of dequeue() call.
        }

        synchronized boolean isStopped() {
            return isStopped;
        }
    }
}
