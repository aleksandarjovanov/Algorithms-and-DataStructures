import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.*;

/* Да се напише Java програма која со користење на I/O стримови ќе ја прочита 
 * содржината на датотеката izvor.txt, а потоа нејзината содржина ќе ја испише
 *  превртена во празната датотека destinacija.txt. Читањето и запишувањето 
 *  реализирајте го со стримови кои работат бајт по бајт.
 *  Напомена: Сами креирајте ги овие две датотеки и пополнете ја izvor.txt со 
 *  произволна содржина.*/
public class zad2_preresena {

	public static void main(String[] args)throws IOException {
		File from = new File("C:\\Users\\Aleksandar\\Desktop\\java\\pro.txt");
		File to = new File("C:\\Users\\Aleksandar\\Desktop\\out\\dest.txt");
		
		FileInputStream in = null;
		RandomAccessFile out = null;
		
		try {
			in = new FileInputStream(from);
			out = new RandomAccessFile(to,"rw");
			
			long position = from.length() - 1;
			int c = 0;
			while((c = in.read()) != -1) {
				out.seek(position);
				out.write(c);
				position --;
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
