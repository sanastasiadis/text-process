package org.stavros.text.process.module;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public interface DirectoryProcessor {
	
	List<Finding> processDirectory(File directory) throws FileNotFoundException, IOException;
	
	List<Finding> processDirectory(String directory) throws FileNotFoundException, IOException;

}
