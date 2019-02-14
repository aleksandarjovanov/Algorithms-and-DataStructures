import java.io.*;
public class posledna {

	public static void main(String[] args)throws IOException {
		String in ="C:\\Users\\Aleksandar\\Desktop\\toto";
		String out ="C:\\Users\\Aleksandar\\Desktop\\jojo";
		
		File fin = new File(in);
		File fout = new File(out);
		
		if(!fin.exists()) {
			System.out.println("prazno");
			return;
		}
		
		if(!fout.exists()) {
			fout.mkdirs();
		}
		else {
		File [] files = fout.listFiles();
		
			for(File f : files) {
				f.delete();
			}
		}
		
		work(in, out);

	}
	
	public static void work(String in, String out)throws IOException {
		File fin = new File(in);
		File fout = new File(out);
		

			
		int numFiles = countFiles(fin);
		
		File [] files = fin.listFiles();
		for(File f : files) {
			
			if(f.isFile()) {
				if(numFiles > 5) {
				
					if(f.isFile()) {
						f.delete();
					}
				}
				else {
					if(f.isFile()) {
						f.renameTo(new File(fout.getAbsolutePath()+"\\"+f.getName()));
					}
				}
			}
			else {
				work(f.getAbsolutePath(), fout.getAbsolutePath());
			}
		}	
	}
	
	public static int countFiles(File fin)throws IOException{
		
		File [] files = fin.listFiles();
		int count = 0;
		
		for(File f : files) {
			if(f.isFile()) {
				count++;
			}
		}
		
		return count;
	}
	
	

}
