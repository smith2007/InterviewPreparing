package backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public static void main(String[] args) {

    }

    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<>();
        if (num == null || num.length() == 0) return rst;
        dive(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public void dive(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval){
                res.add(path);

            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                dive(res, path + cur, num, target, i + 1, cur, cur);
            } else {
                dive(res, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                dive(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                dive(res, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
