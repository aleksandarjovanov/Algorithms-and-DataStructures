import java.io.*;
public class lab1_zad4 {
	
	public static double prosekPoStudent(String line)throws IOException{
		String [] niza = line.split("\\,");
		double prosek = 0;
		int zbir = 0;
		zbir = Integer.parseInt(niza[1]) + Integer.parseInt(niza[2]) + Integer.parseInt(niza[3]);
		prosek = zbir / 3.0;
		
		return prosek;
	}
	public static void prosekPoPredmet(String path)throws IOException{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(path));
			String line;
			int brojac = 0;
			int zbirKrs = 0, zbirNrs = 0, zbirAok = 0;
			in.readLine();
			
			while((line = in.readLine()) != null) {
				String[]niza = line.split("\\,");
				brojac ++;
				zbirKrs += Integer.parseInt(niza[1]);
				zbirNrs += Integer.parseInt(niza[2]);
				zbirAok += Integer.parseInt(niza[3]);
			}
			double prosekKrs = zbirKrs/(1.0 * brojac);
			double prosekNrs = zbirNrs/(1.0 * brojac);
			double prosekAok = zbirAok/(1.0 * brojac);
			
			System.out.println("Prosecnata ocenka na studentite po predmetot KRS e: "+prosekKrs);
			System.out.println("Prosecnata ocenka na studentite po predmetot NRS e: "+prosekNrs);
			System.out.println("Prosecnata ocenka na studentite po predmetot AOK e: "+prosekAok);
		}
		finally {
			if(in != null){
				in.close();
			}
		}
		
	}

	public static void main(String[] args)throws IOException{
		File f =  new File("C:\\Users\\Aleksandar\\Desktop\\izvor.csv");
		
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(f.getAbsolutePath()));
			
			in.readLine();
			String line = "";
			while((line = in.readLine()) != null) {
				double prosek = prosekPoStudent(line);
				System.out.println("Prosekot za studentot "+line.split("\\,")[0]+" e: "+ prosek);
			}
			
			prosekPoPredmet(f.getAbsolutePath());
		}
		finally {
			if(in != null) {
				in.close();
			}
		}
		convertToTsv(f.getAbsolutePath());
	}
	public static void convertToTsv(String path)throws IOException {
		File f2 = new File("C:\\Users\\Aleksandar\\Desktop\\destinacija.tsv");
		f2.createNewFile();
		
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader(path));
			out = new BufferedWriter(new FileWriter(f2.getAbsolutePath()));
			
			String line = "";
			while((line = in.readLine()) != null) {
				out.write(line);
			}
			
		}
		finally {
			if(in != null)
				in.close();
			if(out != null)
				out.close();
		}
	}

}
