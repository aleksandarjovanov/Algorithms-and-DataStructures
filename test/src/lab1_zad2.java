import java.io.*;
public class lab1_zad2 {

	public static void main(String[] args)throws IOException{
		
		File izvor = new File("C:\\Users\\Aleksandar\\Desktop","izvor.txt");
		izvor.createNewFile();
		
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter cout = new BufferedWriter(new FileWriter(izvor.getAbsolutePath(),true));  // na sekoe novo izvrsuvanje da se nadovre tekstot i celata odnovo ke se kopira
		
		
		System.out.println("vnesete sodrzina");
		String s = "";
		while(!s.equals("kraj")) {
		s = cin.readLine();
		cout.write(s);
		}
		cin.close();
		cout.close();
		
		File destinacija = new File("C:\\Users\\Aleksandar\\Desktop","destinacija.txt");   // now i need 2 new Stream for reading from a sorc.txt file and writing in a dest.txt
 		
		BufferedReader input = null;
		BufferedWriter output = null;
		
		try {
			input = new BufferedReader(new FileReader(izvor.getAbsolutePath()));
			output = new BufferedWriter(new FileWriter(destinacija.getAbsolutePath()));
			
			String line;
			StringBuilder sb = new StringBuilder();
			while((line = input.readLine()) != null){
				sb.append(line);
			}
			sb.reverse();
			output.write(sb.toString());
			
		}
		finally {
			if(input != null) {
				input.close();
			}
			if(output != null) {
				output.close();
			}
		}
		
	}

}
