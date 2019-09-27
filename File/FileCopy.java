package FFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Software.niit.Fish;

public class FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		FileOutputStream fos=null;
		try {
			//1.创建输入流，负责读取D:/HelloWord.txt
			fis=new FileInputStream("D:/HelloWord.txt");
			//2.创建输出流，
			fos=new FileOutputStream("D:/MyFile/Hello.txt");
			//3.创建中转站
			byte[] bytes=new byte[1024];
			//4.通过循环实现文件读取
			int count=0;
			//while(fis.read()!=-1) {
				fis.read(bytes);
				count++;
				fos.write(bytes,0,bytes.length);
			//}
			System.out.println(count);
			System.out.println("复制文件成功!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
