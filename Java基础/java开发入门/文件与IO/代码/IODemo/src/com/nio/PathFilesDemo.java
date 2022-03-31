package com.nio;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

/**
 * JDK1.7�µ��ļ�������
 * Path�ӿ�
 * Paths��
 * Files��
 * @author HP
 *
 */

public class PathFilesDemo {

	public static void main(String[] args) {
		File file = new File("c:\\test\\3DO.jpg");
		
		//path
		Path p1 = Paths.get("c:\\test","3DO.jpg");
		System.out.println(p1);
		
		Path p2 = file.toPath();
		System.out.println(p2);
		
		Path p3 = FileSystems.getDefault().getPath("c:\\test", "3DO.jpg");
		
		// Files������
		Path p4 = Paths.get("c:\\test\\vince.txt");
		String info = "xxx";
		try {
			// д���ļ�
			Files.write(p4, info.getBytes("gb2312"), StandardOpenOption.APPEND);
		} catch (UnsupportedEncodingException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		// ��ȡ�ļ�
		try {
			byte[] bytes = Files.readAllBytes(p4);
			System.out.println(bytes);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		
		// �����ļ�
		try {
			Files.copy(p3, Paths.get("c:\\3DO.jpg"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		// �ƶ��ļ�
		try {
			Files.move(p3, Paths.get("c:\\3DO.jpg"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// ɾ���ļ�
//		try {
//			Files.delete(p3); // static boolean deleteIfExists(Path path)
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		// ������Ŀ¼���������һ�������������������Ѵ��ڵ�
//		try {
//			Files.createDirectory(Paths.get("c:\\BB"));
//			//Files.createDirectories(Path);�����༶�����ڵ�Ŀ¼
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		// �����ļ�
		try {
			Files.createFile(Paths.get("c:\\BB.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ���ǰ/��׺������ʱ�ļ�����ʱĿ¼
//		Path newPath = File.createTempFile(dir, prefix, suffix);
//		Path newPath = Files.createTempDirectory(dir, prefix);
	}

}
