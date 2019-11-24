package hkttty.niuke;

import org.junit.Test;

import java.util.ArrayDeque;

public class MinStack {

    /*用例:
["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]

对应输出应该为:

3,3,2,2,2,3,3,0*/

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    ArrayDeque<Integer> help = new ArrayDeque<>();


    @Test
    public void test1(){
        MinStack s = new MinStack();
        s.push(3);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.push(2);
        System.out.println(s.min());
        s.push(3);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.push(0);
        System.out.println(s.min());
    }

    public void push(int node) {
        stack.push(node);
        if(help.isEmpty() || node <= help.peek()){
            help.push(node);
        }
    }

    public void pop() {
        if(stack==null){
            return;
        }
        Integer pop = stack.pop();
        if(pop==help.peek()){
            help.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min(){
        return help.peek();
    }
}
