package 线性表.栈.栈的经典习题;

import java.util.Stack;

/**
 * 力扣150
 * medium
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> characters = new Stack<>();
        for (String token: tokens) {
            if ("+-*/".contains(token)) {
                Integer num1 = characters.pop();
                Integer num2 = characters.pop();
                switch (token) {
                    case "+":
                        characters.push(num1 + num2);
                        break;
                    case "-":
                        characters.push(num2 - num1);
                        break;
                    case "*":
                        characters.push(num1 * num2);
                        break;
                    default:
                        characters.push(num2 / num1);
                        break;
                }
            } else {
                characters.push(Integer.parseInt(token));
            }
        }
        return characters.pop();
    }
    public static int evalRPNPrac(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        int result=0;
        for (String token: tokens){
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                Integer val1 = stack.pop();
                Integer val2 = stack.pop();
//                System.out.println("val1 = "+val1);
//                System.out.println("val2 = "+val2);
                switch (token){
                    case "+":
                        result = val2+val1;
                        break;
                    case "-":
                        result = val2-val1;
                        break;
                    case "*":
                        result = val2*val1;
                        break;
                    case "/":
                        result = val2/val1;
                        break;
                }
                stack.push(result);
            } else {
                Integer val1 = Integer.valueOf(token);
//                System.out.println("val1 = "+val1);
                stack.push(val1);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
//        String[] test = {"4","13","5","/","+"};
        String[] test = {"18"};
        System.out.println(evalRPNPrac(test));
    }
}
