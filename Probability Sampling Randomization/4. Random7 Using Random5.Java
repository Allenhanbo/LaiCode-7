
/*
Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random7().
*/

public class Solution {
  public int random7() {
    // write your solution here
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    /*
    0 1 2 3 4
    5 6 0 1 2
    3 4 5 6 0
    1 2 3 4 5
    6 21222324
    */
    int row = RandomFive.random5();
    int col = RandomFive.random5();
    int curr = row * 5 + col;
    if(curr > 20) {
      return random7();
    }
    else {
      return curr % 7;
    }
  }
}

