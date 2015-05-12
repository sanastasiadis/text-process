package org.stavros.text.process.examples.keys;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.stavros.text.process.FileUtils;

public class MainSpecificKeys {
	
	public final static void main(String[] args) {
		Set<String> sf = new HashSet<>();
		sf.add("java");
		sf.add("jsp");
		
		FullTextSearchAllSet ftss = new FullTextSearchAllSet();
		ftss.setFileExtensions(sf);
		try {
			ftss.setKeys(getKeys("src/main/resources/keys.txt"));
			ftss.processDirectory(args[0]);
			
			for (Entry<String,Integer> entry: ftss.getResults().entrySet()) {
				System.out.println("|" + entry.getKey() + "|" + entry.getValue() + "|");
			}
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace(System.out);
		}
		catch(IOException ioe) {
			ioe.printStackTrace(System.out);
		}
	}
	
	public static Set<String> getKeys(String filename) throws FileNotFoundException, IOException {
		Set<String> keys = new HashSet<>();
		
		keys.addAll(FileUtils.loadLinesList(filename));
		
		return keys;
	}

}
