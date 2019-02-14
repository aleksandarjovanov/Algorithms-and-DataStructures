import java.io.*;
public class baza {

	public static void main(String[] args)throws IOException { ///// 2016 SEPTEMVRI
		
		File f = new File("C:\\Users\\Aleksandar\\Desktop\\test2.txt");
		
		int rowNum = 9; 
		byte [] id = {99,100};
		byte [] value = { 105, 106, 107, 108, 109, 110, 111, 112, 113, 114};
		boolean status = true;
		
		//put(f,rowNum,id,value,status);
		get(f,rowNum);
			
	}
	public static void get(File f, int rowNumber)throws IOException {
		int fileRows = (int)(f.length() - 10) / 13; // kako dole
		BufferedReader in = null;
		String s ="";
		int count = -1;      /// vaka mi odgovarase :(
		
		try {
			in = new BufferedReader(new FileReader(f.getAbsolutePath()));
			while(count != rowNumber - 1) {
				s = in.readLine();
				if(s == null)
					break;
				
				count++;
			}
			if(s == null) {
				System.out.println(in.readLine());
			}else {
				if(s.endsWith("0")) {
					System.out.println("prazen objekt");
				}else {
					System.out.println(s);
				}
			}
			
		}
		finally {
			if(in != null)
				in.close();
		}
		
	}
	public static void put(File f,int rowNum, byte[] id, byte[] value, boolean status)throws IOException {
		
		int fileRows = (int)(f.length() - 10) / 13;      /// OVAA  -10  ne treba da e vaka poradi toa so jas sega znam kolku linii si imam u datotekata, eden \n e 2 bajti 6 linii t.e 5 \n * 2 = 10	
		FileOutputStream out = null;
		
		
		try {
			out = new FileOutputStream(f.getAbsolutePath(),true);
			
			if(rowNum > fileRows) {
				int brojNaPrazniObjetki = rowNum - fileRows;
				String nuli = "";
			
				for(int i = 0; i < 13; i++) {
					nuli = nuli + "0";
				}
				out.write("\r\n".getBytes());
				for(int i = 0; i < brojNaPrazniObjetki; i++) {
					out.write(nuli.getBytes());
					out.write("\r\n".getBytes());
				}
				out.write(id, 0, 2);
				out.write(value, 0, 10);
				if(status) {
					out.write((byte)'T');
				}
				else {
					out.write((byte)'F');
				}
			}
		}
		finally {
			if(out != null)
				out.close();
		}
		
	}

}
