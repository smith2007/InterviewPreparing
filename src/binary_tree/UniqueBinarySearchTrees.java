package binary_tree;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        UniqueBinarySearchTrees ins = new UniqueBinarySearchTrees();
        int i = ins.numTrees(3);
        System.out.println(i);
    }

    /**
     * короче тут суть вот в чем мы работаем по массиву dp
     * чем то мне эта задача напомнила coin change
     *
     * короче мы бере массив - каждый элемент массива будет нам говорить сколько возможных коомбинаций
     * получиться если максимальное число нод такое то
     *
     * например для для n = 3 - при как бы нодах 1 2 3
     *
     * массив dp будет выглядеть вот так 1 1 2 5
     *
     * то есть если индекс i = 2 - то dp[2] = 2 - то есть у нам максимум два варианта в случае если кол-во нод == 2
     *
     * и мы будем рассматривать каждое ограниченное число нод принимая во внимание что какой-то жытый - будет в кач
     * рутовой ноды - см. вложенный цикл for
     *
     */
    public int numTrees(int n) {
        // представим что перед нами массив от 1 до n
        // 1 2 3
        //создаем массив dp на один больше по размеру
        int[] dp = new int[n + 1];
        //для нуля и одного элемента у нас будет 1 вариант конфигураций
        dp[0] = 1;
        dp[1] = 1;

        //начинаем обход со второго элемента
        for (int totalNumberOfNodes = 2; totalNumberOfNodes <= n; totalNumberOfNodes++) {

            //предположим что наш итый элемент будет рутом
            //начинаем рассматривать для него
            for (int currNodeAsRoot = 1; currNodeAsRoot <= totalNumberOfNodes; currNodeAsRoot++) {

                int leftPartIndex = totalNumberOfNodes - currNodeAsRoot;
                int lefterElements = dp[leftPartIndex];

                int rightPartIndex = currNodeAsRoot - 1;
                int righterElements = dp[rightPartIndex];

                dp[totalNumberOfNodes] += lefterElements * righterElements;
            }

        }

        return dp[n];
    }
}
