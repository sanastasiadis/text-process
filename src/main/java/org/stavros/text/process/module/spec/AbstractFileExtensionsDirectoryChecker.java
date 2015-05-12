package org.stavros.text.process.module.spec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.stavros.text.process.FileUtils;
import org.stavros.text.process.module.Finding;

public abstract class AbstractFileExtensionsDirectoryChecker extends AbstractDirectoryProcessor {
	private Set<String> fileExtensions;
	public void setFileExtensions(Set<String> fileExtensions) {
		this.fileExtensions = fileExtensions;
	}
	public void addFileExtension(String fileExtension) {
		this.fileExtensions.add(fileExtension);
	}
	
	@Override
	public List<Finding> processDirectory(File f) throws FileNotFoundException, IOException {
		if (fileExtensions != null) {
			if (FileUtils.checkFileExtensions(f, fileExtensions)) {
				return super.processDirectory(f);
			}
			else {
				System.out.println("No effective extension file: " + f.getName());
			}
		}
		else {
			return super.processDirectory(f);
		}
		
		return new ArrayList<>();
	}
	
	@Override
	public List<Finding> processDirectory(String directoryName) throws FileNotFoundException, IOException {
		return processDirectory(new File(directoryName));
	}
}
