package dynamic_programming;

import java.util.HashMap;

public class ContinuousSubarraySum {

	public static void main(String[] args) {

		int[] arr = {23, 2, 6, 4, 8, 8};

		System.out.println(checkSubarraySum(arr, 6));
	}

	static boolean checkSubarraySum(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		//мемоизировать будем через хешмапу
		//базовый элемент 0, -1
		map.put(0, -1);

		//так же работаем через локальную сумму
		int localSum = 0;

		for (int i = 0; i < arr.length; i++) {
			int elm = arr[i];
			localSum += elm;
			//каждую итерацию мы апдейтим текущую сумму
			//модулем
			if (k != 0) {
				localSum = localSum % k;
			}
			//расчитываем то число которого не хватает для счастья
			Integer neededSum = map.get(localSum);
			if (neededSum != null) {

				//если его индекс больше чем 1 тогда да, массив состоит больше чем из одного элемента - возвращаем
				//иными словами есть ли такой элемент который в прошлом давал такой же результат
				//от деления по модулю?
				if (i - neededSum > 1) {
					return true;
				}
			} else {
				map.put(localSum, i);

			}
		}
		return false;
	}
}
