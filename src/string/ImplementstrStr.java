package string;

public class ImplementstrStr {

    public static void main(String[] args) {

        System.out.println(strStr("ababcaababcaabc", "ababcaabc"));
    }

    static int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLenght = haystack.length();

        if (needleLength > haystackLenght){
            return -1;
        }

        // base value for the rolling hash function
        int a = 26;

        // modulus value for the rolling hash function to avoid overflow
        long pow = (long) Math.pow(2, 31);

        // compute the hash of strings haystack[:L], needle[:L]
        long haystackHash = 0;
        long needleHash = 0;

        for (int i = 0; i < needleLength; ++i) {
            haystackHash = (haystackHash * a + charToInt(i, haystack)) % pow;
            needleHash = (needleHash * a + charToInt(i, needle)) % pow;
        }
        if (haystackHash == needleHash){
            return 0;
        }

        // const value to be used often : a**L % modulus
        long aL = 1;

        for (int i = 1; i <= needleLength; ++i){
            aL = (aL * a) % pow;
        }

        for (int start = 1; start < haystackLenght - needleLength + 1; ++start) {
            // compute rolling hash in O(1) time
            haystackHash = (haystackHash * a - charToInt(start - 1, haystack) * aL
                    + charToInt(start + needleLength - 1, haystack)) % pow;

            if (haystackHash == needleHash){
                return start;
            }
        }
        return -1;
    }


    static int charToInt(int idx, String s) {
        return (int) s.charAt(idx) - (int) 'a';
    }

}
