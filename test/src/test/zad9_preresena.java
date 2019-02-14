package test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/*Со користење на Java I/O да се имплементираат следните методи од класата ExamIO:

(10 поени)void copyLargeTxtFiles(String from, String to, long size)
Ги копира сите датотеки со екстензија .txt од именикот зададен преку from аргументот, во 
именикот зададен преку to аргументот, кои се поголеми од вредноста на size аргументот (во бајти). 
Доколку не постои именикот from да се испише "Ne postoi", a aко не постои именикот to, потребно е да се креира.

(10 поени)void serializeData(String destination, List<byte[]> data)
Низата од податоци зададени со data ја запишува во датотеката destination, без никакви делимитери 
(како континуиран тек од бајти). Сите елементи на листата data имаат иста должина (ист број бајти).

(Бонус 5 поени)byte[] deserializeDataAtPosition(String source, long position, long elementLength)
Го исчитува и враќа податокот на позицијата position од датотеката source, која содржи голем број податоци, 
сите со иста должина во бајти, без никаков делимитер. Секој од податоците има должина зададена со elementLength. 
При имплементацијата да не се чита содржината на целата датотека.*/
public class zad9_preresena {
	public static void copy(File f, File dest)throws IOException{
		BufferedReader in = null;
		BufferedWriter out = null;
		
		try {
			in = new BufferedReader(new FileReader(f));
			out = new BufferedWriter(new FileWriter(dest));
			
			String line;
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
	public static void copyLargeTxtFiles(File from, File to, long size)throws IOException {
		
		File [] files = from.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				if(f.length() > size) {
					File dest = new File(to,f.getName());
					dest.createNewFile();
					copy(f,dest);
				}
			}
			else {
				copyLargeTxtFiles(f,to,size);
			}
		}
	}
	public static void serializeData(File destination, List<byte[]> data)throws IOException {
		
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(destination);
			
			for(byte [] b : data) {
				out.write(b);
			}
		}
		finally {
			if(out != null)
				out.close();
		}
	}
	public static void deserializeDataAtPosition(File dest, long position, long elementLength )throws IOException{
		FileInputStream in = new FileInputStream(dest);
		
		int element = (int)(position-1) * (int)elementLength;
		in.skip(element);
		
		byte [] b = new byte [(int)elementLength];
		in.read(b);
		
		for(int i = 0; i < elementLength; i++) {
			System.out.println((char)b[i]);
		}
		
		if(in != null)
			in.close();
	}
	public static void main(String [] args)throws IOException {
		File from = new File("C:\\Users\\Aleksandar\\Desktop\\java");
		File to = new File("C:\\Users\\Aleksandar\\Desktop\\out");
		
		int size = 10;
		//copyLargeTxtFiles(from, to, size);
		
		File dest = new File("C:\\Users\\Aleksandar\\Desktop\\out\\destt.txt");
		ArrayList<byte[]> data = new ArrayList<byte[]>();
		byte [] niza = {68,69,70,71}; 
		byte [] niza1 = {72,73,74,75}; 
		byte [] niza2 = {76,77,78,79}; 
		byte [] niza3 = {80,81,82,83}; 
		data.add(niza);
		data.add(niza1);
		data.add(niza2);
		data.add(niza3);
		//serializeData(dest,data);
		deserializeDataAtPosition(dest,3,3);
	}

}
