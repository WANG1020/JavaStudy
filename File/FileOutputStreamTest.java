package FFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class FileOutputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos=null;
		String str="who are you?what,why??";
		byte[] bytes=str.getBytes();
		try {
			fos=new FileOutputStream("D:\\MyFile\\HelloJava.txt",true);//加了true是在原来的后面添加文本
			fos.write(bytes,0,bytes.length);
			System.out.println("写文件成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
