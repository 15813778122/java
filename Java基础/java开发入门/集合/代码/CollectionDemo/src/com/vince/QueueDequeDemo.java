package com.vince;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Queue�ӿڣ����У���һ���Ƚ��ȳ����������ݽṹ(�Ŷ�)
 * LinkedList��ʵ����queue�ӿ�
 * ������У���Ϣ���У�����
 * 
 * Deque�ӿڣ�˫�˶���
 * Stack:��ջ���Ƚ����
 * @author HP
 *
 */

public class QueueDequeDemo {
	
	private static void stack() {
		Stack s = new Stack();
		s.push("lily");
		s.push("tom");
		s.push("zizi");
		
		System.out.println(s.peek());//�鿴�����Ԫ��
		System.out.println(s.pop());//�鿴��ɾ�������Ԫ��
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
