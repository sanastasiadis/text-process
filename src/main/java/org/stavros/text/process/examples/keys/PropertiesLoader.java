package org.stavros.text.process.examples.keys;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.stavros.text.process.module.AbstractFilePropertiesProcessor;
import org.stavros.text.process.module.Finding;

public class PropertiesLoader extends AbstractFilePropertiesProcessor {

	private Set<String> keys;
	public Set<String> getKeys() {
		return this.keys;
	}

	@Override
	protected List<Finding> processProperties(Properties properties) {
		Set<String> keys = new HashSet<>();
		for (Object key: properties.keySet()) {
			keys.add((String)key);
		}
		return null;
	}

}
