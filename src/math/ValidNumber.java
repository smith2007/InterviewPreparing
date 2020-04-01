package math;

public class ValidNumber {

    public static void main(String[] args) {

    }

    /**
     * тупая задача, решаем через флаги
     *
     * We start with trimming.
     *
     * If we see [0-9] we reset the number flags.
     * We can only see . if we didn't see e or ..
     * We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
     * We can only see + and - in the beginning and after an e
     * any other character break the validation.
     * At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.
     */

    public boolean isNumber(String s) {
        //We start with trimming.
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            //If we see [0-9] we reset the number flags.
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                //We can only see . if we didn't see e or ..
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                //We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                //We can only see + and - in the beginning and after an e
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                //any other character break the validation.
                return false;
            }
        }
        //At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.
        return numberSeen && numberAfterE;
    }
}
