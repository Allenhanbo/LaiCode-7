
/*
Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random1000()
*/


public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    // 5^5 = 3125
    int n = 1;
    int curr = 5;
    while(curr < 1000) {
      curr = curr * 5;
      n++;
    }
    int result = 0;
    for(int i = 0; i < n; i++) {
      int temp = RandomFive.random5();
      result = result + (int)(temp * Math.pow(5, i));
    }
    int max = (int)Math.pow(5, n);
    int times = max / 1000;
    if(result >= 1000 * times) {
      return random1000();
    }
    return result % 1000;
  }
}
