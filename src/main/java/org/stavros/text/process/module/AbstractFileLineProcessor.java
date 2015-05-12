package org.stavros.text.process.module;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractFileLineProcessor extends AbstractFileGenericProcessor implements FileProcessor {
	
	@Override
	public List<Finding> processFile(File file) throws FileNotFoundException, IOException {
		List<Finding> findings = new ArrayList<>();
		try(FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			Stream<String> lines = br.lines();
			
			Iterator<String> iter = lines.iterator();
			
			long lineNumber = 0;
			while(iter.hasNext()) {
				lineNumber++;
				findings.addAll(processLine(lineNumber, iter.next()));
			}
		}
		return findings;
	}
	
	protected abstract List<Finding> processLine(long lineNumber, String line);

}
