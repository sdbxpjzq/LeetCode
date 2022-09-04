package _03_栈._用两个栈模拟实现队列的入队出队;

import java.util.Stack;

public class imitateQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 入队:栈1入栈
     */
    public void push(int data) {
        // 栈1入栈
        stack1.push(data);
    }

    /**
     * 出队
     */
    public Integer pop() {
        // 栈2为空的时候
        if (stack2.isEmpty()) {
            // 将栈1中的所有元素放进栈2中 并且栈2出栈
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // 栈2不为空直接出栈 避免因进栈顺序导致出栈出错
        return stack2.pop();
    }

    public static void main(String[] args) {
        imitateQueue imitateQueue = new imitateQueue();
        imitateQueue.push(1);
        imitateQueue.push(2);
        System.out.print(imitateQueue.pop());//期望结果：1
        imitateQueue.push(3);
        System.out.print(imitateQueue.pop());//期望结果：2
        imitateQueue.push(4);
        System.out.print(imitateQueue.pop());//期望结果：3
        System.out.print(imitateQueue.pop());//期望结果：4
    }



}
