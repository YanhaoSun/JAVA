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

    public static void main(String[] args) {
        String[] test = {"4","13","5","/","+"};
        System.out.println(evalRPN(test));
    }
}
