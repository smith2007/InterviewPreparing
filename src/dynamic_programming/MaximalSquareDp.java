package dynamic_programming;

public class MaximalSquareDp {

  public static void main(String[] args) {
    char[][] matrix = {{'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
    };
    MaximalSquareDp maximalSquare = new MaximalSquareDp();
    System.out.println(maximalSquare.maximalSquare(matrix));
  }

  public int maximalSquare(char[][] matrix) {

    if (matrix.length == 0) {
      return 0;
    }

    int m = matrix.length;
    int n = matrix[0].length;

    int[][] dp = new int[m + 1][n + 1];

    int maxEdge = 0;
    //обходим нашу матрицу и проверяем ДИАГОНАЛЬ
    //наша задача построить максимальную диагональ

    /**
     * dp - динамическое программирование - мы работаем по принципу диагональ->длинна ребра
     * то есть мы делаем матрицу dp - в ней каждый элемент будет означать буквально следующее - максимальный размер стороны квадрата, заканчивающийся этим углом
     *
     * вот так для примера будет выглядеть наша матрица dp
     *
     * 0 0 0 0 0 0
     * 0 1 0 1 0 0
     * 0 1 0 1 1 1
     * 0 1 1 1 2 2
     * 0 1 0 0 1 0
     *
     * видно что двойки стоят там - где сошлись звезды и во всех направлениях левее - выше - диагональнее
     * стоят как бы единицы
     * итак соотв для того что бы успешно построить такую матрицу надо удостоверится
     * что во всех направлениях от нашей как бы точки стоит то что надо
     *
     * для этого надо брать минимумы из того что левее, выше и левее-диагональнее и если там хоть
     * где то ноль, то все нет никакого квадрата, конечный dp[i][j] будет равен 1 - так как
     * максимальный размер стороны квадрата, заканчивающийся этим углом равен 1 так как нет никакого квадрата
     */
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          //надо взять минимум из того что стоит выше либо левее в нашей dp матрице
          //это как раз надо для того что бы понять - есть ли у нас квадрат
          //если квадрат не получается и где-то слева или справа стоит 0, то и тут вернется 0
          //а вот если и там и там 1 да еще и наше ребро диаганальное равно 1
          //тогда это заявка на победу
          int min = Math.min(dp[i - 1][j], dp[i][j - 1]);

          //вот тут мы проверяем наше диагональное ребро
          //если звезды сойдутся и нам выпадает квадрат то
          //все переменные вернут 1

          // ну и наш dp - i j будет складываться из того что минимально там,
          // либо и того что стоит диагональю выше и левее
          dp[i][j] = Math.min(min, dp[i - 1][j - 1]) + 1;

          //ну и так как мы работаем по принципу диагональ->длинна ребра
          //мы тут накапливаем максимальную длинну нашего как бы ребра нашего квадрата
          //а максимальной она будет только тогда когда мы апдейтим и апдейтим
          //наш массив dp когда у нас в диагональном эл-те сначала 2 потом 3 потом 4 например
          //и тд
          maxEdge = Math.max(maxEdge, dp[i][j]);
        }
      }
    }

    //ну и площадь находится просто это квадрат стороны
    return maxEdge * maxEdge;
  }


}
