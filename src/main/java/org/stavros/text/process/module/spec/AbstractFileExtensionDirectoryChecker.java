package org.stavros.text.process.module.spec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.stavros.text.process.FileUtils;
import org.stavros.text.process.module.Finding;

public abstract class AbstractFileExtensionDirectoryChecker extends AbstractDirectoryProcessor {
	
	private String fileExtension;
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	
	@Override
	public List<Finding> processDirectory(File f) throws FileNotFoundException, IOException {
		if (fileExtension != null) {
			if (FileUtils.checkFileExtension(f, fileExtension)) {
				return super.processDirectory(f);
			}
			else {
				System.out.println("No "+fileExtension+" file: " + f.getName());
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
