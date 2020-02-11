package array;

import java.util.Arrays;

public class ThreeSumClosest {

	/**
	 * 186.3SumClosest - ThreeSumClosest
	 *
	 * https://leetcode.com/problems/3sum-closest/
	 *
	 * дан массив чисел размером n а также число target, найди три числа из этого массива которые в сумме дают число которые ближе всего к таргету
	 * пример
	 * массив = [-1, 2, 1, -4], и target = 1.
	 *
	 * на выходе хочу видеть 2. так как  (-1 + 2 + 1 = 2).
	 *
	 * очень интересный алгоритм, он основан на принице сжатия от отправной точки, а именно, давай держать в голове то что нам надо найти а именно такую сумму которая будет максимально близка к нашему таргету (ну или равна ему)
	 *
	 * тут основная проблема которая тебя застопорила и которая отличается в корне от задачи 3sum это то что тебе нечего замемоизировать
	 * ты не знаешь те гэпы как бы которые надо
	 *
	 * по этому принцип из 3sum (мемоизация) тебе не подходит
	 *
	 * тут принцип - сжатие от отправной точки
	 *
	 * идея - сортируем массив, создадим служебную переменную проиницализировав ее через sum = arr[0] + arr[1] + arr[arr.length - 1];
	 *
	 * раскручиваем цикл фор по i - arr[i] -  и будет нашей отправной точкой епта
	 *
	 * а дальше нам надо сжимать остальную часть массива с помощью двух указателей и счиать тот гэп по модулю
	 *
	 * во внутреннем цикле вайл берем два указатель  left = i + 1 и right = arr.length - 1 - крутимся пока они не встретятся
	 * смотрим чем будет равна сумма из нашего триплета a[i]+a[left]+a[right] - что она нам дает?? больще чем таргет? меньше чем таргет?
	 * если большн надо бы уменьшить через right— так как массив сортированный
	 * если меньше надо увеличить через left++
	 */
	public static void main(String[] args) {

		int[] arr = {-1, 2, 1, -4};

		System.out.println(threeSumClosest(arr, 1));
	}

	static int threeSumClosest(int[] arr, int target) {

		//первым делом сортируем массив
		Arrays.sort(arr);

		//предположим что нашей отправной точкой будет предположение
		//что та самая ближайшая искомая сумма будет сумма нулевого, первого и последнего элемента
		int sum = arr[0] + arr[1] + arr[arr.length - 1];
		int closestSum = sum;

		//делаем запас на 2 два элемента
		for (int i = 0; i < arr.length - 2; i++) {

			int left = i + 1;
			int right = arr.length - 1;

			while (left<right){

				sum = arr[i] + arr[left] + arr[right];
				if (sum<target){
					left++;
				} else {
					right--;
				}

				if (Math.abs(target-sum)< Math.abs(target-closestSum)){
					closestSum=sum;
				}
			}

		}
		return closestSum;


	}
}