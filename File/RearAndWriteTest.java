package FFile;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RearAndWriteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInputStream dis=null;
		DataOutputStream out=null;
			FileInputStream fis;
			try {
				fis = new FileInputStream("D:\\MyFile\\BufferReaderTest.class");
				dis=new DataInputStream(fis);
				FileOutputStream fos=new FileOutputStream("D:\\MyFile\\temp.class");
				out=new DataOutputStream(fos);
				int t;
				while((t=dis.readInt())!=-1) {
					out.write(t);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

}
