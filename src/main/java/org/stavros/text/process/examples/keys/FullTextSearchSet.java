package org.stavros.text.process.examples.keys;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.stavros.text.process.FileUtils;
import org.stavros.text.process.module.AbstractFileLineProcessor;
import org.stavros.text.process.module.FileProcessor;
import org.stavros.text.process.module.Finding;

public class FullTextSearchSet extends AbstractFileLineProcessor implements FileProcessor {
	
	private Set<String> keys;
	public void setKeys(Set<String> keys) {
		this.keys = keys;
	}

	@Override
	protected List<Finding> processLine(long lineNumber, String line) {
		if (FileUtils.checkContains(line, keys)) {
			System.out.println(getCurrentFile().getPath() + ": line: ("+ lineNumber +"): " + line);
		}
		return new ArrayList<>();
	}

}
