import java.io.*;

public class lab1_zad1 {

	public static void main(String[] args)throws IOException {
		File izvor = new File("C:\\Users\\Aleksandar\\Desktop","izvor.txt");
		System.out.println(izvor.createNewFile());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new FileWriter(izvor.getAbsolutePath(),true));  // OVDE MORA DA IMA TRUE ZATOA SO NA SEKOE IZVRSUVANJE IZVORNATA CELOSNO SE KOPIRA
		
		System.out.println("vnesete sodrzina ");
		
		String tekst = in.readLine();
		out.write(tekst);
		in.close();
		out.close();
		
		File dest = new File("C:\\Users\\Aleksandar\\Desktop","destinacija.txt");
		System.out.println(dest.createNewFile());
		
		FileInputStream vlez = null;
		RandomAccessFile izlez = null;
		
		
		try {
			vlez = new FileInputStream(izvor.getAbsolutePath());                 
			izlez = new RandomAccessFile(dest.getAbsolutePath(), "rw");         // So RandomAccess
			
			//izlez.setLength(izvor.length());
			long position = izvor.length();
			
			int c;
			
			while((c = vlez.read()) != -1) {
				position--;
				izlez.seek(position);
				izlez.write(c);                               // ako ova e byte po byte togaj moze i vaka ama mislam deka e!
			} 
			
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		/*	StringBuilder sb = new StringBuilder();            So StringBuilder ke padne za golemi fajlovi
 			int c;
			while((c = vlez.read()) != -1) {
				char znak = (char) c;
				sb.append(znak);
			}
			sb.reverse();
			izlez.write(sb.toString().getBytes()); */
		}
		finally{
			if(vlez != null) {
				vlez.close();
			}
			if(izlez != null) {
				izlez.close();
			}
		}
		

	}

}
