package greedy;

public class GasStation {

  /**
   * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
   *
   * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
   *
   * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
   *
   * Note:
   *
   * If there exists a solution, it is guaranteed to be unique.
   * Both input arrays are non-empty and have the same length.
   * Each element in the input arrays is a non-negative integer.
   * Example 1:
   *
   * Input:
   * gas  = [1,2,3,4,5]
   * cost = [3,4,5,1,2]
   *
   * Output: 3
   *
   * Explanation:
   * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
   * Travel to station 4. Your tank = 4 - 1 + 5 = 8
   * Travel to station 0. Your tank = 8 - 2 + 1 = 7
   * Travel to station 1. Your tank = 7 - 3 + 2 = 6
   * Travel to station 2. Your tank = 6 - 4 + 3 = 5
   * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
   * Therefore, return 3 as the starting index.
   * Example 2:
   *
   * Input:
   * gas  = [2,3,4]
   * cost = [3,4,3]
   *
   * Output: -1
   *
   * Explanation:
   * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
   * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
   * Travel to station 0. Your tank = 4 - 3 + 2 = 3
   * Travel to station 1. Your tank = 3 - 3 + 3 = 3
   * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
   * Therefore, you can't travel around the circuit once no matter where you start.
   */


  /**
   * The idea is simple.
   *
   * Whenever the sum is negative, reset it and let the car start from next point.
   * In the mean time, add up all of the left gas to total. If it's negative finally, return -1 since it's impossible to finish.
   * If it's non-negative, return the last point saved in res;
   */
  private static final int EMPTY = 0;
  public int canCompleteCircuit(int[] gas, int[] cost) {
    assert gas != null && cost != null && gas.length == cost.length;
    int start = 0;
    int tank = EMPTY; // cumulated from station at start
    int total = EMPTY; // extra fuel left at the end of a full circle
    for (int station = 0, count = gas.length; station < count; ++station) {
      int fuel = gas[station] - cost[station]; // re-fuel and drive to the next station
      tank += fuel;
      total += fuel;
      if (tank < EMPTY) { // Ran out of gas on this circle starting from start, so
        tank = EMPTY; // we're starting again
        start = station + 1; // from next station.
        // We already left this station when run out of gas.
        // Starting anywhere (>= 0) up to this station would be futile,
        // because we'll run out of gas somewhere before this station.
      }
    }
    return total < EMPTY?
        -1 // cannot complete the full circle, because we would run out of gas somewhere
        :
            start // something is left in the tank so the last starting point is valid
        ;
  }
}
