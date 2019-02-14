/*Потребно е да ја имплементирате функцијата manage(String in, String out) која врши организација на 
 *текстуалните датотеки (*.dat) од именикот in според нивните привилегии на следниот начин:

доколку датотеката има привилегии за запишување тогаш таа треба да се премести во out именикот. 
При преместувањето, во конзола испечатете pomestuvam и апсолутното име на датотеката која се копира.

доколку датотеката нема привилегии за запишување тогаш нејзината содржина додадете ја на крај од датотеката 
writable-content.txt во resources именикот. При додавањето, во конзола испечатете dopisuvam и апсолутното име 
на датотеката. Сметајте дека овие датотеки може да бидат многу поголеми од физичката меморија на компјутерот.

доколку датотеката е скриена (hidden), тогаш избришете ја од in именикот, и во конзола испечатете zbunet sum и 
апсолутното име на датотеката.
Доколку in именикот не постои, испечатете на екран ne postoi.

Доколку out именикот веќе постои, избришете ја неговата содржина. Претпоставете дека во out именикот има само датотеки.*/
import java.io.*;
public class zad8_preresena {
	public static void copy(File f, File rec)throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream(f);
			out = new FileOutputStream(rec,true);
			
			int c = 0;
			while((c = in.read()) != -1) {
				out.write(c);
			}
		}
		finally {
			if(in != null)
				in.close();
			if(out != null)
				out.close();
		}
	}
	public static void manage(File in, File out)throws IOException{
		File rec = new File("C:\\Users\\Aleksandar\\Desktop\\test.txt"); 
		
		File [] files = in.listFiles();
		for(File f : files) {
			if(!f.isDirectory()) {
				if(f.isFile() && f.getName().endsWith(".txt") && f.canWrite()) {
					f.renameTo(new File(out,f.getName()));
					System.out.println("pomestuvam " + f.getAbsolutePath());
				}
				else if(f.isFile() && f.getName().endsWith(".txt") && !f.canWrite()) {
					copy(f,rec);
					System.out.println("dopisuvam"+" "+f.getAbsolutePath());
				}
				else if(f.isHidden()) {
					f.delete();
					System.out.println("Zbunet sum");
				}
			}
			else {
				manage(f,out);
			}
		}
		
	}
	public static void main(String[] args)throws IOException {
		File in = new File("C:\\Users\\Aleksandar\\Desktop\\java");
		File out = new File("C:\\Users\\Aleksandar\\Desktop\\out");
		
		if(out.exists()) {
			delete(out);
		}
		manage(in,out);
	}
	public static void delete(File out) {
		
		File [] files = out.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				f.delete();
			}
			else {
				delete(f);
				f.delete();
			}
		}
	}
}
