package org.stavros.text.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class FileUtils {
	
	public final static String getExtension(File f) {
		return f.getName().substring(f.getName().lastIndexOf('.')<0?f.getName().length():f.getName().lastIndexOf('.')+1);
	}
	
	public final static boolean checkFileExtension(File f, String fileExtension) {
		return getExtension(f).equalsIgnoreCase(fileExtension);
	}
	
	public final static boolean checkFileExtensions(File f, Set<String> fileExtensions) {
		boolean ret = false;
		for (String fe: fileExtensions) {
			if (FileUtils.checkFileExtension(f, fe)) {
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	public final static boolean checkContains(String line, String key) {
		return checkContains(line, key, true);
	}
	
	public final static boolean checkContains(String line, String key, boolean ignoreCase) {
		if (ignoreCase) {
			return line.toLowerCase().indexOf(key.toLowerCase()) >= 0;
		}
		else {
			return line.indexOf(key) >= 0;
		}
	}
	
	public final static boolean checkContains(String line, Set<String> keys) {
		return checkContains(line, keys, true);
	}
	
	public final static boolean checkContains(String line, Set<String> keys, boolean ignoreCase) {
		boolean ret = false;
		for (String key: keys) {
			if (checkContains(line, key, ignoreCase)) {
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	public final static List<String> checkContainsAll(String line, Set<String> keys) {
		return checkContainsAll(line, keys, true);
	}
	
	public final static List<String> checkContainsAll(String line, Set<String> keys, boolean ignoreCase) {
		List<String> ret = new ArrayList<>();
		for (String key: keys) {
			if (checkContains(line, key, ignoreCase)) {
				ret.add(key);
			}
		}
		return ret;
	}
	
	public final static List<String> loadLinesList(String filename) throws FileNotFoundException, IOException {
		List<String> linesList = new ArrayList<>();
		File file = new File(filename);
		try(FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			Stream<String> lines = br.lines();
			
			Iterator<String> iter = lines.iterator();
			
			while(iter.hasNext()) {
				linesList.add(iter.next());
			}
		}
		
		return linesList;
	}

}
