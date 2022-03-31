package com.vince;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Collection�ӿ�:���ڴ��浥������ļ���
 * List�ӿڣ�
 * 1.����ģ������ظ�
 * 2.������nullԪ��
 * 3.�о����ʵ���࣬���õģ�ArrayList��Vector��LinkedList
 * ��ʵ�ʿ����У��������ѡ��list�ľ���ʵ�֣�
 * 1.��ȫ������
 * 2.�Ƿ�Ƶ�����룬ɾ������(LinkedList)
 * 3.�Ƿ��Ǵ洢�����
 * @author HP
 *
 */

public class ListDemo {
	
	/**
	 * LinkedList
	 * 1.ʵ��ԭ������˫������ṹʵ��
	 * 2.�ʺϲ��룬ɾ�����������ܸ�
	 */
	private static void linkedList() {
		LinkedList<String> list = new LinkedList<>();
		list.add("����ʦ");
		list.add("����ʦ");
		list.add("����ʦ");
		list.add("����ʦ");
		list.add("����ʦ");
		// ��������
		int size = list.size();
		for(int i = 0;i<size;i++) {
			System.out.println(list.get(i));
		}
	}
	
	/**
	 * Vector
	 * 1.ʵ��ԭ�����ö�̬��������ʵ�֣�Ĭ�Ϲ��췽��������һ����СΪ10�Ķ�������
	 * 2.�����㷨��������Ϊ0ʱ������Ϊԭ����С��2��������������0ʱ������Ϊԭ����С+����
	 * 3.���ʺϽ���ɾ����������
	 * 4.Ϊ�˷�ֹ���鶯̬����������࣬���鴴��Vectorʱ��������ʼ����
	 * 5.�̰߳�ȫ���ʺ��ڶ��̷߳���ʱʹ�ã��ڵ��߳���ʹ��Ч�ʽϵ�
	 */
	private static void vector() {
		Vector<String> v = new Vector<>();
		v.add("����ʦ");
		v.add("����ʦ");
		v.add("����ʦ");
		v.add("����ʦ");
		v.add("����ʦ");
		for(int i = 0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
	}
	
	/**
	 * ArrayList
	 * 1.ʵ��ԭ�����ö�̬��������ʵ�֣�Ĭ�Ϲ��췽��������һ��������
	 * 2.��һ�����Ԫ�أ���չ����Ϊ10��֮��������㷨��ԭ�������С+ԭ�������һ��
	 * 3.���ʺϽ���ɾ����������
	 * 4.Ϊ�˷�ֹ���鶯̬����������࣬���鴴��ArrayListʱ��������ʼ����
	 * 5.���߳����̲߳���ȫ���ʺ��ڵ��̷߳���ʱʹ�ã�Ч�ʽϸ�
	 * JDK1.2��ʼ
	 * @param args
	 */
	private static void arrayList() {
		// ʹ�ü������洢�����ͬ���͵�Ԫ��(����),��ô�ڴ���ʱ��Ƚ��鷳����ʵ�ʿ����У�������
		// ����ʹ�ã�����Ӧ����һ�������д洢��ͬ�����Ͷ���
		List<String> list = new ArrayList<>();
		list.add("����ʦ");
		list.add("����ʦ");
		list.add("����ʦ");
		list.add("����ʦ");
		list.add("����ʦ");
		// ��������
		int size = list.size();
		for(int i = 0;i<size;i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println(list.contains("����ʦ"));
		list.remove("����ʦ");
		System.out.println(list.size());
		
		String[] arrary = list.toArray(new String[] {});
		for(String s:arrary	) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arrayList();
	}

}
