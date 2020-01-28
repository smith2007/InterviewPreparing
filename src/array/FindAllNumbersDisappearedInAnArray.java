package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

	/**
	 * 169.FindAllNumbersDisappearedInAnArray
	 * <p>
	 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
	 * <p>
	 * дан массив целых чисел где каждый элемент находится в промежутке от 1 до n, некоторые элементы встречаются
	 * дважды, остальные единожды, найди все элементы в промежутке от 1 до n которые не встретились в этом массиве
	 * <p>
	 * Input: 				Output: [4,3,2,7,8,2,3,1]     		[5,6]
	 * <p>
	 * n = 8
	 */
	public static void main(String[] args) {

		//int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
		int[] arr = {1, 1};
		findDisappearedNumbers(arr).forEach(System.out::print);
	}

	/**
	 * решаем проблему через маркировку минусом суть заключается в том что мы путешествуем по элементам используя их
	 * значения как индексы для маркировки
	 */
	static List<Integer> findDisappearedNumbers(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			//запоминай паттер бляха муха
			// берем элемент от аррай итого
			int elm = arr[i];
			//берем элемент от элемента
			//почему Math.abs(elm) - 1 - да потому что элементы имеют
			//значения от 1 до n
			//а индексы у нас с НУЛЯ ЕПТА
			int newIndex = Math.abs(elm) - 1;
			int elmFromElm = arr[newIndex];

			//смотрим, если этот элемент от элемента ранее не был
			//посещен то значит - занчит маркируем
			//а в какой ситуации мы сюда не зайдем и не будем маркировать минусом???
			//ну на пример ситуация следующая
			//i = 5 -> elm=arr[5]=2 -> arr[elm-1] = arr[2-1] = arr[1] = -3
			//опа -3 это значит что мы сюда уже ссылались когда то, то есть
			//был раньше элемент arr[i] = 2 который нас привел через
			//arr[arr[i]] в 3 и мы пометили его как -3
			//соответсвенно наш текущий arr[i] он же arr[5] = 2 маркировать минусом не надо
			if (elmFromElm > 0) {
				arr[newIndex] *= -1;
			} else {
				System.out.println();
			}
		}

		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 1; i <= arr.length; i++) {
			if (arr[i - 1] > 0) {
				res.add(i);
			}

		}
		return res;
	}
}
