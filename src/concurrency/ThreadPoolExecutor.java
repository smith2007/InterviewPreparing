package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutor {

    private BlockingQueue<Runnable> runnablesQueue;
    private List<Worker> workers = new ArrayList<>();

    //у нашего ThreadPoolExecutor есть состояние, как только создали - оно TRUE
    //воркеры созданы и работают
    //но вот когда false - то воркеров надо остановить
    private boolean isStopped = false;

    /**
     * еще раз блять!!
     *
     * у нас очередь из RUNNABLE - эту очередь как фуры на складе разгребают
     * грузчики - они же Worker - грузчиков ограниченное кол-во
     * если их всех не хватает - очередь будет расти!
     *
     * у воркеров и у экзекутора есть состояние - для этого флаг isStopped
     */
    public ThreadPoolExecutor(int numberOfThreads, int maxNoOfTasks) {
        runnablesQueue = new ArrayBlockingQueue<>(maxNoOfTasks);
        for (int i = 0; i < numberOfThreads; i++) {
            workers.add(new Worker(runnablesQueue));
        }
        //запускаем воркеров
        for (Worker worker : workers) {
            worker.start();
        }
    }

    /**
     * метод execute, он принимает новую таску - RUNNABLE
     * и добавляет в очередь - в очереди воркеры - разгребают
     */
    public synchronized void execute(Runnable task) {
        if (this.isStopped){ //сперва проверим то что наш тред пул не остановлен
            throw new IllegalStateException("ThreadPool is stopped");
        }

        this.runnablesQueue.add(task); // происходит добавление в очередь
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

        //воркеру обязательно нужна очередь - он ее будет разгребать
        private BlockingQueue<Runnable> taskQueue;
        private boolean isStopped = false;

        Worker(BlockingQueue<Runnable> queue) {
            taskQueue = queue;
        }

        public void run() {
            //крутимся в бесконечном цикле пока нас не остановят
            while (!isStopped()) {
                try {
                    //и разгребаем очередь, если очередь пустая ждем 24 часа
                    Runnable runnable = taskQueue.poll(24, TimeUnit.HOURS);
                    //взяли поток - запустили его
                    runnable.run();
                } catch (Exception e) {
                    //log or otherwise report exception,
                    //but keep pool thread alive.
                }
            }
        }

        //у самого воркера тоже есть состояние, и мы должны это предусмотреть
        synchronized void doStop() {
            isStopped = true;
            this.interrupt(); //break pool thread out of dequeue() call.
        }

        synchronized boolean isStopped() {
            return isStopped;
        }
    }
}
