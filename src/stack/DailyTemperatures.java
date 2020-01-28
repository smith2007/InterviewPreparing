package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

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

	static int[] dailyTemperatures(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		Stack<Node> stack = new Stack<>();

		for (int i = 0; i < temperatures.length; i++) {
			//крутимся в цикле вайл до тех пор пока наша
			//а в цикле выгребаем все ранее пройденные элементы
			//температура которых меньше чем наша текущая температура
			//либо стек не опустеет
			//
			while (!stack.empty() && temperatures[i] > stack.peek().temp) {
				ans[stack.peek().index] = i - stack.pop().index;
			}
			//в конце каждой итерации обязательно фиксируем пройденый
			//элемент что бы на будущее найти для него значение
			//если мы выйдем из цикла а этот элемент так и останется в
			//стеке ну значит нет для него элемента который больше
			//значит наш цикл вайл который выше не крутился по нему и не
			//выгреб его
			stack.push(new Node(temperatures[i], i));
		}

		return ans;
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
