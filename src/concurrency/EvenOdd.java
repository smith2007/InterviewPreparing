package concurrency;


import java.util.concurrent.Semaphore;

public class EvenOdd {

  private final static String ODD = "ODD";
  private final static String EVEN = "EVEN";
  private final static int MAX_ITERATIONS = 10;

  static class EvenOddThread implements Runnable {

    private String mType;
    private int mNum;
    private Semaphore mMySema;
    private Semaphore mOtherSema;

    public EvenOddThread(String str, Semaphore mine, Semaphore other) {
      mType = str;
      mMySema = mine;//new Semaphore(1); // start out as unlocked
      mOtherSema = other;//new Semaphore(0);
      if (str.equals(ODD)) {
        mNum = 1;
      } else {
        mNum = 2;
      }
    }

    @Override
    public void run() {

      for (int i = 0; i < MAX_ITERATIONS; i++) {
        mMySema.acquireUninterruptibly();
        if (mType.equals(ODD)) {
          System.out.println("Odd Thread - " + mNum);
        } else {
          System.out.println("Even Thread - " + mNum);
        }
        mNum += 2;
        mOtherSema.release();
      }
    }

  }

  public static void main(String[] args) throws InterruptedException {
    Semaphore odd = new Semaphore(1);
    Semaphore even = new Semaphore(0);

    System.out.println("Start!!!");
    System.out.println();

    Thread tOdd = new Thread(new EvenOddThread(ODD,
        odd,
        even));
    Thread tEven = new Thread(new EvenOddThread(EVEN,
        even,
        odd));

    tOdd.start();
    tEven.start();

    tOdd.join();
    tEven.join();

    System.out.println();
    System.out.println("Done!!!");
  }
}