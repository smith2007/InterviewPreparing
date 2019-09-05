package string;

public class Bracets {

    public static void main(String[] args) {
        String s1 = "())";
        System.out.println(minAddToMakeValid(s1));
    }

    private static int minAddToMakeValid(String str) {
        int ans = 0, bal = 0;
        for (int i = 0; i < str.length(); ++i) {
            int i1 = str.charAt(i) == '(' ? 1 : -1;
            bal = bal + i1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
}
