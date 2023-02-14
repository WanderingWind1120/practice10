package org.example;

import java.util.Stack;

public class LongestValidParentheses {
    public boolean isValid (String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i<= s.length() -1; i++){
            if (s.charAt(i) == '('){
                stack.push('(');
            }
            else if (s.charAt(i) != '('){
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public int longestValidParentheses (String s){
        int max = 0;
        for (int i = 0; i <= s.length() -1; i++){
            for (int j = i+2; j <= s.length()-1; j += 2){
                if (isValid(s.substring(i,j))){
                    max = Math.max(max, j-i);
                }
            }
        }
        return max;
    }
}
