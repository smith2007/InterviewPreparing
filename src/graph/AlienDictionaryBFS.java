package graph;

import java.util.*;

public class AlienDictionaryBFS {

	public static void main(String[] args) {
        String[] arr = {"abc", "ab"};
		System.out.println(alienOrder(arr));
	}

	//необходимо получить на выходе порядок букв в этом алфавите
	//решаем с помощью topological sort и bfs
	static String alienOrder(String[] words) {

		//две мапы
		// нужна для хранения как бы напротив буквы как бы возможных следующих букв
		//то есть текущаябуква -> кто вставал за ней
		Map<Character, Set<Character>> letterToChain = new HashMap<>();

		//будет служить неким каунтером для букв сколько раз конкрентная буква вставала за кем то
		//логично что для того что бы взять например первую букву алфавита надо взять ключи со значением == 0
		//потому что они ни за кем не вставали
		Map<Character, Integer> letterToCounterMap = new HashMap<>();

		//результирующий стринг билдер
		StringBuilder result = new StringBuilder();
		if (words == null || words.length == 0) {
			return result.toString();
		}

		/**
		 * перво наперво строим вот такую мапу letterToCounterMap
		 * каждое слово траверсится,
		 * каждая буква будет положена в мапу где ключ - буква а инт - счетчик
		 * w:0
		 * r:0
		 * t:0
		 * f:0
		 * e:0
		 */
		for (String s : words) {
			for (char c : s.toCharArray()) {
				letterToCounterMap.put(c, 0);
			}
		}

		/**
		 * дальше бегаем по массиву слов
		 * набиваем letterToCounterMap и letterToChain
		 */
		for (int i = 0; i < words.length - 1; i++) {
			//берем текущее слово
			String cur = words[i];
			//берем следующее слово
			String next = words[i + 1];

			//берем минимальную длинну из этих двух слов
			int minLength = Math.min(cur.length(), next.length());

			/**
			 * в цикле берем по букве из первого curr слова и второго next слова,
			 * если они равны скипаем, если они не равны - это повод добавить
			 * одну из этих букв как главу чейна (ключ) в letterToChain
			 * и вторую как возможное продолжение
			 */
			for (int j = 0; j < minLength; j++) {

				//берем две паралельные буквы
				char c1 = cur.charAt(j);
				char c2 = next.charAt(j);

				//крутимся до первого различия
				if (c1 != c2) {
					//это повод создать новый сет и положить его в letterToChain
					//в letterToChain будет ключ - это символ из первой строки с1
					// а велью это сет в который будем добавлять буквы из второго - с2
					Set<Character> chain = letterToChain.getOrDefault(c1, new HashSet<>());

					if (!chain.contains(c2)) {
						chain.add(c2);
						letterToChain.put(c1, chain);
						//обновляем каунтер мапу - ключ у мапы это буква из второго слова
						letterToCounterMap.merge(c2, 1, Integer::sum);
					}
					break;
				}
			}
		}

		//мапы на руках - начинаем бфс - иницализируем очередь каунтами из letterToCounterMap
		//ТО ЕСТЬ ТОЛЬКО БУКВЫ КОТОРОЫЕ НЕ ПЕРЕД КЕМ НЕ СТОЯЛИ НИКОГДА
		Queue<Character> queue = new LinkedList<>();
		for (char c : letterToCounterMap.keySet()) {
			//добавляем только те буквы у которых каунт == 0
			if (letterToCounterMap.get(c) == 0) {
				queue.add(c);
			}
		}

		//последний этап - наш бфс, крутимся в цикле пока очередь не пуста
		while (!queue.isEmpty()) {
			//если в очередь попадают буквы с каунтом == 0
			//извлекаем эл из очереди
			char letter = queue.poll();
			//добавляем в результирующую строку
			result.append(letter);
			//а дальше надо понять что, какая буква будет следующей
			//для этого используем letterToChain - там будут возможные следующие эл-ты цепи
			if (letterToChain.containsKey(letter)) { // например в нашем кейсе первый прогон первая буква w -> e у нее в сете лежит е
			    //откуда там е
				Set<Character> possibleNextChainElements = letterToChain.get(letter);
				for (char c2 : possibleNextChainElements) {
					//декрементим кол-во
					letterToCounterMap.put(c2, letterToCounterMap.get(c2) - 1);
					//если ноль тогда кладем в очередь что бы на сл итерации достать
					//и положить в строку
					if (letterToCounterMap.get(c2) == 0) {
						queue.add(c2);
					}
				}
			}
		}

		if (result.length() != letterToCounterMap.size()) {
			return "";
		}
		return result.toString();
	}
}
