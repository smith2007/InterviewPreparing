package backtracking;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public boolean canPartitionKSubsets(int[] arr, int k) {
        if (k > arr.length) {
            return false;
        }
        //так же набиваем кумулятивную сумму
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        //если сумма не делится на k без остатка - то это поделить невозможно
        if (sum % k != 0) {
            return false;
        }

        boolean[] visited = new boolean[arr.length];
        Arrays.sort(arr);
        return dfs(arr, 0, arr.length - 1, visited, sum / k, k);
    }

    /**
     * ну а дальше dfs, наша задача набить k
     */
    public boolean dfs(int[] arr, int sum, int index, boolean[] visited, int target, int round) {
        if (round == 0) {
            return true;
        }
        if (sum == target && dfs(arr, 0, arr.length - 1, visited, target, round - 1)) {
            return true;
        }

        //идем назад
        for (int i = index; i >= 0; i--) {
            //если ранее этот элемент не посещали, и его сумма с таргетом имеет смысл то пытаемся взять его в чей
            //и дальше запустить на нем снова дфс и пытаемся набить дальше до сама
            if (!visited[i] && sum + arr[i] <= target) {
                visited[i] = true;
                if (dfs(arr, sum + arr[i], i - 1, visited, target, round)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
