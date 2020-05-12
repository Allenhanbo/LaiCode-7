
/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:

"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/


public class Solution {
  public int calculate(String input) {
	    if(input.length() == 1) {
	      return Integer.parseInt(input);
	    }
	    Deque<Character> stack = new LinkedList<>();
	    int curr = 0;
	    while(curr < input.length()) {
        //判断当前数字是否是空格
	    	if(input.charAt(curr) == ' ') {
	    		curr++;
	    	}
        //如果不是空格不是)就直接输入stack中
	    	else if(input.charAt(curr) != ')') {
	        stack.push(input.charAt(curr));
	        curr++;
	      }
        // 遇到)就把()中间的字符导出来
	      else {
	        String sub = "";
	        while(stack.peek() != '(') {
	          sub += stack.pop();
	        }
	        stack.pop(); // pop (
          // 把中间的字符在调回原来的顺序
	        String temp = reverse(sub);
          // 把计算的结果转回字符串然后放入stack中
	        String solu = String.valueOf(compute(temp));
	        for(int i = 0; i < solu.length(); i++) {
	          stack.push(solu.charAt(i));
	        }
	        curr++;
	      }
	    } // end while
	    String last = ""; // 这里是没有任何括号的最后的计算式
	    while(!stack.isEmpty()) {
	      last += stack.pop();
	    }
	    return compute(reverse(last));
	  }
		
	public String reverse(String input) {
	      char[] inputCharArray = input.toCharArray();
	      int i = 0;
	      int j = input.length() - 1;
	      while(i <= j) {
	        char temp = inputCharArray[i];
	        inputCharArray[i] = inputCharArray[j];
	        inputCharArray[j] = temp;
	        i++;
	        j--;
	      }
	      return String.valueOf(inputCharArray);
	    }
	
	  public int compute(String input) {
	    int curr = 0;
	    boolean plus = false;
	    boolean minus = false;
	    String head = "";
      // 读取第一个数字
	    while(curr < input.length() && Character.isDigit(input.charAt(curr))) {
	      head += input.charAt(curr);
	      curr++;
	    }
	    int result = Integer.parseInt(head);
      // 每次读取一个字符或者一个数字（数字可以是多个char组成)
	    while(curr < input.length()) {
	      if(input.charAt(curr) == '+') {
	    	  plus = true;
	        curr++;
	      }
	      else if (input.charAt(curr) == '-') {
	      	// case1 : + - ; 加一个负数的情况
	    	  	if(plus && !minus) {
	    	  		plus = false;
	    	  		minus = true;
	    	  	}
	    	  	// case2: - - ; 减一个负数的情况
	    	  	else if(!plus && minus) {
	    	  		plus = true;
	    	  		minus = false;
	    	  	}
	    	  	else {
	    	  		minus = true;
	    	  	}
	        curr++;
	      }
	      else { // 遇到数字的时候才开始计算
		      String number = ""; // 先读取数字
		      while(curr < input.length() && Character.isDigit(input.charAt(curr))) {
		        number += input.charAt(curr);
		        curr++;
		      }
		      int next = Integer.parseInt(number);
          // 这里开始才是计算
		      if(plus) {
		        result += next;
		        plus = false;
		      }
		      if(minus) {
		        result -= next;
		        minus = false;
		      }
		    }
	    }
	    return result;
	  }
}
