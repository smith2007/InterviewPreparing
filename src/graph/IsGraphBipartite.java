package graph;

public class IsGraphBipartite {


    /**
     * 245.IsGraphBipartite
     * <p>
     * https://leetcode.com/problems/is-graph-bipartite/
     * <p>
     * дан НЕ направленный граф - верни true тогда и только тогда когда этот граф двудольный
     * <p>
     * Напомним, что граф является двудольным, если мы можем разделить его набор нод на два независимых лагеря A и B так,
     * чтобы у каждого ребра графа был один узел в A и другой узел в B.
     * на картинке два множества красные и синие - граф двудольный
     */
    public static void main(String[] args) {

    }

    /**
     * будем красить граф через числа
     * 0: Haven't been colored yet.
     * 1: Blue.
     * -1: Red.
     *
     * смысл вот в чем
     * если нода не была еще раскрашена - раскрашиваем ее
     * далее используем паралельный цвет что бы раскрасить всех ее соседей
     * если нода была раскрашена, проверь что текущий цвет точно такой же как тот цвет который ты планируешь
     * использовать для раскрашивания
     *
     */
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++) { //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validColor(int[][] graph, int[] colors, int colorForColoring, int node) {
        //сразу првоеряем раскрашена ли наша текущая нода
        //если она раскрашена то есть не равна нулю!!
        //то надо проверить что она раскрашена тем чем мы хотели бы ее раскрасить
        if (colors[node] != 0) {
            return colors[node] == colorForColoring;
        }
        //если нода не была еще раскрашена - раскрашиваем ее
        colors[node] = colorForColoring;
        for (int next : graph[node]) {
            //ну и далее берем соседей этой ноды
            //далее проверяем всех соседей что они раскрашены правильно в праралельный цвет
            if (!validColor(graph, colors, -1 * colorForColoring, next)) {
                return false;
            }
        }
        return true;
    }

}
