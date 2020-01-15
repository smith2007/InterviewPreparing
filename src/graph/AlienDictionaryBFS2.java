package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionaryBFS2 {

	public static void main(String[] args) {
		String[] arr = {"za", "zb", "ca", "cb"};
		System.out.println(alienOrder(arr));
	}

	//решаем с помощью bfs
	static String alienOrder(String[] words) {

		if (words == null || words.length == 0) {
			return "";
		}

		Map<Character, Set<Character>> letterToChain = new HashMap<>();
		Map<Character, Integer> letterToCount = new HashMap<>();

		for (String word : words) {
			for (char letter : word.toCharArray()) {
				letterToCount.put(letter, 0);
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String currWord = words[i];
			String nextWord = words[i + 1];

			int minLength = Math.min(currWord.length(), nextWord.length());

			for (int j = 0; j < minLength; j++) {

				char c1 = currWord.charAt(j);
				char c2 = nextWord.charAt(j);

				if (c1 != c2) {
					Set<Character> chain = letterToChain.getOrDefault(c1, new HashSet<>());
					if (!chain.contains(c2)) {
						chain.add(c2);
						letterToChain.put(c1, chain);
						letterToCount.merge(c2, 1, Integer::sum);
					}
					break;
				}
			}
		}

		LinkedList<Character> queue = new LinkedList<>();
		for (Character key : letterToCount.keySet()) {
			if (letterToCount.get(key) == 0) {
				queue.add(key);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			Character letter = queue.poll();

			sb.append(letter);

			Set<Character> nextChain = letterToChain.get(letter);
			if (nextChain == null) {
				continue;
			}
			for (Character elm : nextChain) {
				letterToCount.put(elm, letterToCount.get(elm) - 1);
				if (letterToCount.get(elm) == 0) {
					queue.add(elm);
				}
			}
		}

		return sb.toString();
	}
}
