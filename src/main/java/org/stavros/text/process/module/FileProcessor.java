package org.stavros.text.process.module;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileProcessor {
	
	List<Finding> processFile(File file) throws FileNotFoundException, IOException;
	
	List<Finding> processFile(String filename) throws FileNotFoundException, IOException;

}
