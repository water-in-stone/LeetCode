package leetcode.stack;

import java.util.List;

/**
 * @author baikal on 2019-02-27
 * @project Algorithm
 * <p>
 * 关键在于链表的使用
 */
public class _155_MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}

class MinStack {
    ListNode top;
    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (top == null) {
            this.top = new ListNode(x);
        } else {
            ListNode a = new ListNode(x);
            a.next = this.top;
            this.top = a;
        }
        // 保存最小值
        if (x <= this.min) {
            this.min = x;
        }
    }

    public void pop() {
        if (this.top != null) {
            if (this.top.val == this.min) {
                this.top = this.top.next;
                ListNode minNode = this.top;
                this.min = Integer.MAX_VALUE;

                while (minNode != null) {
                    if (minNode.val < this.min) {
                        this.min = minNode.val;
                    }
                    minNode = minNode.next;
                }
            } else {
                this.top = this.top.next;
            }
        }
    }

    public int top() {
        if (this.top != null) {
            return this.top.val;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int getMin() {
        if (this.top != null) {
            return this.min;
        } else {
            return Integer.MIN_VALUE;
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}