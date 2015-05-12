package org.stavros.text.process.module;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public abstract class AbstractFilePropertiesProcessor extends AbstractFileGenericProcessor implements FileProcessor {

	@Override
	public List<Finding> processFile(File f) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		try (FileReader fr = new FileReader(f)) {
			properties.load(fr);
		}
		catch(IOException ioe) {
			ioe.printStackTrace(System.out);
		}
		return processProperties(properties);
	}
	
	protected abstract List<Finding> processProperties(Properties properties);

}
