package hkttty.leetcode;

import java.util.LinkedList;
import java.util.Stack;

//给定 pushed 和 popped 两个序列，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，
// 返回 true；否则，返回 false 。
//
public class No946 {
    //方法一： 贪心
    //思路
    //所有的元素一定是按顺序 push 进去的，重要的是怎么 pop 出来？
    //假设当前栈顶元素值为 2，同时对应的 popped 序列中下一个要 pop 的值也为 2，那就必须立刻把这个值 pop 出来。
    // 因为之后的 push 都会让栈顶元素变成不同于 2 的其他值，这样再 pop 出来的数 popped 序列就不对应了。

    //将 pushed 队列中的每个数都 push 到栈中，同时检查这个数是不是 popped 序列中下一个要 pop 的值，如果是就把它 pop 出来。
    //最后，检查不是所有的该 pop 出来的值都是 pop 出来了。

    //就是说，如果当前入栈的栈顶元素和对应的弹栈的元素相同，就必须弹出来
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       int n = pushed.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int j = 0;
        for(int x : pushed){
            stack.push(x);
            while (!stack.isEmpty() && stack.peek()==popped[j]){
                j++;
                stack.pop();
            }
        }
        return j==n ;
    }
}
