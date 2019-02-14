import java.io.*;
public class ispitna_juni {

	public static void main(String[] args)throws IOException{
		File in = new File("C:\\Users\\Aleksandar\\Desktop\\jojo");
		File out = new File("C:\\Users\\Aleksandar\\Desktop\\toto");
		File rec = new File("C:\\Users\\Aleksandar\\Desktop\\test.txt");
		
		if(in.exists()) {
			
			if(out.exists()) {
				File [] files = out.listFiles();
				for(File f : files) {
					f.delete();
				}
			}
			else {
				out.mkdirs();
			}
			
			File [] files = in.listFiles();
			
			for(File f : files) {
				if(f.getName().endsWith("txt") && f.canWrite()) {
					System.out.println("pomestuvam"+" "+f.getAbsolutePath());
					f.renameTo(new File(out.getAbsoluteFile()+"\\"+f.getName()));
				}
				else {
					if(!f.isDirectory()){
						FileInputStream fis = null;
						FileOutputStream fout = null;
						try {
							fis = new FileInputStream(f.getAbsolutePath());
							fout = new FileOutputStream(rec.getAbsolutePath(),true);
							
							int c;
							while((c = fis.read()) != -1) {
								fout.write(c);
							}
							System.out.println("dopisuvam"+" "+f.getAbsolutePath());
						}
						finally {
							if(fis != null)
								fis.close();
							if(fout != null)
								fout.close();
						}
					}
					
				}
				if(f.isHidden()) {
					f.delete();
					System.out.println("zbunet sum"+" "+f.getAbsolutePath());
				}
				 
			}

			
		}
		else {
			System.out.println("ne postoi");
		}
	}

}
