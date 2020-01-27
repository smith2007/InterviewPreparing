package stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures2 {

	/**
	 * 167.DailyTemperatures https://leetcode.com/problems/daily-temperatures/
	 * <p>
	 * дан список дневных температур - Т, верни на выходе лист да при том такой что бы каждый во входном массиве дней
	 * говорил тебе как много дней тебе необходимо ждать до тех пор пока температура не станет теплее если же такой даты
	 * нет, например температура становится с каждым днем все холоднее - положи в массив 0
	 * <p>
	 * например на входе массив температур по дням T = [23, 24, 25, 21, 19, 22, 26, 23], на выходе надо получить [1, 1,
	 * 4, 2, 1, 1, 0, 0]
	 * <p>
	 * нам по факту тут надо найти для каждого элемента следующий который больше него и взять разницу индексов между
	 * ними
	 */
	public static void main(String[] args) {
		int[] t = {23, 24, 25, 21, 19, 22, 26, 23};

		int[] ints = dailyTemperatures(t);

		System.out.println(Arrays.toString(ints));
	}

	static int[] dailyTemperatures(int[] temp) {
		LinkedList<Integer> stack = new LinkedList<>();

		int[] res = new int[temp.length];

		for (int i = 0; i < temp.length; i++) {
			while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
				res[stack.peek()] = i - stack.pop();
			}
			stack.push(i);
		}

		return res;
	}

	static class Node {
		int temp;
		int index;

		public Node(int temp, int index) {
			this.temp = temp;
			this.index = index;
		}
	}
}
