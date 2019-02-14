import java.io.*;
public class septemvri_2015 {

	public static void main(String[] args)throws IOException {//////////////////////////////////
		
		work("C:\\Users\\Aleksandar\\Desktop\\toto","C:\\Users\\Aleksandar\\Desktop\\jojo");
	}
	
	public static void work(String in_value, String out_value)throws IOException{/////////////////////////////////////
		File in = new File(in_value);
		File out = new File(out_value);
		File rezult = new File(out_value,"big.bin");
		
		if(!in.exists()) {
			System.out.println("ne postoi");
			return;
		}
		if(!out.exists()) {
			out.mkdirs();
		}
		else {
			rekurzivnoBrisenje(out);
		}
		
		if(!rezult.exists())
			rezult.createNewFile();
		
		File [] files = in.listFiles();
		
		for(File f : files) {
			
			float size = (float)f.length() / 1024;
			
			if(f.isFile() && f.getName().endsWith(".txt")) {
				if(size < 10) {
					copy(f,out);
				}
				else {
					File tmp = new File(in, "b.bin");
					tmp.createNewFile();
					
					ReadFromSourceToDestination(rezult, tmp);
					rezult.delete();
					rezult.createNewFile();
					
					ReadFromSourceToDestination(f, rezult);
					
					readFromSourceAppendToDestination(tmp,rezult);
					tmp.delete();
					
				}
			}
			else if(f.isDirectory()) {
				work(f.getAbsolutePath(), out.getAbsolutePath());
			}
		}
		
	}
	public static void rekurzivnoBrisenje(File out)throws IOException {//////////////////////////////////////////////
		
		File [] files = out.listFiles();
		
		for(File f : files) {
			if(!f.isDirectory()) {
				f.delete();
			}
			else {
				rekurzivnoBrisenje(f);
				f.delete();
			}
		}
	}
	public static void copy(File f, File out)throws IOException{///////////////////////////
		File newf = new File(out.getAbsolutePath(), f.getName());
		
		if(newf.exists()) {
			System.out.println("veke postoi");
		}
		else {
			newf.createNewFile();
			
			BufferedReader bin = null;
			BufferedWriter bout = null;
			
			try {
				bin = new BufferedReader(new FileReader(f.getName()));
				bout = new BufferedWriter(new FileWriter(out.getName()));
				
				String line;
				while((line = bin.readLine()) != null) {
					bout.write(line+"\n");
				}
			}
			finally {
				if(bin != null) {
					bin.close();
				}
				if(bout != null) {
					bout.close();
				}
			}
			
		}
	}
	public static void ReadFromSourceToDestination(File source, File destination)throws IOException{
		
		FileInputStream fis = null;
		FileOutputStream fout = null;
		try {
			fis = new FileInputStream(source);
			fout = new FileOutputStream(destination);
			
			int b = 0;
			
			while((b = fis.read()) != -1) {
				fout.write(b);
			}
		}
		finally {
			if(fis != null)
				fis.close();
			if(fout != null) {
				fout.close();
			}
		}
		
		
		
		
	}
	public static void readFromSourceAppendToDestination(File source, File destination)throws IOException{
		
		FileInputStream fis = null;
		FileOutputStream fout = null;
		try {
			fis = new FileInputStream(source);
			fout = new FileOutputStream(destination,true);
			
			int b = 0;
			
			while((b = fis.read()) != -1) {
				fout.write(b);
			}
		}
		finally {
			if(fis != null)
				fis.close();
			if(fout != null) {
				fout.close();
			}
		}
		
		
		
		
	}
}
