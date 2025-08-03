package zuochengyun;

// 队列和栈
// 使用数组实现队列和栈、使用数组实现循环队列（统一使用左闭右开表示法）
// 使用栈实现队列、使用队列实现栈
// 最小栈

// Java API: java.util.Queue; java.util.Stack;
// public Queue<Integer> q = new LinkedList<>();
// isEmpty() 判断是否为空
// size()    获取元素数量
// offer()   尾部插入元素   push()
// poll()    首部删除元素   pop()
// peek()    获取首部元素

import java.util.Stack;
import java.util.Queue;

public class QueueAndStack {
    // 数组实现队列
    public static class MyQueue {
        public int[] queue;
        int left, right;  // 左闭右开表示

        public MyQueue(int n) {
            this.queue = new int[n];
            this.left = this.right = 0;
        }

        public boolean isEmpty() {return this.left == this.right;}
        
        public int size() {return this.right - this.left;}

        public void offer(int num) {this.queue[this.right++] = num;}

        public int poll() {return this.queue[this.left++];}

        public int peek() {return this.queue[this.left];}
    }

    // 数组实现栈
    public static class MyStack {
        public int[] stack;
        public int size;

        public MyStack(int n) {
            this.stack = new int[n];
            this.size = 0;
        }

        public boolean isEmpty() {return this.size == 0;}
        
        public int size() {return this.size;}

        public void push(int num) {this.stack[this.size++] = num;}

        public int pop() {return this.stack[--this.size];}

        public int peek() {return this.stack[this.size - 1];}
    }

    // 数组实现循环队列
    // https://leetcode.cn/problems/design-circular-queue
    public static class MyCircularQueue {
        public int[] queue;
        public left, right, size, limit;

        // k 表示循环队列中同时存在的元素数量上限
        public MyCircularQueue(int k) {
            this.queue = new int[k];
            this.left = this.right = this.size = 0;
            this.limit = k;
        }

        public boolean isFull() {return this.size == this.limit;}

        public boolean isEmpty() {return this.size == 0;}

        public boolean enQueue(int val) {
            if (this.isFull()) return false;
            
            this.queue[this.right] = val;
            this.right = this.right == this.limit - 1 ? 0 : (this.right + 1);
            this.size++;
            return true;
        }

        public boolean deQeue() {
            if (this.isEmpty()) return false;

            this.left = this.left == this.limit - 1 ? 0 : (this.left + 1);
            this.size--;
            return true;
        }

        public int front() {
            if (this.isEmpty()) return -1;
            else return this.queue[this.left];
        }

        public int rear() {
            if (this.isEmpty()) return -1;
            else {
                int last = this.right == 0 ? (this.limit - 1) : this.right - 1;
                return this.queue[last];
            }
        }
    }

    // 使用栈实现队列
    // https://leetcode.cn/problems/implement-queue-using-stacks
    public static class ImplementQueueUsingStack {
        public Stack<Integer> in, out;

        public ImplementQueueUsingStack() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        private void inToOut() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        public void push(int x) {
            in.push(x);
            inToOut();
        }

        public int pop() {
            inToOut();
            return out.pop();
        }

        public int peek() {
            inToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    // 使用队列实现栈
    // https://leetcode.cn/problems/implement-stack-using-queues
    public static class ImplementStackUsingQueue {
        Queue<Integer> queue;

        public ImplementStackUsingQueue() {
            this.queue = LinkedList<Integer>();
        }

        // O(n)
        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) queue.offer(queue.poll());
        }

        public int pop() {return queue.poll();}

        public int top() {return queue.peek();}

        public boolean empty() {return queue.isEmpty();}
    }

    // 最小栈
    // https://leetcode.cn/problems/min-stack
    public static class MinStack {
        public Stack<Integer> data, min;

        public MinStack() {
            data = new Stack<Integer>();
            min = new Stack<Integer>();
        }

        public void push(int x) {
            data.push(x);
            if (min.isEmpty() || x <= min.peek()) min.push(x);
            else min.push(min.peek());
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {return data.peek();}

        public int getMin() {return min.peek();}
    }
}
