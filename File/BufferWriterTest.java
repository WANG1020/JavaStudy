package FFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterTest {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		FileWriter fw=null;
		BufferedWriter bw=null;
		
		FileReader fr=null;
		BufferedReader br=null;
		StringBuffer sbf=new StringBuffer();
		try {
			//创建一个FileWrite对象
			fw=new FileWriter("D:\\MyFile\\Hello1.txt");
			bw=new BufferedWriter(fw);
			bw.write("今天星期八");
			bw.write("明天星期二");
			bw.newLine();
			bw.write("快上课了");
			bw.newLine();
			bw.write("神殿");
			bw.flush();
			System.out.println("ok");
			
			//创建一个FileReader对象
			fr=new FileReader("D:\\MyFile\\Hello1.txt");
			br=new BufferedReader(fr);
			String line=br.readLine();
			while(line!=null) {
				sbf.append(line);
				line=br.readLine();
			}
			System.out.println(sbf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
