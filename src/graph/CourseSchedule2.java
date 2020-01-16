package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CourseSchedule2 {

	public static void main(String[] args) {
		List<List<Integer>> pre = new ArrayList<>();
		pre.add(List.of(1, 0));
		pre.add(List.of(2, 0));
		pre.add(List.of(3, 1));
		pre.add(List.of(3, 2));

		int[][] p = new int[4][2];

		for (int i = 0; i < p.length; i++) {
			p[i][0] = pre.get(i).get(0);
			p[i][1] = pre.get(i).get(1);
		}
		CourseSchedule2 cs = new CourseSchedule2();
		System.out.println(Arrays.toString(cs.findOrder(4, p)));
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		//и так сразу создаем результирующий массив резов
		//сразу понятно что размер его будет равен кол-ву наших курсов
		List<Integer> res = new ArrayList<>();

		//создаем набор наших курсов
		List<Course> courses = new ArrayList<>();

		//инициализируем курсы
		for (int i = 0; i < numCourses; i++) {
			courses.add(new Course(i));
		}
		//следующий шаг - заполняем наши зависимости
		for (int[] prerequisite : prerequisites) {
			Course leftCourse = courses.get(prerequisite[0]);
			Course rightCourse = courses.get(prerequisite[1]);
			leftCourse.pre.add(rightCourse);
		}
		//раскручиваем цикл по курсам
		//и проверяем внутри является ли он циклом а заодно и заполняем массив резов
		for (int i = 0; i < numCourses; i++) {
			//если хоть одна нода - то есть курс является началом цикла - сразу возвращаем пустой массив
			if (isCyclic(courses.get(i), res)) {
				return new int[0];
			}
		}
		return res.stream().mapToInt(Integer::intValue).toArray();
	}

	private boolean isCyclic(Course currCourse, List<Integer> result) {
		if (currCourse.tested) {
			return false;
		}
		if (currCourse.visited) {
			return true;
		}
		currCourse.visited = true;
		// тут берем и проверяем  каждого соседа
		//является ли он началом цикла или нет
		for (Course c : currCourse.pre) {
			if (isCyclic(c, result)) {
				return true;
			}
		}
		currCourse.tested = true;
		//в конце сетим нужный нам элемент массива
		result.add(currCourse.val);
		return false;
	}

	//класс обертка для нашего курса
	static class Course {
		//тут у нас есть два флага
		//первый нужен что бы два раза не заходить в одну и ту же ноду
		boolean visited = false;
		//второй нужен что бы понимать что эту ноду и ее детей мы уже УСПЕШНО протестировали на цикличность
		boolean tested = false;
		int val;
		List<Course> pre = new ArrayList<>();

		public Course(int val) {
			this.val = val;
		}
	}
}
