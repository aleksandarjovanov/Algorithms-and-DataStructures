import java.io.*;
public class testSeek {

public static void invertLargeFile(String source, String destination) throws IOException{
		
		File s = new File(source);
		File d = new File(destination);
		
		
		//FileInputStream fis = null;
		//FileOutputStream ois = null;
		RandomAccessFile in = null;
		RandomAccessFile out = null;
		try {
			//fis = new FileInputStream(s);
			in = new RandomAccessFile(s.getAbsolutePath(), "rw");
			out = new RandomAccessFile(d.getAbsoluteFile(), "rw");
		//	ois = new FileOutputStream(d);
			int c;
			long position = s.length();
			while((c = in.read()) != -1) {
				position --;
				out.seek(position);
				//char znak = in.readChar();
				out.write(c);
																														
				
			}
			
		}finally {
			if(in != null) {
				in.close();
			}
			
			if(out != null) {
				out.close();
			}
		}
	}

	public static void main(String[] args) throws IOException{
		
		//moveWritableTxtFiles("C:\\Users\\Viktorija\\Desktop\\Test\\Ace\\Gile", "C:\\Users\\Viktorija\\Desktop\\rez");
		invertLargeFile("C:\\Users\\Aleksandar\\Desktop\\test.txt","C:\\Users\\Aleksandar\\Desktop\\test2.txt");
	}

}
