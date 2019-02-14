
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class kolokviumska_grupa1 {

	public static void main(String[] args) throws IOException{
		String from = "C:\\Users\\Aleksandar\\Desktop\\jojo"; 
		String to = "C:\\Users\\Aleksandar\\Desktop\\toto"; 
		String source = "C:\\Users\\Aleksandar\\Desktop\\test.txt"; 
		
		 int elementLength = 3;
		 ArrayList<byte[]> al = new ArrayList<>();
		
		 deserializeData(source, al, elementLength);
		
		//moveWritableTxtFiles(from, to);
	}
	public static void deserializeData(String source, List<byte[]> data, long elementLength)throws IOException{
		File sourceFile = new File(source);
		FileInputStream input = new FileInputStream(source);
		
		try {
			long n = elementLength;
			byte [] niza = new byte[(int) n];
			int c = 0;   /// broj na procitani bajti
			
			while(true) {
				while(c<niza.length) {
					c = input.read(niza);
					
					if(c == -1) {
						return;
					}
				}
				System.out.println(niza);
				data.add(niza);
				c = 0;
			}
			
		}
		finally {
			
			if(input != null)
				input.close();
		}
		
	}
	
	public static void moveWritableTxtFiles(String from, String to)throws IOException {
		
		File f = new File(from);
		File t = new File(to);
		
		if(f.exists()) {
			if(!t.exists()) {
				t.mkdirs();
			}
			
			File [] files = f.listFiles();
			
			for(File b : files) {
				if(b.getName().endsWith(".txt") && b.canWrite()) {
					b.renameTo(new File(t.getAbsolutePath()+"\\"+b.getName()));
				}
			}
			
			
		}
		else {
			System.out.println("ne postoi");
			return;
		}
	}

}
