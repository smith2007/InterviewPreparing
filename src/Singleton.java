import java.util.concurrent.ThreadLocalRandom;

public class Singleton {

    private static Singleton instance;

    private Integer id;

    private Singleton(Integer id) {
        this.id = id;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(ThreadLocalRandom.current().nextInt());
                }
            }

        }
        return instance;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "id=" + id +
                '}';
    }


    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println("First instance is " + instance1);

        System.out.println("Second instance is " + instance2);

    }
}
