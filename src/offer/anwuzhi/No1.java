package offer.anwuzhi;

import java.util.LinkedList;
import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        boolean result = go(str);
        //请在这里输入你的代码
        System.out.println(result);
    }

    private static boolean go(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!stack.isEmpty()) {
                if ((c == ')' && stack.peek() != '(') ||
                        (c == ']' && stack.peek() != '[') ||
                        (c == '}' && stack.peek() != '{')) {
                    return false;
                } else if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
