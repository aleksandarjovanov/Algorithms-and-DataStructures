import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class Rekurzivno_listanje_fajlovSistem {

	public static void main(String[] args) {
		String path = "C:\\Users\\Aleksandar\\Desktop\\riki";

		//createDirectory(new File(path), "riki\\trajce");

		listFile(path, "");

	}
	
	public static void createDirectory(File parent, String name) {                         /// OPCIONALNO
		File dir = new File(parent, name);
		if (dir.exists()) {
			System.err.println("The directory " + dir.getAbsolutePath()
					+ " already exists!");
		} else {
			try {
				// mkdirs creates the directory together with the missing
				// parents
				boolean created = dir.mkdirs();
				if (created) {
					System.out.println(dir.getAbsolutePath() + " is created!");
				} else {
					System.out.println(dir.getAbsolutePath()
							+ " is not created!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void listFile(String absolutePath, String prefix) {             ///// !!!!!!!!!!!!!   ////////
		File file = new File(absolutePath);

		if (file.exists()) {
			File[] subfiles = file.listFiles();
			for (File f : subfiles) {
				// print the permissions in unix like format
				System.out.println(prefix + getPermissions(f) + "\t"
						+ f.getName());

				// Recursively show the content of sub-directories
				if (f.isDirectory()) {
					listFile(f.getAbsolutePath(), prefix + "\t");
				}
			}
		}
	}

	public static String getPermissions(File f) {
		return String.format("%s%s%s", f.canRead() ? "r" : "-",
				f.canWrite() ? "w" : "-", f.canExecute() ? "x" : "-");
	}
}

