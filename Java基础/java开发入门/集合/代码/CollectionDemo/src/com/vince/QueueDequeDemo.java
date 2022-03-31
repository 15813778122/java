package com.vince;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Queue接口：队列，是一种先进先出的线性数据结构(排队)
 * LinkedList类实现了queue接口
 * 请求队列，消息队列，任务
 * 
 * Deque接口：双端队列
 * Stack:堆栈：先进后出
 * @author HP
 *
 */

public class QueueDequeDemo {
	
	private static void stack() {
		Stack s = new Stack();
		s.push("lily");
		s.push("tom");
		s.push("zizi");
		
		System.out.println(s.peek());//查看最顶部的元素
		System.out.println(s.pop());//查看并删除最顶部的元素
	}
	
	private static void deque() {
		Deque<String> deque = new LinkedList<>();
		deque.add("xx");
		deque.add("xx2");
		deque.add("xx3");
		deque.add("xx4");
		deque.add("xx5");
		deque.add("xx6");
		
		System.out.println(deque.getFirst());
		System.out.println(deque.getLast());
	}
	
	private static void queue() {
		Queue<String> queue = new LinkedList<>();
		queue.add("xx");
		queue.add("xx2");
		queue.add("xx3");
		queue.add("xx4");
		queue.add("xx5");
		queue.add("xx6");
		
		System.out.println(queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queue();
	}

}
