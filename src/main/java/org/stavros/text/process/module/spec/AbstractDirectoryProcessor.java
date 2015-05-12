package org.stavros.text.process.module.spec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.stavros.text.process.module.DirectoryProcessor;
import org.stavros.text.process.module.Finding;

public abstract class AbstractDirectoryProcessor implements DirectoryProcessor {
	
	@Override
	public List<Finding> processDirectory(File directory) throws FileNotFoundException, IOException {
		List<Finding> ret = new ArrayList<>();
		for (File f: directory.listFiles()) {
			if (f.isDirectory()) {
				// recursive
				ret.addAll(processDirectory(f));
			}
			else {
				// enter process file
				ret.addAll(processFile(f));
			}
		}
		return ret;
	}
	
	@Override
	public List<Finding> processDirectory(String directoryName) throws FileNotFoundException, IOException {
		File f = new File(directoryName);
		return processDirectory(f);
	}
	
	protected abstract List<Finding> processFile(File f) throws FileNotFoundException, IOException;

}
