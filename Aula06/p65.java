import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class p65 {
	public static void main(String[] args)throws IOException {
		String file;
		if(args.length==0) {
			file = "dir1";
		}
		else {
			file = args[0];
		}
		printDir(file);
	}
	public static void printDir(String file)throws IOException {
		File f = new File(file);
		File[] paths = f.listFiles();
		out.println(f.getPath());
		if (paths==null) {
			System.out.println("The directory is empty");
			exit(1);
		}
		for(int i=0; i < paths.length; i++) {
			String temp = paths[i].getPath();
			if (paths[i].isFile()) {
				out.println(paths[i].getPath());
			}
		}
		for(int i=0; i < paths.length; i++) {
			if (paths[i].isDirectory() && paths[i].canRead()) {
				printDir(paths[i].getPath());
			}
		}
	}
}