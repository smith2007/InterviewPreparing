package string;

public class SplitaStringinBalancedStrings {


    public int balancedStringSplit(String s) {
        char[] sA = s.toCharArray();  // convert String to char array.

        int rez = 0;
        int r = 0;
        int l = 0;

        for (char c : sA) { // go for each char in array
            if (c == 'R') r++; // check if char is 'R' or 'L' if so increase the corespoding counter
            else if (c == 'L') l++;

            if (r > 0 && r == l) { // check if counter is not empty and they are equals
                rez++; // increase rez counter and set r\l counter to 0.
                r = 0;
                l = 0;
            }
        }

        return rez;
    }
}
