package com.nio;

import java.nio.ByteBuffer;

public class NIODemo {

	public static void main(String[] args) {
		//����һ���ֽڻ������������ڴ�ռ�Ϊ8�ֽ�
		ByteBuffer buf = ByteBuffer.allocate(8);
		
		System.out.println("position="+buf.position());
		System.out.println("limit="+buf.limit());
		System.out.println("capacity="+buf.capacity());
	
		System.out.println("--------");
		
		//�򻺳�����д������
		buf.put((byte)10);
		buf.put((byte)20);
		buf.put((byte)30);
		buf.put((byte)40);
		System.out.println("position="+buf.position());
		System.out.println("limit="+buf.limit());
		System.out.println("capacity="+buf.capacity());
	
		// ��������ת
		buf.flip();
		System.out.println("--------");
		System.out.println("position="+buf.position());
		System.out.println("limit="+buf.limit());
		System.out.println("capacity="+buf.capacity());
		// ��֪�ڵ�ǰλ�ú�����֮���Ƿ���Ԫ��
		if(buf.hasRemaining()) {
			//���ص�ǰλ��������֮���Ԫ����
			for(int i = 0;i<buf.remaining();i++) {
				byte b = buf.get(i);
				System.out.println(b);
			}
		}
	}

}
