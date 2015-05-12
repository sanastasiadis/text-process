package org.stavros.text.process.examples.jsp;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		FileChecker fc = new FileChecker("h:form", "id", "action");
		Set<String> fileExtensions = new HashSet<>();
		fileExtensions.add("jsp");
		fc.setFileExtensions(fileExtensions);
		
		try {
			fc.processDirectory(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
