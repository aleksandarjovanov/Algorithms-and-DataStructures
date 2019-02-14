package test;

import java.io.*;

public class test {

	public static void main(String[] args)throws IOException {
		File f = new File("..//..//..//Desktop/java//koko.txt");
		if(f.exists())
			System.out.println("true");
		
		boolean is = f.delete();
		
		System.out.println(f.canWrite());
	}
	

}
