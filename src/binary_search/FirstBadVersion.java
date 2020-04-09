package binary_search;

public class FirstBadVersion {


	/**
	 * 201.FirstBadVersion
	 *
	 * https://leetcode.com/problems/first-bad-version/
	 *
	 *
	 * представь что ты продукт менеджер и в текущий момент ведешь команду которая разрабатывает новый продукт,
     * к сожалению последняя версия твоего продукта провалилась на тестировании. Поскольку каждая версия разработана
     * на основе предыдущей версии, все версии после плохой версии также являются плохими. Представь что ты имеешь n
     * версий (1,2 ….n) и ты хочешь найти первую плохую версию котрая  привела к багам в текущей версии продукта.
     * для этого у тебя есть API bool isBadVersion(version) которое возвращает результат тестирования -
     * кривая это версия или нет. реализуй алгоритм который возвращает первую сломанную версию
     * - так что бы кол-во вызовов api проверки было минимально
	 *
	 * Example:
	 * Given n = 5, and version = 4 is the first bad version.
	 *
	 * call isBadVersion(3) -> false
	 * call isBadVersion(5) -> true
	 * call isBadVersion(4) -> true
	 *
	 * тупой бинарный поиск
	 */
	public static void main(String[] args) {

		System.out.println(firstBadVersion(2));
	}


	static int firstBadVersion(int n) {
		if(n==1 && isBadVersion(1)){
			return 1;
		}
		int start = 1;
		int end = n;


		int lastBroken = -1;

		while (start<=end){
			int mid = start+(end-start)/2;

			if(isBadVersion(mid)){
				lastBroken = mid;
				end = mid-1;
			} else {
				start = mid+1;
			}
		}

		return lastBroken;
	}

	static boolean isBadVersion(int version){
		return version>=2;
	}
}
