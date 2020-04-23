package math;

public class CountPrimes {

  /**
   * Count the number of prime numbers less than a non-negative number, n.
   * <p>
   * Example:
   * <p>
   * Input: 10 Output: 4 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
   */
/*  public int countPrimes(int n) {
    boolean[] primes = new boolean[n]; //all initialized to false
		*//*starting at 2 because all numbers are divisible by 1 and undivisble by 0.
		We do i*i and j*i because mathematecally there are no primers greater than the current number and its square*//*
    for (int i = 2; i * i < primes.length; i++) {
      if (!primes[i]) {
        for (int j = i; j * i < primes.length; j++) {
          primes[i * j] = true;
        }
      }
    }
    int result = 0;
    for (int i = 2; i < primes.length; i++) {
      if (!primes[i]) {
        result++; //count all primes
      }
    }
    return result;
  }*/

  public int countPrimes(int n) {
    // isMultipleOfPrime[i] store whether num i is dividable by a prime num < i
    boolean[] isMultipleOfPrime = new boolean[n];//all initialized to false
    // count of prime nums so far
    int count = 0;
    for (int i = 2; i < n; i++) {     // start from 2
      if (!isMultipleOfPrime[i]) {  // if i not dividable by a previous num, it's a prime
        count++;                  // count toward total num of primes seen so far
        for (int j=i; j<n; j=j+i) // mark all multiples of i as non-prime
          isMultipleOfPrime[j] = true;
      }
    }
    return count;
  }
}
