package org.stavros.text.process.examples.keys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.stavros.text.process.FileUtils;
import org.stavros.text.process.module.AbstractFileLineProcessor;
import org.stavros.text.process.module.FileProcessor;
import org.stavros.text.process.module.Finding;

public class FullTextSearchAllSet extends AbstractFileLineProcessor implements FileProcessor {
	
	private Set<String> keys;
	public void setKeys(Set<String> keys) {
		this.keys = keys;
		
		for (String key: keys) {
			results.put(key, 0);
		}
	}
	
	private Map<String, Integer> results = new HashMap<>();
	public Map<String, Integer> getResults() {
		return this.results;
	}

	@Override
	protected List<Finding> processLine(long lineNumber, String line) {
		List<String> containedKeys = FileUtils.checkContainsAll(line, keys, false);
		
		for(String containedKey: containedKeys) {
			Integer count = results.get(containedKey);
			results.put(containedKey, ++count);
			System.out.println(getCurrentFile().getPath() + ": line: ("+ lineNumber +"): " + line);
		}
		
		return new ArrayList<>();
	}

}
