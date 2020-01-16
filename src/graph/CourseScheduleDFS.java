package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleDFS {

	/**
	 * 156.CourseSchedule
	 *
	 * https://leetcode.com/problems/course-schedule/
	 *
	 * и так у нас перед глазами n курсов в универе которые нам необходимо взять, каждый курс пронумерован от 0 до n-1
	 * некоторые курсы могут быть зависимы друг от друга, например что бы взять курс 0 тебе сначала надо пройти курс 1
	 * эти зависимости представлены парой 0,1
	 *
	 * на входе алгоритма у нас общее число курсов в виде числа и матрица зависимостей - по факту пар 0,1 - 2,3
	 * необходимо ответить на вопрос, возможно ли закончить все курсы исходя из зависимостей которые даны?
	 *
	 * Example 1:
	 * Input: 2, [[1,0]]
	 * Output: true
	 * Explanation: There are a total of 2 courses to take.
	 *              To take course 1 you should have finished course 0. So it is possible.
	 *
	 * интересный алгоритм решение сводится к нахождению цикла в графе, условно каждый из наших курсов - вершина графа
	 * наша задача построит как бы граф, на основании массива зависимостей добавить соседей и затем проверить каждую вершину а не является ли она началом цикла
	 *
	 * задача условно сводится к DFS через рекурсию с массивом boolean[] visited
	 *
	 * так же есть BFS решение через очередь
	 */
	public static void main(String[] args) {

		int[][] prerequisites = new int[2][2];
		prerequisites[0][0] = 1;
		prerequisites[0][1] = 0;
/*
		prerequisites[1][0] = 1;
		prerequisites[1][1] = 0;*/
		System.out.println(canFinish(2, prerequisites));

	}

	static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses == 0 || prerequisites.length == 0) {
			return true;
		}

		List<Course> courses = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			courses.add(new Course(i));
		}

		for (int[] prerequisite : prerequisites) {
			Course left = courses.get(prerequisite[0]);
			Course right = courses.get(prerequisite[1]);
			if (!left.equals(right)) {
				left.dep.add(right);
			}
		}

		for (Course course : courses) {
			if (isCycle(course, new boolean[numCourses])){
				return false;
			}
		}
		return true;
	}

	static boolean isCycle(Course curr, boolean[] visited) {
		visited[curr.val] = true;
		for (Course course : curr.dep) {
			if (visited[course.val] || isCycle(course, visited)) {
				return true;
			}
		}
		visited[curr.val] = false;
		return false;
	}


	static class Course {
		int val;
		List<Course> dep;
		public Course(int val) {
			this.val = val;
			this.dep = new ArrayList<>();
		}
	}


}
