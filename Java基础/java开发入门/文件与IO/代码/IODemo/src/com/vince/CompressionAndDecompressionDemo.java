package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * ѹ�����ѹ��
 * @author HP
 *
 */

public class CompressionAndDecompressionDemo {

	/**
	 * ѹ��
	 * @param args
	 */
	private static void compression(String zipFileName, File targetFile) {
		System.out.println("����ѹ��...");
		try {
			// Ҫ���ɵ�ѹ���ļ�
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
			BufferedOutputStream bos = new BufferedOutputStream(out);
			zip(out,targetFile,targetFile.getName(),bos);
			bos.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ѹ�����");
	}
	
	private static void zip(ZipOutputStream zOut, File targetFile, String name, BufferedOutputStream bos) throws IOException {
		// ����Ǹ�Ŀ¼
		if(targetFile.isDirectory()) {
			File[] files = targetFile.listFiles();
			if(files.length==0) {//���ļ���
				zOut.putNextEntry(new ZipEntry(name+"/"));// �����Ŀ¼
			}
			for(File f:files) {
				//�ݹ鴦��
				zip(zOut,f,name+"/"+f.getName(),bos);
			}
		} else {
			zOut.putNextEntry(new ZipEntry(name));
			InputStream in = new FileInputStream(targetFile);
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len=bis.read(bytes))!=-1) {
				bos.write(bytes,0,len);
			}
			bis.close();
		}
	}
	
	/**
	 * ��ѹ
	 * @param args
	 */
	private static void decompression(String targetFileName, String parent) {
		try {
			//�����ѹ��������
			ZipInputStream zIn = new ZipInputStream(new FileInputStream(targetFileName));
			ZipEntry entry = null;
			File file = null;
			while((entry=zIn.getNextEntry())!=null && !entry.isDirectory()) {
				file = new File(parent,entry.getName());
				if(!file.exists()) {
					new File(file.getParent()).mkdir();//�������ļ����ϼ�Ŀ¼
				}
				OutputStream out = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				byte[] bytes = new byte[1024];
				int len = -1;
				while((len=zIn.read(bytes))!=-1) {
					bos.write(bytes,0,len);
				}
				bos.close();
				System.out.println(file.getAbsolutePath()+" ��ѹ�ɹ�");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		compression("E:\\test.zip",new File("E:\\test"));
		decompression("E:\\test.zip","E:\\");
	}

}
