package org.stavros.text.process.examples.keys;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Main {
	
	public static void main(String[] args) {
		PropertiesLoader dp = new PropertiesLoader();
		Set<String> fileExtensions = new HashSet<>();
		fileExtensions.add("properties");
		dp.setFileExtensions(fileExtensions);
		try {
			dp.processDirectory(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String str: dp.getKeys()) {
			System.out.println(str);
		}
		
		Set<String> sf = new HashSet<>();
		sf.add("java");
		sf.add("jsp");
		
		FullTextSearchSet ftss = new FullTextSearchSet();
		ftss.setFileExtensions(sf);
		ftss.setKeys(dp.getKeys());
		try {
			ftss.processDirectory(args[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
