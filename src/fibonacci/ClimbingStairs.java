package fibonacci;

public class ClimbingStairs {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {

        if(n == 1){
            return 1;
        }

        int prepre = 1;
        int pre = 2;

        int res = 1;

        for(int i = 3; i<=n; i++){
            res = prepre+pre;
            prepre = pre;
            pre = res;
        }
        return pre;

    }
}
