import java.io.*;

public class ispitna_juni_2015 {

	public static void main(String[] args)throws IOException {
		File f = new File("C:\\Users\\Aleksandar\\Desktop\\out\\destt.txt");
		
		FileInputStream in = null;
	
		try {
			in = new FileInputStream(f.getAbsolutePath());
			
			String buff = "";
			int count = 0;
			int c;
			long i = 3;
			
			in.skip(i*2);
			
			while(count != 2) {
				if((c = in.read()) == -1) {
					break;
				}
				buff = buff + (char)c;
				count++;
			}
			System.out.println(buff);
 			
		}
		finally {
			if(in != null)
				in.close();
		}
		
		
	}

}
