package com.vince;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 序列化：由属性和属性值组成对象的过程叫序列化，反之称为反序列化
 * @author HP
 *
 */

public class ObjetStreamDemo {
	
	/**
	 * 
	 * 对象序列化
	 * 保存或传输都叫对象序列化
	 * 把对象写入文件:实际写入的是类名，属性名，属性类型，属性的值等
	 */
	// 序列化一组对象可采用：对象数组的形式，因为对象数组可以向Object进行转型操作
	private static void writeObjects() {
		Dog dog = new Dog("wangwang",2,"母");
		Dog dog2 = new Dog("wangwang2",3,"公");
		Dog[] dogs = {dog,dog2};
		try {
			File file = new File("c:\\test\\dog.obj");
			OutputStream out = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(dogs);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 反序列化的过程
	 * 从文件中把对象的内容读取出来，还原成对象
	 */
	private static void readObject() {
		File file = new File("c:\\test\\dog.obj");
		try {
			InputStream out = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(out);
			Dog dog = (Dog)ois.readObject();
			ois.close();
			System.out.println(dog);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 对象序列化
	 * 保存或传输都叫对象序列化
	 * 把对象写入文件:实际写入的是类名，属性名，属性类型，属性的值等
	 */
	private static void writeObject() {
		Dog dog = new Dog("wangwang",2,"母");
		try {
			File file = new File("c:\\test\\dog.obj");
			OutputStream out = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(dog);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		writeObject();
	}

}
