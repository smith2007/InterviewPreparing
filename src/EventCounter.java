import java.util.concurrent.atomic.AtomicInteger;

public class EventCounter {


  private AtomicInteger eventsCounter = new AtomicInteger(0);
  private int timeCounter;
  private boolean active;

  public EventCounter(int timeInSeconds) {
    timeCounter = timeInSeconds;
    active = true;
  }

  // Call this method whenever an interesting event occurs
  public int add() {
    if (active) {
      int current;
      do {
        current = eventsCounter.get();
      } while (eventsCounter.compareAndSet(current, current + 1));

      return current + 1;
    } else {
      return -1;
    }
  }

  // Get current number of events
  public int getCount() {
    return eventsCounter.get();
  }

  // Start the FrequencyCounter
  public void run() {
    Thread timer = new Thread(() -> {
      while (timeCounter > 0) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        timeCounter--;
      }
      active = false;
    });
    timer.start();
  }

}
