package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	/**
	 * 184.MostCommonWord
	 * <p>
	 * https://leetcode.com/problems/most-common-word/
	 * <p>
	 * Дан параграф текста и список запрещенных слов, верни наиболлее часто встречающееся слово которое не входит в
	 * число запрещенных слово. Гарантированно что есть хотя бы одно слово которое которое не запрещено и ответ
	 * уникален. Слова в списке запрещенных слов даны в нижнем регистре, слова в параграфе кейс инсенситив, ответ должен
	 * быть в нижнем регистре
	 * <p>
	 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit." banned = ["hit"]
	 * <p>
	 * На выходе получаем: "ball"
	 * <p>
	 * Explanation: "hit" occurs 3 times, but it is a banned word. "ball" occurs twice (and no other word does), so it
	 * is the most frequent non-banned word in the paragraph. Note that words in the paragraph are not case sensitive,
	 * that punctuation is ignored (even if adjacent to words, such as "ball,"), and that "hit" isn't the answer even
	 * though it occurs more because it is banned
	 */
	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";

		String[] banned = {"ball"};

		System.out.println(mostCommonWord(paragraph, banned));
	}

	static String mostCommonWord(String paragraph, String[] banned) {
		if (paragraph == null || paragraph.trim().isEmpty()) {
			return "";
		}

		Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> map = new HashMap<>();
		String maxKey = null;

		String[] words = paragraph.trim().split("[ \\p{Punct}]+");

		for (String word : words) {
			word = word.toLowerCase();
			if (!bannedSet.contains(word)) {
				Integer numberOfOcc = map.getOrDefault(word, 0);
				Integer maxCount = map.getOrDefault(maxKey != null ? maxKey : "", 0);

				if (numberOfOcc == maxCount) {
					maxKey = word;
				}
				map.put(word, numberOfOcc + 1);
			}

		}

		return maxKey;
	}
}
