package com.vince.ex;

/**
 * �Զ����쳣ͨ������ͨ���̳�һ���쳣����ʵ��
 * 1.Throwable
 * 2.Exception
 * 3.RuntimeException
 * @company
 * �Զ����쳣��ʵ���ǣ��ṩ���췽��
 * �쳣��������û��ʵ�ʹ��ܣ�ֻ��һ��������ı�ʶ
 * @author Journey
 * @description
 */

public class MyException extends Exception{
	public MyException() {
		super();
	}
	public MyException(String message) {
		super(message);
	}
}
