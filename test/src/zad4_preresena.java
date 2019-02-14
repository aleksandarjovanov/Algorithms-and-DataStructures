import java.io.*;
/*Да се напише Java програма која прима два аргументи: локација на текстуална датотека и збор.
 * Програмата треба да испечати колку пати се сретнува зборот проследен како втор аргумент,
 * во текстуалната датотека проследена како прв аргумент.*/
public class zad4_preresena {
	public static void countWord(File f, String zbor)throws IOException {
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(f));
			
			int count = 0;
			String line;
			while((line = in.readLine()) != null) {
				String [] words = line.split(" ");
				for(String s : words) {
					if(s.equals(zbor))
						count++;
				}
			}
			System.out.println(count);
		}
		finally {
			if(in != null)
				in.close();
		}
	}
	public static void main(String [] args)throws IOException {
	File from = new File("C:\\Users\\Aleksandar\\Desktop\\java\\pro.txt");
	countWord(from,"zbor");
	}
}
