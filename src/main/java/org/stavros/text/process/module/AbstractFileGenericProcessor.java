package org.stavros.text.process.module;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.stavros.text.process.module.spec.AbstractFileExtensionsDirectoryChecker;

public abstract class AbstractFileGenericProcessor extends AbstractFileExtensionsDirectoryChecker implements FileProcessor {
	
	private File currentFile;
	public File getCurrentFile() {
		return this.currentFile;
	}
	
	@Override
	public List<Finding> processFile(String filename) throws FileNotFoundException, IOException {
		File file = new File(filename);
		this.currentFile = file;
		return processFile(file);
	}

	public abstract List<Finding> processFile(File f) throws FileNotFoundException,	IOException;

}
