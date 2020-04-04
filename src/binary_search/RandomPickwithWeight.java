package binary_search;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickwithWeight {

    public static void main(String[] args) {
        int[] w = {1, 99, 99};

        RandomPickwithWeight ins = new RandomPickwithWeight(w);
        for (int i = 0; i < 1000; i++) {
            System.out.println(ins.pickIndex());

        }
    }

    private int cnt = 0;
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    private Random rnd = new Random();

    public RandomPickwithWeight(int[] w) {
        for (int idx = 0; idx < w.length; idx++) {
            cnt += w[idx];
            map.put(cnt, idx);
        }
    }

    public int pickIndex() {
        int cnnnt = rnd.nextInt(cnt);
        //выдай ключи которые выше! этого числа
        int key = map.higherKey(cnnnt);
        //если ключа с таким номером нет, выдается первый по порядку по возрастанию
        return map.get(key);
    }
}
