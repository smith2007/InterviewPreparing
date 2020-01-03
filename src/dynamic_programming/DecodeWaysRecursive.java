package dynamic_programming;

import java.util.Arrays;

public class DecodeWaysRecursive {

    public static void main(String[] args) {
        String str = "11111";

        System.out.println(getAll(str));
    }


    static int getAll(String str) {
        int[] mem = new int[str.length() + 1];
        Arrays.fill(mem, -1);
        return decode(str, 0, mem);
    }

    static int decode(String m, int i, int[] mem) {

        if (i == m.length()) {
            return 1;
        }

        int ch = m.charAt(i) - '0';

        if (ch == 0) {
            return 0;
        }

        if (mem[i] != -1) {
            return mem[i];
        }

        int result = decode(m, i + 1, mem);

        if (i < m.length() - 1 && (ch * 10 + (m.charAt(i + 1) - '0')) < 27) {
            result += decode(m, i + 2, mem);
        }
        mem[i] = result;
        return result;
    }

}
