package FFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		BufferedReader br=null;
		StringBuffer sbf=new StringBuffer();
		try {
			//创建一个FileReader对象
			fr=new FileReader("D:/MyFile/HelloJava.txt");
			//创建一个BufferedReader对象
			br=new BufferedReader(fr);
			//先读一行
			String line=br.readLine();
			//循环读入
			while(line!=null) {
				sbf.append(line);
				line=br.readLine();
			}
			System.out.println(sbf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
