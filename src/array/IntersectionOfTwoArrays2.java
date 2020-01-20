package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {

	public int[] intersect(int[] nums1, int[] nums2) {

		Map<Integer, Integer> map1 = new HashMap<>();

		for (int i : nums1) {
			map1.merge(i, 1, Integer::sum);
		}

		Map<Integer, Integer> map2 = new HashMap<>();

		for (int i : nums2) {
			map2.merge(i, 1, Integer::sum);
		}
		List<Integer> res = new ArrayList<>();

		for (int i : nums1) {
			if (!map2.containsKey(i)) {
				map1.remove(i);
			}
		}

		for (int i : nums2) {
			if (!map1.containsKey(i)) {
				map2.remove(i);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			for (int i = 0; i < Math.min(entry.getValue(), map2.get(entry.getKey())); i++) {
				res.add(entry.getKey());
			}
		}
		return res.stream().mapToInt(i -> i).toArray();

	}
}
