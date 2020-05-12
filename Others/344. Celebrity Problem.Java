
/*
Given an binary matrix of N * N (the only elements in the matrix are 0s and 1s), each of the indices represents one person.

matrix[i][j] = 1 if and only if person i knows person j (this is single direction, only if matrix[j][i] = 1 such that person j knows person i).

Determine if there is one celebrity among all N persons, a celebrity is defined as

He does not know any other person.
All the other persons know him.
Return the celebrity's index if there exist one (there could be at most one celebrity, why?), return -1 otherwise.

Assumptions:

The given matrix is not null and N >= 2.
Examples:

matrix = { { 0, 1, 1 },

                { 0, 0, 0 },

                { 1, 1, 0 } }

The celebrity is person 1, since person 0 and person 2 all know him, but person 1 does not know person 0 or person 2.
*/


public class Solution {
  public int celebrity(int[][] matrix) {
    // Write your solution here
    if(matrix == null || matrix.length <= 1 || matrix[0].length <= 1) {
      return 0;
    }
    int row = matrix.length;
    for(int i = 0; i < row; i++) {
      int rowCount = 0;
      int colCount = 0;
      for(int j = 0; j < row; j++){
        if(j != i && matrix[i][j] == 1) {
          continue;
        }
        else {
          rowCount++;
        }
        if(j != i && matrix[j][i] == 0) {
          continue;
        }
        else {
          colCount++;
        }
      }
      if(rowCount == row && colCount == row) {
        return i;
      }
    }
    return -1;
  }
}


/*
Suppose you are at a party with n people(label from 0 to n-1) and among them, there may(may not) exist one celebrity.
The definition of a celebrity is that all the other n-1 people know him/her but he/she does not know any of them.

implement findCelebrity(n)
Method 1: Brute Force: O(n^2)
for each person a (check if a is a celebrity: 2 conditions)
  go through all other people b
    check !knows(a, b) && check knows(b, a)


Optimized Solution: O(n)
Method 2: find a candidate by one pass: (make sure other people are not a celebrity)
knows(i, j)
return true; i knows j, i is not celebrity
return false; i does not know j, j is not celebrity
*/


/* The known API is defined in the parent class Relation
boolean knows(int a, int b);
*/

/* idea: 
1. find a candidate by one pass: make sure other people are not a celebrity
2. make sure if the candidate is a celebrity by one pass
*/

public class Solution extends Relation {
  // Assumption: n > 1; if no celebrity, return -1
  public int findCelebrity(int n) {
    int candidate = 0;
    // 1. find a candidate by one pass: make sure other people are not a celebrity
    for(int i = 1; i < n; i++) {
      if(knows(candidate, i)) {
        candidate = i;
      }
    }
    // 2. make sure if the candidate is a celebrity by one pass
    for(int i = 0; i < n; i++) {
      if(i != candidate && !knows(i, candidate) || knows(candidate, i)) {
        return -1; 
      }
    }
    return candidate;
  }
}


