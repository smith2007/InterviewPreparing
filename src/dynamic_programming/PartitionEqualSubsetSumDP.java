package dynamic_programming;

import java.util.Arrays;

public class PartitionEqualSubsetSumDP {

    public static void main(String[] args) {

    }
    //
    public boolean canPartition(int[] nums) {
        int sum = 0;
        //набиваем кумулятивную сумму
        for (int num : nums) {
            sum += num;
        }

        //если сумма получилась НЕ четная - все, разделить не возможно
        if (sum % 2 == 1) {
            return false;
        }
        //делим сумму пополам - ее то и надо набить в массиве
        sum /= 2;


        boolean[] knapsack = new boolean[sum + 1];
        Arrays.fill(knapsack, false);
        knapsack[0] = true;

        //принцип рюкзака - есть наши элементы - есть наша сумма - наша задача
        //понять можно ли подобрать конфигурацию элементов так что бы
        //получилась такая сумма
        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    knapsack[i] = knapsack[i] || knapsack[i - num];
                }
            }
        }

        return knapsack[sum];
    }
}
