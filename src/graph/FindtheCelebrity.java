package graph;

import java.util.Stack;

public class FindtheCelebrity {

  public static void main(String[] args) {

  }

  /**
   * ну конечно брут форсом - это спрашивать каждого насчет каждого и вести как бы приорити кью -
   * делать такой аналог лидерборда второй вариант - это бинарным по
   * <p>
   * более умный вариант - принцип - стек + два прохода с попарным отметанием
   * <p>
   * надо проверять через стек, наложить в стек, и далее брать парами и отметать тех кого хоть
   * кто-то знает затем после первого прохода у нас на руках стек у которого потенциально только тот
   * кто может быть селебрити делаем второй проход потенциальный селебрити должен не знать никого и
   * его должны знать все
   */
  public int findCelebrity(int n) {
    // base case
    if (n <= 0) {
      return -1;
    }
    if (n == 1) {
      return 0;
    }

    //на стек кладем потенциальных селебрити
    Stack<Integer> stack = new Stack<>();

    //кладем всех людей на стек
    // put all people to the stack
    for (int i = 0; i < n; i++) {
      stack.push(i);
    }

    int firstMan = 0;
    int secondMan = 0;

    while (stack.size() > 1) {
      firstMan = stack.pop();
      secondMan = stack.pop();

      // firstMan knows secondMan,
      // so firstMan is not the celebrity, but secondMan may be
      if (knows(firstMan, secondMan)) {
        stack.push(secondMan);
      } else {
        // a doesn't know b, so b is not the celebrity, but a may be
        stack.push(firstMan);
      }
    }

    //в итоге на выходе остается только потенциальные селебрити
    // double check the potential celebrity
    int potentialCelebrity = stack.pop();

    //необходимо проверить их
    for (int i = 0; i < n; i++) {
      // potentialCelebrity should not know anyone else
      if (i != potentialCelebrity && (knows(potentialCelebrity, i) || !knows(i,
          potentialCelebrity))) {
        return -1;
      }
    }
    return potentialCelebrity;
  }

  boolean knows(int a, int b) {
    return true;
  }
}
