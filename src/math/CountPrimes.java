package math;

public class CountPrimes {

  /**
   * Count the number of prime numbers less than a non-negative number, n.

   * Example:

   * Input: 10 Output: 4 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.


   * Просто́е число́ — натуральное число, имеющее ровно два различных натуральных делителя — единицу
   * и самого себя.
   *
   *
   * в общем тут такой принцип полу динамического программирования
   * мы будем брать число например 2 смотрим что оно ПРАЙМ - далее мы понимаем что все
   * его множителями ПРАЙМАМИ НЕ БУДУТ то есть 4 6 8 10 и так до n -
   *
   * и таким образом мы помечаем наперед те числа которые сто пудово праймами не будут
   */

  public int countPrimes(int n) {

    //нам надо посчитать кол-во простых чисел которые меньше чем n
    //для этого мы делаем массив булеанов размером n

    // isMultipleOfPrime[i] store whether num i is dividable by a prime num < i
    boolean[] isMultipleOfPrime = new boolean[n];//all initialized to false
    // count of prime nums so far
    int count = 0;
    for (int i = 2; i < n; i++) {     // start from 2
      if (!isMultipleOfPrime[i]) {  // if i not dividable by a previous num, it's a prime
        count++;                  // count toward total num of primes seen so far
        //помечаем все числа которые являются множителями НЕ ПРАЙМАМИ
        for (int j = i; j < n; j = j + i) { // mark all multiples of i as non-prime
          isMultipleOfPrime[j] = true;
        }
      }
    }
    return count;
  }
}
