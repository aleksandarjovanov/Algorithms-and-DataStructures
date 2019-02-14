import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class kol1_zad2 {

	public static void main(String[] args)throws IOException {
		String from = "C:\\Users\\Aleksandar\\Desktop\\toto";
		String to = "C:\\Users\\Aleksandar\\Desktop\\test2.txt";
		long size = 1;
		ArrayList<byte[]> data = new ArrayList<byte[]>();
		byte [] niza = {1,2,4,5}; 
		data.add(niza);
		
		copyLargeTxtFiles(from, to, size); 
		serializeData(to, data);
	}
	public static void serializeData(String destination, List<byte[]> data)throws IOException {
		File f = new File(destination);
		
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(f.getAbsoluteFile());
			
			for(byte [] elem : data) {
				out.write(elem);
			}
		}
		finally {
			if(out != null)
				out.close();
		}
		
	}
	public byte[] deserializeDataAtPosition(String source, long position, int elementLength)throws IOException {
       
        RandomAccessFile input = null;
       
        try
        {
            input = new RandomAccessFile(source, "r"); //creates a new random access file stream to read from
            input.seek(position); //seek-moves the file pointer to the specified location
           
           
            for(int i=0; i<elementLength; i++)
            {
                input.read();
            }
        }
        finally
        {
            if(input!=null)
            {
                input.close();
 
            }
        }
       
        return null;
    }
	public static void copyLargeTxtFiles(String from, String to, long size) {
		File f = new File(from);
		File f2 = new File(to);

		if(f.exists()) {
			
			if(!f2.exists())
				f2.mkdirs();
			
			File [] files = f.listFiles();
			
			for(File file : files){
				
				if(file.isFile() && file.getName().endsWith(".txt") && file.length() > size) {
					file.renameTo(new File(f2.getAbsolutePath()+"//"+file.getName()));
				}
			}
		}
		else {
			System.out.println("ne postoi");
		}
		
	}
}
