import java.io.*;
import java.io.FileInputStream;

public class testttt {

	public static void main(String[] args)throws IOException{
		File f = new File("C:\\Users\\Aleksandar\\Desktop\\nova.txt");
		
		FileInputStream in = null;
	
		byte [] buff = new byte[10];
		try {
			in = new FileInputStream(f.getAbsolutePath());
			
			
			
			int read = 0;
			char c;
			int off = 0;
			int len = 2;
			long position = 2;
			int counter = 0;
			in.skip(position*2);
			
			while((read = in.read(buff, off, len)) != -1) {
				counter++;
				if(counter == 1) {        						/// DVA PATI KE PROCITA ZA 0 I ZA 1  ovaa treba da se mene zavisi kako e baranjeto na zadacata
					break;
				}
				
				off+=read;
			}
			
			
			for(byte b : buff) {
				 if(b == 0)
		               
		               // if b is empty
		               c = '-';
		            else
		               
		               // if b is read
		               c = (char)b;
		            
		            // prints character
		            System.out.print(c);
			}
 			
		}
		finally {
			if(in != null)
				in.close();
		}
		
		write(5,buff);
		
	}
	public static void write(long i, byte [] obj)throws IOException {
		File f = new File("C:\\Users\\Aleksandar\\Desktop\\test2.txt");
		
		FileOutputStream in = null;
		
		try {
			in = new FileOutputStream (f.getAbsoluteFile(),true);
			
			long position = i * 2;
			
			if(position >= f.length()) {
				
				String nuli = "00";
				byte [] prazen = nuli.getBytes();
				
				int brojPrazni = ((int)position - (int)f.length()) / 2;
				
				for(int j = 0; j < brojPrazni; j++) {
					in.write(prazen);
				}
				
				in.write(obj);
				
			}
			
		}
		finally {
			if(in != null) {
				in.close();
			}
		}
		
		
		
	}
}
