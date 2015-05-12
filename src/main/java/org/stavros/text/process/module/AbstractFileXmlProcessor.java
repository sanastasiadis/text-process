package org.stavros.text.process.module;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class AbstractFileXmlProcessor extends AbstractFileGenericProcessor implements FileProcessor {

	@Override
	public List<Finding> processFile(File f) throws FileNotFoundException, IOException {
		Document doc = Jsoup.parse(f, "UTF-8");
		return processDocument(doc);
	}
	
	protected abstract List<Finding> processDocument(Document doc);

}
