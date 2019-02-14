import java.io.*;
public class lab1_zad3 {
	
	public static void countWord(String path, String word)throws IOException{
		BufferedReader in = null;
		int count = 0;
		try {
			in = new BufferedReader(new FileReader(path));
			
			String line = "";
			
			while((line = in.readLine()) != null) {
				String [] words = line.split(" ");
				for(String w : words) {
					if(w.equals(word)) {
						count++;
					}
				}
			}
		}
		finally {
			if(in != null)
				in.close();
		}
		System.out.println(count);
	}

	public static void main(String[] args)throws IOException{
		File f = new File("C:\\Users\\Aleksandar\\Desktop\\izvor.txt");
		countWord(f.getAbsolutePath(),"toleto");

	}

}
