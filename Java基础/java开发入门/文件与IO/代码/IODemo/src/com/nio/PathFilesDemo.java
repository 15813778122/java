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
 * JDK1.7新的文件操作类
 * Path接口
 * Paths类
 * Files类
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
		
		// Files工具类
		Path p4 = Paths.get("c:\\test\\vince.txt");
		String info = "xxx";
		try {
			// 写入文件
			Files.write(p4, info.getBytes("gb2312"), StandardOpenOption.APPEND);
		} catch (UnsupportedEncodingException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		// 读取文件
		try {
			byte[] bytes = Files.readAllBytes(p4);
			System.out.println(bytes);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		
		// 复制文件
		try {
			Files.copy(p3, Paths.get("c:\\3DO.jpg"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		// 移动文件
		try {
			Files.move(p3, Paths.get("c:\\3DO.jpg"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 删除文件
//		try {
//			Files.delete(p3); // static boolean deleteIfExists(Path path)
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		// 创建新目录，除了最后一个部件，其他必须是已存在的
//		try {
//			Files.createDirectory(Paths.get("c:\\BB"));
//			//Files.createDirectories(Path);创建多级不存在的目录
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		// 创建文件
		try {
			Files.createFile(Paths.get("c:\\BB.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 添加前/后缀创建临时文件或临时目录
//		Path newPath = File.createTempFile(dir, prefix, suffix);
//		Path newPath = Files.createTempDirectory(dir, prefix);
	}

}
