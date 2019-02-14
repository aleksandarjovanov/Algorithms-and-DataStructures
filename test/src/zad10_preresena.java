import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*Со користење на Java I/O да се имплементираат следните методи од класата ExamIO:

(10 поени) moveWritableTxtFiles(String from, String to)
Ги преместува сите датотеки со екстензија .txt од именикот зададен преку from аргументот, 
во именикот зададен преку to аргументот, кои имаат привилегија за запишување. 
Доколку не постои именикот from да се испише "Ne postoi", a aко не постои именикот to, 
потребно е да се креира.

(10 поени) void deserializeData(String source, List<byte[]> data, long elementLength)
Ја исчитува содржината на датотеката source, која содржи голем број податоци,
 сите со иста должина во бајти, без никаков делимитер. Секој од податоците има должина 
 зададена со elementLength. Исчитаните податоци да се запишат во листата зададена преку 
 аргументот data (data.add(readElement)).
 
(Бонус 5 поени) void invertLargeFile(String source, String destination)
Содржината од датотеката source ја запишува во обратен редослед (карактер по карактер) во 
датотеката destination. Содржината на датотеката source е многу голема и не ја собира во меморија.*/
public class zad10_preresena {
	public static void deserializeData(File source, ArrayList<byte[]> data, long elementLength)throws IOException {
		FileInputStream in = null;
		
		try {
			in = new FileInputStream(source);
			int numOfReadedBytes = 0;
			
			while(numOfReadedBytes < source.length()) {
				
				int off = 0;
				int len = (int)elementLength;
				int read = 0;
				byte [] b = new byte[len];
			
				while((read = in.read(b, off, len)) != -1){
					data.add(b);
					
					off += read;
					len -= read;
					
					numOfReadedBytes += read;
					
					for(int i = 0; i < b.length; i++) {
						System.out.print((char)b[i]);
					}
					System.out.println();
					break;
				}
				
			}
		}
		finally {
			if(in != null)
				in.close();
		}
	}
	public static void moveWritableTxtFiles(File from,File to)throws IOException {
		File [] files = from.listFiles();
		for(File f : files){
			if(f.isFile()) {
				if(f.getName().endsWith(".txt") && f.canWrite()) {
					f.renameTo(new File(to,f.getName()));
				}
			}
			else {
				moveWritableTxtFiles(f,to);
			}
		}
	}
	public static void main(String[] args)throws IOException {
		File from = new File("C:\\Users\\Aleksandar\\Desktop\\java\\pro.txt");
		File to = new File("C:\\Users\\Aleksandar\\Desktop\\out\\destt.txt");
		if(from.exists()) {
			//moveWritableTxtFiles(from, to);
			
			if(!to.exists())
				to.mkdirs();
			
			ArrayList<byte[]> data = new ArrayList<byte[]>();
			
			long elementLength = 3;
			File src = new File("C:\\Users\\Aleksandar\\Desktop\\out\\destt.txt");
			deserializeData(src, data, elementLength);
			
		}else
			System.out.println("ne postoi");
	}

}
