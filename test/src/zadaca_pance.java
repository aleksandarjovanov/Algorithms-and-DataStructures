import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class zadaca_pance {

	public static void main(String[] args)throws IOException {
		String input = "C:\\Users\\Aleksandar\\Desktop\\test2.txt";
		List<byte[]> list = read(input);
		
	    for (byte[] element : list) {
	        System.out.print("[");
	        for (byte b : element) {
	          System.out.print((char)b);
	          System.out.print(" ");
	        }
	        System.out.println("]");
	      }
	}
	
	public static List<byte []> read(String input) throws IOException{
		
		File f = new File(input);
		
		List<byte[]> result = new ArrayList<>();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(f.getAbsoluteFile());
			
			int c;
			int len;
			
			while((c = fis.read()) != -1) {
				
				len = Character.getNumericValue((char) c);
				byte [] b = new byte[len];
				
				for(int i = 0; i < len; i++) {
					b[i] = (byte)fis.read();
				}
				result.add(b);
			}
			
			
		}
		finally {
			if(fis != null)
				fis.close();
			
		}
		return result;
	}

}
