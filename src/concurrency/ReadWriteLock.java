package concurrency;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLock {

  //все потоки для чтения будем класть в мапу
  private Map<Thread, Integer> readingThreads = new HashMap<>();

  private int writeAccesses = 0;
  private int writeRequests = 0;

  //так же будем учитывать поток для чтения
  //потому что только он имеет эксклюзивную блокировку на это
  private Thread writingThread = null;


  public synchronized void lockRead() throws InterruptedException {
    Thread callingThread = Thread.currentThread();
    while (!canGrantReadAccess(callingThread)) {
      wait();
    }
    readingThreads.put(callingThread, (getReadAccessCount(callingThread) + 1));
  }

  //проверяем можем ли мы дать акцесс на чтение
  private boolean canGrantReadAccess(Thread callingThread) {
    if (isWriter(callingThread)) {
      return true; // если он же писатель и просит блокировку на чтение - дай
    }
    if (hasWriter()) {
      return false; //если кто-то пишет не даем
    }
    if (isReader(callingThread)) { // если этот чувак уже имеет блокировку на чтение - пускай снова
      return true;
    }
    if (hasWriteRequests()) { // если есть ожидающие потоки на запись, не давай
      return false;
    }
    return true;
  }


  public synchronized void unlockRead() {
    Thread callingThread = Thread.currentThread();
    if (!isReader(callingThread)) { // если он не брал блокировку - разблокировать нечего
      throw new IllegalMonitorStateException("Calling Thread does not" +
          " hold a read lock on this ReadWriteLock ");
    }
    // смотрим - сколько раз этот чувак просил блокировку на чтение
    int accessCount = getReadAccessCount(callingThread);
    if (accessCount == 1) {
      //если один раз - надо удалять его из мапы
      readingThreads.remove(callingThread);
    } else {
      //если много раз, просто декремент
      readingThreads.put(callingThread, accessCount - 1);
    }
    //пошли сигнал всем кто завис на wait()
    notifyAll();
  }

  public synchronized void lockWrite() throws InterruptedException {
    //инкремент счетчика запросов на write
    writeRequests++;
    Thread callingThread = Thread.currentThread();
    //можно ли давать ему доступ на запись?
    while (!canGrantWriteAccess(callingThread)) {
      wait();
    }
    writeRequests--;
    writeAccesses++;
    writingThread = callingThread;
  }

  public synchronized void unlockWrite() throws InterruptedException {
    if (!isWriter(Thread.currentThread())){
      throw new IllegalMonitorStateException("Calling Thread does not" +
          " hold the write lock on this ReadWriteLock ");
    }
    writeAccesses--;
    if (writeAccesses == 0) {
      writingThread = null;
    }
    notifyAll();
  }

  private boolean canGrantWriteAccess(Thread callingThread) {
    //если он один читатель, и он один захватил эту блокировку
    if (isOnlyReader(callingThread)) {
      return true;
    }
    //если есть другие читатели - шлем нахер
    if (hasReaders()) {
      return false;
    }
    //если никто не занял еще блокировку на запись
    if (writingThread == null) {
      return true;
    }
    //если он же и есть писатель, он же ее и занял
    if (!isWriter(callingThread)) {
      return false;
    }
    return true;
  }


  private int getReadAccessCount(Thread callingThread) {
    Integer accessCount = readingThreads.get(callingThread);
    if (accessCount == null) {
      return 0;
    }
    return accessCount;
  }


  private boolean hasReaders() {
    return readingThreads.size() > 0;
  }

  private boolean isReader(Thread callingThread) {
    return readingThreads.get(callingThread) != null;
  }

  private boolean isOnlyReader(Thread callingThread) {
    return readingThreads.size() == 1 &&
        readingThreads.get(callingThread) != null;
  }

  private boolean hasWriter() {
    return writingThread != null;
  }

  private boolean isWriter(Thread callingThread) {
    return writingThread == callingThread;
  }

  private boolean hasWriteRequests() {
    return this.writeRequests > 0;
  }

}
